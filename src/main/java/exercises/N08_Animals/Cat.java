package exercises.N08_Animals;

public class Cat extends Animal{
    public Cat(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow");
    }

    @Override
    public void sleep() {
        System.out.println("Zzz");
    }
}
