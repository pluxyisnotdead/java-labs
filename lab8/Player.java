package lab8;

public class Player implements Comparable<Player>{
    private String name;
    private int age;
    private int number;

    public String toString(){
        return getName() + "\t" + getAge() + "\t" + getNumber();
    }

    public Player(String name, int age, int number){
        setName(name);
        setAge(age);
        setNumber(number);
    }

    public int compareTo(Player player){
        return Integer.compare(this.getNumber(), player.getNumber());
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getNumber() {
        return number;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
