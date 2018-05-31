import javax.swing.JPanel;
public abstract class Collider extends ScreenObject{
    GameObject parent;
    Collider(GameObject obj,int x,int y){
        super(obj.getPanel(),x,y);
        parent = obj;
        setVisible(true);
    }
    public int getX(){ return parent.getX()+super.getX(); }
    public int getY(){ return parent.getY()+super.getY(); }
    public int getLocalX(){ return super.getX(); }
    public int getLocalY(){ return super.getY(); }
    public GameObject getParent(){ return parent; }
    public abstract boolean hit(GameObject obj);
}