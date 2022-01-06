import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaEng {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(71);
        l.add(5);
        l.add(10);
        l.add(9);
        l.add(8);
        l.add(12);
        l.add(5);

        printElementFunctional(l);
        System.out.println();
        printElementStructured(l);
        System.out.println();
        evenListElementsStructured(l);
        System.out.println();
        evenListElementsFunctional(l);
        System.out.println();
        printSquereofoddElements(l);
        System.out.println();
        CubeofDistinctOddElements(l);
        System.out.println();
        sumOfSquereofDistinctEvenElements(l);
        System.out.println();
        calculateCubesoftheDistinctEvenelements(l);
        getTheMaxValueOfElements(l);
        getTheMaxValueOfElements2Way(l);
        greaterThanSeven02(l);
        greaterThanSeven01(l);
        greaterThanSeven03(l);
        getHalfOfDistinctElementsInReverseOrder(l);

    }

    public static void printElementFunctional(List<Integer> list) {
        list.stream().forEach(t -> System.out.print((t + " ")));
    }

    public static void printElementStructured(List<Integer> list) {
        for (Integer w : list) {
            System.out.print(w + " ");
        }
    }

    //Print even list elements
    public static void evenListElementsStructured(List<Integer> list) {
        for (Integer w : list) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    public static void evenListElementsFunctional(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " ."));
    }

    //Print the Squere of odd list elements
    public static void printSquereofoddElements(List<Integer> list) {
        list.stream().filter(t -> t % 2 != 0).map(t -> t * t).forEach(t -> System.out.print(t + "  "));
    }

    //print theCube of distinct odd list elements
    public static void CubeofDistinctOddElements(List<Integer> list) {
        list.stream().distinct().filter(t -> t % 2 != 0).map(t -> t * t * t).forEach(t -> System.out.print(t + "  "));
    }

    //calculate the sum of the squere of distincteven elements
    public static void sumOfSquereofDistinctEvenElements(List<Integer> list) {
        Integer sum = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);
        System.out.println(sum);
    }

    //calculate the product of the cubes  of the  distinct even elements
    public static void calculateCubesoftheDistinctEvenelements(List<Integer> list) {
        Integer calc = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (t, u) -> t * u);
        System.out.println(calc);
    }

    //find the max value from the list elements
    //1. way
    public static void getTheMaxValueOfElements(List<Integer> list) {
        Integer max = list.stream().reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);
        System.out.println(max);
    }

    //2.way
    public static void getTheMaxValueOfElements2Way(List<Integer> list) {
        Integer max2 = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> u);
        System.out.println(max2);
    }

    public static void greaterThanSeven01(List<Integer> list) {
        Integer minGreaterThanSeven = list.
                stream().
                distinct().
                filter(t -> t > 7).
                filter(t -> t % 2 == 0).
                reduce(Integer.MAX_VALUE, (t, u) -> t > u ? u : t);
        System.out.println(minGreaterThanSeven);

    }

    public static void greaterThanSeven02(List<Integer> list) {
        Integer minGreaterThanSeven = list.
                stream().
                distinct().
                filter(t -> t > 7).
                filter(t -> t % 2 == 0).
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE, (t, u) ->  u );
        System.out.println(minGreaterThanSeven);
    }
    public static void greaterThanSeven03(List<Integer> list) {
        Integer minGreaterThanSeven = list.
                stream().
                distinct().
                filter(t -> t > 7).
                filter(t -> t % 2 == 0).
                sorted().
                findFirst().
                get();
        System.out.println(minGreaterThanSeven);
    }
    //find the half of the distincts which are greater than 5

    public static void getHalfOfDistinctElementsInReverseOrder(List<Integer>list){
        List<Double> result=list.
                stream().
                distinct().
                filter(t->t>5).
                map(t-> t/2.0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.println(result);
    }
}
