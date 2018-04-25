import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;

public abstract class Rigidbody extends GameObject
{
    private int fallSpeed;
    private static float GRAVITY = 1;
    public Rigidbody(JPanel jp, int x, int y, int w, int h){
        super(jp, x, y, w, h);
        fallSpeed = 0;
    }
    
    public void fall(){
        setY(getY() + fallSpeed);
        fallSpeed += GRAVITY;
    }
    
    public void restore(){
        fallSpeed -=GRAVITY;
        setY(getY() - fallSpeed);
        fallSpeed = 0;
    }
    
    public void setFallSpeed(int speed){
        fallSpeed = speed;
    }
    
}