import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        printSupportedRequests();

        while(true) {
            InputHandler inputHandler = new InputHandler();

            if (inputHandler.getTokens().length == 0) {
                printSupportedRequests();
                continue;
            }

            try {
                long[] numbers = inputHandler.validateAndParseInput();

                String property = inputHandler.validateProperty();

                NumberProcessor.process(numbers, property);

            } catch (NumberFormatException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            } catch (PropertyInvalidaException e) {
                System.out.println("\n" + e.getMessage());
                System.out.println("Available properties: [" + String.join(", ",
                        NumberProperties.AVAILABLE_PROPERTIES) + "] \n");
            }
        }

    }

    private static void printSupportedRequests() {
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("    * the first parameter represents a starting number;");
        System.out.println("    * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();

    }
}