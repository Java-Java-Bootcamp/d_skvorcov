package exercises;

import exercises.N07_ATM.RealATM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TN07_ATM {
    @Test
    public void test(){
        N07_ATM.ATM atm0 = new RealATM(1000);
        N07_ATM.Account acc0 = new N07_ATM.Account(1000, 123);

        atm0.login(acc0, 123);
        assertEquals(1000,acc0.amount);

        atm0.withdraw(N07_ATM.Denomination.HUNDRED, 1);
        assertEquals(900, acc0.amount);

        atm0.depositMoney(N07_ATM.Denomination.ONE, 75);
        assertEquals(975, acc0.amount);

        //Вытащить слишком много
        atm0.withdraw(N07_ATM.Denomination.TEN, 100);
        assertEquals(975, acc0.amount);

        //Вставить слишком много
        atm0.depositMoney(N07_ATM.Denomination.TEN, 10000);
        assertEquals(975, acc0.amount);
    }
}
