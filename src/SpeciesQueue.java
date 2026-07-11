import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * A priority queue of elements ordered by their natural ordering, highest first.
 * Elements of the same class are kept contiguous, and a newly added element is
 * placed first within its own class group. Backed by an array that doubles in
 * size when full.
 *
 * @param <T> the type of elements held in this queue
 */
public class SpeciesQueue <T extends Comparable<T>> implements Cloneable, Iterable<T> {
    /** The number of elements currently in the queue. */
    private int queueSize;
    /** The array holding the queue elements. */
    private T[] queueElements;
    /** Constructs an empty queue with an initial capacity. */
    public SpeciesQueue(){
        this.queueSize = 0;
        queueElements = (T[]) (new Comparable[10]);
    }
    /**
     * Adds an element to the queue in its correct position.
     * The element is placed first among elements of its own class, and the backing
     * array is doubled if it is full.
     *
     * @param animal the element to add
     * @throws InvalidInputException if the element is null
     */
public void add(T animal) throws InvalidInputException{
        if(animal==null){throw new InvalidInputException();}
        if(queueElements.length==queueSize){
            T[] tempQueueElements = (T[]) (new Comparable[queueElements.length*2]);
            for(int j=0; j<queueSize; j++){
                tempQueueElements[j]=queueElements[j];
            }
            queueElements=tempQueueElements;
        }
    int insertAt = queueSize;
    for (int j = 0; j < queueSize; j++) {
        if (queueElements[j].getClass().equals(animal.getClass())) {
            insertAt = j;
            break;
        }
        if (queueElements[j].compareTo(animal) < 0) {
            insertAt = j;
            break;
        }
    }

    for (int j = queueSize; j > insertAt; j--) {
        queueElements[j] = queueElements[j-1];
    }
    queueElements[insertAt] = animal;
    queueSize += 1;
}
    /**
     * Returns the head of the queue without removing it.
     *
     * @return the head of the queue
     * @throws EmptyQueueException if the queue is empty
     */
public T peek() throws EmptyQueueException{
        if(queueSize==0){throw new EmptyQueueException();}
        return queueElements[0];
}
    /**
     * Removes the head of the queue and returns it.
     *
     * @return the removed head of the queue
     * @throws EmptyQueueException if the queue is empty
     */
public T remove() throws EmptyQueueException{
        T head = this.peek();
        for(int i=0; i<queueSize-1; i++){
            queueElements[i]=queueElements[i+1];
        }
        queueSize-=1;
        return head;
}
    /** Returns the number of elements in the queue. */
public int size(){
        return queueSize;
}
    /** Returns whether the queue is empty. */
public boolean isEmpty(){
        return queueSize==0;
}

    /**
     * Returns a deep copy of this queue.
     * Elements that implement Cloneable are cloned; other elements are shared with
     * the original queue.
     *
     * @return a deep copy of this queue, or null if the copy could not be made
     */
    @Override
    public SpeciesQueue<T> clone(){
        try{
            SpeciesQueue<T> cloned = (SpeciesQueue<T>) super.clone();
            T[] clonedElements = (T[]) (new Comparable[queueElements.length]);
            for(int i=0; i<queueSize; i++){
                if(queueElements[i] instanceof Cloneable){
                    Method cloneMethod = queueElements[i].getClass().getMethod("clone");
                    clonedElements[i] = (T) cloneMethod.invoke(queueElements[i]);
                } else {
                    clonedElements[i] = queueElements[i];
                }
            }
            cloned.queueElements = clonedElements;
            return cloned;
        } catch (Exception e) {
            return null;
        }
    }

    /** An iterator over the queue elements, from head to tail. */
    private class QueueIterator implements Iterator<T>{
        /** The index of the next element to return. */
        private int currentIndex = 0;

        /** Returns whether there are further elements to iterate over. */
        @Override
        public boolean hasNext() {
            return currentIndex<queueSize;
        }

        /** Returns the next element and advances the iterator. */
        @Override
        public T next() {
            T currentElement = queueElements[currentIndex];
            currentIndex+=1;
            return currentElement;
        }
    }

    /**
     * Returns an iterator over the elements of this queue.
     *
     * @return an iterator from head to tail
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
}
