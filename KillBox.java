import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.ArrayList;
public class KillBox extends GameObject{
    public KillBox(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
        getColliders().add(new BoxCollider(this,x,y,w,h));
        setVisible(true);
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
            g.setColor(Color.red);
            g.fillRect(getX(),getY(),getWidth(),getHeight());
        }
    }
}