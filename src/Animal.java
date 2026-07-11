public abstract  class Animal implements Comparable<Animal> {
    private int dominanceNumber;
    public Animal(int dominanceNumber){
        this.dominanceNumber = dominanceNumber;
    }

    @Override
    public int compareTo(Animal other) {
        return this.dominanceNumber-other.dominanceNumber;
        }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

