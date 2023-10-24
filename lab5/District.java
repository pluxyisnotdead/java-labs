package lab5;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class District {
    private String name;
    private ArrayList<City> cities;

    District(){
        setName("");
        setCities(new ArrayList<City>());
    }

    District(String name, Double area, ArrayList<City> cities){
        setName(name);
        setCities(cities);
    }

    public static District get(Scanner scanner){
        District district = new District();

        System.out.print("Определимся с названием района: ");
        district.setName(scanner.next());

        return district;
    }

    public void addCity(City city){
        this.cities.add(city);
    }

    public String getName(){ return this.name; }
    public ArrayList<City> getCities() { return this.cities; }

    public void setName(String name){ this.name = name;}
    public void setCities(ArrayList<City> cities){ this.cities = cities;}
}
