package exercises;

import java.util.ArrayList;
import java.util.List;

public class N07_ATM {
    public enum Denomination{
        ONE(1),
        TEN(10),
        HUNDRED(100);

        int realValue;
        Denomination(int realValue) {
            this.realValue=realValue;
        }
    }

    public static class Account{
        public int amount;
        public int password;

        public Account(int amount, int password) {
            this.amount = amount;
            this.password = password;
        }

        public void putMoney(int amount){
            this.amount+=amount;
        }
        public void getMoney(int amount){
            this.amount-=amount;
        }
        public boolean canGet(int amount){
            return this.amount-amount>0;
        }
    }

    public interface ATM{
        public void withdraw(Denomination denomination, int amount);
        public void depositMoney(Denomination denomination, int amount);
        public void login(Account account, int password);
    }

    public static class RealATM implements ATM{
        private List<MoneyCell> moneyCells = new ArrayList<>();
        private int maxCellSize = 1000;
        private Account currentAccount;

        public RealATM(int maxCellSize) {
            this.maxCellSize = maxCellSize;
            this.moneyCells.add(new MoneyCell(Denomination.ONE, 500, this.maxCellSize));
            this.moneyCells.add(new MoneyCell(Denomination.TEN, 500, this.maxCellSize));
            this.moneyCells.add(new MoneyCell(Denomination.HUNDRED, 500, this.maxCellSize));
        }

        public void login(Account account, int password){
            if(account.password==password){
                this.currentAccount = account;
            }
        }

        @Override
        public void withdraw(Denomination denomination, int amount) {
            if(currentAccount==null) {
                System.out.println("Нет аккаунта!");
                return;
            }
            if(!currentAccount.canGet(amount*denomination.realValue)) {
                System.out.println("Недостаточно денег!");
                return;
            }

            for (MoneyCell cell : moneyCells) {
                if (cell.denomination == denomination && cell.canGet(amount)) {
                    cell.getMoney(amount);
                    currentAccount.getMoney(amount *denomination.realValue);
                    return;
                }
            }
            System.out.println("Нет подходящей ячейки!");
        }

        @Override
        public void depositMoney(Denomination denomination, int amount) {
            if(currentAccount==null) {
                System.out.println("Нет аккаунта!");
            }

            for (MoneyCell cell : moneyCells) {
                if (cell.denomination == denomination && cell.canPut(amount)) {
                    cell.putMoney(amount);
                    currentAccount.putMoney(amount *denomination.realValue);
                    return;
                }
            }
            System.out.println("Нет подходящей ячейки!");
        }
    }

    public static class MoneyCell{
        public Denomination denomination;
        int banknotesNumber;
        int maxNumber;

        public MoneyCell(Denomination denomination, int banknotesNumber, int maxNumber) {
            this.denomination = denomination;
            this.banknotesNumber = banknotesNumber;
            this.maxNumber = maxNumber;
        }

        public void putMoney(int amount){
            banknotesNumber+=amount;
        }
        public boolean canPut(int amount){
            return banknotesNumber+amount<=maxNumber;
        }
        public void getMoney(int amount){
            banknotesNumber-=amount;
        }
        public boolean canGet(int amount){
            return banknotesNumber-amount>0;
        }
    }
}
