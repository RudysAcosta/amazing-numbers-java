package dev.ncrousset.model;

public class Number {

    private long value;

    public Number(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public int getLastDigit() {
        return (int) (value % 10);
    }

    public int getFirstDigit() {
        long num = value;
        while (num > 9) {
            num = num / 10;
        }
        return (int) num;
    }

    public int[] getDigits() {
        String s = Long.toString(this.value);
        int[] digits = new int[s.length()];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }

        return digits;
    }

}