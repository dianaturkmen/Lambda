import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaEng03 {
    public static void main(String[] args){

        List<String> l=new ArrayList<>();
        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");

        printAllListUpperCase01(l);
        System.out.println();
        //printAllListUpperCase02(l);
        printElementsSortedByLength(l);
        System.out.println();
        printElementsSortedByLengthreversed(l);
        System.out.println();
        printDsitinctSortedByLastChar(l);
        System.out.println();
        SortElementsLenghtsThenAccordingFirsCahr(l);
        System.out.println();
       // removeIfTheLenghtIsGreaterThanFive(l);
        System.out.println();
        //RemoveIfLenghtIsBetween8And10orEndingWitho(l);

        System.out.println();
        System.out.println(checkLenghtToLessThanTwelve(l));
        System.out.println(checkNotToStartWithX(l));
        System.out.println();
        System.out.println(checkAnyElEndingWithR(l));



    }
    //create a method to print all list elements in uppercase
    public static void printAllListUpperCase01 (List<String> l){
        l.stream().map(String::toUpperCase).forEach(Utils::printInTheSameLineWithSpace);
    }
    //2.way
    //public static void printAllListUpperCase02 (List<String>l){
      //  l.replaceAll(String::toUpperCase);
        //System.out.println(l);
    // }
//create a method to print the elements after ordering according to their lengths
    public static void printElementsSortedByLength(List<String>l){
        l.stream().sorted(Comparator.comparing(String::length)
                ).forEach(Utils::printInTheSameLineWithSpace);

    }
    //create a method to print the elements after ordering according to their lengths(In reversed order
    public static void printElementsSortedByLengthreversed(List<String>l){
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::printInTheSameLineWithSpace);
    }
    // create  a method to sort the distinct elements by using their last characters
    public static void printDsitinctSortedByLastChar(List<String>l){
        l.stream().distinct().sorted(Comparator.comparing(Utils::getLastChar)).forEach(Utils::printInTheSameLineWithSpace);
    }
    //Create a method to sort the elemenets according to their lengths then according to their first character
    public static void SortElementsLenghtsThenAccordingFirsCahr(List<String>l){
        l.stream().
                sorted(Comparator.comparing(String::length).thenComparing(Utils::getFirstChar)).
                forEach(Utils::printInTheSameLineWithSpace);
    }
    // Remove the elements if the length of the element is greater than 5
   // public static void removeIfTheLenghtIsGreaterThanFive(List<String>l){
       // l.removeIf(t->t.length()>5);
      //  System.out.println(l);
    //}
//Remove the elements if the lenghts is between 8-10 or ending with 'O'
    //public static void RemoveIfLenghtIsBetween8And10orEndingWitho(List<String>l){
        //Predicate<String >checkCondition = t->(t.length()>7&&t.length()<11)||t.endsWith("o");
      //  l.removeIf(t-> checkCondition.test(t));
    //    System.out.println(l);
  //  }
//}
//Create a method to check if the lenghts of all elements are less than 12
public static boolean checkLenghtToLessThanTwelve(List<String>l){
    return l.stream().allMatch(t->t.length()<12);
    }
    //create aMethod to check if the initial of any elements is not 'X'
    public static boolean checkNotToStartWithX(List<String>l){
        return l.stream().noneMatch(t->t.startsWith("X"));
    }
    //Create a method  to check if at least one of the elements ending with "r"
    public static boolean checkAnyElEndingWithR (List<String>l){
        return l.stream().anyMatch(t->t.endsWith("r"));
    }

}