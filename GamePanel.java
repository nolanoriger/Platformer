import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public class GamePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private Platform plat;
    private PlayerCharacter pc;
    private Camera c;
    private int lives = 3;
    public GamePanel(GameController gc){
        super(gc);
        pc = new PlayerCharacter(this,200,0,"images/pc_singleframe.png");
        c = getCamera();
        c.setLocation(pc.getX()-getWidth()/2,pc.getY()-getHeight()/2+pc.getHeight()/2);
        ArrayList gameObjects = getGameObjects();
        gameObjects.add(pc);
        gameObjects.add(new Platform(this,0,0,1,18));
        gameObjects.add(new Platform(this,1,2,10,1));
        gameObjects.add(new Platform(this,7,1,4,1));
        gameObjects.add(new Platform(this,1,3,28,2));
        gameObjects.add(new Platform(this,29,4,8,1));
        gameObjects.add(new Platform(this,31,1,3,1));
        gameObjects.add(new Platform(this,14,0,3,1));
        gameObjects.add(new Platform(this,19,2,10,1));
        gameObjects.add(new Platform(this,21,1,8,1));
        gameObjects.add(new Platform(this,27,0,2,1));
        gameObjects.add(new Platform(this,42,0,1,18));
        gameObjects.add(new Minigame(this,700,100,100,100,MinigamePanel.class));
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
        int y = c.getY();
        if(pc.getX()+pc.getWidth()/2-x>pc.getPanel().getWidth()*3/5) x = pc.getX()-getWidth()*3/5+pc.getWidth()/2;
        else if(pc.getX()+pc.getWidth()/2-x<pc.getPanel().getWidth()*2/5) x = pc.getX()-getWidth()*2/5+pc.getWidth()/2;
        c.setLocation(x,0);
    }
    public void pingClick(int x,int y){
        
    }
    public PlayerCharacter getPC(){ return pc; }
}