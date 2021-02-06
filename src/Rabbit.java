package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Rabbit extends Hitable implements Drawable {
    double vx = 0, vy = 0;
    int keyUp, keyLeft, keyRight;

    Score score;
    boolean isPushedUp, isPushedDown, isPushedRight, isPushedLeft;
    boolean isMovingRight;
    boolean isMovingLeft;
    boolean isjumping;
    BufferedImage rabbitLeft;
    BufferedImage rabbitRight;
    BufferedImage rabbitStop;

    public void setScore(int x, int number) {
        this.score = new Score(x, number);
    }

    public Rabbit(int x, int y, int w, int h, int scoreX, int number, File left, File right, File stop) throws IOException {
        super(x, y, w, h);
        this.rabbitLeft = ImageIO.read(left);
        this.rabbitRight = ImageIO.read(right);
        this.rabbitStop = ImageIO.read(stop);
        setScore(scoreX, number);
    }


    public void draw(Graphics2D g2d) {
        Image rabbit;

        if (vx < 0)
            rabbit = rabbitLeft;
        else if (vx > 0)
            rabbit = rabbitRight;
        else {

            rabbit = rabbitStop;

        }
        g2d.drawImage(rabbit, this.x, this.y, this.w, this.h, null, (img, infoflags, x, y, width, height) -> false);
        g2d.drawString(Integer.toString(score.number), this.x + (int) this.w / 2, (int) (this.y - Main.rabbitNumberDeltaY));
    }


    void setKeyCodes(int u, int l, int r) {
        keyUp = u;
        keyLeft = l;
        keyRight = r;
    }

    void upScore() {
        this.score.increment();
    }

    void die() {
        this.y = 0;
        this.x = new Random().nextInt(Main.rabbitRespawnBound);
        this.vy = 0;
    }

    void update() {
        isPushedUp = false;
        isPushedDown = false;
        isPushedLeft = false;
        isPushedRight = false;
        vy += Main.g;
        vy = Math.min(vy, Main.maxYSpeed);
        for (Hitable obj : Main.currlevel.hitables
        ) {
            if (!obj.equals(this)) {
                int res = hitTest(obj.x, obj.y, obj.w, obj.h);
                if (res == Main.pushedUp) {
                    if (obj instanceof Rabbit) {
                        this.die();
                        ((Rabbit) obj).upScore();
                    }
                    isPushedUp = true;
                }
                if (res == Main.pushedRight) {
                    isPushedRight = true;
                }
                if (res == Main.pushedDown) {
                    isPushedDown = true;
                }
                if (res == Main.pushedLeft) {
                    isPushedLeft = true;
                }
            }
        }
        if (isPushedUp && vy < 0) {
            vy = 0;
        }
        if (isPushedDown && vy > 0) {
            vy = 0;
        }
        if (isPushedRight && vx > 0) {
            vx = 0;
        }
        if (isPushedLeft && vx < 0) {
            vx = 0;
        }

        x += vx;
        y += vy;
        if (y > Main.panel.getHeight()) {
            y = 0;
            vy = 0;
        }
        if (isPushedDown && isjumping) {
            vy = Main.jumpSpeed;
        }
        if (isMovingRight && !isPushedRight) {
            vx += Main.LeftRightspeed;
            vx = Math.min(Main.maxLeftRightSpeed, vx);
        } else if (isMovingLeft && !isPushedLeft) {
            vx -= Main.LeftRightspeed;
            vx = Math.max(vx, -Main.maxLeftRightSpeed);
        } else if (!(isMovingLeft || isMovingRight)) {
            vx /= Main.stopAcceleration;
            if (Math.abs(vx) < Main.minimumXSpeed) {
                vx = 0;
            }
        }

    }

    public void keyPressed(int key) {

        if (key == keyUp) {
            isjumping = true;
        }
        if (key == keyLeft) {
            isMovingLeft = true;
            isMovingRight = false;
        }
        if (key == keyRight) {
            isMovingRight = true;
            isMovingLeft = false;
        }
    }

    public void keyReleased(int key) {
        if (key == keyUp) {
            isjumping = false;
        }
        if (key == keyLeft) {
            isMovingLeft = false;
        }
        if (key == keyRight) {
            isMovingRight = false;
        }
    }

}
