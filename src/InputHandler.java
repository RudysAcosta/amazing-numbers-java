import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private String[] tokens;

    public InputHandler() {
        System.out.print("Enter a request: ");
        this.input = scanner.nextLine().trim();
        this.tokens = input.split(" ");

    }

    public String[] getTokens() {
        return tokens;
    }

    public long[] validateAndParseInput() {

        int length = (tokens.length > 2) ? 2 : tokens.length;

        long[] numbers = new long[length];

        for (int i = 0; i < length; i++) {
            try {
                numbers[i] = Long.parseLong(tokens[i]);

                if (numbers[i] < 0) {
                    throw new NumberFormatException("The first parameter should be a natural number or zero.");
                }

            }catch (NumberFormatException e) {
                throw new NumberFormatException("The first parameter should be a natural number or zero.");
            }
        }

        return numbers;
    }

    public String validateProperty() {
        String property = "";

        if (tokens.length > 2) {
            property = tokens[2].toUpperCase();

            if (!Arrays.stream(NumberProperties.AVAILABLE_PROPERTIES).anyMatch(property::equals)) {
                throw new PropertyInvalidaException("The property [" + property + "] is wrong.");
            }
        }

        return property;
    }

    public String getProperty() {
        return input;
    }

    public void close() {
        scanner.close();
    }


}
