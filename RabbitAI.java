package DymashevskijJumpAndBump;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RabbitAI extends Rabbit {

    public RabbitAI(int x, int y, int w, int h, int scoreX, int number, File left, File right, File stop) throws IOException {
        super(x, y, w, h, scoreX, number, left, right, stop);
        isjumping = true;
    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    void update() {
        Random r = new Random();
        if (r.nextBoolean()) {
            isMovingLeft = true;
                        isMovingRight = false;
        } else {
            isMovingLeft = false;
            isMovingRight = true;
        }
        super.update();
    }
}
