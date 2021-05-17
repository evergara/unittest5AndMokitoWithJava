package scientificcalculator;

import scientificcalculator.util.ValidaterDateCalculator;

public class Divide {
    private ValidaterDateCalculator validaterDateCalculator;

    public Divide(ValidaterDateCalculator validaterDateCalculator) {
        this.validaterDateCalculator = validaterDateCalculator;
    }

    public int divide(Object a, Object b){
        if(validaterDateCalculator.check(a) && validaterDateCalculator.check(b)
            && validaterDateCalculator.checkZero(a) && validaterDateCalculator.checkZero(b)){
            return (Integer) a / (Integer) b;
        }else{
            return 0;
        }

    }
}
