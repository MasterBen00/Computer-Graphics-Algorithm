
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



        findZone(gl,-100,-100,100,-100);
        findZone(gl,-100,-100,-100,100);
        findZone(gl,100,-100,100,100);
        findZone(gl,100,100,-100,100);




        clipLine(gl, -65,120, -80,0);
        clipLine(gl, -80,0, -45,-70);
        clipLine(gl, -55,-150, -45,-70);
        clipLine(gl, -55,-150, 30,-140);
        clipLine(gl, 125,-5, 30,-140);
        clipLine(gl, 125,-5, 45,15);
        clipLine(gl, 55,130, 45,15);
        clipLine(gl, 55,130, -40,60);
        clipLine(gl, -65,120, -40,60);



//        findZone(gl, -65,120, -80,0);
//        findZone(gl, -80,0, -45,-70);
//        findZone(gl, -55,-150, -45,-70);
//        findZone(gl, -55,-150, 30,-140);
//        findZone(gl, 125,-5, 30,-140);
//        findZone(gl, 125,-5, 45,15);
//        findZone(gl, 55,130, 45,15);
//        findZone(gl, 55,130, -40,60);
//        findZone(gl, -65,120, -40,60);




    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }

    int dx, dy, b;
    private void DrawMPL(GL2 gl,int zone, int x1, int y1, int x2, int y2) {
        //write your own code

        int dx, dy, d, incE, incNE, x, y;



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

    private void draw8wayPixel(GL2 gl,int zone, int x, int y){
        gl.glPointSize(2.0f);
        gl.glColor3d(1, 1, 1);

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


    int findZone(GL2 gl, int x1, int y1, int x2, int y2) {
        int zone = 0;

        int dx = x2-x1;
        int dy = y2-y1;

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


    int top=8;
    int bottom=4;
    int right=2;
    int left=1;
    int xmax=100;
    int xmin=-100;
    int ymax=100;
    int ymin=-100;

    void clipLine(GL2 gl, int x1, int y1, int x2, int y2){



        int code, code_0, code_1;

        code_0=makeCode(x1,y1);
        code_1=makeCode(x2,y2);

        boolean accept=false;

        System.out.println("in method clipline");
        System.out.println(code_0);
        System.out.println(code_1);



        while(true){
            if((code_0 | code_1) ==0){

                accept=true;


                break;

            }
            else if((code_0 & code_1)!=0){
                accept=false;
                break;
            }
            else{

                int x=0; int y=0;
                if(code_0 !=0){
                    code=code_0;
                }
                else{
                    code=code_1;
                }
                if((code & top)!=0){
                    y=ymax;
                    x=x1+ (x2-x1)*(y-y1)/(y2-y1);


                }
                else if((code & bottom)!=0){
                    y=ymin;
                    x=x1+ (x2-x1)*(y-y1)/(y2-y1);



                }
                else if((code & right)!=0){
                    x=xmax;
                    y=y1+(y2-y1)*(x-x1)/(x2-x1);



                }
                else if((code & left)!=0){
                    x=xmin;
                    y=y1+ (y2-y1)*(x-x1)/(x2-x1);



                }

                if(code==code_0){
                    x1=x;
                    y1=y;
                    code_0=makeCode(x1,y1);

                }
                else{
                    x2=x;
                    y2=y;
                    code_1=makeCode(x2,y2);


                }

            }

        }
        if(accept==true){
            System.out.println(x1+" "+y1+" "+x2+" "+y2);

            findZone(gl,x1,y1,x2,y2);
        }





    }





    int makeCode(int x, int y){
        int code=0;



        if(y>ymax){
            code=code|top;
        }
        else if(y<ymin){
            code=code|bottom;
        }

        if(x>xmax){
            code=code|right;
        }
        else if(x<xmin){
            code=code|left;
        }
        return code;

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


