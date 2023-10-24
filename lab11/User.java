package lab11;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private Rate rate;

    public User(String name, Rate rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", rate=" + rate.toString() +
                '}';
    }
}
