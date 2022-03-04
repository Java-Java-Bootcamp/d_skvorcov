package exercises;

import exercises.N08_Animals.Animal;
import exercises.N08_Animals.Cat;
import exercises.N08_Animals.Dog;
import exercises.N08_Animals.Vet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TN08_Animals {

    @Test
    public void testAnimals(){
        Animal cat = new Cat("Whiskas", "Home");
        Animal dog = new Dog("Bones", "Wilderness");
        Assertions.assertNotEquals(cat.getClass(), dog.getClass());

        Vet vet = new Vet();
        vet.treat(cat);
        vet.treat(dog);
        Assertions.assertEquals(200, cat.getHealth());
        Assertions.assertEquals(200, dog.getHealth());
    }
}
