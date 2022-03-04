package exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TN09_Calculator_Alt {
    @Test
    public void testCalculator(){
        N09_Calculator_Alt.CalcAdd calcAdd = new N09_Calculator_Alt.CalcImpl();
        N09_Calculator_Alt.CalcSub calcSub = new N09_Calculator_Alt.CalcImpl();
        N09_Calculator_Alt.CalcDiv calcDiv = new N09_Calculator_Alt.CalcImpl();
        N09_Calculator_Alt.CalcMult calcMult = new N09_Calculator_Alt.CalcImpl();

        Assertions.assertEquals(100, calcAdd.add(50,50));
        Assertions.assertEquals(100, calcSub.sub(150,50));
        Assertions.assertEquals(100, calcDiv.div(200,2));
        Assertions.assertEquals(100, calcMult.mult(50,2));
    }
}
