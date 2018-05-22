import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class MyPanel extends JPanel{
    private ArrayList<GameObject> gameObjects;
    private GameController gc;
    private Camera cam;
    public MyPanel(GameController gc){
        setLayout(null);
        gameObjects = new ArrayList();
        this.gc = gc;
        cam = new Camera(0,0);
    }
    public GameController getGameController(){ return gc; }
    public Camera getCamera(){ return cam; }
    public ArrayList<GameObject> getGameObjects(){ return gameObjects; }
    public void handleX(RigidBody rb){
        if(!(hitTest(rb,Platform.class) != null)){
            int speed = rb.getSpeed();
            rb.move(speed,0);
            if(speed!=0&&hitTest(rb,Platform.class) != null){
                while(hitTest(rb,Platform.class) != null) rb.move(-speed/Math.abs(speed),0);
                rb.setSpeed(0);
            }
        }
    }
    public void handleY(RigidBody rb){
        boolean finGrounded = false;
        if(!(hitTest(rb,Platform.class) != null)){
            int fallSpeed = rb.getFallSpeed();
            rb.move(0,fallSpeed);
            if(fallSpeed!=0&&hitTest(rb,Platform.class) != null){
                while(hitTest(rb,Platform.class) != null) rb.move(0,-fallSpeed/Math.abs(fallSpeed));
                rb.setFallSpeed(0);
                if(fallSpeed>0) finGrounded = true;
            }
        }
        if(rb instanceof PlayerCharacter) ((PlayerCharacter) rb).setGrounded(finGrounded);
    }
    public ArrayList hitTest(GameObject obj,Class<?> varClass){
        ArrayList arr = new ArrayList();
        for(GameObject cobj : getGameObjects()){
            if(obj.hit(cobj)&&obj!=cobj&&varClass.isInstance(cobj)) arr.add(cobj);
        }
        if(arr.size()>0) return arr;
        return null;
    }
    public abstract void pingClick(int x,int y);
    public abstract void physicsUpdate();
}