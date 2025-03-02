package dev.ncrousset.io;

import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Scanner;

import dev.ncrousset.model.NumberProperties;
import dev.ncrousset.exception.PropertyInvalidaException;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private String[] tokens;

    private Set<String> properties;

    public InputHandler() {
        System.out.print("Enter a request: ");
        this.input = scanner.nextLine().trim();

        this.tokens = input.isEmpty() ? new String[0] : input.split("\\s+");

        setProperties();
    }

    public String[] getTokens() {
        return tokens;
    }

    public long[] validateAndParseInput() {

        int length = Math.min(tokens.length, 2);

        long[] numbers = new long[length];

        if (numbers[0] < 0) {
            throw new NumberFormatException("The first parameter should be a natural number or zero.");
        }

        try {
            numbers[0] = Long.parseLong(tokens[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The first parameter should be a natural number or zero.");
        }

        if (length > 1) {
            try {
                numbers[1] = Long.parseLong(tokens[1]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("The second parameter should be a natural number.");
            }
        }

        return numbers;
    }

    public void validateProperty() {

        validateMinProperties();
        validateMutuallyExclusiveProperties();

        Set<String> wrongProperties = new HashSet<>();

        for (String property : properties) {
            if(!NumberProperties.AVAILABLE_PROPERTIES.contains (property)) {
                wrongProperties.add(property);
            }
        }

        if (!wrongProperties.isEmpty()) {
            String title = wrongProperties.size() > 1 ? "are" : "is";
            throw new PropertyInvalidaException("The property [" + String.join(", ", wrongProperties) + "] "+title+" wrong.");
        }
    }

    private void validateMinProperties() {
        if (tokens.length < 3) {
            throw new NumberFormatException("The number of properties should be at least 3");
        }
    }

    private void validateMutuallyExclusiveProperties() {
        checkMutualExclusion("EVEN", "ODD");
        checkMutualExclusion("-EVEN", "-ODD");
        checkMutualExclusion("DUCK", "SPY");
        checkMutualExclusion("-DUCK", "-SPY");
        checkMutualExclusion("SUNNY", "SQUARE");
        checkMutualExclusion("-SUNNY", "-SQUARE");
        checkMutualExclusion("HAPPY", "SAD");
        checkMutualExclusion("-HAPPY", "-SAD");
    }

    private void checkMutualExclusion(String prop1, String prop2) {
        if (properties.contains(prop1) && properties.contains(prop2)) {
            throw new NumberFormatException("The request contains mutually exclusive properties: [" +  prop1 +", "+ prop2 +"]" +
                    "\n There are no numbers with these properties");
        }
    }

    private void setProperties() {
        int length = (tokens.length == 3) ? 1 : tokens.length - 2;
        Set<String> properties = new HashSet<>(Collections.emptySet());

        for(int i = 0; i < length; i++) {
            String property = tokens[i + 2].toUpperCase().trim();

            if (!property.isEmpty()) {
                properties.add(property);
            }
        }

        this.properties = properties;
    }

    public Set<String> getProperties() {
        return properties;
    }

    public void close() {
        scanner.close();
    }
}
