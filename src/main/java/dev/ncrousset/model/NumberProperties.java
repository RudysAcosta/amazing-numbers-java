package dev.ncrousset.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class NumberProperties {

    private final Number number;

    public static final Set<String> AVAILABLE_PROPERTIES = Set.of(
            "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD",
            "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD"
    );

    public NumberProperties(Number number) {
        this.number = number;
    }

    public boolean isEven() {
        return number.getValue() % 2 == 0;
    }

    public boolean isDivisibleBy(int divisor) {
        return number.getValue() % divisor == 0;
    }

    public boolean isDuck() {
        long tempNumber = number.getValue();
        while(tempNumber >= 10) {
            if (tempNumber % 10 == 0) {
                return true;
            }

            tempNumber /= 10;
        }
        return false;
    }

    public boolean isPalindrome() {
        if (number.getValue() == 0) return false;

        long tempNumber = number.getValue(), reversed = 0;
        while (tempNumber > 0) {
            long lastNumber = tempNumber % 10;
            reversed = reversed * 10 + lastNumber;
            tempNumber /= 10;
        }

        return number.getValue() == reversed;
    }

    public boolean isGapful() {
        if (number.getValue() <= 99) return false;

        return number.getValue() % ((number.getFirstDigit() * 10L) + number.getLastDigit()) == 0;
    }

    public boolean isSpy() {
        int[] digits = number.getDigits();
        long product = 1, sum = 0;

        for (int digit : digits) {
            product *= digit;
            sum += digit;
        }

        return product == sum;
    }

    public boolean isPerfectSquareNumber(long number) {
        if (number == 0) return false;

        long sqrt = (long) Math.sqrt(number);

        return sqrt * sqrt == number;
    }

    public boolean isPerfectSquareNumber() {
        if (number.getValue() == 0) return false;

        long sqrt = (long) Math.sqrt(number.getValue());

        return sqrt * sqrt == number.getValue();
    }

    public boolean isSunnyNumber() {
        return isPerfectSquareNumber(number.getValue() + 1);
    }

    public boolean isJumping() {
        int[] digits = number.getDigits();

        if (digits.length == 1) return true;

        for (int i = 1; i < digits.length; i++) {
            if (Math.abs(digits[i -1] - digits[i]) != 1) return false;
        }

        return true;
    }


    public boolean checkProperty(String property) {
        Map<String, Supplier<Boolean>> properties = new HashMap<>();

        properties.put("BUZZ", () -> isDivisibleBy(7) || (number != null && number.getLastDigit() == 7));
        properties.put("DUCK", this::isDuck);
        properties.put("PALINDROMIC", this::isPalindrome);
        properties.put("GAPFUL", this::isGapful);
        properties.put("SPY", this::isSpy);
        properties.put("EVEN", this::isEven);
        properties.put("ODD", () -> !isEven());
        properties.put("SQUARE", this::isPerfectSquareNumber);
        properties.put("SUNNY", this::isSunnyNumber);
        properties.put("JUMPING", this::isJumping);
//        properties.put("HAPPY", this::isHappy);

        return properties.getOrDefault(property.toUpperCase(), () -> false).get();
    }

}
