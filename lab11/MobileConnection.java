package lab11;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MobileConnection implements Serializable {
    private String name;
    private List<Rate> rates;
    private List<User> users;

    public void sortRatesByPrice(){
        Collections.sort(rates);
    }

    public MobileConnection(String name, List<Rate> rates, List<User> users) {
        this.name = name;
        this.rates = rates;
        this.users = users;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String toString() {
        StringBuilder ratesAndUsersStr = new StringBuilder();
        for (var rate : rates) {
            ratesAndUsersStr.append("\n\t").append(rate.toString());
        }
        ratesAndUsersStr.append(",\nusers=");
        for (var user : users) {
            ratesAndUsersStr.append("\n\t").append(user.toString());
        }

        return "MobileConnection \"" + name + "\" {" +
                "\nrates=" + ratesAndUsersStr.toString() + '}';
    }
}
