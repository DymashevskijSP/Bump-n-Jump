package DymashevskijJumpAndBump;

import static DymashevskijJumpAndBump.Main.*;

public class Hitable {
    int x, y, w, h;

    public Hitable(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    int hitTest(int x, int y, int w, int h) {
        int up = y;
        int down = y + h;
        int left = x;
        int right = x + w;
        int thisUp = this.y;
        int thisDown = this.y + this.h;
        int thisLeft = this.x;
        int thisRight = this.x + this.w;
        int centerY = this.y + this.h / 2;
        int centerX = this.x + this.w / 2;


        if (thisDown > down && thisUp < down && centerX < right && centerX > left) {
            return Main.pushedUp;
        }
        if (up > thisUp && up < thisDown && centerX < right && centerX > left) {
            return pushedDown;
        }

        if (thisLeft < right && thisRight > right && centerY < down && centerY > up) {
            return pushedLeft;
        }
        if (thisRight > left && thisLeft < left && centerY < down && centerY > up) {
            return pushedRight;
        }
        return notPushed;
    }
}
