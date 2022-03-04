package exercises;

import java.util.ArrayList;

public class N09_Calculator {
    public static class Operation {
        public enum OperationType {
            ADD,
            SUB,
            MULT,
            DIV
        }

        double number;
        OperationType operationType;

        public Operation(double number, OperationType operationType) {
            this.number = number;
            this.operationType = operationType;
        }
    }

    public interface Calculator{
        void addOperation(double n1, Operation.OperationType type);
        void clear();
        double calculate();
    }

    public static class CalculatorImpl implements Calculator{
        public ArrayList<Operation> operations = new ArrayList<>();

        public void addOperation(double n1, Operation.OperationType o){
            operations.add(new Operation(n1, o));
        }

        public double calculate(){
            if(operations.size()==0) return 0;
            if(operations.size()==1) return operations.get(0).number;
            double result = operations.get(0).number;
            for(int x=0; x< operations.size()-1; x++){
                result = performOperation(result, operations.get(x+1).number, operations.get(x).operationType);
            }
            clear();
            return result;
        }

        public void clear(){
            operations.clear();
        }

        public double performOperation(double n0, double n1, Operation.OperationType o){
            switch (o) {
                case ADD:
                    return n0+n1;
                case SUB:
                    return n0-n1;
                case MULT:
                    return n0*n1;
                case DIV:
                    return n0/n1;
            }
            return 0;
        }
    }
}
