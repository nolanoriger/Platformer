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
        gameObjects.add(new Platform(this,0,0,72,1458));
        gameObjects.add(new Platform(this,1*72,2*81,10*72,81));
        gameObjects.add(new Platform(this,7*72,1*81,72*4,81*1));
        gameObjects.add(new Platform(this,1*72,3*81,28*72,2*81));
        gameObjects.add(new Platform(this,29*72,4*81,8*72,1*81));
        gameObjects.add(new Platform(this,31*72,1*81,3*72,1*81));
        gameObjects.add(new Platform(this,14*72,0,3*72,1*81));
        gameObjects.add(new Platform(this,19*72,2*81,10*72,1*81));
        gameObjects.add(new Platform(this,21*72,1*81,8*72,1*81));
        gameObjects.add(new Platform(this,27*72,0,2*72,1*81));
        gameObjects.add(new Platform(this,42*72,0,1*72,18*81));
        gameObjects.add(new Platform(this,3*72,10*81,38*72,1*81));
        gameObjects.add(new Platform(this,13*72,7*81,1*72,3*81));
        gameObjects.add(new Platform(this,14*72,8*81,1*72,2*81));
        gameObjects.add(new Platform(this,15*72,9*81,1*72,1*81));
        gameObjects.add(new Platform(this,19*72,7*81,4*72,1*81));
        gameObjects.add(new Platform(this,28*72,9*81,1*72,1*81));
        gameObjects.add(new Platform(this,29*72,8*81,1*72,2*81));
        gameObjects.add(new Platform(this,30*72,7*81,1*72,3*81));
        gameObjects.add(new Platform(this,33*72,7*81,1*72,3*81));
        gameObjects.add(new Platform(this,34*72,8*81,1*72,2*81));
        gameObjects.add(new Platform(this,35*72,9*81,1*72,1*81));
        gameObjects.add(new Platform(this,4*72,15*81,1*72,2*81));
        gameObjects.add(new Platform(this,5*72,16*81,1*72,1*81));
        gameObjects.add(new Platform(this,8*72,16*81,1*72,1*81));
        gameObjects.add(new Platform(this,9*72,15*81,1*72,2*81));
        gameObjects.add(new Platform(this,1*72,17*81,40*72,1*81));
        gameObjects.add(new Platform(this,12*72,13*81,2*72,1*81));
        gameObjects.add(new Platform(this,16*72,15*81,1*72,2*81));
        gameObjects.add(new Platform(this,17*72,16*81,1*72,1*81));
        gameObjects.add(new Platform(this,21*72,16*81,1*72,1*81));
        gameObjects.add(new Platform(this,23*72,15*81,1*72,2*81));
        gameObjects.add(new Platform(this,25*72,14*81,1*72,3*81));
        gameObjects.add(new Platform(this,27*72,15*81,1*72,2*81));
        gameObjects.add(new Platform(this,29*72,16*81,1*72,1*81));
        gameObjects.add(new Minigame(this,0,0,100,100,MinigamePanel.class));
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
        if(pc.getX()+pc.getWidth()/2-x>getWidth()*3/5) x = pc.getX()-getWidth()*3/5+pc.getWidth()/2;
        else if(pc.getX()+pc.getWidth()/2-x<getWidth()*2/5) x = pc.getX()-getWidth()*2/5+pc.getWidth()/2;
        c.setLocation(x,pc.getY()+pc.getHeight()/2-getHeight()/2);
    }
    public void pingClick(int x,int y){
        
    }
    public PlayerCharacter getPC(){ return pc; }
}