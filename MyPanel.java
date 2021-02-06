package DymashevskijJumpAndBump;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(Main.defaultFont);
        Main.currlevel.draw(g2d);
    }
}
