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
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
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

    public boolean equals(Colour other) {
        if (this.red == other.red && this.green == other.green && this.blue == other.blue) {
            return true;
        }
        return false;
    }
}
