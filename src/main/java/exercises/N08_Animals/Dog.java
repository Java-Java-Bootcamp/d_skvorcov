package exercises.N08_Animals;

public class Dog extends Animal{
    public Dog(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof");
    }

    @Override
    public void sleep() {
        System.out.println("Zzz");
    }
}
