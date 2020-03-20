
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;



import java.awt.*;

public class Main extends Application {
    private final static short WIDTH = 640;
    private final static short HEIGHT = 640;
    Color grey = Color.rgb(100,100,100);
    Color white = Color.rgb(255,255,255);
    Color black = Color.rgb(0,0,0);
    Color red = Color.rgb(255,0,0);
    Color green = Color.rgb(0,128,0);
    Color yellow = Color.rgb(255,255,0);

    @Override
    public void start(Stage stage) {
        stage.setTitle("Lab1");

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(grey);

        Rectangle r = new Rectangle(300,320,40,320);
        r.setFill(black);
        root.getChildren().add(r);

        Polygon triangle = new Polygon(160.0, 320.0,
                320.0, 42.0,
                480.0, 320.0
        );

        triangle.setFill(red);
        root.getChildren().add(triangle);

        Polygon triangle2 = new Polygon(200.0, 295.0,
                320.0, 77.0,
                440.0, 295.0
        );

        triangle2.setFill(white);
        root.getChildren().add(triangle2);

        Circle circle = new Circle(320,140,25);

        circle.setFill(red);
        root.getChildren().add(circle);

        Circle circle1 = new Circle(320,200,25);

        circle1.setFill(yellow);
        root.getChildren().add(circle1);

        Circle circle2 = new Circle(320,260,25);

        circle2.setFill(green);
        root.getChildren().add(circle2);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
