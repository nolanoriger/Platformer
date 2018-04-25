import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public class GamePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private ArrayList<GameObject> gameObjects;
    private Platform plat;
    private PlayerCharacter pc;
    private GameController gc;
    private Camera c;
    public GamePanel(GameController gc){
        this.gc = gc;
        gameObjects = new ArrayList();
        pc = new PlayerCharacter(this,200,200,"images/pc_singleframe.png");
        c = new Camera(pc.getX()-getWidth()/2,pc.getY()-getHeight()/2+pc.getHeight()/2);
        gameObjects.add(pc);
        gameObjects.add(new Platform(this,0,340,800,40));
        gameObjects.add(new Platform(this,300,200,200,20));
        gameObjects.add(new Platform(this,600,200,200,300));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,800,400);
        g.translate(-c.getX(),-c.getY());
        for(GameObject obj : gameObjects){
            obj.draw(g);
        }
    }
    public void physicsUpdate(){
        for(GameObject obj : gameObjects){
            if(obj instanceof RigidBody){
                RigidBody rb = ((RigidBody) obj);
                if(obj!=pc) rb.applyGravity();
                handleX(rb);
                handleY(rb);
            }
        }
    }
    public void handleX(RigidBody rb){
        if(!hitTest(rb)){
            int speed = rb.getSpeed();
            rb.move(speed,0);
            if(speed!=0&&hitTest(rb)){
                while(hitTest(rb)){
                    rb.move(-speed/Math.abs(speed),0);
                }
                rb.setSpeed(0);
            }
        }
    }
    public void handleY(RigidBody rb){
        boolean finGrounded = false;
        if(!hitTest(rb)){
            int fallSpeed = rb.getFallSpeed();
            rb.move(0,fallSpeed);
            if(fallSpeed!=0&&hitTest(rb)){
                while(hitTest(rb)){
                    rb.move(0,-fallSpeed/Math.abs(fallSpeed));
                }
                rb.setFallSpeed(0);
                if(fallSpeed>0){
                    finGrounded = true;
                }
            }
        }
        if(rb instanceof PlayerCharacter){
            ((PlayerCharacter) rb).setGrounded(finGrounded);
        }
    }
    public boolean hitTest(GameObject obj){
        for(GameObject cobj : gameObjects){
            if(obj.hit(cobj)&&obj!=cobj){
                return true;
            }
        }
        return false;
    }
    public PlayerCharacter getPC(){ return pc; }
    public ArrayList<GameObject> getGameObjects(){ return gameObjects; }
    public Camera getCamera(){ return c; }
}