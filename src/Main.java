import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String separation = "----------------------";

        List<Product> products = List.of(new Product("Book", 500)
                                        ,new Product("Apple", 100)
                                        ,new Product("Book", 300)
                                        ,new Product("Book", 100)
                                        ,new Product("TV", 600)
                                        ,new Product("Book", 400));
        products.forEach(System.out::println);
        System.out.println();
        Product.removeNotBooks(products);
        System.out.println(separation);

        List<ProductDiscount> productDiscounts = List.of(new ProductDiscount("Book", 100, true)
                                                        ,new ProductDiscount("TV", 500, true)
                                                        ,new ProductDiscount("Book", 150, false)
                                                        ,new ProductDiscount("Book", 200, true)
                                                        ,new ProductDiscount("Book", 125, true));
        productDiscounts.forEach(System.out::println);
        System.out.println();
        ProductDiscount.useDiscountOnBooks(productDiscounts);
        System.out.println(separation);

        List<ProductDiscount> productDiscounts1 = List.of(new ProductDiscount("Book", 100, true)
                                                        ,new ProductDiscount("TV", 500, true)
                                                        ,new ProductDiscount("Book", 150, false)
                                                        ,new ProductDiscount("Book", 200, true)
                                                        ,new ProductDiscount("Book", 125, true));

        productDiscounts1.forEach(System.out::println);
        System.out.println();
        ProductDiscount cheapestBook = ProductDiscount.findCheapestBook(productDiscounts1);
        System.out.println(cheapestBook);
        System.out.println(separation);

        List<ProductDiscountDate> productsDiscountDates = List.of(new ProductDiscountDate("Book", 400, true, LocalDate.of(2025, 1, 31))
                                                                ,new ProductDiscountDate("TV", 400, true, LocalDate.of(2025, 2, 3))
                                                                ,new ProductDiscountDate("Guitar", 400, true, LocalDate.of(2025, 1, 30))
                                                                ,new ProductDiscountDate("TV", 400, true, LocalDate.of(2025, 2, 1))
                                                                ,new ProductDiscountDate("TV", 400, true, LocalDate.of(2025, 1, 29)));

        productsDiscountDates.forEach(System.out::println);
        System.out.println();
        productsDiscountDates = ProductDiscountDate.findThreeLast(productsDiscountDates);
        System.out.println(separation);

        List<ProductDiscountDate> productsDiscountDates1 = List.of(new ProductDiscountDate("Book", 72, true, LocalDate.of(2025, 1, 31))
                                                                ,new ProductDiscountDate("TV", 1500, true, LocalDate.of(2025, 2, 3))
                                                                ,new ProductDiscountDate("Guitar", 1000, false, LocalDate.of(2025, 1, 30))
                                                                ,new ProductDiscountDate("Book", 26, false, LocalDate.of(2025, 2, 1))
                                                                ,new ProductDiscountDate("Book", 100, true, LocalDate.of(2025, 1, 29)));

        productsDiscountDates1.forEach(System.out::println);
        double sumOfBookPrices = ProductDiscountDate.calculateBooksPrice(productsDiscountDates1);
        System.out.println();
        System.out.println("Sum of books' price: " + sumOfBookPrices);
    }
}
