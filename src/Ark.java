/** An ark that animals board one at a time, in order of dominance. */
public class Ark {
    /** The queue of animals waiting to board. */
    private SpeciesQueue<Animal> queue;
    /** Constructs an ark with an empty queue of animals. */
    public Ark(){
        this.queue = new SpeciesQueue<Animal>();
    }
    /**
     * Adds an animal to the queue of animals waiting to board.
     *
     * @param animal the animal to add
     */
    public void add(Animal animal){
        queue.add(animal);
    }
    /**
     * Boards the first animal in the queue and prints a message announcing it.
     *
     * @throws EmptyQueueException if no animals are waiting
     */
    public void enterToArk(){
        Animal firstAnimal = queue.remove();
        System.out.println("A " + firstAnimal.toString() + " entered the ark");
    }
    /** Boards all waiting animals, one at a time. */
    public void enterAllToArk(){
        while (!queue.isEmpty()){enterToArk();}
    }
    /** Prints the animals waiting to board, separated by commas. */
    public void showQueue() {
        boolean isFirst = true;
        for (Animal animal : queue) {
            if (!isFirst) {
                System.out.print(", ");
            }
            System.out.print(animal.toString());
            isFirst = false;
        }
        System.out.println();
    }
}
