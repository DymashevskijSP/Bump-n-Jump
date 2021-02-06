package DymashevskijJumpAndBump;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Background implements Drawable {
    BufferedImage img;
    int x, y, w, h;
    public Background(int x, int y, int w, int h, String filename) throws IOException {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.img = ImageIO.read(new File(filename));
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, w, h, (img, infoflags, x, y, width, height) -> false);
    }
}
