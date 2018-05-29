import javax.swing.JPanel;
import java.awt.Graphics;
public class Couch extends GameObject{
    public Couch(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
        }
    }
}