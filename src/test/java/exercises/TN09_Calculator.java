package exercises;

import exercises.N08_Animals.Animal;
import exercises.N08_Animals.Cat;
import exercises.N08_Animals.Dog;
import exercises.N08_Animals.Vet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TN09_Calculator {

    @Test
    public void testCalculator(){
        N09_Calculator.Calculator c = new N09_Calculator.CalculatorImpl();
        c.addOperation(100, N09_Calculator.Operation.OperationType.ADD);
        c.addOperation(100, N09_Calculator.Operation.OperationType.SUB);
        c.addOperation(50, N09_Calculator.Operation.OperationType.MULT);
        c.addOperation(4, N09_Calculator.Operation.OperationType.DIV);
        c.addOperation(2, N09_Calculator.Operation.OperationType.ADD);
        Assertions.assertEquals(300, c.calculate());

        c.addOperation(100, N09_Calculator.Operation.OperationType.ADD);
        Assertions.assertEquals(100, c.calculate());

        Assertions.assertEquals(0, c.calculate());
    }
}
