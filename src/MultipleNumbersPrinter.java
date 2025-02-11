import java.text.NumberFormat;
import java.util.ArrayList;

public class MultipleNumbersPrinter  implements NumberPrinter {

    private Number[] numbers;

    public MultipleNumbersPrinter(long start, int  quantity) {
        numbers = new Number[quantity];

        for (int i = 0; i < quantity; i++) {
            long number = start + i;
            numbers[i] = new Number(number);
        }
    }

    public MultipleNumbersPrinter(long start, int  quantity, String property) {
        numbers = new Number[quantity];

        for (int i = 0; i < quantity; ) {
            Number number = new Number(start);
            NumberProperties numberProperties = new NumberProperties(number);

            boolean checkProperty = numberProperties.checkProperty(property);

            if (checkProperty) {
                numbers[i] = number;
                i++;
            }

            start++;
        }
    }

    public void print() {
        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println();
        for(Number number : numbers) {
            System.out.println(numberFormat.format(number.getValue()) + " is " + getProperties(number));
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

        if (properties.isPalindrome()) {
            propertiesString.add("palindromic");
        }

        if (properties.isSpy()) {
            propertiesString.add("spy");
        }

        if (properties.isPerfectSquareNumber()) {
            propertiesString.add("square");
        }

        if (properties.isSunnyNumber()) {
            propertiesString.add("sunny");
        }

        if (properties.isEven()) {
            propertiesString.add("even");
        }

        if (!properties.isEven()) {
            propertiesString.add("odd");
        }

        return String.join(", ", propertiesString);
    }

}
