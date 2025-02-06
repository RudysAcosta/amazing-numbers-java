public class NumberProcessor {
    public static void process(long[] numbers) {

        NumberPrinter printer;

        if (numbers.length == 1) {
            long number = numbers[0];
            printer = new SingleNumberPrinter(new Number(number));
        } else if (numbers.length == 2) {
            long start = numbers[0];
            long end = numbers[1];
            printer = new MultipleNumbersPrinter(start, end);
        } else {
            System.out.println("Entrada no válida.");
            return;
        }

        printer.print();
    }
}
