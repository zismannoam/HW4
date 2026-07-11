public class Ark {
    private SpeciesQueue<Animal> queue;
    public Ark(){
        this.queue = new SpeciesQueue<Animal>();
    }
    public void add(Animal animal){
        queue.add(animal);
    }
    public void enterToArk(){
        Animal firstAnimal = queue.remove();
        System.out.println("A " + firstAnimal.toString() + " entered the ark");
    }
    public void enterAllToArk(){
        while (!queue.isEmpty()){enterToArk();}
    }
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
