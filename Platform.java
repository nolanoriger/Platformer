import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Platform extends GameObject{
    private static final Color COLOR = Color.YELLOW;
    Platform(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
        getColliders().add(new BoxCollider(this,0,0,w,h));
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider coll:getColliders()) coll.draw(g);
            g.setColor(COLOR);
            g.fillRect(getX(),getY(),getWidth(),getHeight());
        }
    }
    public String toString(){ return "X: "+getX()+" Y: "+getY()+" W: "+getWidth()+" H: "+getHeight(); }
}