package DymashevskijJumpAndBump;

import java.awt.*;
import java.io.IOException;

public class InvisibleWall extends Wall {
    boolean isPushed = false;
    public InvisibleWall(int x, int y, int w, int h) throws IOException {
        super(x, y, w, h);
    }

    @Override
    public void draw(Graphics2D g2d) {
        isPushed = false;
        for(Rabbit r: Main.currlevel.rabbits){
            if(r.hitTest(x, y, w, h)!= 0){
                isPushed = true;
            }
        }
        if(isPushed){
            g2d.drawImage(img, x, y, w, h, (img, infoflags, x, y, width, height) -> false);
        }
    }
}
