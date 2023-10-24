package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Region{
    private String name;
    private ArrayList<District> districts;
    private City center;

    Region(){
        setName("");
        setDistricts(new ArrayList<District>());
    }

    Region(String name, ArrayList<District> districts, City center){
        setName(name);
        setDistricts(districts);
        setCenter(center);
    }

    public static Region get(Scanner scanner){
        Region region = new Region();

        System.out.print("Определимся с названием региона: ");
        region.setName(scanner.next());

        return region;
    }

    public void addDistrict(District district){
        this.districts.add(district);
    }

    public String getName(){ return this.name; }
    public ArrayList<District> getDistricts(){ return this.districts; }
    public City getCenter() { return this.center; }

    public void setName(String name){ this.name = name;}
    public void setDistricts(ArrayList<District> districts){ this.districts = districts;}
    public void setCenter(City center){ this.center = center;}
}
