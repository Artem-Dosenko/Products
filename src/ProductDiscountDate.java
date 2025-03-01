import java.time.LocalDate;
import java.util.List;

public class ProductDiscountDate {
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public ProductDiscountDate(String type, double price, boolean discount, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public static List<ProductDiscountDate> findThreeLast(List<ProductDiscountDate> productDiscountDates){
        return productDiscountDates.stream()
                .skip(productDiscountDates.size() - 3)
                .peek(System.out::println)
                .toList();
    }

    public static double calculateBooksPrice(List<ProductDiscountDate> productDiscountDates) {
        return productDiscountDates.stream()
                .filter(s -> s.getCreateDate().getYear() < 2025 || s.getType().equals("Book") || s.getPrice() < 75)
                .mapToDouble(ProductDiscountDate::getPrice)
                .sum();
    }


    @Override
    public String toString() {
        return "ProductDiscountDate{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }
}
