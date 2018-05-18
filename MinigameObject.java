import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
public class MinigameObject extends RigidBody{
    private int id;
    private String source;
    public MinigameObject(JPanel jp,int x,int y,int w,int h,int id,String src){
        super(jp,x,y,w,h);
        this.id = id;
        source = src;
        getColliders().add(new BoxCollider(this,0,0,w,h));
    }
    public int getId(){ return id; }
    public String getSource(){ return source; }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
            ImageIcon imgItem = new ImageIcon(source);
            g.drawImage(imgItem.getImage(),getX(),getY(),getWidth(),getHeight(),null);
        }
    }
}