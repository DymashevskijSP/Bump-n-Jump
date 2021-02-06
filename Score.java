package DymashevskijJumpAndBump;

import java.awt.*;

import static DymashevskijJumpAndBump.Main.scoreBonus;
import static DymashevskijJumpAndBump.Main.scoreY;

public class Score implements Drawable {
    int val, x, y, number;
    public Score(int x, int number){
        this.x = x;
        this.y = scoreY;
        this.number = number;
        val = 0;
    }
    public void increment(){
        val += scoreBonus;
    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawString("Score"+Integer.toString(number)+": " + Integer.toString(val), x, y);
    }
}
