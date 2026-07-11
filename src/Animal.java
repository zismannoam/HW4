/**
 * An animal with a dominance level, waiting to board the ark.
 * Animals are ordered by dominance, higher dominance first.
 */
public abstract  class Animal implements Comparable<Animal>, Cloneable {
    /** The dominance level of this animal. */
    private int dominanceNumber;
    /**
     * Constructs an animal with the given dominance level.
     *
     * @param dominanceNumber the dominance level of this animal
     */
    public Animal(int dominanceNumber){
        this.dominanceNumber = dominanceNumber;
    }

    /**
     * Compares this animal to another by dominance level.
     *
     * @param other the animal to compare against
     * @return a negative number if this animal is less dominant, zero if equally
     *     dominant, a positive number if more dominant
     */
    @Override
    public int compareTo(Animal other){
        return this.dominanceNumber-other.dominanceNumber;

    }
    /** Returns the species name of this animal. */
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    /**
     * Returns a copy of this animal.
     * Since an animal holds only a primitive dominance number,
     * a shallow copy is also a complete copy.
     */
    @Override
    public Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
    }
}

