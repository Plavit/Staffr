package system.rest.exception;

/**
 * Thrown when a conflict in the data occurs.
 */
public class DataConflictException extends RuntimeException {

    public DataConflictException(String message) {
        super(message);
    }
}
