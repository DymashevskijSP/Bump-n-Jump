package src;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Level implements Drawable {
    ArrayList<Hitable> hitables = new ArrayList<>();
    ArrayList<Rabbit> rabbits = new ArrayList<>();
    ArrayList<Drawable> drawable = new ArrayList<>();

    public void draw(Graphics2D g2d) {
        for (Drawable o : drawable
        ) {

            o.draw(g2d);
        }
    }

    public void update() {
        for (Rabbit r : rabbits) {
            r.update();
        }
    }

    public void keyPressed(int key) {
        for (Rabbit r : rabbits) {
            r.keyPressed(key);
        }
    }

    public void keyReleased(int key) {
        for (Rabbit r : rabbits) {
            r.keyReleased(key);
        }
    }

    public Level(String wallFile, String rabitFile) throws IOException {
        Scanner sc = new Scanner(new File(wallFile));

        ArrayList<Wall> walls = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x, y, w, h;
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();
            drawable.add(new Background(x, y, w, h, Main.projFolder + sc.next()));

        }
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x, y, w, h;
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();
            walls.add(new Wall(x, y, w, h));

        }
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x, y, w, h;
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();
            walls.add(new InvisibleWall(x, y, w, h));
        }
        n = sc.nextInt();
        Main.AIcount = n;
        for (int i = 0; i < n; i++) {
            int x, y, sz;
            x = sc.nextInt();
            y = sc.nextInt();
            sz = sc.nextInt();
            RabbitAI newRabbit = new RabbitAI(x, y, sz, sz, Main.scoreXlength * (i + 1), (i + 1),
                    new File(Main.projFolder + sc.next()), new File(Main.projFolder + sc.next()),
                    new File(Main.projFolder + sc.next()));
            rabbits.add(newRabbit);
        }
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x, y, w, h;
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();
            drawable.add(new FakeWall(x, y, w, h));
        }
        drawable.addAll(walls);
        hitables.addAll(walls);
        sc.close();
        sc = new Scanner(new File(rabitFile));
        n = sc.nextInt();
        for (int i = Main.AIcount; i < n + Main.AIcount; i++) {
            int x, y, sz;
            x = sc.nextInt();
            y = sc.nextInt();
            sz = sc.nextInt();
            Rabbit newRabbit = new Rabbit(x, y, sz, sz, Main.scoreXlength * (i + 1), (i + 1),
                    new File(Main.projFolder + sc.next()), new File(Main.projFolder + sc.next()),
                    new File(Main.projFolder + sc.next()));
            rabbits.add(newRabbit);


        }

        hitables.addAll(rabbits);
        drawable.addAll(rabbits);
        for (Rabbit r : rabbits) {
            drawable.add(r.score);
            if (r.getClass() == Rabbit.class) {
                r.setKeyCodes(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
        }


    }

}
