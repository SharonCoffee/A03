package cs3318.a03;


/**
 *
 * Colour class consists of a constructor for a colour object that takes three parameters specifying colour components, in
 * the order red, green and blue, using a floating point values in the range 0.0 to 1.0;
 * Colour class consists of a constructor for a colour object that takes one parameter which is a combined RGB value
 * consisting of the red component in bits 16-23, the green component in bits 8-15, and the blue component in bits 0-7;
 * It is not allowed to create a Colour object without specifying valid component values; and
 * Colours can be compared and if considered to be equal they must have the same component values
 *
 * @author Sharon Coffee
 * @version 1.0
 *
 */

public class Colour {
    public float red;
    public float green;
    public float blue;

    int RGB;

    /**
     *
     * @param red The float value for the red component.
     * @param green The float value for the green component.
     * @param blue The float value for the blue component.
     *
     * @throws IllegalArgumentException if Colour constructor contains invalid colour component values.
     *
     */
    public Colour(float red, float green, float blue) {
        if (red < 0 || red > 1 || green < 0 || green > 1 || blue < 0 || blue > 1) {
            throw new IllegalArgumentException("Invalid colour component value");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     *
     * @param RGB The combined RGB value
     */
    public Colour(int RGB) {
        this.red = (RGB >> 16) & 0xff;
        this.green = (RGB >> 8) & 0xff;
        this.blue = RGB & 0xff;
        this.RGB = RGB;
    }

    /**
     *
     * @param red The float value for the red component.
     */
    public void setRed(float red) {
        this.red = red;
    }

    /**
     *
     * @param green The float value for the green component.
     */
    public void setGreen(float green) {
        this.green = green;
    }

    /**
     *
     * @param blue The float value for the blue component.
     */
    public void setBlue(float blue) {
        this.blue = blue;
    }

    /**
     *
     * @return red
     */
    public float getRed() {
        return red;
    }

    /**
     *
     * @return green
     */
    public float getGreen() {
        return green;
    }

    /**
     *
     * @return blue
     */
    public float getBlue() {
        return blue;
    }

    /**
     *
     * @param colourObject The colour object
     * @return true if this colour is equal to the colourObject with similar component values;
     * false if colour objects contain null values; and
     * float values if colour objects contain similar float component values.
     */
    @Override
    public boolean equals(Object colourObject) {
        if (this == colourObject) {
            return true;
        }
        if (colourObject == null || getClass() != colourObject.getClass()) {
            return false;
        }
        Colour colour = (Colour) colourObject;
        return Float.compare(colour.red, red) == 0 && Float.compare(colour.green, green) == 0 && Float.compare(colour.blue, blue) == 0;
    }

    /**
     *
     * @param red The float value for the red component.
     * @param green The float value for the green component.
     * @param blue The float value for the blue component.
     * @return combined RGB component values converted from the float component values for red, green and blue.
     */
    public int getCombinedFloatRGB(float red, float green, float blue) {
        return ((int)(red * 255) << 16) | ((int)(green * 255) << 8) | (int)(blue * 255);
    }

    /**
     *
     * @param red The float value for the red component.
     * @param green The float value for the green component.
     * @param blue The float value for the blue component.
     * @return combined Hex component values converted from combined RGB component containing red bits 16-23, green bits 8-17 and blue bits 0-7.
     */
    public int getCombinedHexRGB(int red, int green, int blue) {
        return (red << 16) | (green << 8) | blue;
    }

    /**
     *
     * @return float component values from an array of float values for red, green and blue
     */
    public float[] getComponents() {
        float[] components = new float[3];
        components[0] = this.red;
        components[1] = this.green;
        components[2] = this.blue;
        return components;
    }

    /**
     *
     * @return the hash result after converting the red, green and blue float values into the bit component values.
     */
    @Override
    public int hashCode() {
        return (red != 0.0f ? Float.floatToIntBits(red) : 0)
                + (green != 0.0f ? Float.floatToIntBits(green) : 0)
                + (blue != 0.0f ? Float.floatToIntBits(blue) : 0);
    }

    /**
     *
     * @return String showing red, green and blue values used.
     */
    @Override
    public String toString() {
        return "Colour{" + "red = " + red + ", green = " + green + ", blue = " + blue + "}";
    }

}
