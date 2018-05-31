import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class GamePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private Platform plat;
    private PlayerCharacter pc;
    private Camera c;
    private int lives = 3;
    private boolean interacting = true;
    public GamePanel(GameController gc){
        super(gc);
        pc = new PlayerCharacter(this,0,0,"images/idle.png");
        c = getCamera();
        c.setLocation(pc.getX()-getWidth()/2,pc.getY()-getHeight()/2+pc.getHeight()/2);
        ArrayList gameObjects = getGameObjects();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0,0,800,400);
        g.translate(-c.getX(),-c.getY());
        for(GameObject obj : getGameObjects()) obj.draw(g);
        g.setColor(Color.BLACK);
        if(interacting) g.drawString("Press \"Space\" to interact",pc.getX()-22,pc.getY()-20);
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
    public abstract void cameraUpdate();
    public PlayerCharacter getPC(){ return pc; }
    public void pingClick(int x,int y){ }
    public void setInteracting(boolean b){ interacting = b; }
}