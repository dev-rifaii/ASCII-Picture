import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

import java.awt.*;

public class Ascii {
    char chars[] = {'.', '\'', '`', '^', '"', ',', ':', ';', 'I', 'l', '!', 'i', '>', '<', '~', '+', '_', '-', '?',
            ']', '[', '}', '{', '1', ')', '(', '|', '\\', '/', 't', 'f', 'j', 'r', 'x', 'n', 'u', 'v', 'c', 'z', 'X',
            'Y', 'U', 'J', 'C', 'L', 'Q', '0', 'O', 'Z', 'm', 'w', 'q', 'p', 'd', 'b', 'k', 'h', 'a', 'o', '*', '#'
            , 'M', 'W', '&', '8', '%', 'B', '@', '$'};
    Color[][] colors;
    char[][] ascii;
    MarvinImage image;

    public Ascii(String path) {
        image = MarvinImageIO.loadImage(path);
        image.resize(300, 300);
        colors = new Color[image.getWidth()][image.getHeight()];
        ascii = new char[image.getWidth()][image.getHeight()];
    }

    public void fillColors() {
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                colors[i][j] = new Color(image.getIntComponent0(i, j), image.getIntComponent1(i, j), image.getIntComponent2(i, j));
            }
        }
    }

    public void fillAscii() {
        for (int i = 0; i < ascii.length; i++) {
            for (int j = 0; j < ascii[i].length; j++) {
                ascii[i][j] = chars[((((colors[i][j].getRed() + colors[i][j].getGreen() + colors[i][j].getBlue()) + 1) / 3) / 4)];
            }
        }
    }

    public void draw() {
        for (int i = 0; i < ascii.length; i++) {
            System.out.println();
            for (int j = 0; j < ascii[i].length; j++) {
                System.out.print(ascii[j][i]);
                System.out.print(ascii[j][i]);
                System.out.print(ascii[j][i]);
            }
        }
    }
}
