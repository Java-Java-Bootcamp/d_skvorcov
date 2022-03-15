package exercises;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class TN26_ATMSaveStateTest {
    @Test
    public void test(){
        File stateFile = new File("amtstate.txt");
        N26_ATMSaveState.RealATMSerializable atm = new N26_ATMSaveState.RealATMSerializable(10000);
        atm.login(new N07_ATM.Account(1000,100),100);
        atm.depositMoney(N07_ATM.Denomination.HUNDRED, 1);
        atm.saveStateToFile(stateFile);
        try {
            System.out.println(FileUtils.readFileToString(stateFile, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        N26_ATMSaveState.RealATMSerializable newAtm = N26_ATMSaveState.RealATMSerializable.fromSavedState(stateFile);
        newAtm.withdraw(N07_ATM.Denomination.HUNDRED, 1);
        System.out.println(newAtm.saveStateToFile(null));
    }
}