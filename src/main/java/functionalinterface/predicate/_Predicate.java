package functionalinterface.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("0788856696"));
        System.out.println(isPhoneNumberValid("0909211123"));

        Predicate<String> isPhoneNumberValid = phoneNumber -> {
            return phoneNumber.startsWith("07") && phoneNumber.length() == 10;
        };

        System.out.println(isPhoneNumberValid.test("0909211123"));

        DealWithPredicate<Integer> isGreaterThan100 = number -> number > 100;
        System.out.println(isGreaterThan100.test(101));

        Predicate<String> containNumber3 = s-> s.contains("3");
        //can use or instead of and
        boolean isContain3AndValid = isPhoneNumberValid.and(containNumber3).test("0709211123");
        System.out.println(isContain3AndValid);

        // same thing there is BiPredicate
        BiPredicate <String, Integer> numberEqualString = (string,number) -> {
            return string.equals(String.valueOf(number));
        };

        System.out.println(numberEqualString.test("100", 100));
    }

    public static boolean isPhoneNumberValid (String phoneNumber) {
        return (
                phoneNumber.startsWith("07") &&
                phoneNumber.length() == 10
        );
    }
}
