package cs3318.a03;

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
        int result = (red != 0.0f ? Float.floatToIntBits(red) : 0);
        result = result + (green != 0.0f ? Float.floatToIntBits(green) : 0);
        result = result + (blue != 0.0f ? Float.floatToIntBits(blue) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Colour{" + "red = " + red + ", green = " + green + ", blue = " + blue + "}";
    }

}
