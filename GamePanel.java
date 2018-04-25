import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.*;
public class GamePanel extends JPanel{
    private static final long serialVersionUID = 1L;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private PlayerCharacter pc;
    
    public GamePanel(){
        pc = new PlayerCharacter(this, 250, 100, "images/pc_singleFrame.png");
        gameObjects.add(new Platform(this, 50, 300, 200, 20));
        gameObjects.add(new Platform(this, 200, 250, 200, 20));
        gameObjects.add(pc);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 800, 400);
        for(GameObject go: gameObjects) go.draw(g);
    }
    public PlayerCharacter getPC(){
        return pc;
    }
    public void physicsUpdate(){
        pc.fall();
        
        for(GameObject go: gameObjects){
            if(go instanceof Platform){
                if(pc.hit(go)){
                    pc.restore();
                    if(GameController.getSpacePressed()){
                        pc.jump();
                    }
                    break;
                }
            }
        }
        if(GameController.getAPressed()){
            pc.moveLeft();
        }
        if(GameController.getDPressed()){
            pc.moveRight();
        }
    }
}
