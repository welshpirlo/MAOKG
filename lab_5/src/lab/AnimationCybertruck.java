package lab;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AnimationCybertruck implements ActionListener, KeyListener {
    private Button go;
    private TransformGroup wholeCybertruck;
    private Transform3D translateTransform;

    private Transform3D rotateTransformX;
    private Transform3D rotateTransformY;
    private Transform3D rotateTransformZ;

    private JFrame mainFrame;

    private float a = 0.0f;
    private float zoom = 1f;
    private float xloc = 0.8f;
    private float yloc = 0.0f;
    private float zloc = 0.0f;
    private Timer timer;

    public AnimationCybertruck(TransformGroup wholeCybertruck, Transform3D trans, JFrame frame) {
        go = new Button("Go");

        rotateTransformX= new Transform3D();
        rotateTransformY= new Transform3D();
        rotateTransformZ= new Transform3D();

        this.wholeCybertruck = wholeCybertruck;
        this.mainFrame = frame;

        wholeCybertruck.setTransform(trans);

        translateTransform = trans;

        zoom = (float) trans.getScale();

        FirstMainClass.canvas.addKeyListener(this);
        timer = new Timer(5, this);

        Panel p = new Panel();
        p.add(go);
        mainFrame.add("North", p);
        go.addActionListener(this);
        go.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // start timer when button is pressed
        if (e.getSource() == go) {
            if (!timer.isRunning()) {
                timer.start();
                go.setLabel("Stop");
            }
            else {
                timer.stop();
                go.setLabel("Go");
            }
        }
        else {
            Move();
            translateTransform.setScale(new Vector3d(zoom, zoom, zoom));
            translateTransform.setTranslation(new Vector3f(xloc, yloc, zloc));
            wholeCybertruck.setTransform(translateTransform);
        }
    }

    private void Move() {
        yloc -= (0.0055 * a);
        zloc -= (0.1 * a);

        if (zloc <= -31f) {
            a = 0.0f;
            zloc = -31f;
            yloc = -1.7f;
        }
        if(zloc >= 2.84f) {
            zloc = 2.84f;
            yloc = 0.16f;
        }

        if(a >= 0.6f) {
            a = 0.6f;
        }
        if(a <= -0.3f) {
            a = -0.3f;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Invoked when a key has been typed.
    }

    @Override
    public void keyPressed(KeyEvent e) {
            if (e.getKeyChar()=='w') {
                a += 0.1;
            }
            if (e.getKeyChar()=='s') {
                a -= 0.1;
            }
            if (e.getKeyChar()=='1') {
                rotateTransformX.rotX(Math.PI/2);
                translateTransform.mul(rotateTransformX);
            }
            if (e.getKeyChar()=='2') {
                rotateTransformY.rotY(Math.PI/2);
                translateTransform.mul(rotateTransformY);
            }
            if (e.getKeyChar()=='3') {
                rotateTransformZ.rotZ(Math.PI/2);
                translateTransform.mul(rotateTransformZ);
            }
    }




    @Override
    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }
}