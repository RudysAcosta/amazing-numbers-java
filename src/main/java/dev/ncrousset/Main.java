package dev.ncrousset;

import dev.ncrousset.exception.PropertyInvalidaException;
import dev.ncrousset.io.InputHandler;
import dev.ncrousset.model.*;
import dev.ncrousset.processor.NumberProcessor;

import java.util.Collections;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        printSupportedRequests();


        while(true) {
            InputHandler inputHandler = new InputHandler();
            int numberOfTokens = inputHandler.getTokens().length;

            if (numberOfTokens == 0) {
                printSupportedRequests();
                continue;
            }

            try {
                long[] numbers = inputHandler.validateAndParseInput();

                Set<String> properties;

                if (numberOfTokens > 2) {
                    inputHandler.validateProperty();
                    properties = inputHandler.getProperties();
                } else {
                    properties = Collections.emptySet();
                }

                NumberProcessor.process(numbers, properties);

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
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();

    }
}