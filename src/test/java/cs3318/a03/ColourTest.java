package cs3318.a03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The ColourTest class contains methods for testing:
 * if the colour object takes three parameters specifying colour components, in
 * the order red, green and blue, using a floating point values in the range 0.0 to 1.0;
 * if the colour object takes one parameter which is a combined RGB value
 * consisting of the red component in bits 16-23, the green component in bits 8-15, and the blue
 * component in bits 0-7;
 * if it is not allowed to create a Colour object without specifying valid component values; and
 * if colours can be compared and if considered to be equal they must have the same component values
 *
 * @author  Sharon Coffee
 * @version 1.0
 */


class ColourTest {

    float RED_FLOAT_VALUE1 = 0.1f;
    float GREEN_FLOAT_VALUE1 = 0.2f;
    float BLUE_FLOAT_VALUE1 = 0.3f;
    float RED_FLOAT_VALUE2 = 0.6f;
    float GREEN_FLOAT_VALUE2 = 0.5f;
    float BLUE_FLOAT_VALUE2 = 0.4f;
    float RED_FLOAT_VALUE3 = 0.9f;
    float GREEN_FLOAT_VALUE3 = 0.7f;
    float BLUE_FLOAT_VALUE3 = 0.8f;

    float RED_FLOAT_VALUE_WITHIN_BOUNDS = 1.0f;
    float GREEN_FLOAT_VALUE_WITHIN_BOUNDS = 0.0f;
    float BLUE_FLOAT_VALUE_WITHIN_BOUNDS = 0.5f;
    float RED_FLOAT_VALUE_BELOW_MINIMUM = -0.1f;
    float GREEN_FLOAT_VALUE_BELOW_MINIMUM = -0.2f;
    float BLUE_FLOAT_VALUE_BELOW_MINIMUM = -0.3f;
    float RED_FLOAT_VALUE_ABOVE_MAXIMUM = 1.1f;
    float GREEN_FLOAT_VALUE_ABOVE_MAXIMUM = 1.2f;
    float BLUE_FLOAT_VALUE_ABOVE_MAXIMUM = 1.3f;
    float DELTA1 = 0.1f;
    float DELTA2 = 0.00001f;
    int RGB = 0x010203;
    int RGB2 = 0x010204;
    int EXPECTED_RED_BIT = 0x01;
    int EXPECTED_GREEN_BIT = 0x02;
    int EXPECTED_BLUE_BIT = 0x03;
    int EXPECTED_RGB_FLOAT_VALUE = 16711807;
    int RED_BITS = 16;
    int GREEN_BITS = 8;
    int BLUE_BITS = 0;


    Colour testColour;

