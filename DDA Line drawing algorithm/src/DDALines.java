import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

/**
 *
 * @author sbiswas.amit
 */
public class DDALines implements GLEventListener {
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
        /*
         * put your code here
         */
        DDA(gl, -100, -50, 60, 70);

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }

    private void DDA(GL2 gl, int x1, int y1, int x2, int y2) {
        //write your own code
    /*   gl.glPointSize(1.0f);
       gl.glColor3d(1, 0, 0);
       gl.glBegin(GL2.GL_POINTS);

       gl.glVertex2d(x1, y1);*/
        double length=0;


        double delx=Math.abs(x2-x1);
        double dely=Math.abs(y2-y1);
        if(delx>=dely) {
            length=delx;

        }
        else {
            length=dely;
        }

        delx=(x2-x1)/length;
        dely=(y2-y1)/length;


        double x,y;

        x=x1+.5*delx;
        y=y1+.5*dely;




        gl.glPointSize(1.0f);
        gl.glColor3d(1, 0, 0);
        gl.glBegin(GL2.GL_POINTS);

        for(int i=0;i<=length;i++) {


            gl.glVertex2d(x, y);
            x=x+delx;
            y=y+dely;

        }




        // gl.glVertex2d(x2, y2);


        gl.glEnd();
    }

    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}