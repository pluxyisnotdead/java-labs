package lab9;

import java.io.*;

public class Course implements Serializable {
    private String name;
    private int level;
    private int hours;

    public Course(String name, int level, int hours){
        setName(name);
        setLevel(level);
        setHours(hours);
    }

    public int getHours() {
        return hours;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
