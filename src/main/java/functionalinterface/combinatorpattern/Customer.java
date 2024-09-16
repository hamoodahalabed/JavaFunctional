package functionalinterface.combinatorpattern;

import java.time.LocalDate;

public record Customer (
        String name,
        String email,
        String phoneNumber,
        LocalDate birthDate
) {
}
