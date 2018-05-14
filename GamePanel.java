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
        if(hitTest(pc,KillBox.class)!=null) getGameController().changePanel(GameOverPanel.class);
    }
    public void cameraUpdate(){
        int x = c.getX();
        int y = c.getY();
        if(pc.getX()+pc.getWidth()/2-x>getWidth()*3/5) x = pc.getX()-getWidth()*3/5+pc.getWidth()/2;
        else if(pc.getX()+pc.getWidth()/2-x<getWidth()*2/5) x = pc.getX()-getWidth()*2/5+pc.getWidth()/2;
        c.setLocation(x,pc.getY()+pc.getHeight()/2-getHeight()/2);
    }
    public PlayerCharacter getPC(){ return pc; }
    public void pingClick(int x,int y){ }
}