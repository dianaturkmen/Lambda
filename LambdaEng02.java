import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaEng02 {

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
        printElements(l);
        System.out.println();
        printEvenEListElements(l);
        System.out.println();
        printSquareOffOddElements(l);
        System.out.println();
        printCubeofDistinctElements(l);
        System.out.println();
        sumOfSquareOfDistinctEvenElements(l);
        System.out.println();
        productOfTheCubesOfDistinctEvenElements(l);
        System.out.println();
        getMaxElement(l);
        getMinElement(l);
        getMinGreaterThanSeven(l);
        getHalfOfDistinctElementsInReversedOrder(l);

    }

    //print the list of elements on the console in the same line with a space
    // between two consecutive elements.(Functional)
    public static void printElements(List<Integer>list){
        list.stream().forEach(Utils::printInTheSameLineWithSpace);
    }

// print the even list elements on the console in the same line with a space between two
    public static void printEvenEListElements(List<Integer>list){
        list.stream().filter(Utils::checkToBeEven).forEach(Utils::printInTheSameLineWithSpace);
    }
    //create a method to print the square of odd list elements on the console in the same line with a space between two
    public static void printSquareOffOddElements (List<Integer>list){
        list.stream().filter(Utils::checkToBeOdd).map(Utils::getSquare).forEach(Utils::printInTheSameLineWithSpace);
    }
    //create a method to print the cube of distinct odd elements on the console in the same line with a space between two
    public static void printCubeofDistinctElements(List<Integer>list){
        list.stream().distinct().filter(Utils::checkToBeOdd).map(Utils::getCube).forEach(Utils::printInTheSameLineWithSpace);
    }
    //calculate the sum of the square of distinct even elements
    public static void sumOfSquareOfDistinctEvenElements(List<Integer>list){
        Integer sum=list.stream().distinct().filter(Utils::checkToBeEven).map(Utils::getSquare).reduce(0,Math::addExact);
        System.out.println(sum);
    }
    // calculate the  product of the cubes of distinct even  elements
    public static void productOfTheCubesOfDistinctEvenElements (List<Integer>list){
        Integer result=list.stream().distinct().filter(Utils::checkToBeEven).
                map(Utils::getCube).reduce(1,Math::multiplyExact);
        System.out.println(result);
    }
    // create a method to find the max value  from the list elements
    public static void getMaxElement (List<Integer>list){
        Integer max=list.stream().reduce(Integer.MIN_VALUE, Math::max);
        System.out.println(max);
    }

    // create a method to find the min value  from the list elements
    public static void getMinElement (List<Integer>list){
        Integer min=list.stream().reduce(Integer.MAX_VALUE, Math::min);
        System.out.println(min);
    }

    // create a minimum value vhich is greater than 7and even from list
    public static void getMinGreaterThanSeven(List<Integer>list){
        Integer min=list.stream().filter(t->t>7).filter(Utils::checkToBeEven).reduce(Integer.MAX_VALUE,Math::min);
        System.out.println(min);
    }
    //create a method to find the half of the elements which are distinct and greater than 5 in reverse order in the list
    public static void getHalfOfDistinctElementsInReversedOrder (List<Integer>list){

        List<Double>result= list.
                stream().
                distinct().
                filter(t-> t>5).
                map(Utils::getHalf).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.println(result);
    }

}