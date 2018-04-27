import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public class GamePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private Platform plat;
    private PlayerCharacter pc;
    private GameController gc;
    private Camera c;
    private int lives = 3;
    public GamePanel(GameController gc){
        super();
        this.gc = gc;
        pc = new PlayerCharacter(this,200,200,"images/pc_singleframe.png");
        c = new Camera(pc.getX()-getWidth()/2,pc.getY()-getHeight()/2+pc.getHeight()/2);
        ArrayList gameObjects = getGameObjects();
        gameObjects.add(pc);
        gameObjects.add(new Platform(this,0,340,800,40));
        gameObjects.add(new Platform(this,300,200,200,20));
        gameObjects.add(new Platform(this,600,200,200,300));
        gameObjects.add(new KillBox(this,700,100,100,100));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,800,400);
        g.translate(-c.getX(),-c.getY());
        for(GameObject obj : getGameObjects()) obj.draw(g);
    }
    public void physicsUpdate(){
        for(GameObject obj : getGameObjects()){
            if(obj instanceof RigidBody){
                RigidBody rb = ((RigidBody) obj);
                if(obj!=pc) rb.applyGravity();
                handleX(rb);
                handleY(rb);
            }
        }
    }
    public void cameraUpdate(){
        int x = c.getX();
        if(pc.getX()+pc.getWidth()/2-x>pc.getPanel().getWidth()*3/5) x = pc.getX()-getWidth()*3/5+pc.getWidth()/2;
        else if(pc.getX()+pc.getWidth()/2-x<pc.getPanel().getWidth()*2/5) x = pc.getX()-getWidth()*2/5+pc.getWidth()/2;
        c.setLocation(x,0);
    }
    
    public void pingClick(int x,int y){
        
    }
    public PlayerCharacter getPC(){ return pc; }
    public Camera getCamera(){ return c; }
}