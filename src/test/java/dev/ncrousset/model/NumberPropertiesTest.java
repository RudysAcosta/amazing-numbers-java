package dev.ncrousset.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberPropertiesTest {

    @Test
    void testIsEven() {
        int[] numbers = {2,4,6,8,20, 100, 36, 78, 92, 76, };

        for (int num: numbers) {
            Number number = new Number(num);
            NumberProperties numberProperties = new NumberProperties(number);

            assertTrue(numberProperties.isEven());
        }
    }



}
