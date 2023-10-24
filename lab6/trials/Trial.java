package lab6.trials;

public abstract class Trial {
    private int grade;
    private String author;
    private static int amount = 0;

    public Trial(){
        setGrade(0);
        setAuthor("");
        amount++;
    }

    public Trial(int grade, String author){
        setGrade(grade);
        setAuthor(author);
        amount++;
    }

    public int getGrade(){ return this.grade; }
    public String getAuthor() { return this.author; }

    public void setGrade(int grade){ this.grade = grade;}
    public void setAuthor(String author){ this.author = author; }
}
