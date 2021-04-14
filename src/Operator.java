import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Operator {
    public static void generateTimes(int buffer,int compileCount) {
        SortAlgorithms sortAlgorithms = new SortAlgorithms();

        // initialize average time list of each sorting algorithm
        List<Double> averageOfCombTimes = new ArrayList<>();
        List<Double> averageOfGnomeTimes = new ArrayList<>();
        List<Double> averageOfShakerTimes = new ArrayList<>();
        List<Double> averageOfStoogeTimes = new ArrayList<>();
        List<Double> averageOfBitonicTimes = new ArrayList<>();

        // input size for each list
        List<Integer> sizeOfLists = new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096));
        for (Integer sizeOfList: sizeOfLists) {

            // generate lists
            List<TestObject> testObjectList = generateList(sizeOfList);

            // sort n times for each algorithm and set times to calculate average over all
            List<Double> timesOfCombSort = calculateTimeAddToList(testObjectList,sortAlgorithms,"comb",buffer,compileCount);
            List<Double> timesOfGnomeSort = calculateTimeAddToList(testObjectList,sortAlgorithms,"gnome",buffer,compileCount);
            List<Double> timesOfShakerSort = calculateTimeAddToList(testObjectList,sortAlgorithms,"shaker",buffer,compileCount);
            List<Double> timesOfStoogeSort = calculateTimeAddToList(testObjectList,sortAlgorithms,"stooge",buffer,compileCount);
            List<Double> timesOfBitonicort = calculateTimeAddToList(testObjectList,sortAlgorithms,"bitonic",buffer,compileCount);

            // calculate average of the times
            averageOfCombTimes.add(calculateAverage(timesOfCombSort));
            averageOfGnomeTimes.add(calculateAverage(timesOfGnomeSort));
            averageOfShakerTimes.add(calculateAverage(timesOfShakerSort));
            averageOfStoogeTimes.add(calculateAverage(timesOfStoogeSort));
            averageOfBitonicTimes.add(calculateAverage(timesOfBitonicort));

        }

        System.out.println("combTimes = " + averageOfCombTimes.toString());
        System.out.println("gnomeTimes = " + averageOfGnomeTimes.toString());
        System.out.println("shakerTimes = " + averageOfShakerTimes.toString());
        System.out.println("stoogeTimes = " + averageOfStoogeTimes.toString());
        System.out.println("bitonicTimes = " + averageOfBitonicTimes.toString());
    }

    /**
     * Takes list as an argument, calculates average of the list.
     * @param numbers List<Double>
     * @return int
     */
    public static double calculateAverage(List<Double> numbers) {
        Double sum = 0D;
        if(!numbers.isEmpty()) {
            for (Double number : numbers) {
                sum += number;
            }
            return sum / numbers.size();
        }
        return sum;
    }


    /**
     * Takes desired size of the list as an argument, returns a list which is randomly generated with the given size.
     * @param sizeOfList
     * @return
     */
    public static List<TestObject> generateList(int sizeOfList) {
        List<TestObject> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < sizeOfList; i++) {

            String generatedString = Long.toHexString(Double.doubleToLongBits(Math.random()));

            int generatedNumber = random.nextInt();

            TestObject tempObject = new TestObject(generatedString,generatedNumber);

            result.add(tempObject);
        }
        return result;
    }


    /**
     * Takes list and the sorting algorithm name, sorts and returns sorting time.
     *
     * @param elementsToBeSorted List<TestObject>
     * @param sortAlgorithms SortAlgorithms class
     * @param sortAlgorithm Type of sort algorithm <String>
     * @param buffer int
     * @param compileCount int
     * @return
     */
    public static List<Double> calculateTimeAddToList(List<TestObject> elementsToBeSorted,SortAlgorithms sortAlgorithms,String sortAlgorithm,int buffer, int compileCount) {
        List<TestObject> copyOfElementsToBeSorted = new ArrayList<>(elementsToBeSorted);

        List<Double> listOfTimes = new ArrayList<>();

        // run without storing the time
        for (int i = 0; i < buffer; i++) {
            if (sortAlgorithm.equals("comb"))
                sortAlgorithms.combSort(copyOfElementsToBeSorted);
            else if (sortAlgorithm.equals("gnome"))
                sortAlgorithms.gnomeSort(copyOfElementsToBeSorted);
            else if (sortAlgorithm.equals("shaker"))
                sortAlgorithms.shakerSort(copyOfElementsToBeSorted);
            else if (sortAlgorithm.equals("stooge"))
                sortAlgorithms.stoogeSort(copyOfElementsToBeSorted);
            else if (sortAlgorithm.equals("bitonic"))
                sortAlgorithms.bitonicSort(copyOfElementsToBeSorted);

            // deep copy of the list
            copyOfElementsToBeSorted = new ArrayList<>(elementsToBeSorted);
        }

        // store the times
        for (int i = 0; i < compileCount; i++) {
            // deep copy of the list
            copyOfElementsToBeSorted = new ArrayList<>(elementsToBeSorted);
            if (sortAlgorithm.equals("comb")) {
                sortAlgorithms.combSort(copyOfElementsToBeSorted);
                listOfTimes.add(sortAlgorithms.elapsedTimeComb);
            }

            else if (sortAlgorithm.equals("gnome")) {
                sortAlgorithms.gnomeSort(copyOfElementsToBeSorted);
                listOfTimes.add(sortAlgorithms.elapsedTimeGnome);
            }

            else if (sortAlgorithm.equals("shaker")) {
                sortAlgorithms.shakerSort(copyOfElementsToBeSorted);
                listOfTimes.add(sortAlgorithms.elapsedTimeShaker);
            }
            else if (sortAlgorithm.equals("stooge")) {
                sortAlgorithms.stoogeSort(copyOfElementsToBeSorted);
                listOfTimes.add(sortAlgorithms.elapsedTimeStooge);
            }
            else if (sortAlgorithm.equals("bitonic")) {
                sortAlgorithms.bitonicSort(copyOfElementsToBeSorted);
                listOfTimes.add(sortAlgorithms.elapsedTimeBitonic);
            }

        }


        return listOfTimes;
    }
}
