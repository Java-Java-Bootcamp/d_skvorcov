package exercises.N08_Animals;

public class Horse extends Animal{
    public Horse(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Neigh");
    }

    @Override
    public void sleep() {
        System.out.println("Zzz");
    }
}
