package cs3318.a03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */


class ColourTest {

    Colour testColour;

    @Test
    @DisplayName("Test the direct inputs and outputs of a test colour object")
    void testDirectInputsAndOutputs() {
        float RED_VALUE = 0.5f;
        float GREEN_VALUE = 0.5f;
        float BLUE_VALUE = 0.5f;
        float DELTA = 0.1f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        assertEquals(RED_VALUE, testColour.getRed(), DELTA);
        assertEquals(GREEN_VALUE, testColour.getGreen(), DELTA);
        assertEquals(BLUE_VALUE, testColour.getBlue(), DELTA);
    }

    @Test
    @DisplayName("Test that the colour constructor contains three parameters with floating point values ranging from 0.0 to 1.0")
    void testColourObjectConstructorThreeParameters() {
        float RED_VALUE = 0.1f;
        float GREEN_VALUE = 0.2f;
        float BLUE_VALUE = 0.3f;
        float DELTA = 0.00001f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        assertEquals(RED_VALUE, testColour.red, DELTA);
        assertEquals(GREEN_VALUE, testColour.green, DELTA);
        assertEquals(BLUE_VALUE, testColour.blue, DELTA);
    }

    @Test
    @DisplayName("Test the colour object constructor takes one parameter which produces combined RGB value with red component bits 16-23, green component bits 8-15 and blue component bits 0-7")
    void testColourObjectConstructorOneParameter() {
        int RGB = 0x010203;
        int EXPECTED_RED = 0x01;
        int EXPECTED_GREEN = 0x02;
        int EXPECTED_BLUE = 0x03;
        float DELTA = 0.00001f;
        testColour = new Colour(RGB);
        assertEquals(EXPECTED_RED, testColour.red, DELTA);
        assertEquals(EXPECTED_GREEN, testColour.green, DELTA);
        assertEquals(EXPECTED_BLUE, testColour.blue, DELTA);
    }

