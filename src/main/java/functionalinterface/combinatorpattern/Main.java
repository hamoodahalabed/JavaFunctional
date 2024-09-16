package functionalinterface.combinatorpattern;

import java.time.LocalDate;

import static functionalinterface.combinatorpattern.CustomerRegistrationValidator.*;
import static functionalinterface.combinatorpattern.ValidationResult.EMAIL_INVALID;
import static functionalinterface.combinatorpattern.ValidationResult.SUCCESS;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Mohammad",
                "mohammad@gamil.com",
                "0788856696",
                LocalDate.of(2002,3,30)
        );

        ValidationResult result = isEmailValid()
                .and(isPohoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);
    }

}
