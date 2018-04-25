import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
public abstract class Collider extends ScreenObject{
    private static final Color color=new Color(0,0,0,0.5f); 
    private GameObject gameObject;
    
    public Collider(GameObject go,int x,int y) {
        super(go.getPanel(),x,y);
        gameObject = go;
    }
    
    public Color getColor() {
        return color;
    }
    
    public GameObject getGameObject() {
        return gameObject;
    }
    
    public int getX() {
        return getGameObject().getX() + getLocalX(); 
    }
    
    public int getY() {
        return getGameObject().getY() + getLocalY(); 
    }
    
    public int getLocalX() {
        return super.getX();
    }
    
    public int getLocalY() {
        return super.getY();
    }
    
    public abstract boolean hit(GameObject obj);
    // public abstract boolean hit(Collider obj);
    // public abstract boolean hit(CircleCollider obj);
    // public abstract boolean hit(BoxCollider obj);
}