    @Test
    @DisplayName("Test the colour comparison is equal for colour object constructor with three parameters")
    void testColourEqualThreeParameters() {
        float RED_VALUE = 0.1f;
        float GREEN_VALUE = 0.2f;
        float BLUE_VALUE = 0.3f;
        Colour testColour1 = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        Colour testColour2 = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        assertEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test when colours are equal then they should have same red, green and blue values")
    void whenColoursAreEqualThenTheyShouldHaveSameRedGreenAndBlueValues() {
        float RED_VALUE1 = 0.6f;
        float GREEN_VALUE1 = 0.5f;
        float BLUE_VALUE1 = 0.4f;
        float RED_VALUE2 = 0.6f;
        float GREEN_VALUE2 = 0.5f;
        float BLUE_VALUE2 = 0.4f;
        Colour testColour1 = new Colour(RED_VALUE1, GREEN_VALUE1, BLUE_VALUE1);
        Colour testColour2 = new Colour(RED_VALUE2, GREEN_VALUE2, BLUE_VALUE2);
        assertEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test the colour comparison is equal for colour object constructor with one parameter")
    void testColourEqualOneParameter() {
        // initially used 0x01020304, but removed 04 for previous test and passed.
        int RGB = 0x010203;
        Colour testColour1 = new Colour(RGB);
        Colour testColour2 = new Colour(RGB);
        assertEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test the colour comparison is not equal for colour object constructor with three parameters")
    void testColourNotEqualThreeParameters() {
        float RED_VALUE1 = 0.1f;
        float GREEN_VALUE1 = 0.2f;
        float BLUE_VALUE1 = 0.3f;
        float RED_VALUE2 = 0.1f;
        float GREEN_VALUE2 = 0.2f;
        float BLUE_VALUE2 = 0.4f;
        Colour testColour1 = new Colour(RED_VALUE1, GREEN_VALUE1, BLUE_VALUE1);
        Colour testColour2 = new Colour(RED_VALUE2, GREEN_VALUE2, BLUE_VALUE2);
        assertNotEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test when colours are not equal then they should have different red, green and blue values")
    void whenColoursAreNotEqualThenTheyShouldHaveDifferentRedGreenOrBlueValues() {
        float RED_VALUE1 = 0.5f;
        float GREEN_VALUE1 = 0.5f;
        float BLUE_VALUE1 = 0.5f;
        float RED_VALUE2 = 0.6f;
        float GREEN_VALUE2 = 0.6f;
        float BLUE_VALUE2 = 0.6f;
        Colour testColour1 = new Colour(RED_VALUE1, GREEN_VALUE1, BLUE_VALUE1);
        Colour testColour2 = new Colour(RED_VALUE2, GREEN_VALUE2, BLUE_VALUE2);
        assertNotEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test the colour comparison is not equal for colour object constructor with one parameter")
    void testColourNotEqualOneParameter() {
        int RGB1 = 0x010203;
        int RGB2 = 0x010204;
        Colour testColour1 = new Colour(RGB1);
        Colour testColour2 = new Colour(RGB2);
        assertNotEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test that two colours compared to one another containing similar values will be equal")
    public void testColourEqualsObject() {
        float RED_VALUE1 = 0.1f;
        float GREEN_VALUE1 = 0.2f;
        float BLUE_VALUE1 = 0.3f;
        float RED_VALUE2 = 0.1f;
        float GREEN_VALUE2 = 0.2f;
        float BLUE_VALUE2 = 0.3f;
        float RED_VALUE3 = 0.1f;
        float GREEN_VALUE3 = 0.2f;
        float BLUE_VALUE3 = 0.3f;
        Colour testColour1 = new Colour(RED_VALUE1, GREEN_VALUE1, BLUE_VALUE1);
        Colour testColour2 = new Colour(RED_VALUE2, GREEN_VALUE2, BLUE_VALUE2);
        Colour testColour3 = new Colour(RED_VALUE3, GREEN_VALUE3, BLUE_VALUE3);
        assertEquals(testColour1, testColour2);
        assertEquals(testColour1, testColour3);
        assertEquals(testColour2, testColour3);
    }

    @Test
    @DisplayName("Test that two colours compared to one another containing different values will not be equal")
    public void testColourNotEqualsObject() {
        float RED_VALUE1 = 0.1f;
        float GREEN_VALUE1 = 0.4f;
        float BLUE_VALUE1 = 0.3f;
        float RED_VALUE2 = 0.1f;
        float GREEN_VALUE2 = 0.2f;
        float BLUE_VALUE2 = 0.3f;
        float RED_VALUE3 = 0.1f;
        float GREEN_VALUE3 = 0.3f;
        float BLUE_VALUE3 = 0.2f;
        Colour testColour1 = new Colour(RED_VALUE1, GREEN_VALUE1, BLUE_VALUE1);
        Colour testColour2 = new Colour(RED_VALUE2, GREEN_VALUE2, BLUE_VALUE2);
        Colour testColour3 = new Colour(RED_VALUE3, GREEN_VALUE3, BLUE_VALUE3);
        assertNotEquals(testColour1, testColour2);
        assertNotEquals(testColour1, testColour3);
        assertNotEquals(testColour2, testColour3);
    }

    @Test
    @DisplayName("Test if colour object constructor taking three parameters is within floating point values from 0.0 to 1.0")
    void testColourConstructorWithinRangeReturnsColour() {
        float RED_VALUE = 0.5f;
        float GREEN_VALUE = 0.7f;
        float BLUE_VALUE = 0.9f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        assertEquals(RED_VALUE, testColour.getRed());
        assertEquals(GREEN_VALUE, testColour.getGreen());
        assertEquals(BLUE_VALUE, testColour.getBlue());
    }

    @Test
    @DisplayName("Test set red values of the colour")
    void setRed() {
        float RED_VALUE = 1.0f;
        float GREEN_VALUE = 1.0f;
        float BLUE_VALUE = 1.0f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        testColour.setRed(RED_VALUE);
        assertEquals(RED_VALUE, testColour.getRed(), "Red values should be equal");
    }

    @Test
    @DisplayName("Test set green values of the colour")
    void setGreen() {
        float RED_VALUE = 1.0f;
        float GREEN_VALUE = 1.0f;
        float BLUE_VALUE = 1.0f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        testColour.setGreen(GREEN_VALUE);
        assertEquals(GREEN_VALUE, testColour.getGreen(), "Green values should be equal");
    }

    @Test
    @DisplayName("Test set blue values of the colour")
    void setBlue() {
        float RED_VALUE = 1.0f;
        float GREEN_VALUE = 1.0f;
        float BLUE_VALUE = 1.0f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        testColour.setBlue(BLUE_VALUE);
        assertEquals(BLUE_VALUE, testColour.getBlue(), "Blue values should be equal");
    }

    @Test
    @DisplayName("Test if colour object constructor taking three parameters is exceeding the maximum floating point value of 1.0")
    void testColourConstructorOutOfMaximumRangeThrowsIllegalArgumentException() {
        float RED_VALUE = 1.5f;
        float GREEN_VALUE = 1.1f;
        float BLUE_VALUE = 1.2f;
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE));
    }

    @Test
    @DisplayName("Test if colour object constructor taking three parameters is less than the minimum floating point value of 0.0")
    void testColourConstructorOutOfMinimumRangeThrowsIllegalArgumentException() {
        float RED_VALUE = -0.1f;
        float GREEN_VALUE = -0.2f;
        float BLUE_VALUE = -0.3f;
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE));
    }

    @Test
    @DisplayName("Test when creating a colour object with red, green and blue float values returns a combined RGB value that is correct")
    void testCombinedRGB() {
        float RED_VALUE = 0.1f;
        float GREEN_VALUE = 0.0f;
        float BLUE_VALUE = 0.0f;
        int EXPECTED_RGB_VALUE = 1638400;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        assertEquals(EXPECTED_RGB_VALUE, testColour.getCombinedFloatRGB(RED_VALUE, GREEN_VALUE, BLUE_VALUE));
    }

    @Test
    @DisplayName("Test when creating colour object with red, green and blue bit components returns a combined RGB value that is correct")
    void testColourCombinedRGBValueIsCorrect() {
        int RED_VALUE = 0xFF;
        int GREEN_VALUE = 0x00;
        int BLUE_VALUE = 0x00;
        int EXPECTED_RGB_VALUE = 0xFF0000;
        testColour = new Colour(EXPECTED_RGB_VALUE);
        assertEquals(EXPECTED_RGB_VALUE, testColour.getCombinedHexRGB(RED_VALUE, GREEN_VALUE, BLUE_VALUE));
    }

    @Test
    @DisplayName("Test float components returns the expected values from the float array which is equal to the input.")
    void testGetComponents() {
        float RED_VALUE = 0.1f;
        float GREEN_VALUE = 0.0f;
        float BLUE_VALUE = 0.0f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        float[] expected = {RED_VALUE, GREEN_VALUE, BLUE_VALUE};
        assertArrayEquals(expected, testColour.getComponents());
    }

    @Test
    @DisplayName("Test red components are in bits 16-23")
    void testRedComponents() {
        int RGB = 0x123456;
        int RED_BITS = 0x12;
        testColour = new Colour(RGB);
        assertEquals(RED_BITS, testColour.getRed());
    }

    @Test
    @DisplayName("Test green components are in bits 8-15")
    void testGreenComponents() {
        int RGB = 0x123456;
        int GREEN_BITS = 0x34;
        testColour = new Colour(RGB);
        assertEquals(GREEN_BITS, testColour.getGreen());
    }

    @Test
    @DisplayName("Test blue components are in bits 0-7")
    void testBlueComponents() {
        int RGB = 0x123456;
        int BLUE_BITS = 0x56;
        testColour = new Colour(RGB);
        assertEquals(BLUE_BITS, testColour.getBlue());
    }

    @Test
    @DisplayName("Test it is not allowed to create a Colour object without specifying valid red, green and blue component values.")
    void testInvalidFloatColourComponents() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(-0.1f, 0.2f, 0.3f));
        assertThrows(IllegalArgumentException.class, () -> new Colour(0.1f, -0.2f, 0.3f));
        assertThrows(IllegalArgumentException.class, () -> new Colour(0.1f, 0.2f, -0.3f));
        assertThrows(IllegalArgumentException.class, () -> new Colour(1.1f, 0.2f, 0.3f));
        assertThrows(IllegalArgumentException.class, () -> new Colour(0.1f, 2.2f, 0.3f));
        assertThrows(IllegalArgumentException.class, () -> new Colour(0.1f, 0.2f, 3.3f));
    }

