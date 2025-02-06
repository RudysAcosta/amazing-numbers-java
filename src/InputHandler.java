import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);
    private String input;

    public InputHandler() {
        System.out.print("Enter a request: ");
        this.input = scanner.nextLine().trim();
    }

    public String getInput() {
        return this.input;
    }

    public long[] validateAndParseInput() {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        String[] tokens = input.split(" ");
        long[] numbers = new long[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
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

    public void close() {
        scanner.close();
    }


}
