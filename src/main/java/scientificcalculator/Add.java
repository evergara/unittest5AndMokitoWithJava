package scientificcalculator;

import scientificcalculator.util.PrintMessage;
import scientificcalculator.util.ValidaterDateCalculator;

public class Add {
   private ValidaterDateCalculator validaterDateCalculator;
   private PrintMessage printMessage;

    public Add(ValidaterDateCalculator validaterDateCalculator, PrintMessage printMessage) {
        this.validaterDateCalculator = validaterDateCalculator;
        this.printMessage = printMessage;
    }

    public int add(Object a, Object b){
        if(validaterDateCalculator.check(a) && validaterDateCalculator.check(b)){
            return (Integer) a + (Integer) b;
        }else{
            return 0;
        }

    }

    public void addPrint(Object a, Object b){
        int result = 0;
        if(validaterDateCalculator.check(a) && validaterDateCalculator.check(b)){
            result = (Integer) a + (Integer) b;
            printMessage.showMessage(result);
        }else{
            printMessage.showError("Numero Invalido");
        }

    }
}