    @Test
    @DisplayName("Test the direct inputs and outputs of a test colour object")
    void testDirectInputsAndOutputs() {
        testColour = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE1);
        assertEquals(RED_FLOAT_VALUE1, testColour.getRed(), DELTA1);
        assertEquals(GREEN_FLOAT_VALUE1, testColour.getGreen(), DELTA1);
        assertEquals(BLUE_FLOAT_VALUE1, testColour.getBlue(), DELTA1);
    }

    @Test
    @DisplayName("Test that the colour constructor contains three parameters with floating point values ranging from 0.0 to 1.0")
    void testColourObjectConstructorTakesThreeParameters() {
        testColour = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE1);
        assertEquals(RED_FLOAT_VALUE1, testColour.getRed(), DELTA2);
        assertEquals(GREEN_FLOAT_VALUE1, testColour.getGreen(), DELTA2);
        assertEquals(BLUE_FLOAT_VALUE1, testColour.getBlue(), DELTA2);
    }

    @Test
    @DisplayName("Test the colour object constructor takes one parameter which produces combined RGB value with red component bits 16-23, green component bits 8-15 and blue component bits 0-7")
    void testColourObjectConstructorTakesOneParameter() {
        testColour = new Colour(RGB);
        assertEquals(EXPECTED_RED_BIT, testColour.red, DELTA2);
        assertEquals(EXPECTED_GREEN_BIT, testColour.green, DELTA2);
        assertEquals(EXPECTED_BLUE_BIT, testColour.blue, DELTA2);
    }

    @Test
    @DisplayName("Test the colour comparison is equal for colour object constructor with three parameters")
    void testColourComparisonIsEqualWithThreeParameters() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE1);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE1);
        assertEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test when colours are equal then they should have same red, green and blue values")
    void whenColoursAreEqualThenTheyShouldHaveSameRedGreenAndBlueValues() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        assertEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test the colour comparison is equal for colour object constructor with one parameter")
    void testColourComparisonIsEqualWithOneParameter() {
        Colour testColour1 = new Colour(RGB);
        Colour testColour2 = new Colour(RGB);
        assertEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test the colour comparison is not equal for colour object constructor with three parameters")
    void testColourComparisonIsNotEqualWithThreeParameters() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE1);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        assertNotEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test when colours are not equal then they should have different red, green and blue values")
    void whenColoursAreNotEqualThenTheyShouldHaveDifferentRedGreenOrBlueValues() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        assertNotEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test the colour comparison is not equal for colour object constructor with one parameter")
    void testColourComparisonIsNotEqualWithOneParameter() {
        Colour testColour1 = new Colour(RGB);
        Colour testColour2 = new Colour(RGB2);
        assertNotEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test that colours compared to one another containing similar values will be equal")
    public void testColoursComparedContainSimilarValuesAreEqual() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        Colour testColour3 = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        assertEquals(testColour1, testColour2);
        assertEquals(testColour1, testColour3);
        assertEquals(testColour2, testColour3);
    }

    @Test
    @DisplayName("Test that two colours compared to one another containing different values will not be equal")
    public void testColoursComparedContainDifferentValuesAreNotEqual() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE1);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        Colour testColour3 = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        assertNotEquals(testColour1, testColour2);
        assertNotEquals(testColour1, testColour3);
        assertNotEquals(testColour2, testColour3);
    }

    @Test
    @DisplayName("Test if colour object constructor taking three parameters is within floating point values from 0.0 to 1.0")
    void testColourConstructorWithinRangeReturnsColour() {
        testColour = new Colour(RED_FLOAT_VALUE_WITHIN_BOUNDS, GREEN_FLOAT_VALUE_WITHIN_BOUNDS, BLUE_FLOAT_VALUE_WITHIN_BOUNDS);
        assertEquals(RED_FLOAT_VALUE_WITHIN_BOUNDS, testColour.getRed());
        assertEquals(GREEN_FLOAT_VALUE_WITHIN_BOUNDS, testColour.getGreen());
        assertEquals(BLUE_FLOAT_VALUE_WITHIN_BOUNDS, testColour.getBlue());
    }

    @Test
    @DisplayName("Test if colour object constructor taking three parameters is exceeding the maximum floating point value of 1.0")
    void testColourConstructorOutOfMaximumRangeThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE_ABOVE_MAXIMUM, GREEN_FLOAT_VALUE_ABOVE_MAXIMUM, BLUE_FLOAT_VALUE_ABOVE_MAXIMUM));
    }

    @Test
    @DisplayName("Test if colour object constructor taking three parameters is less than the minimum floating point value of 0.0")
    void testColourConstructorOutOfMinimumRangeThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE_BELOW_MINIMUM, GREEN_FLOAT_VALUE_BELOW_MINIMUM, BLUE_FLOAT_VALUE_BELOW_MINIMUM));
    }

    @Test
    @DisplayName("Test set red values of the colour")
    void setRed() {
        testColour = new Colour(RED_FLOAT_VALUE_WITHIN_BOUNDS, GREEN_FLOAT_VALUE_WITHIN_BOUNDS, BLUE_FLOAT_VALUE_WITHIN_BOUNDS);
        testColour.setRed(RED_FLOAT_VALUE_WITHIN_BOUNDS);
        assertEquals(RED_FLOAT_VALUE_WITHIN_BOUNDS, testColour.getRed(), "Red values should be equal");
    }

    @Test
    @DisplayName("Test set green values of the colour")
    void setGreen() {
        testColour = new Colour(RED_FLOAT_VALUE_WITHIN_BOUNDS, GREEN_FLOAT_VALUE_WITHIN_BOUNDS, BLUE_FLOAT_VALUE_WITHIN_BOUNDS);
        testColour.setGreen(GREEN_FLOAT_VALUE_WITHIN_BOUNDS);
        assertEquals(GREEN_FLOAT_VALUE_WITHIN_BOUNDS, testColour.getGreen(), "Green values should be equal");
    }

    @Test
    @DisplayName("Test set blue values of the colour")
    void setBlue() {
        testColour = new Colour(RED_FLOAT_VALUE_WITHIN_BOUNDS, GREEN_FLOAT_VALUE_WITHIN_BOUNDS, BLUE_FLOAT_VALUE_WITHIN_BOUNDS);
        testColour.setBlue(BLUE_FLOAT_VALUE_WITHIN_BOUNDS);
        assertEquals(BLUE_FLOAT_VALUE_WITHIN_BOUNDS, testColour.getBlue(), "Blue values should be equal");
    }

    @Test
    @DisplayName("Test when creating a colour object with red, green and blue float values returns a combined RGB value that is correct")
    void testFloatValuesReturnsCombinedRGB() {
        testColour = new Colour(RED_FLOAT_VALUE_WITHIN_BOUNDS, GREEN_FLOAT_VALUE_WITHIN_BOUNDS, BLUE_FLOAT_VALUE_WITHIN_BOUNDS);
        assertEquals(EXPECTED_RGB_FLOAT_VALUE, testColour.getCombinedFloatRGB(RED_FLOAT_VALUE_WITHIN_BOUNDS, GREEN_FLOAT_VALUE_WITHIN_BOUNDS, BLUE_FLOAT_VALUE_WITHIN_BOUNDS));
    }

    @Test
    @DisplayName("Test when creating colour object with red, green and blue bit components returns a combined RGB value that is correct")
    void testColourBitValuesReturnsCombinedRGBValueIsCorrect() {
        testColour = new Colour(RGB);
        assertEquals(RGB, testColour.getCombinedHexRGB(EXPECTED_RED_BIT, EXPECTED_GREEN_BIT, EXPECTED_BLUE_BIT));
    }

    @Test
    @DisplayName("Test float components returns the expected values from the float array which is equal to the input.")
    void testFloatComponentsReturnsExpectedFloatValuesFromArray() {
        testColour = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        float[] expected = {RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2};
        assertArrayEquals(expected, testColour.getComponents());
    }

    @Test
    @DisplayName("Test red components are in bits 16-23")
    void testRedComponentsInBits() {
        testColour = new Colour(RGB);
        assertEquals(EXPECTED_RED_BIT, testColour.getRed());
    }

    @Test
    @DisplayName("Test green components are in bits 8-15")
    void testGreenComponentsInBits() {
        testColour = new Colour(RGB);
        assertEquals(EXPECTED_GREEN_BIT, testColour.getGreen());
    }

    @Test
    @DisplayName("Test blue components are in bits 0-7")
    void testBlueComponentsInBits() {
        testColour = new Colour(RGB);
        assertEquals(EXPECTED_BLUE_BIT, testColour.getBlue());
    }

    @Test
    @DisplayName("Test it is not allowed to create a Colour object without specifying valid red, green and blue component values.")
    void testNotAllowedToCreateColourObjectWithoutSpecifyingFloatColourComponents() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE_BELOW_MINIMUM, GREEN_FLOAT_VALUE_BELOW_MINIMUM, BLUE_FLOAT_VALUE_BELOW_MINIMUM));
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE_BELOW_MINIMUM, BLUE_FLOAT_VALUE1));
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE_BELOW_MINIMUM));
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE_ABOVE_MAXIMUM, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE3));
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE_ABOVE_MAXIMUM, BLUE_FLOAT_VALUE3));
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_FLOAT_VALUE_ABOVE_MAXIMUM, GREEN_FLOAT_VALUE_ABOVE_MAXIMUM, BLUE_FLOAT_VALUE_ABOVE_MAXIMUM));
    }

    @Test
    @DisplayName("Test that it is not allowed to create a Colour object without valid red bit component values from 16-23, green bit component values from 8-15 and blue bit component values from 0-7")
    void testNotAllowedToCreateColourObjectWithoutSpecifyingComponentBitValues() {
        assertThrows(IllegalArgumentException.class, () -> new Colour(RED_BITS, GREEN_BITS, BLUE_BITS));
    }

    @Test
    @DisplayName("Test objects from different class are not equal and should return false")
    void testEqualsDifferentClassShouldReturnFalse() {
        testColour = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE3);
        Object colourObject = "not a colour";
        boolean result = testColour.equals(colourObject);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test a null colour object should return false")
    void testEqualsNullObjectShouldReturnFalse() {
        testColour = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE1);
        boolean result = false;
        assertFalse(result);
    }

    @Test
    @DisplayName("Test colour object with same values are equal and should return true")
    void testEqualsObjectWithSameValuesShouldReturnTrue() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE2, GREEN_FLOAT_VALUE2, BLUE_FLOAT_VALUE2);
        boolean result = Objects.equals(testColour1, testColour2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test colour objects with different values are not equal and should return false")
    void testEqualsObjectWithDifferentValuesShouldReturnFalse() {
        Colour testColour1 = new Colour(RED_FLOAT_VALUE1, GREEN_FLOAT_VALUE1, BLUE_FLOAT_VALUE1);
        Colour testColour2 = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        boolean result = testColour1.equals(testColour2);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test that hash code is working correctly with valid input values")
    void testHashCode() {
        testColour = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        assertEquals(testColour.hashCode(), Float.floatToIntBits(RED_FLOAT_VALUE3) + Float.floatToIntBits(BLUE_FLOAT_VALUE3) + Float.floatToIntBits(GREEN_FLOAT_VALUE3));
    }

    @Test
    @DisplayName("Test that the string method returns a string of text")
    void testStringMethod() {
        testColour = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        String expected =  "Colour{red = 0.9, green = 0.7, blue = 0.8}";
        String actual = testColour.toString();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(floats = {0.0f, 0.1f, 0.2f})
    void testFloatColourComponents() {
        testColour = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        assertTrue(testColour.getRed() >= 0.0 && testColour.getRed() <= 1.0);
        assertTrue(testColour.getGreen() >= 0.0 && testColour.getGreen() <= 1.0);
        assertTrue(testColour.getBlue() >= 0.0 && testColour.getBlue() <= 1.0);
    }

    @ParameterizedTest
    @ValueSource(floats = {0.0f, 1.0f})
    void testFloatColourComponentsWithinRange() {
        testColour = new Colour(RED_FLOAT_VALUE3, GREEN_FLOAT_VALUE3, BLUE_FLOAT_VALUE3);
        assertTrue(RED_FLOAT_VALUE3 >= 0.0 && RED_FLOAT_VALUE3 <= 1.0);
        assertTrue(GREEN_FLOAT_VALUE3 >= 0.0 && GREEN_FLOAT_VALUE3 <= 1.0);
        assertTrue(BLUE_FLOAT_VALUE3 >= 0.0 && BLUE_FLOAT_VALUE3 <= 1.0);
    }



}