import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductDiscountDateID {
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductDiscountDateID(String type, double price, boolean discount, LocalDate createDate, int id) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
        this.id = id;
    }

    public static Map<String, List<ProductDiscountDateID>> sortByType(List<ProductDiscountDateID> products){
        return products.stream()
                .collect(Collectors.groupingBy(s -> s.type));
    }

    @Override
    public String toString() {
        return "ProductDiscountDateID{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                ", id=" + id +
                '}';
    }
}
