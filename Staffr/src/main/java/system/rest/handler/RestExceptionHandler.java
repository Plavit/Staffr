/**
 * Copyright (C) 2016 Czech Technical University in Prague
 * <p>
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package system.rest.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import system.exception.*;
import system.rest.exception.DataConflictException;

import javax.servlet.http.HttpServletRequest;


/**
 * Contains exception handlers for REST controllers.
 */
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorInfo> resourceNotFound(HttpServletRequest request, NotFoundException e) {
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.NOT_FOUND);
    }

    private ErrorInfo errorInfo(HttpServletRequest request, Throwable e) {
        return new ErrorInfo(e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorInfo> mappingException(HttpServletRequest request, HttpMessageNotReadableException e) {
        return new ResponseEntity<>(errorInfo(request, e.getCause()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<ErrorInfo> usernameExistsException(HttpServletRequest request, UsernameExistsException e) {
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(WebServiceIntegrationException.class)
    public ResponseEntity<ErrorInfo> webServiceIntegrationException(HttpServletRequest request,
                                                                    WebServiceIntegrationException e) {
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorInfo> unsupportedOperationException(HttpServletRequest request,
                                                                   UnsupportedOperationException e) {
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> illegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        LOG.error("Illegal argument caught:", e);
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ErrorInfo> persistenceException(HttpServletRequest request, PersistenceException e) {
        LOG.error("Persistence exception caught:", e);
        return new ResponseEntity<>(errorInfo(request, e.getCause()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ErrorInfo> transactionException(HttpServletRequest request, TransactionException e) {
        return new ResponseEntity<>(errorInfo(request, e.getCause()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataConflictException.class)
    public ResponseEntity<ErrorInfo> dataConflictException(HttpServletRequest request, DataConflictException e) {
        LOG.error("Conflict in data detected:", e);
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<ErrorInfo> authorizationException(HttpServletRequest request, AuthorizationException e) {
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorInfo> accessDeniedEx(HttpServletRequest request, AccessDeniedException e) {
        return new ResponseEntity<>(errorInfo(request, e), HttpStatus.FORBIDDEN);
    }
}
