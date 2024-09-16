package functionalinterface.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer mohammad = new Customer("Mohammad", "0788856696");
        greetCustomer(mohammad);

        Consumer<Customer> greetCustomerConsumer = customer -> {
            System.out.println(
                    "Hello, "
                            + customer.name()
                            + " thanks for showing your number "
                            + customer.phoneNumber()
            );
        };

        greetCustomerConsumer.accept(mohammad);

        DealWithConsumer<Customer> greetUser = customer -> {
            System.out.println(
                    "Hello, "
                            + customer.name()
                            + " thanks for showing your number "
                            + customer.phoneNumber()
            );
        };

        greetUser.accept(mohammad);

        BiConsumer<Customer,Boolean> shouldShowPhoneNumberWhenGreet = (customer, aBoolean) -> {
            System.out.println("Hello " + customer.name());
            if (aBoolean) {
                System.out.println("your phone number is " + customer.phoneNumber());
            } else {
                System.out.println("your phone number is " + "**********");
            }
        };

        shouldShowPhoneNumberWhenGreet.accept(mohammad,false);

        Consumer<Customer> consume = customer -> {
            System.out.println("Hello " + customer.name());
        };
        greetCustomerConsumer.andThen(consume).accept(mohammad);
    }

    public static void greetCustomer (Customer customer){
        System.out.println(
                "Hello, "
                + customer.name()
                + " thanks for showing your number "
                + customer.phoneNumber()
        );
    }
}
