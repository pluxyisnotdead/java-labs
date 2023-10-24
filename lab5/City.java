package lab5;

import java.util.Scanner;

public class City {
    private String name;
    private boolean isCapital;
    private boolean isRegionCenter;

    City(){
        setName("");
        setIsCapital(false);
        setIsRegionCenter(false);
    }

    City(String name, boolean isRegionCenter, boolean isCapital){
        setName(name);
        setIsRegionCenter(isRegionCenter);
        setIsCapital(isCapital);
    }

    public static City get(Scanner scanner){
        City city = new City();

        System.out.print("Введите название города: ");
        city.setName(scanner.next());

        return city;
    }

    public String getName(){ return this.name; }
    public boolean getIsCapital(){ return this.isCapital; }
    public boolean getIsRegionCenter(){ return this.isRegionCenter; }

    public void setName(String name) { this.name = name; }
    public void setIsCapital(boolean isCapital) { this.isCapital = isCapital; }
    public void setIsRegionCenter(boolean isRegionCenter) { this.isRegionCenter = isRegionCenter; }
}
