package lab4;

public class Main1 {
    public static void main(String[] args){
        Product[] products = new Product[3];

        products[0] = new Product(2, 3);
        products[1] = new Product(5, 5);
        products[2] = new Product(4, 3);

        for (var product : products){
            System.out.println("Price: " + product.getPrice() + ", amount: " + product.getAmount());
        }

        System.out.println("\nDoes product 1 equals product 2? " + products[0].isEquals(products[1]));
        System.out.println("\nSum of all prices is " + Product.allPrice(products) + ".");
    }
}
