package scientificcalculator;

import scientificcalculator.util.ValidaterDateCalculator;

public class Add {
   private ValidaterDateCalculator validaterDateCalculator;

    public Add(ValidaterDateCalculator validaterDateCalculator) {
        this.validaterDateCalculator = validaterDateCalculator;
    }

    public int add(Object a, Object b){
        if(validaterDateCalculator.check(a) && validaterDateCalculator.check(b)){
            return (Integer) a + (Integer) b;
        }else{
            return 0;
        }

    }
}
