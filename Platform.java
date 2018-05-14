import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Platform extends GameObject{
    private static final Color COLOR = Color.YELLOW;
    Platform(JPanel jp,int x,int y,int w,int h){
        super(jp,x*50,y*50,w*50,h*50);
        getColliders().add(new BoxCollider(this,0,0,w*50,h*50));
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