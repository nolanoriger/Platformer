import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.ArrayList;
public class KillBox extends GameObject{
    private String id;
    public KillBox(JPanel jp,int x,int y,int w,int h,String id){
        super(jp,x,y,w,h);
        getColliders().add(new BoxCollider(this,0,0,w,h));
        this.id = id;
        setVisible(false);
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
            g.setColor(Color.red);
            g.fillRect(getX(),getY(),getWidth(),getHeight());
        }
    }
    public String getID(){ return id; }
}