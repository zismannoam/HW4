import java.lang.reflect.Method;
import java.util.Iterator;

public class SpeciesQueue <T extends Comparable<T>> implements Cloneable, Iterable<T> {
    private int queueSize;
    private T[] queueElements;
    public SpeciesQueue(){
        this.queueSize = 0;
        queueElements = (T[]) (new Object[10]);
    }
public void add(T animal) throws InvalidInputException{
        if(animal==null){throw new InvalidInputException();}
        if(queueElements.length==queueSize){
            T[] tempQueueElements = (T[]) (new Object[queueElements.length*2]);
            for(int j=0; j<queueSize; j++){
                tempQueueElements[j]=queueElements[j];
            }
            queueElements=tempQueueElements;
        }
        int i = 0;
        for(i=queueSize-1; i>=0; i--){
            if(queueElements[i].compareTo(animal)>0){
                break;
            } else {
                queueElements[i+1]=queueElements[i];
            }
        }
        queueElements[i+1]=animal;
        queueSize+=1;
}
public T peek() throws EmptyQueueException{
        if(queueSize==0){throw new EmptyQueueException();}
        return queueElements[0];
}
public T remove() throws EmptyQueueException{
        T head = this.peek();
        for(int i=0; i<queueSize-1; i++){
            queueElements[i]=queueElements[i+1];
        }
        queueSize-=1;
        return head;
}
public int size(){
        return queueSize;
}
public boolean isEmpty(){
        return queueSize==0;
}

    @Override
    public SpeciesQueue<T> clone() throws CloneNotSupportedException {
        SpeciesQueue<T> cloned = (SpeciesQueue<T>) super.clone();
        T[] clonedElements = (T[]) (new Object[queueElements.length]);
        try {
            for(int i=0; i<queueSize; i++){
                if(queueElements[i] instanceof Cloneable){
                    Method cloneMethod = queueElements[i].getClass().getMethod("clone");
                    clonedElements[i] = (T) cloneMethod.invoke(queueElements[i]);
                } else {
                    clonedElements[i] = queueElements[i];
                }
            }
            cloned.queueElements = clonedElements;
        } catch (Exception e) {
            return null;
        }
        return cloned;
    }

    private class QueueIterator implements Iterator<T>{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex<queueSize;
        }

        @Override
        public T next() {
            T currentElement = queueElements[currentIndex];
            currentIndex+=1;
            return currentElement;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
}
