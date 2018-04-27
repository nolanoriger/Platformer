import java.awt.Graphics;
import javax.swing.JPanel;
public abstract class ScreenObject{
    private int x,y;
    private boolean isRigidBody,visible;
    private JPanel panel;
    public ScreenObject(JPanel jp,int x,int y){
        this.x = x;
        this.y = y;
        panel = jp;
        visible = true;
    }
    public int getX(){ return x; }
    public int getY(){ return y; }
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public void move(int x,int y){
        this.x += x;
        this.y += y;
    }
    public JPanel getPanel(){ return panel; }
    public boolean isVisible(){ return visible; }
    public void setVisible(boolean v){ visible = v; }
    public abstract void draw(Graphics g);
}