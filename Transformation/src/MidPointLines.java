
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
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;
import javax.swing.JFrame;

/**
 *
 * @author sajib
 */
public class MidPointLines  implements GLEventListener, KeyListener {


    static double Mx=0;
    static double My=0;
    static double Nx=0;
    static double Ny=100;
    static double Ox=100;
    static double Oy=100;
    static double Px=100;
    static double Py=0;
    static Double[][] A = { { Mx, Nx, Ox,Px }, { My, Ny, Oy,Py },{ 1.0, 1.0, 1.0,1.0 } };
    /**
     * Interface to the GLU library.
     */
    public void keyPressed(KeyEvent ke) {


        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            Double[][] B= { { 1.0, 0.0, 50.0 }, {0.0, 1.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            Double[][] B= { { 1.0, 0.0, -50.0 }, {0.0, 1.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            Double[][] B= { { 1.0, 0.0, 0.0 }, {0.0, 1.0, 50.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            Double[][] B= { { 1.0, 0.0, 0.0 }, {0.0, 1.0, -50.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_1) {
            Double[][] B= { { 1.0, 0.0, 50.0 }, {0.0, 1.0, 50.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_2) {
            Double[][] B= { { 1.0, 0.0, -50.0 }, {0.0, 1.0, 50.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_3) {
            Double[][] B= { { 1.0, 0.0, 50.0 }, {0.0, 1.0, -50.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];

        }
        if (ke.getKeyCode() == KeyEvent.VK_4) {
            Double[][] B= { { 1.0, 0.0, -50.0 }, {0.0, 1.0, -50.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_M) {
            Double[][] B= { { 2.0, 0.0, 0.0 }, {0.0, 1.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_C) {
            Double[][] B= { { 1/2.0, 0.0, 0.0 }, {0.0, 1.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_T) {
            Double[][] B= { { 1.0, 0.0, 0.0 }, {0.0, 2.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_P) {
            Double[][] B= { { 1.0, 0.0, 0.0 }, {0.0, 1.0/2.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_B) {
            Double[][] B= { { 2.0, 0.0, 0.0 }, {0.0, 2.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            Double[][] B= { { 1/2.0, 0.0, 0.0 }, {0.0, 1.0/2.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }

        if (ke.getKeyCode() == KeyEvent.VK_L) {
            Double[][] B= { { Math.cos(Math.toRadians(45)),-Math.sin(Math.toRadians(45)), 0.0 }, {Math.sin(Math.toRadians(45)),Math.cos(Math.toRadians(45)), 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_R) {
            Double[][] B= { { Math.cos(Math.toRadians(-45)),-Math.sin(Math.toRadians(-45)), 0.0 }, {Math.sin(Math.toRadians(-45)),Math.cos(Math.toRadians(-45)), 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_X) {
            Double[][] B= { { 1.0, 2.0, 0.0 }, {0.0, 1.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }
        if (ke.getKeyCode() == KeyEvent.VK_Y) {
            Double[][] B= { { 1.0, 0.0, 0.0 }, {2.0, 1.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }

        if (ke.getKeyCode() == KeyEvent.VK_Z) {
            Double[][] B= { { 1.0, 2.0, 0.0 }, {2.0, 1.0, 0.0 },{ 0.0, 0.0, 1.0 } };
            A=multiply(B,A);
            Mx=A[0][0];
            Nx=A[0][1];
            Ox=A[0][2];
            Px=A[0][3];

            My=A[1][0];
            Ny=A[1][1];
            Oy=A[1][2];
            Py=A[1][3];


        }

    }
    public void keyReleased(KeyEvent ke) {}
    public void keyTyped(KeyEvent ke) {}

    public Double[][] multiply(Double A[][], Double B[][]){

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        Double[][] C = new Double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;


    }

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
        /*
         * put your code here
         */
        //points should be in the same zone


        findZone(gl, Mx, My, Nx, Ny);
        findZone(gl, Nx, Ny, Ox, Oy);
        findZone(gl, Ox, Oy, Px, Py);
        findZone(gl, Px, Py, Mx,My);


    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }

    double dx, dy, b;
    private void DrawMPL(GL2 gl,double zone, double x1, double y1, double x2, double y2) {
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

            draw8wayPixel(gl,zone, x, y);
            if (d>0) {
                d = d + incNE;
                y = y + 1;
            } else {
                d = d + incE;
            }
        }

       // gl.glEnd();
    }

    //y=mx+b
    private int func(int x, float y){
        return (int)(dy*x - y*dx + b*dx);
    }

    private void draw8wayPixel(GL2 gl,double zone, double x, double y){
        gl.glPointSize(2.0f);
        gl.glColor3d(0, 1, 0);

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
                DrawMPL(gl, zone, x1, y1, x2, y2);
            }
            else{
                zone=1;
                DrawMPL(gl, zone, y1, x1, y2, x2);
            }
        }
        else if(dx<0 && dy>=0){
            if(Math.abs(dx)>dy){
                zone=3;
                DrawMPL(gl, zone, -x1, y1, -x2, y2);
            }
            else{
                zone=2;
                DrawMPL(gl, zone, y1, -x1, y2, -x2);
            }
        }

        else if(dx<0 && dy<0){
            if(Math.abs(dx)>Math.abs(dy)){
                zone=4;
                DrawMPL(gl, zone, -x1, -y1, -x2, -y2);
            }
            else{
                zone=5;
                DrawMPL(gl, zone, -y1, -x1, -y2, -x2);
            }
        }
        else{
            if(dx<Math.abs(dy)){
                zone=6;
                DrawMPL(gl, zone, -y1, x1, -y2, x2);
            }
            else{
                zone=7;
                DrawMPL(gl, zone, x1, -y1, x2, -y2);
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


