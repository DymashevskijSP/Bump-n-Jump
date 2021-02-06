package DymashevskijJumpAndBump;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import static DymashevskijJumpAndBump.Main.wallImg;


class Wall extends Hitable implements Drawable {
    BufferedImage img;

    public Wall(int x, int y, int w, int h) throws IOException {
        super(x, y, w, h);
        this.img = wallImg;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, w, h, (img, infoflags, x, y, width, height) -> false);
    }
}
