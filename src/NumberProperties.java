class NumberProperties {

    private final Number number;


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

}
