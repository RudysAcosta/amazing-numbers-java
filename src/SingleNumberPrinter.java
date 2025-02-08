import java.text.NumberFormat;

public class SingleNumberPrinter implements NumberPrinter {

    private final Number number;

    public SingleNumberPrinter(Number number) {
        this.number = number;
    }

    @Override
    public void print() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        NumberProperties properties = new NumberProperties(number);

        System.out.println();
        System.out.printf("Properties of %s \n",  numberFormat.format(number.getValue()));
        System.out.printf("buzz: %b \n",  (properties.isDivisibleBy(7) || number.getLastDigit() == 7));
        System.out.printf("duck: %b \n",  properties.isDuck());
        System.out.printf("palindromic: %b \n",  properties.isPalindrome());
        System.out.printf("gapful: %b \n",  properties.isGapful());
        System.out.printf("spy: %b \n",  properties.isSpy());
        System.out.printf("even: %b \n",  properties.isEven());
        System.out.printf("odd: %b \n\n",  !properties.isEven());


    }
}
