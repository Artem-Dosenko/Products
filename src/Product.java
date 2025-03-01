import java.util.List;

public class Product {
    private String type;
    private double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public static List<Product> removeNotBooks(List<Product> products){
        return products.stream()
                .filter(s -> s.getType().equals("Book") && s.getPrice() > 250)
                .peek(System.out::println)
                .toList();
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
