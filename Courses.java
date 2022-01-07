public class Courses {
    private  String Season;
    private String courseName;
    private int averageScore;
    private int numberOfStudents;

    //1 Constructor without parameter
    public Courses(){
    }

    public String getSeason() {
        return Season;
    }

    public void setSeason(String season) {
        Season = season;
    }

    //2 Constructor with all  parameters
    public Courses(String season, String courseName, int averageScore, int numberOfStudents){
        Season = season;
        this.courseName =courseName;
        this.averageScore=averageScore;
        this.numberOfStudents=numberOfStudents;
    }
    // 3 getter() and setter()


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        courseName = courseName;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    // 4 ToString()
    public String toString(){
        return "Course: Season=" +Season +"courseName"+courseName+"courseName" + "averageScore" +averageScore
                +"numberOfStudents"+numberOfStudents;
    }
}