
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;*/

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import java.util.Scanner;

/**
 *
 * @author sajib
 */
public class MidPointLines  implements GLEventListener {




    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     * @param gld
     */
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    /**
     * Take care of drawing here.
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);


      int n = 5;


       double x1,x2,x3,y1,y2,y3;

       double r=120;



        for(int i=1;i<=n;i++){





            if(i%2==0){
                DrawMPL(gl, r);
            }


            else{
                x1 = r*1; y1=r*0;
                x2=r*-.5; y2=r*.87;
                x3=r*-.5; y3=r*-.87;
                findZone(gl, x1,y1,x2,y2);
                findZone(gl, x1,y1,x3,y3);
                findZone(gl, x2,y2,x3,y3);
                r = Math.sqrt((x1+x2)/2 * (x1+x2)/2 + (y1+y2)/2 * (y1+y2)/2);
            }



        }


    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }

    int dx, dy, b;
    private void DrawMPL(GL2 gl,double r) {
        //write your own code

        double d, incN, incNW, x, y;

       /* gl.glPointSize(1.0f);
        gl.glColor3d(1, 0, 0);

        gl.glBegin(GL2.GL_POINTS);*/


    /*  gl.glVertex2d(x1, y1);
      gl.glVertex2d(x2, y2);

       gl.glEnd();*/



        d   = 5-4*r;
        x=r;
        y = 0;

        while(y<x)
        {
            //gl.glVertex2d(x, y);

            draw8wayPixel(gl, x, y);
            if (d<0) {
                d = d + 8*y+12;
                y = y + 1;
            } else {
                d = d + 8*y-8*x+20;
                y++;
                x--;
            }
        }

       // gl.glEnd();
    }

    //y=mx+b
    private int func(int x, float y){
        return (int)(dy*x - y*dx + b*dx);
    }

    private void draw8wayPixel(GL2 gl, double x, double y){
        gl.glPointSize(2.0f);
        gl.glColor3d(1, 0,1);

        gl.glBegin(GL2.GL_POINTS);

        gl.glVertex2d(x, y);


        gl.glVertex2d(y, x);


        gl.glVertex2d(-y, x);


        gl.glVertex2d(-x, y);


        gl.glVertex2d(-x, -y);

        gl.glVertex2d(-y, -x);


        gl.glVertex2d(y, -x);


        gl.glVertex2d(x, -y);
        gl.glEnd();
    }
















    private void DrawMPL2(GL2 gl, int zone, double x1, double y1, double x2, double y2) {
        //write your own code

        double dx, dy, d, incE, incNE, x, y;

       /* gl.glPointSize(1.0f);
        gl.glColor3d(1, 0, 0);

        gl.glBegin(GL2.GL_POINTS);*/


    /*  gl.glVertex2d(x1, y1);
      gl.glVertex2d(x2, y2);

       gl.glEnd();*/



        dx = x2 - x1;
        dy = y2 - y1;
        d   = 2*dy - dx;
        incE   = 2*dy;
        incNE = 2*(dy - dx);
        y = y1;
        for (x=x1; x<=x2; x++)
        {
            //gl.glVertex2d(x, y);

            draw8wayPixel2(gl,zone, x, y);
            if (d>0) {
                d = d + incNE;
                y = y + 1;
            } else {
                d = d + incE;
            }
        }

        // gl.glEnd();
    }



    private void draw8wayPixel2(GL2 gl, int zone, double x, double y){
        gl.glPointSize(2.0f);
        gl.glColor3d(0,1, 1);

        gl.glBegin(GL2.GL_POINTS);

        if(zone==0){
            gl.glVertex2d(x, y);
        }
        else if(zone==1){
            gl.glVertex2d(y, x);
        }
        else if(zone==2){
            gl.glVertex2d(-y, x);
        }
        else if(zone==3){
            gl.glVertex2d(-x, y);
        }
        else if(zone==4){
            gl.glVertex2d(-x, -y);
        }
        else if(zone==5){
            gl.glVertex2d(-y, -x);
        }
        else if(zone==6){
            gl.glVertex2d(y, -x);
        }
        else {
            gl.glVertex2d(x, -y);
        }
        gl.glEnd();
    }







    int findZone(GL2 gl, double x1, double y1, double x2, double y2) {
        int zone = 0;

        double dx = x2-x1;
        double dy = y2-y1;

        if(dx>=0 && dy>=0){
            if(dx>=dy){
                zone=0;
                DrawMPL2(gl, zone, x1, y1, x2, y2);
            }
            else{
                zone=1;
                DrawMPL2(gl, zone, y1, x1, y2, x2);
            }
        }
        else if(dx<0 && dy>=0){
            if(Math.abs(dx)>dy){
                zone=3;
                DrawMPL2(gl, zone, -x1, y1, -x2, y2);
            }
            else{
                zone=2;
                DrawMPL2(gl, zone, y1, -x1, y2, -x2);
            }
        }

        else if(dx<0 && dy<0){
            if(Math.abs(dx)>Math.abs(dy)){
                zone=4;
                DrawMPL2(gl, zone, -x1, -y1, -x2, -y2);
            }
            else{
                zone=5;
                DrawMPL2(gl, zone, -y1, -x1, -y2, -x2);
            }
        }
        else{
            if(dx<Math.abs(dy)){
                zone=6;
                DrawMPL2(gl, zone, -y1, x1, -y2, x2);
            }
            else{
                zone=7;
                DrawMPL2(gl, zone, x1, -y1, x2, -y2);
            }
        }


        return zone ;
    }






    int convertX(int x, int y, int zone){
        int convertedX=0;
        return convertedX;
    }

    int convertY(int x, int y, int zone){
        int convertedY=0;
        return convertedY;
    }


    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}


