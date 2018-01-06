package system.exception;

/**
 * Thrown when access to a resource or functionality invocation is denied due to insufficient permission.
 */
public class AuthorizationException extends RuntimeException {

    public AuthorizationException(String message) {
        super(message);
    }
}
