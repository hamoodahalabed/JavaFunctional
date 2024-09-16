package functionalinterface.strams;

import ImperativeVsDeclarative.person.Person;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class _Streams {

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Product1", 19.99),
                new Product("Product2", 29.99),
                new Product("Product3", 39.99),
                new Product("Product4", 49.99),
                new Product("Product5", 59.99)
        );

        Function<Product,Product> formateProductFunction = product -> {
            return new Product(product.name() + "/new", product.price());
        };

        Predicate<Product> PriceGreaterThan30 = product -> product.price() > 30;

        List<Product> products1 = products.stream()
                .map(formateProductFunction)
                .filter(PriceGreaterThan30)
                .toList();

        // products1 == products2

        List<Product> products2 = products.stream()
                .map(p -> new Product(p.name() + "/new", p.price()))
                .filter(p -> p.price() > 30)
                .toList();

        products1.forEach(p1 -> System.out.println(p1.name() + " " + p1.price()));
        System.out.println("---------------------------------------------------");
        products2.forEach(p2 -> System.out.println(p2.name() + " " + p2.price()));
    }
}
