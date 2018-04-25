import java.awt.Graphics;
import javax.swing.JPanel;
public abstract class ScreenObject {
     private int x, y, width, height;
     private JPanel panel;
     private boolean visible;
     
     public ScreenObject(JPanel jp, int x, int y) {
         visible = true;
         panel = jp;
         this.x = x;
         this.y = y;
     }
     
     public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int newX) {
        x = newX;
    }
    
    public void setY(int newY) {
        y = newY;
    }
    
    public void setVisible(boolean v) {
        visible=v;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public JPanel getPanel() {
        return panel;
    }
    
    public abstract void draw(Graphics g);
}
