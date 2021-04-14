import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class StableCheck {
    public static Map<String,Boolean> generateStableMap() {

        Map<String,Boolean> stabilityConditions = new HashMap<>();
        stabilityConditions.put("comb",false);
        stabilityConditions.put("gnome",false);
        stabilityConditions.put("shaker",false);
        stabilityConditions.put("stooge",false);
        stabilityConditions.put("bitonic",false);

        SortAlgorithms sortAlgorithms = new SortAlgorithms();

        List<TestObject> mainList = generateList();
        List<TestObject> mainReversedList = generateReversedList(mainList);


        // COMB \\

        // generate a list with size 5 and add 3 same value with different strings
        List<TestObject> normalList = new ArrayList<>(mainList);
        // generate reversed version of the list
        List<TestObject> reversedList = new ArrayList<>(mainReversedList);

        // sort both normal and reversed list. if they are not equal it means algorithm is not stable
        sortAlgorithms.combSort(normalList);
        sortAlgorithms.combSort(reversedList);


        // iterate sortedstrings and sortedobjects. check two strings at the same time
        for (int i = 0; i < normalList.size(); i++) {

            if (normalList.get(i).randomString.equals("intersection") && normalList.get(i).randomString.equals(reversedList.get(i).randomString) ) {
                stabilityConditions.put("comb",true);
            }


        }
        normalList.clear();
        reversedList.clear();
        // COMB \\

        // GNOME \\

        // generate a list with size 5 and add 3 same value with different strings
        normalList = new ArrayList<>(mainList);
        // generate reversed version of the list
        reversedList = new ArrayList<>(mainReversedList);

        sortAlgorithms.gnomeSort(normalList);
        sortAlgorithms.gnomeSort(reversedList);


        // iterate sortedstrings and sortedobjects. check two strings at the same time
        for (int i = 0; i < normalList.size(); i++) {
            // if two strings are not equal, it means that
            if (normalList.get(i).randomString.equals("intersection") && normalList.get(i).randomString.equals(reversedList.get(i).randomString) ) {
                stabilityConditions.put("gnome",true);
            }
        }

        normalList.clear();
        reversedList.clear();

        // GNOME \\


        // SHAKER \\

        // generate a list with size 5 and add 3 same value with different strings
        normalList = new ArrayList<>(mainList);
        // generate reversed version of the list
        reversedList = new ArrayList<>(mainReversedList);


        sortAlgorithms.shakerSort(normalList);
        sortAlgorithms.shakerSort(reversedList);



        // iterate sortedstrings and sortedobjects. check two strings at the same time
        for (int i = 0; i < normalList.size(); i++) {
            // if two strings are not equal, it means that
            if (normalList.get(i).randomString.equals("intersection") && normalList.get(i).randomString.equals(reversedList.get(i).randomString) ) {
                stabilityConditions.put("shaker",true);
            }
        }


        normalList.clear();
        reversedList.clear();

        // SHAKER \\

        // STOOGE \\

        // generate a list with size 5 and add 3 same value with different strings
        normalList = new ArrayList<>(mainList);
        // generate reversed version of the list
        reversedList = new ArrayList<>(mainReversedList);

        sortAlgorithms.stoogeSort(normalList);
        sortAlgorithms.stoogeSort(reversedList);


        // iterate sortedstrings and sortedobjects. check two strings at the same time
        for (int i = 0; i < normalList.size(); i++) {
            // if two strings are not equal, it means that
            if (normalList.get(i).randomString.equals("intersection") && normalList.get(i).randomString.equals(reversedList.get(i).randomString) ) {
                stabilityConditions.put("stooge",true);
            }
        }



        normalList.clear();
        reversedList.clear();

        // STOOGE \\

        // BITONIC \\

        // generate a list with size 5 and add 3 same value with different strings
        normalList = new ArrayList<>(mainList);
        // generate reversed version of the list
        reversedList = new ArrayList<>(mainReversedList);

        sortAlgorithms.bitonicSort(normalList);
        sortAlgorithms.bitonicSort(reversedList);


        // iterate sortedstrings and sortedobjects. check two strings at the same time
        for (int i = 0; i < normalList.size(); i++) {
            // if two strings are not equal, it means that
            if (normalList.get(i).randomString.equals("intersection") && normalList.get(i).randomString.equals(reversedList.get(i).randomString) ) {
                stabilityConditions.put("bitonic",true);
            }
        }

        normalList.clear();
        reversedList.clear();

        // BITONIC \\



        return stabilityConditions;
    }

    public static List<TestObject> generateList() {
        List<TestObject> tempList = Operator.generateList(5);
        tempList.add(new TestObject("test1",0));
        tempList.add(new TestObject("test2",0));
        tempList.add(new TestObject("test3",0));
        tempList.add(new TestObject("test4",0));
        tempList.add(new TestObject("test5",0));
        tempList.add(new TestObject("test6",0));
        tempList.add(new TestObject("intersection",0));
        tempList.add(new TestObject("test8",0));
        tempList.add(new TestObject("test9",0));
        tempList.add(new TestObject("test10",0));
        tempList.add(new TestObject("test11",0));
        tempList.add(new TestObject("test12",0));
        tempList.add(new TestObject("test13",0));

        return tempList;

    }
    public static List<TestObject> generateReversedList(List<TestObject> normalList) {
        List<TestObject> reversedList = new ArrayList<>();

        for (int i = normalList.size()-1; i >=0 ; i--) {
            reversedList.add(normalList.get(i));
        }

        return reversedList;
    }

}
