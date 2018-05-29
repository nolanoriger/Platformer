import javax.swing.JPanel;
import java.awt.Graphics;
public class Envy extends GameObject{
    public Envy(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
        getColliders().add(new BoxCollider(this,0,0,w,h));
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
        }
    }
}