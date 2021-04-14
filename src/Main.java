
import java.util.*;




public class Main  {
    public static void main(String[] args) {

        // takes buffer and compilecount as an argument.
        Operator.generateTimes(0,1);
        Map<String, Boolean> stableMap = StableCheck.generateStableMap();
        System.out.println(stableMap.toString());

        // takes buffer and compilecount as an argument.
        WorstCase.runWorstCaseInputs(0,1);

    }


}


