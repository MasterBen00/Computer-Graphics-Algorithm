
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//com.jogamp or javax.media
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.JFrame;
/**
 *
 * @author sbiswas.amit
 */
public class OpenGL {

    /**
     * uses line drawing method
     **/
    public static void main(String[] args) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        MidPointLines drawing = new MidPointLines();
        glcanvas.addGLEventListener(drawing);
        glcanvas.setSize(400, 400);

        //creating frame
        final JFrame frame = new JFrame ("Transformation");

        //adding canvas to frame
        frame.addKeyListener((java.awt.event.KeyListener) drawing);
        frame.add(glcanvas);
        frame.setSize(800, 640);
        frame.setVisible(true);
        FPSAnimator animator = new FPSAnimator(glcanvas, 60);
        animator.start();

    }

}


