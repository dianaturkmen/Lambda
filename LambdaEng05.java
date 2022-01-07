import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaEng05 {

    public static void main(String[] args){

        Courses courseTurkishDay=new Courses("Summer", "TurkishDay", 97, 128);
        Courses courseTurkishNight=new Courses("Winter", "TurkishNight", 98, 154);
        Courses courseEnglishDay=new Courses("Spring", "EnglishhDay", 95, 132);
        Courses courseEnglishNight=new Courses("Winter", "TurkishNight", 93, 144);
        List<Courses> coursesList=new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseTurkishNight);
        System.out.println(checkAvrageScoresToBeGreaterThanGivenNumber(coursesList,91));
        System.out.println(checkIfLeastOfTheCourseNameContainsGivenWord(coursesList,"Turkish"));
        System.out.println(getCourseNamewhoseAvgIsHighest(coursesList));
        System.out.println(sortCourseWithAvgScoreInAscendingSkipFirsGiven(coursesList,2L));
        System.out.println(getThirdAfterSortingInAsc01(coursesList,3));
        System.out.println(getThirdAfterSortingInAsc01(coursesList,3));

    }
    //1 create a method to check if all average scores are greater than Given average score (91)
    public static boolean checkAvrageScoresToBeGreaterThanGivenNumber(List<Courses> list, double avgScore){
        return list.stream().allMatch(t->t.getAverageScore()>avgScore);
    }
    //2 Create a  method to check if at least one of the course names contains "given" word

    public static boolean checkIfLeastOfTheCourseNameContainsGivenWord (List<Courses>list, String word){
        return list.stream().anyMatch(t->t.getCourseName().contains(word));
    }
    //3 create a method to print the course whose average score is the highest
    public static String getCourseNamewhoseAvgIsHighest(List<Courses>list){
        Courses obj = list.stream().sorted(Comparator.comparing(Courses::getAverageScore).reversed()).findFirst().get();
        return obj.getCourseName();
    }
    //4 sort the list elements according to the average score in ascending order and skip first given elements
    public static List<Courses> sortCourseWithAvgScoreInAscendingSkipFirsGiven(List<Courses>list, long num){
         return list.stream().sorted(Comparator.comparing(Courses::getAverageScore)).skip(num).collect(Collectors.toList());
    }
    //5 Sort the list elements according to the average score in ascending order and print just 3rd one
    public static List<Courses> getThirdAfterSortingInAsc01(List <Courses>list, int num){
        return list.stream().sorted(Comparator.comparing(Courses::getAverageScore)).skip(num-1).limit(1).collect(Collectors.toList());
    }
    public static List<Courses> getThirdAfterSortingInAsc02(List <Courses>list, int num){
        return (List<Courses>) list.stream().sorted(Comparator.comparing(Courses::getAverageScore)).skip(num-1).findFirst().get();
    }

}
