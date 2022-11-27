package cs3318.a03;


/**
 * @author Sharon Coffee
 * @version 1.0
 * Colour class takes three parameters containing float values for red, green and blue in the range from 0.0 to 1.0.
 * Colour class takes one parameter containing RGB component values with red component bits 16-23,
 *   green component bits 8-17 and blue component bits 0-7.
 * @returns true if colour objects with similar component values are equal.
 * @returns false if colour objects contain null values.
 * @returns float values if colour objects contain similar float component values.
 * @returns combined RGB component values converted from the float component values for red, green and blue.
 * @returns combined Hex component values converted from combined RGB component containing red bits 16-23, green bits 8-17 and blue bits 0-7.
 * @returns float component values from an array of float values for red, green and blue
 * @returns the hash result after converting the red, green and blue float values into the bit component values.
 * @returns String showing red, green and blue values used.
 */
public class Colour {
    public float red;
    public float green;
    public float blue;

    int RGB;

    public Colour(float red, float green, float blue) {
        if (red < 0 || red > 1 || green < 0 || green > 1 || blue < 0 || blue > 1) {
            throw new IllegalArgumentException("Invalid colour component value");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Colour(int RGB) {
        this.red = (RGB >> 16) & 0xff;
        this.green = (RGB >> 8) & 0xff;
        this.blue = RGB & 0xff;
        this.RGB = RGB;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

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

    public int getCombinedFloatRGB(float red, float green, float blue) {
        return ((int)(red * 255) << 16) | ((int)(green * 255) << 8) | (int)(blue * 255);
    }

    public int getCombinedHexRGB(int red, int green, int blue) {
        return (red << 16) | (green << 8) | blue;
    }

    public float[] getComponents() {
        float[] components = new float[3];
        components[0] = this.red;
        components[1] = this.green;
        components[2] = this.blue;
        return components;
    }

    @Override
    public int hashCode() {
        return (red != 0.0f ? Float.floatToIntBits(red) : 0)
                + (green != 0.0f ? Float.floatToIntBits(green) : 0)
                + (blue != 0.0f ? Float.floatToIntBits(blue) : 0);
    }

    @Override
    public String toString() {
        return "Colour{" + "red = " + red + ", green = " + green + ", blue = " + blue + "}";
    }

}
