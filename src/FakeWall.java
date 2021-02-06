package src;

import java.awt.*;

public class FakeWall implements Drawable {
    int x, y, w, h;
    boolean wasPushed = false;

    public FakeWall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (Rabbit r : Main.currlevel.rabbits) {
            if (r.hitTest(x, y, w, h) != 0) {
                wasPushed = true;
            }
        }
        if (!wasPushed) {
            g2d.setColor(Color.green);
            g2d.fillRect(x, y, w, h);
            g2d.setColor(Color.BLACK);
        }
    }
}
