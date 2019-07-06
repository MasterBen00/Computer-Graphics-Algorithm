package DDA;
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

class ThirdGLEventListener implements GLEventListener, KeyListener{
	static double Mx=0;
	static double My=0;
	static double Nx=0;
	static double Ny=100;
	static double Ox=100;
	static double Oy=100;
	static double Px=100;
	static double Py=0;
	static Double[][] A = { { Mx, Nx, Ox,Px }, { My, Ny, Oy,Py },{ 1.0, 1.0, 1.0,1.0 } };
	
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

private GLU glu;

/**
 * Take care of initialization here.
 */
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
 */
public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();

    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    /*
     * put your code here
     */
    
    selectZone(gl, Mx, My, Nx, Ny);
    selectZone(gl, Nx, Ny, Ox, Oy);
    selectZone(gl, Ox, Oy, Px, Py);
   
    selectZone(gl, Px, Py, Mx,My);
    
    
}
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

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}
public void selectZone(GL2 gl,double x1,double y1,double x2,double y2){
	int Zone=FindZone(x1, y1, x2, y2);
    if(Zone==0){
        
        drawLine(gl, x1, y1, x2, y2,Zone);
        }
        else if(Zone==1){
         drawLine(gl, y1, x1, y2, x2,Zone);
        }
   else if(Zone==2){
          drawLine(gl, y1, -x1, y2, -x2,Zone);
        }
   else if(Zone==3){
          drawLine(gl, -x1, y1, -x2, y2,Zone);
   }
   else if(Zone==4){
          drawLine(gl, -x1, -y1, -x2, -y2,Zone);
   }
   else if(Zone==5){
        
          drawLine(gl, -y1, -x1, -y2, -x2,Zone);
   }
   else if(Zone==6){
        
              drawLine(gl, -y1, x1, -y2, x2,Zone);
   }
   else if(Zone==7){
       
       drawLine(gl, x1, -y1, x2, -y2,Zone);
}

}

private void drawLine(GL2 gl, double x1, double y1, double x2, double y2, int Zone) 
{
   gl.glBegin(GL2.GL_POINTS);
   double dx, dy, d, incE, incNE, x, y;
    dx = x2 - x1;
    dy = y2 - y1;
    d   = 2*dy - dx;
    incE   = 2*dy;
    incNE = 2*(dy - dx);
    y = y1;
    for (x=x1; x<=x2; x++) 
    {
        if(Zone==0){
            
            gl.glVertex2d(x , y );
            }
            else if(Zone==1){
                
             gl.glVertex2d(y , x );
            }
       else if(Zone==2){
           
           gl.glVertex2d(-y , x );
            }
       else if(Zone==3){
           
           gl.glVertex2d(-x , y );
       }
       else if(Zone==4){
           
           gl.glVertex2d(-x , -y ); 
           }
       else if(Zone==5){
            
           
           gl.glVertex2d(-y , -x );
       }
       else if(Zone==6){
            
           
           
           gl.glVertex2d(y , -x );
       }
       else if(Zone==7){
           
           
           gl.glVertex2d(x , -y );
       }
        
        
         if (d>0) {
             d = d + incNE;
             y = y + 1;
         } else {
             d = d + incE;
         } 
     }
    gl.glEnd();
}




public int FindZone(double x1, double y1, double x2, double y2)
{ 
int Zone=-1;
//System.out.print(Px);
double dx, dy;
dx = x2 - x1;
dy = y2 - y1;
 if (Math.abs(dx)>=Math.abs(dy)){
    if(dx>=0 && dy>=0){
        Zone=0;
    }
    else if(dx<0 && dy>=0){
        Zone=3;
    }
    else if(dx<0 && dy<0){
        Zone=4;
    }
    else if(dx>=0 && dy<0){
        Zone=7;
    }
    // write conditions for other zones
}
else{
 if(dx>=0 && dy>=0){
        Zone=1;
    }
    else if(dx<0 && dy>=0){
        Zone=2;
    }
    else if(dx<0 && dy<0){
        Zone=5;
    }
    else if(dx>=0 && dy<0){
        Zone=6;
    }
    // write conditions for other zones
}
 
 return Zone ;


}



public void dispose(GLAutoDrawable arg0)
{
 
}
}
public class DDA
{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListener b=new ThirdGLEventListener();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(400, 400);
 //creating frame
 final JFrame frame = new JFrame("Basic frame");
 // adding canvas to frame
 frame.addKeyListener((java.awt.event.KeyListener) b);
 frame.add(glcanvas);
 frame.setSize(800, 640);
 frame.setVisible(true);
 FPSAnimator animator = new FPSAnimator(glcanvas, 60);
 animator.start();
;
}
}