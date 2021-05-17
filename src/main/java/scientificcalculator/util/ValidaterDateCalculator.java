package scientificcalculator.util;

public class ValidaterDateCalculator {

    public ValidaterDateCalculator() {}

    public boolean check(Object o){
        if (o instanceof  Integer){
            if ((Integer)o < 10 && (Integer)o>0) {
              return true;
            }else {
                return false;
            }
        }else {
            return  false;
        }
    }

    public boolean checkZero(Object o){
        if (o instanceof  Integer){
            if ((Integer)o == 0) {
                throw new ArithmeticException("No se puede dividir por Zero");
            }else {
                return true;
            }
        }else {
            return  false;
        }
    }
}
