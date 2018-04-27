import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class MyPanel extends JPanel{
    private ArrayList<GameObject> gameObjects;
    private ArrayList<KillBox> damage;
    public void GamePanel(){
        gameObjects = new ArrayList();
        damage = new ArrayList();
    }
    public abstract Camera getCamera();
    public abstract void pingClick(int x,int y);
    public ArrayList hitTest(GameObject obj,Class<?> varClass){
        ArrayList arr = new ArrayList();
        for(GameObject cobj : gameObjects){
            if(obj.hit(cobj)&&obj!=cobj&&varClass.isInstance(cobj)) arr.add(cobj);
        }
        for(KillBox kobj : damage){
            if(obj.hit(kobj)&&obj!=kobj&&varClass.isInstance(kobj)) arr.add(kobj);
        }
        if(arr.size()>0) return arr;
        return null;
    }
    public ArrayList<GameObject> getGameObjects(){ return gameObjects; }
    public ArrayList<KillBox> getDamage(){ return damage; }
}