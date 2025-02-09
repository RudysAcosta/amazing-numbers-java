class NumberProperties {

    private final Number number;

    public static final String[] AVAILABLE_PROPERTIES = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD"};

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

}
