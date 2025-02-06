import java.util.Arrays;

public class MultipleNumbersPrinter  implements NumberPrinter {
    private final long start;
    private final long end;

    private Number[] numbers;

    public MultipleNumbersPrinter(long start, long end) {
        this.start = start;
        this.end = end;

        int diff = (int) (end - start);
        numbers = new Number[diff + 1];

        for (int i = 0; i <= diff; i++) {
            numbers[i] = new Number(start + i);
        }
    }

    public void print() {
        System.out.println("Printing numbers between " + start + " and " + end);
        System.out.println(Arrays.toString(numbers));
    }

}
