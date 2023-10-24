package lab4;

public class Product {
    private int price;
    private int amount;

    Product(){
      setPrice(0);
      setAmount(0);
    }

    Product(int price, int amount){
        setPrice(price);
        setAmount(amount);
    }

    public int getPrice(){ return this.price; }

    private void setPrice(int price){
        this.price = price;
    }

    public int getAmount(){
        return this.amount;
    }

    private void setAmount(int amount){
        this.amount = amount;
    }

    public boolean isEquals(Product obj) {
        return this.getPrice() == obj.getPrice() && this.getAmount() == obj.getAmount();
    }

    public String toString(){
        return "{" + this.getPrice() + ", " + this.getAmount() + "}";
    }

    public static int allPrice(Product[] objects){
        int sum = 0;

        for (var object : objects){
            sum += object.getPrice();
        }

        return sum;
    }
}
