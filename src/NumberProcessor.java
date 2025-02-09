public class NumberProcessor {
    public static void process(long[] numbers, String propety) {

        NumberPrinter printer;

        if (numbers.length == 1) {
            long number = numbers[0];

            if (number == 0) {
                System.out.println();
                System.out.println("Goodbye!");
                System.exit(0);
            }

            printer = new SingleNumberPrinter(new Number(number));
        } else if (numbers.length == 2) {
            long start = numbers[0];
            int quantity = (int) numbers[1];
            printer = new MultipleNumbersPrinter(start, quantity);
        } else if (numbers.length == 3) {
            long start = numbers[0];
            int quantity = (int) numbers[1];

            System.out.println(propety);

            printer = new MultipleNumbersPrinter(start, quantity);
        } else {
            System.out.println("Entrada no válida.");
            return;
        }

        printer.print();
    }
}
