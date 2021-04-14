import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorstCase {


    public static void runWorstCaseInputs(int buffer, int compileCount) {
        combSortWorstCase(buffer,compileCount);
        gnomeSortWorstCase(buffer,compileCount);
        shakerSortWorstCase(buffer,compileCount);
        stoogeSortWorstCase(buffer,compileCount);
        bitonicSortWorstCase(buffer,compileCount);
    }

    public static List<TestObject> bitonicSortWorstCase(int buffer,int compileCount) {
        List<Double> bestBitonicTimes = new ArrayList<>();
        List<Double> randomBitonicTimes = new ArrayList<>();
        List<Double> worstBitonicTimes = new ArrayList<>();


        List<TestObject> output = new ArrayList<>();

        List<Integer> sizeOfLists = new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,8192));

        for (Integer sizeOfList: sizeOfLists) {
            // descending order won't be the worst worst case, but it is worse than normally sorted list.
            List<TestObject> ascendingOrder = generateBestCase(sizeOfList);
            List<TestObject> randomOrder = Operator.generateList(sizeOfList);
            List<TestObject> descendingOrder = generateWorstCase(sizeOfList);

            List<Double> ascendingTimes = Operator.calculateTimeAddToList(ascendingOrder,new SortAlgorithms(),"bitonic",buffer,compileCount);
            List<Double> randomTimes = Operator.calculateTimeAddToList(randomOrder,new SortAlgorithms(),"bitonic",buffer,compileCount);
            List<Double> descendingTimes = Operator.calculateTimeAddToList(descendingOrder,new SortAlgorithms(),"bitonic",buffer,compileCount);

            bestBitonicTimes.add(Operator.calculateAverage(ascendingTimes));
            randomBitonicTimes.add(Operator.calculateAverage(randomTimes));
            worstBitonicTimes.add(Operator.calculateAverage(descendingTimes));
        }

        System.out.println("Bitonic times: ");
        System.out.println("best = " + bestBitonicTimes.toString());
        System.out.println("random = " + randomBitonicTimes.toString());
        System.out.println("worst = " + worstBitonicTimes.toString());
        System.out.println("****************");
        return output;
    }

    public static List<TestObject> stoogeSortWorstCase(int buffer,int compileCount) {
        List<Double> bestStoogeTimes = new ArrayList<>();
        List<Double> randomStoogeTimes = new ArrayList<>();
        List<Double> worstStoogeTimes = new ArrayList<>();


        List<TestObject> output = new ArrayList<>();

        List<Integer> sizeOfLists = new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,8192));

        for (Integer sizeOfList: sizeOfLists) {
            // descending order won't be the worst worst case, but it is worse than normally sorted list.
            List<TestObject> ascendingOrder = generateBestCase(sizeOfList);
            List<TestObject> randomOrder = Operator.generateList(sizeOfList);
            List<TestObject> descendingOrder = generateWorstCase(sizeOfList);

            List<Double> ascendingTimes = Operator.calculateTimeAddToList(ascendingOrder,new SortAlgorithms(),"stooge",buffer,compileCount);
            List<Double> randomTimes = Operator.calculateTimeAddToList(randomOrder,new SortAlgorithms(),"stooge",buffer,compileCount);
            List<Double> descendingTimes = Operator.calculateTimeAddToList(descendingOrder,new SortAlgorithms(),"stooge",buffer,compileCount);

            bestStoogeTimes.add(Operator.calculateAverage(ascendingTimes));
            randomStoogeTimes.add(Operator.calculateAverage(randomTimes));
            worstStoogeTimes.add(Operator.calculateAverage(descendingTimes));
        }

        System.out.println("Stooge times: ");
        System.out.println("best = " + bestStoogeTimes.toString());
        System.out.println("random = " + randomStoogeTimes.toString());
        System.out.println("worst = " + worstStoogeTimes.toString());
        System.out.println("****************");
        return output;
    }


    public static List<TestObject> shakerSortWorstCase(int buffer, int compileCount) {
        List<Double> bestShakerTimes = new ArrayList<>();
        List<Double> randomShakerTimes = new ArrayList<>();
        List<Double> worstShakerTimes = new ArrayList<>();


        List<TestObject> output = new ArrayList<>();

        List<Integer> sizeOfLists = new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,8192));

        for (Integer sizeOfList: sizeOfLists) {
            // descending order won't be the worst worst case, but it is worse than normally sorted list.
            List<TestObject> ascendingOrder = generateBestCase(sizeOfList);
            List<TestObject> randomOrder = Operator.generateList(sizeOfList);
            List<TestObject> descendingOrder = generateWorstCase(sizeOfList);

            List<Double> ascendingTimes = Operator.calculateTimeAddToList(ascendingOrder,new SortAlgorithms(),"shaker",buffer,compileCount);
            List<Double> randomTimes = Operator.calculateTimeAddToList(randomOrder,new SortAlgorithms(),"shaker",buffer,compileCount);
            List<Double> descendingTimes = Operator.calculateTimeAddToList(descendingOrder,new SortAlgorithms(),"shaker",buffer,compileCount);

            bestShakerTimes.add(Operator.calculateAverage(ascendingTimes));
            randomShakerTimes.add(Operator.calculateAverage(randomTimes));
            worstShakerTimes.add(Operator.calculateAverage(descendingTimes));
        }

        System.out.println("best = " + bestShakerTimes.toString());
        System.out.println("random = " + randomShakerTimes.toString());
        System.out.println("worst = " + worstShakerTimes.toString());

        return output;
    }


    public static List<TestObject> gnomeSortWorstCase(int buffer, int compileCount) {
        List<Double> bestGnomeTimes = new ArrayList<>();
        List<Double> randomGnomeTimes = new ArrayList<>();
        List<Double> worstGnomeTimes = new ArrayList<>();


        List<TestObject> output = new ArrayList<>();

        List<Integer> sizeOfLists = new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,8192));

        for (Integer sizeOfList: sizeOfLists) {
            // descending order won't be the worst worst case, but it is worse than normally sorted list.
            List<TestObject> ascendingOrder = generateBestCase(sizeOfList);
            List<TestObject> randomOrder = Operator.generateList(sizeOfList);
            List<TestObject> descendingOrder = generateWorstCase(sizeOfList);

            List<Double> ascendingTimes = Operator.calculateTimeAddToList(ascendingOrder,new SortAlgorithms(),"gnome",buffer,compileCount);
            List<Double> randomTimes = Operator.calculateTimeAddToList(randomOrder,new SortAlgorithms(),"gnome",buffer,compileCount);
            List<Double> descendingTimes = Operator.calculateTimeAddToList(descendingOrder,new SortAlgorithms(),"gnome",buffer,compileCount);

            bestGnomeTimes.add(Operator.calculateAverage(ascendingTimes));
            randomGnomeTimes.add(Operator.calculateAverage(randomTimes));
            worstGnomeTimes.add(Operator.calculateAverage(descendingTimes));
        }

        System.out.println("best = " + bestGnomeTimes.toString());
        System.out.println("random = " + randomGnomeTimes.toString());
        System.out.println("worst = " + worstGnomeTimes.toString());

        return output;
    }


    public static List<TestObject> combSortWorstCase(int buffer,int compileCount) {
        List<Double> bestCombTimes = new ArrayList<>();
        List<Double> randomCombTimes = new ArrayList<>();


        List<TestObject> output = new ArrayList<>();

        List<Integer> sizeOfLists = new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096,8192));

        for (Integer sizeOfList: sizeOfLists) {
            // descending order won't be the worst worst case, but it is worse than normally sorted list.
            List<TestObject> ascendingOrder = generateBestCase(sizeOfList);
            List<TestObject> randomOrder = Operator.generateList(sizeOfList);

            List<Double> ascendingTimes = Operator.calculateTimeAddToList(ascendingOrder,new SortAlgorithms(),"comb",buffer,compileCount);
            List<Double> randomTimes = Operator.calculateTimeAddToList(randomOrder,new SortAlgorithms(),"comb",buffer,compileCount);

            bestCombTimes.add(Operator.calculateAverage(ascendingTimes));
            randomCombTimes.add(Operator.calculateAverage(randomTimes));
        }

        System.out.println("best = " + bestCombTimes.toString());
        System.out.println("random = " + randomCombTimes.toString());

        return output;
    }


    public static List<TestObject> generateWorstCase(int inputSize) {
        List<TestObject> output = new ArrayList<>();
        for (int i = inputSize; i > 0 ; i--) {
            String generatedString = Long.toHexString(Double.doubleToLongBits(Math.random()));
            output.add(new TestObject(generatedString,i));
        }

        return output;
    }

    public static List<TestObject> generateBestCase(int inputSize) {
        List<TestObject> output = new ArrayList<>();
        for (int i = 0; i < inputSize ; i++) {
            String generatedString = Long.toHexString(Double.doubleToLongBits(Math.random()));
            output.add(new TestObject(generatedString,i));
        }

        return output;
    }

}
