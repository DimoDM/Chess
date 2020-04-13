package chess;

import java.util.Scanner;

public class Chess {

    private Display display;
    Scanner input = new Scanner(System.in);
    TextureManager t;

    public void init() {
        display = new Display(600, 600, "Chess");
        t = new TextureManager(30,30,50,50,
                "D:\\CourseJavaProjects\\Chess\\src\\assets\\sprite2.png");
        display.addGraphic(t);
    }

    public void update() {

        t.render();

        t.setX(input.nextInt());
        t.setY(input.nextInt());

    }

    public void render() {

    }
}
