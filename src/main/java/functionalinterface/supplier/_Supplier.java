package functionalinterface.supplier;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getConnection());
        System.out.println(getDBConnectionSupplier.get());
    }

    public static String getConnection() {
        return "jdbc:postgresql://localhost:5432/postgres";
    }

    public static Supplier<List<String>> getDBConnectionSupplier = () ->
            List.of("jdbc:postgresql://localhost:5432/postgres",
                    "jdbc:postgresql://localhost:5432/user",
                    "jdbc:postgresql://localhost:5432/suppliers");
}
