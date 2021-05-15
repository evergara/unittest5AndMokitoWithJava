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
}
