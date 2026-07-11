/** Raised when an operation requires elements but the queue is empty. */
public class EmptyQueueException extends SpeciesQueueException{
    /** Constructs an exception with no message. */
    public EmptyQueueException(){}
    /**
     * Constructs an exception with the given message.
     *
     * @param message the detail message
     */
    public EmptyQueueException(String message){
        super(message);
    }
    /**
     * Constructs an exception with the given message and cause.
     *
     * @param message the detail message
     * @param cause the underlying cause
     */
    public EmptyQueueException(String message, Throwable cause){
        super(message, cause);
    }
}
