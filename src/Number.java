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
}