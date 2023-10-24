package lab11;

import java.io.Serializable;
import java.util.List;

public class Rate implements Serializable, Comparable<Rate>{
    private String name;
    private List<Service> services;
    private int price;

    @Override
    public int compareTo(Rate rate) {
        return Integer.compare(this.getPrice(), rate.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder servicesBuilder = new StringBuilder();
        for (var service : services) {
            servicesBuilder.append("\n\t\t\t").append(service.toString());
        }

        return "Rate{" +
                "name='" + name + '\'' +
                ", services=" + servicesBuilder.toString() +
                ", price=" + price +
                '}';
    }

    public Rate(String name, List<Service> services) {
        this.name = name;
        this.services = services;
        this.price = 0;
        services.forEach(service -> this.price += service.getPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