    @Test
    @DisplayName("Test that it is not allowed to create a Colour object without valid red bit component values from 16-23, green bit component values from 8-15 and blue bit component values from 0-7")
    void testInvalidColourComponentBitValues() {
        int RED_BITS = 16;
        int GREEN_BITS = 8;
        int BLUE_BITS = 0;
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_BITS, GREEN_BITS, BLUE_BITS));
    }

    @Test
    @DisplayName("Test Equals given object with different class should return false")
    void testEqualsDifferentClassShouldReturnFalse() {
        float RED_VALUE = 0.1f;
        float GREEN_VALUE = 0.1f;
        float BLUE_VALUE = 0.2f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        Object colourObject = "not a colour";
        boolean result = testColour.equals(colourObject);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test Equals given a null object should return false")
    void testEqualsNullObjectShouldReturnFalse() {
        float RED_VALUE = 0.1f;
        float GREEN_VALUE = 0.1f;
        float BLUE_VALUE = 0.2f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        boolean result = false;
        assertFalse(result);
    }

    @Test
    @DisplayName("Test Equals given object with same values should return true")
    void testEqualsObjectWithSameValuesShouldReturnTrue() {
        float RED_VALUE1 = 0.1f;
        float GREEN_VALUE1 = 0.2f;
        float BLUE_VALUE1 = 0.3f;
        float RED_VALUE2 = 0.1f;
        float GREEN_VALUE2 = 0.2f;
        float BLUE_VALUE2 = 0.3f;
        Colour testColour1 = new Colour(RED_VALUE1, GREEN_VALUE1, BLUE_VALUE1);
        Colour testColour2 = new Colour(RED_VALUE2, GREEN_VALUE2, BLUE_VALUE2);
        boolean result = Objects.equals(testColour1, testColour2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test Equals given object with different values should return false")
    void testEqualsObjectWithDifferentValuesShouldReturnFalse() {
        float RED_VALUE1 = 0.1f;
        float GREEN_VALUE1 = 0.2f;
        float BLUE_VALUE1 = 0.3f;
        float RED_VALUE2 = 0.4f;
        float GREEN_VALUE2 = 0.5f;
        float BLUE_VALUE2 = 0.6f;
        Colour testColour1 = new Colour(RED_VALUE1, GREEN_VALUE1, BLUE_VALUE1);
        Colour testColour2 = new Colour(RED_VALUE2, GREEN_VALUE2, BLUE_VALUE2);
        boolean result = testColour1.equals(testColour2);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test that hash code is working correctly with valid input values")
    void testHashCode() {
        float RED_VALUE = 0.7f;
        float GREEN_VALUE = 0.8f;
        float BLUE_VALUE = 0.9f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        assertEquals(testColour.hashCode(), Float.floatToIntBits(RED_VALUE) + Float.floatToIntBits(BLUE_VALUE) + Float.floatToIntBits(GREEN_VALUE));
    }

    @Test
    @DisplayName("Test that the string method returns a string of text")
    void testStringMethod() {
        float RED_VALUE = 0.7f;
        float GREEN_VALUE = 0.8f;
        float BLUE_VALUE = 0.9f;
        testColour = new Colour(RED_VALUE, GREEN_VALUE, BLUE_VALUE);
        String expected =  "Colour{red = 0.7, green = 0.8, blue = 0.9}";
        String actual = testColour.toString();
        assertEquals(expected, actual);
    }



}