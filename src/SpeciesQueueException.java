/** An unchecked exception raised by queue operations. */
public class SpeciesQueueException extends RuntimeException{
    /** Constructs an exception with no message. */
    public SpeciesQueueException(){}
    /**
     * Constructs an exception with the given message.
     *
     * @param message the detail message
     */
    public SpeciesQueueException(String message){
        super(message);
    }
    /**
     * Constructs an exception with the given message and cause.
     *
     * @param message the detail message
     * @param cause the underlying cause
     */
    public SpeciesQueueException(String message, Throwable cause){
        super(message, cause);
    }
}
