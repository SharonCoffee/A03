package cs3318.a03;

public class Colour {
    public float red;
    public float green;
    public float blue;

    int RGB;

    public Colour(float red, float green, float blue) {
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
}
