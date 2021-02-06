//Dymashevskij Sergey
// Bump and Jump game'
//20.04.2018
package DymashevskijJumpAndBump;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    static final double g = 0.3;
    static final double maxYSpeed = 15;
    public static final int scoreY = 40;
    public static int scoreBonus = 1;
    public static int scoreXlength = 100;
    public static final double minimumXSpeed = 1;
    public static final int pushedRight = 4;
    public static final int pushedUp = 1;
    public static final int pushedDown = 3;
    public static final int pushedLeft = 2;
    public static final int jumpSpeed = -8;
    public static final int notPushed = 0;
    public static final double LeftRightspeed = 0.3;
    public static final double maxLeftRightSpeed = 5;
    public static final double stopAcceleration = 1.03;
    public static final int timerDelay = 20;
    public static final int windowWidth = 1500;
    public static double rabbitNumberDeltaY = 13;
    public static final int windowHeight = 800;
    public static final int rabbitRespawnBound = 700;
    public static final String projFolder = "src/DymashevskijJumpAndBump/";
    public static final Font defaultFont = new Font("Times new Roman", Font.BOLD, 14);
    public static BufferedImage wallImg;

    static {
        try {
            wallImg = ImageIO.read( new File(projFolder + "kirpich.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static MyPanel panel;
    static int AIcount;
    public static Level currlevel;

    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("BumpAndJump");

        currlevel = new Level(projFolder + "Level1", projFolder + "Rabbits");
        panel = new MyPanel();
        window.add(panel);

        Timer t = new Timer(timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currlevel.update();
                panel.repaint();
            }
        });
        t.start();
        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                currlevel.keyPressed(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                currlevel.keyReleased(e.getKeyCode());
            }
        });
        window.setSize(windowWidth, windowHeight);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
