package src;

import java.awt.*;

public class Score implements Drawable {
    int val, x, y, number;

    public Score(int x, int number) {
        this.x = x;
        this.y = Main.scoreY;
        this.number = number;
        val = 0;
    }

    public void increment() {
        val += Main.scoreBonus;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawString("src.Score" + Integer.toString(number) + ": " + Integer.toString(val), x, y);
    }
}
