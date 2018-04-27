import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class MyPanel extends JPanel{
    private ArrayList<GameObject> gameObjects;
    public MyPanel(){
        gameObjects = new ArrayList();
    }
    public abstract Camera getCamera();
    public abstract void pingClick(int x,int y);
    public ArrayList<GameObject> getGameObjects(){ return gameObjects; }
}