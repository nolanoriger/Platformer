import javax.swing.JPanel;
import java.awt.Graphics;
public abstract class Interaction extends GameObject{
    public Interaction(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
        getColliders().add(new BoxCollider(this,0,0,w,h));
    }
    public abstract void func();
}