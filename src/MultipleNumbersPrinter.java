import java.util.ArrayList;
import java.util.Arrays;

public class MultipleNumbersPrinter  implements NumberPrinter {
    private final long start;
    private final int quantity;

    private Number[] numbers;

    public MultipleNumbersPrinter(long start, int  quantity) {
        this.start = start;
        this.quantity = quantity;

        numbers = new Number[quantity];

        for (int i = 0; i < quantity; i++) {
            long number = start + i;
            numbers[i] = new Number(number);
        }
    }

    public void print() {
        System.out.println();
        for(Number number : numbers) {
            System.out.println(number.getValue() + " is " + getProperties(number));
        }
        System.out.println();
    }

    private String getProperties(Number number) {
        NumberProperties properties = new NumberProperties(number);
        ArrayList<String> propertiesString = new ArrayList<>();


        if ((properties.isDivisibleBy(7) || number.getLastDigit() == 7)) {
            propertiesString.add("buzz");
        }

        if (properties.isDuck()) {
            propertiesString.add("duck");
        }

        if (properties.isGapful()) {
            propertiesString.add("gapful");
        }

        if (properties.isEven()) {
            propertiesString.add("even");
        }

        if (!properties.isEven()) {
            propertiesString.add("odd");
        }

        return String.join(" ", propertiesString);
    }

}
