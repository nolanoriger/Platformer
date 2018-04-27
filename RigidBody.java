import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class RigidBody extends GameObject{
    private int speed,fallSpeed;
    private static final int GRAVITY = 1;
    private static final int MAX_FALL = 20;
    public RigidBody(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
        speed = 0;
        fallSpeed = 0;
    }
    public void applyGravity(){
        fallSpeed += GRAVITY;
        if(fallSpeed>MAX_FALL) fallSpeed = MAX_FALL;
    }
    public void setSpeed(int s){ speed = s; }
    public void setFallSpeed(int s){ fallSpeed = s; }
    public int getSpeed(){ return speed; }
    public int getFallSpeed(){ return fallSpeed; }
    public void applySpeed(){ move(speed,fallSpeed); }
}