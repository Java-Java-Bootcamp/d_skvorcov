package exercises;

public class N09_Calculator_Alt {
    public interface CalcAdd{
        public double add(double n0, double n1);
    }
    public interface CalcSub{
        public double sub(double n0, double n1);
    }
    public interface CalcMult{
        public double mult(double n0, double n1);
    }
    public interface CalcDiv{
        public double div(double n0, double n1);
    }
    public static class CalcImpl implements CalcAdd, CalcSub, CalcMult, CalcDiv{

        @Override
        public double add(double n0, double n1) {
            return n0+n1;
        }

        @Override
        public double sub(double n0, double n1) {
            return n0-n1;
        }

        @Override
        public double mult(double n0, double n1) {
            return n0*n1;
        }

        @Override
        public double div(double n0, double n1) {
            return n0/n1;
        }
    }
}
