package dev.ncrousset.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberPropertiesTest {

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,20, 100, 36, 78, 92, 76,})
    void testIsEven(int num) {
        Number number = new Number(num);
        NumberProperties numberProperties = new NumberProperties(number);

        assertTrue(numberProperties.isEven());
    }

}
