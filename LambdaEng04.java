import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LambdaEng04 {
    public static void main(String[] args) {

        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);
        System.out.println(getSumFromTo10001());
        System.out.println(getSumFromTo10002());
        System.out.println(getMultiplicationFromTwoToEleven());
        System.out.println(calculateFactorial(5));
        System.out.println(calculateFactorial01(-1));
        System.out.println(sumOfIntegersInGivenRange(11,100));
        System.out.println(findSumOfDigitForTheIntegersInTheGivenRange(23,32)); //68

    }
    //Create a method to find sum of integers from 7 to100
    public static int getSumFromTo10001(){
        return IntStream.range(7,101).reduce(0,Math::addExact);
    }
    public static int getSumFromTo10002(){
        return IntStream.rangeClosed(7,100).reduce(0,Math::addExact);
    }
    // Create a method to find the multiplication of the integers from 2(inc) to 11(inc)

    public static int getMultiplicationFromTwoToEleven(){
       return IntStream.rangeClosed(2,11).reduce(1,Math::multiplyExact);
    }
    // Create a method to calculate the factorial of a given number.(5 factorial ==> 5! = 1*2*3*4*5)
    public static int calculateFactorial(int x){
        return IntStream.rangeClosed(1,5).reduce(1,Math::multiplyExact);
    }
    public static Object calculateFactorial01(int x){
        return x>0 ? IntStream.rangeClosed(1,5).reduce(1,Math::multiplyExact):
                "Do not use negative numbers in factoriel op";
}
    // Create a method to calculate the sum of even integers between given two integers
    public static int sumOfIntegersInGivenRange(int s, int e){
       int x=0;
       if(s>e){
           x=s;
           s=e;
           e=x;
       }
       return IntStream.rangeClosed(s,e).filter(Utils::checkToBeEven).sum();
    }
    //create amethod to calculate the sum of digits of every integers between given two integers
    public static int findSumOfDigitForTheIntegersInTheGivenRange(int s, int e){
        int x=0;
        if(s>e){
            x=s;
            s=e;
            e=x;
        }
        return IntStream.rangeClosed(s,e).map(Utils::getSumOfDigits).sum();
    }



}


