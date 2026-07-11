/** Raised when an invalid element is passed to a queue operation. */
public class InvalidInputException extends SpeciesQueueException{
    /** Constructs an exception with no message. */
    public InvalidInputException() {}
    /**
     * Constructs an exception with the given message.
     *
     * @param message the detail message
     */
    public  InvalidInputException(String message){
        super(message);
    }
    /**
     * Constructs an exception with the given message and cause.
     *
     * @param message the detail message
     * @param cause the underlying cause
     */
    public InvalidInputException(String message, Throwable cause){
        super(message, cause);
    }
}
