import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class Animation extends JPanel implements ActionListener{

    public static int maxWidth;
    public static int maxHeight;

    Timer timer;

    private double angle = 0;
    private double rotateAngle = 0;
    private double scale = 1;
    private double delta = 0.01;

    // for movement animation
    private double tx = 1;
    private double ty = 0;
    private int radius = 100;


    public Animation() {
        timer = new Timer(10, this);
        timer.start();
    }
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setBackground(new Color(192, 255, 0));
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        double hexDots[][] = {
                {150, 200},
                {200, 150},
                {250, 150},
                {300, 200},
                {300, 250},
                {250, 300},
                {200, 300},
                {150, 250}
        };

        double triangleDots[][] = {
                {150, 200},
                {210, 100},
                {270, 200}
        };

        double triangleDots1[][] = {
                {170, 190},
                {210, 120},
                {250, 190}
        };

        GeneralPath hexagon = new GeneralPath();
        GeneralPath triangle = new GeneralPath();
        GeneralPath triangle1 = new GeneralPath();

        //task 1 and 2
        g2d.translate(0, 125);
        GradientPaint gp1 = new GradientPaint(5, 25, Color.GREEN, 20, 2, Color.YELLOW, true);
        g2d.setPaint(gp1);
        hexagon.moveTo(hexDots[0][0], hexDots[0][1]);

        for (int k = 1; k < hexDots.length; k++)
            hexagon.lineTo(hexDots[k][0], hexDots[k][1]);

        hexagon.closePath();
        g2d.fill(hexagon);
        g2d.draw(hexagon);

        g2d.setPaint(Color.BLACK);


        //animation
        BasicStroke bs2 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs2);
        g2d.drawRect(520, -90, 800, 750);
        g2d.translate(1000, 300);
        g2d.translate(tx, ty);
        g2d.setPaint(Color.YELLOW);

        //draw rectangle
        g2d.setPaint(new Color(0,0,0));
        g2d.fillRect(200,200,20,150);

        //draw triangles
        g2d.setPaint(Color.RED);
        triangle.moveTo(triangleDots[0][0], triangleDots[0][1]);

        for (int k = 1; k < triangleDots.length; k++)
            triangle.lineTo(triangleDots[k][0], triangleDots[k][1]);

        triangle.closePath();
        g2d.fill(triangle);
        g2d.draw(triangle);


        g2d.setPaint(Color.WHITE);
        triangle1.moveTo(triangleDots1[0][0], triangleDots1[0][1]);

        for (int k = 1; k < triangleDots1.length; k++)
            triangle1.lineTo(triangleDots1[k][0], triangleDots1[k][1]);

        triangle1.closePath();
        g2d.fill(triangle1);
        g2d.draw(triangle1);

        //draw circles
        g2d.setPaint(new Color(0,255,0));
        g2d.fillOval(200, 175, 20, 20);

        g2d.setPaint(new Color(255,255,0));
        g2d.fillOval(200, 150, 20, 20);

        g2d.setPaint(new Color(255,0,0));
        g2d.fillOval(200, 125, 20, 20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // movement
        tx = radius * Math.cos(Math.toRadians(angle));
        ty = - radius * Math.sin(Math.toRadians(angle));

        angle++;
        rotateAngle += 0.01;


        repaint();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab_2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 900);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;

        frame.add(new Animation());


        frame.setVisible(true);

    }
}