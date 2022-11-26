package cs3318.a03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {

    Colour testColour;

    @BeforeEach
    void createTestColour() {
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



}