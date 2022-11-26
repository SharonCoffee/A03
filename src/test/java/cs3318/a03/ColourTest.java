package cs3318.a03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {

    Colour testColour;

    @BeforeEach
    void createTestColour() {
        // requires values and there is no empty constructor in the Colour class
        //testColour = new Colour();
    }

    @Test
    @DisplayName("Test the direct inputs and outputs of a test colour object")
    void testDirectInputsAndOutputs() {
        testColour = new Colour(0.5f, 0.5f, 0.5f);
        assertEquals(0.5f, testColour.getRed(), 0.1f);
        assertEquals(0.5f, testColour.getGreen(), 0.1f);
        assertEquals(0.5f, testColour.getBlue(), 0.1f);
    }

    @Test
    @DisplayName("Test that the colour constructor contains three parameters with floating point values ranging from 0.0 to 1.0")
    void testColourObjectConstructorThreeParameters() {
        float RED_VALUE = 0.1f;
        float GREEN_VALUE = 0.2f;
        float BLUE_VALUE = 0.3f;
        float DELTA = 0.00001f;
        testColour = new Colour(0.1f, 0.2f, 0.3f);
        assertEquals(0.1f, testColour.red, 0.00001f);
        assertEquals(0.2f, testColour.green, 0.00001f);
        assertEquals(0.3f, testColour.blue, 0.00001f);
    }

    @Test
    @DisplayName("Test the colour object constructor takes one parameter which produces combined RGB value with red component bits 16-23, green component bits 8-15 and blue component bits 0-7")
    void testColourObjectConstructorOneParameter() {
        testColour = new Colour(0x010203);
        assertEquals(0x01, testColour.red, 0.00001f);
        assertEquals(0x02, testColour.green, 0.00001f);
        assertEquals(0x03, testColour.blue, 0.00001f);
    }

    @Test
    @DisplayName("Test the colour comparison is equal for colour object constructor with three parameters")
    void testColourEqualThreeParameters() {
        Colour testColour1 = new Colour(0.1f, 0.2f, 0.3f);
        Colour testColour2 = new Colour(0.1f, 0.2f, 0.3f);
        assertTrue(testColour1.equals(testColour2));
    }

    @Test
    @DisplayName("Test when colours are equal then they should have same red, green and blue values")
    void whenColoursAreEqualThenTheyShouldHaveSameRedGreenAndBlueValues() {
        Colour testColour1 = new Colour(0.6f, 0.5f, 0.4f);
        Colour testColour2 = new Colour(0.6f, 0.5f, 0.4f);
        assertEquals(testColour1, testColour2);
    }

    @Test
    @DisplayName("Test the colour comparison is equal for colour object constructor with one parameter")
    void testColourEqualOneParameter() {
        Colour testColour1 = new Colour(0x010203);
        Colour testColour2 = new Colour(0x010203);
        assertTrue(testColour1.equals(testColour2));
    }

    @Test
    @DisplayName("Test the colour comparison is not equal for colour object constructor with three parameters")
    void testColourNotEqualThreeParameters() {
        Colour testColour1 = new Colour(0.1f, 0.2f, 0.3f);
        Colour testColour2 = new Colour(0.1f, 0.2f, 0.4f);
        assertFalse(testColour1.equals(testColour2));
    }

    @Test
    @DisplayName("Test when colours are not equal then they should have different red, green and blue values")
    void whenColoursAreNotEqualThenTheyShouldHaveDifferentRedGreenOrBlueValues() {
        Colour testColour1 = new Colour(0.5f, 0.5f, 0.5f);
        Colour testColour2 = new Colour(0.6f, 0.6f, 0.6f);
        assertNotEquals(testColour1, testColour2);
    }



}