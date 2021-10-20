package Test;

import AsciiImageMaker.AsciiImage;

public class Main {
    public static void main(String[] args) {
        AsciiImage ascii = new AsciiImage("src//resources//zebra.jpg");
        ascii.createImage();
    }
}
