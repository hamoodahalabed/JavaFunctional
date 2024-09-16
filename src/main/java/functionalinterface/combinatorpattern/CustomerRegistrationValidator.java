package functionalinterface.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static functionalinterface.combinatorpattern.ValidationResult.*;
// Static Methods: Provide implementations of apply
// through lambda expressions, returning instances of CustomerRegistrationValidator.

// so here we return the interface it take customer and return ValidationResult
public interface CustomerRegistrationValidator extends
        Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.email().contains("@") ?
                SUCCESS : EMAIL_INVALID;
    }

    static CustomerRegistrationValidator isPohoneNumberValid() {
        return customer -> customer.phoneNumber().startsWith("07") ?
                SUCCESS : PHONENUMBER_INVALID;
    }

    static CustomerRegistrationValidator isAnAdult () {
        return customer -> Period.between(customer.birthDate(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }


}
