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




}