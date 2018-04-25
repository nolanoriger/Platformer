import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;

public abstract class GameObject extends ScreenObject{
    private int width,height;
    private ArrayList<Collider> colliders;
    
    public GameObject(JPanel jp, int x, int y, int w, int h) {
        super(jp,x,y);
        colliders = new ArrayList<Collider>();
        width = w;
        height = h;
    }
    
    public ArrayList<Collider> getColliders() {
        return colliders;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public boolean hit(GameObject go){
        for(Collider c: colliders){
            if(c.hit(go)) return true;
        }
        return false;
    }
}
