import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class GameObject extends ScreenObject{
    private int width,height;
    private ArrayList<Collider> colliders;
    public GameObject(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y);
        width = w;
        height = h;
        colliders = new ArrayList();
    }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
    public ArrayList<Collider> getColliders(){ return colliders; }
    public boolean hit(GameObject obj){
        for(Collider c : colliders){
            if(c.hit(obj)) return true;
        }
        return false;
    }
}