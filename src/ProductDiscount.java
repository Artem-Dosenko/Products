import java.util.Comparator;
import java.util.List;

public class ProductDiscount{
    private String type;
    private double price;
    private boolean discount;

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

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public ProductDiscount(String type, int price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public static void useDiscountOnBooks(List<ProductDiscount> productDiscounts){
        productDiscounts.stream()
                .filter(s -> s.getType().equals("Book") && s.isDiscount())
                .peek(s -> {
                    s.setPrice(s.getPrice() - (s.getPrice() * 0.1));
                    System.out.println(s);
                })
                .toList();

    }

    public static ProductDiscount findCheapestBook(List<ProductDiscount> productDiscounts) throws ProductNotFoundExeption{
        return productDiscounts.stream()
                .filter(s -> s.getType().equals("Book"))
                .min(Comparator.comparingDouble(ProductDiscount::getPrice))
                .orElseThrow(() -> new ProductNotFoundExeption("Books were not found"));
    }

    @Override
    public String toString() {
        return "ProductDiscount{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
