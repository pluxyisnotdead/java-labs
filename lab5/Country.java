package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Country {
    private String name;
    private Double area;
    private ArrayList<Region> regions;
    public City capital;

    Country(){
        setName("");
        setRegions(new ArrayList<Region>());
    }

    Country(String name, ArrayList<Region> regions, City capital){
        setName(name);
        setRegions(regions);
        setCapital(capital);
    }

    public static Country get(Scanner scanner){
        Country country = new Country();

        System.out.println("Определимся с государством.");

        System.out.print("Введите название государства: ");
        country.setName(scanner.next());

        System.out.print("Введите площадь государства: ");
        country.setArea(scanner.nextDouble());

        System.out.println("\nОпределимся со столицей.");
        country.capital = City.get(scanner);
        country.capital.setIsCapital(true);
        country.capital.setIsRegionCenter(true);

        District centralDistrict = District.get(scanner);
        centralDistrict.addCity(country.capital);

        Region centralRegion = Region.get(scanner);
        centralRegion.setCenter(country.capital);

        country.addRegion(centralRegion);

        return country;
    }

    public void addRegion(Region region){
        this.regions.add(region);
    }

    public int amountOfRegions(){
        return this.regions.size();
    }

    public String getName(){ return this.name; }
    public Double getArea(){ return this.area; }
    public List<Region> getRegions(){ return this.regions; }
    public City getCapital(){ return this.capital; }

    public void setName(String name){ this.name = name; }
    public void setArea(Double area){ this.area = area; }
    public void setRegions(ArrayList<Region> regions){ this.regions = regions; }
    public void setCapital(City capital){ this.capital = capital; }
}
