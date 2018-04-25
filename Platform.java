import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Platform extends GameObject {
    private static final Color color=Color.RED;
    
    public Platform(JPanel jp,int x,int y,int w,int h) {
        super(jp,x,y,w,h);
        BoxCollider bc = new BoxCollider(this,0,0,w,h);
        bc.setVisible(true);
        getColliders().add(bc);
    }
    
    public void draw(Graphics g) {
        if(isVisible() ) {
            g.setColor(color);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
            
            for(Collider c: getColliders()){
                c.draw(g);
            }
        }
    }
}

