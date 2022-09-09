package schoolMarksProject;

public class Grade {
    private int math;
    private int eng;
    private int ukr;


    /*
    * Constructors
    * */
    public Grade() {

    }

    public Grade(int math, int eng, int ukr) {
        this.math = math;
        this.eng = eng;
        this.ukr = ukr;
    }

    /*
    * Getters and Setters
    *
    * */

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getUkr() {
        return ukr;
    }

    public void setUkr(int ukr) {
        this.ukr = ukr;
    }

    /*
    * average score
    *
    * */

    public double avgScore () {
        return (getMath()+getEng()+getUkr())/3;
    }



    @Override
    public String toString() {
        return "Grades for the semester: " +
                "math=" + math +
                ", eng=" + eng +
                ", ukr=" + ukr;
    }
}
