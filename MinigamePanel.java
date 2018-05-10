import java.awt.Graphics;
import java.awt.Color;
public class MinigamePanel extends MyPanel{
    private Camera c;
    private PlayerCharacter pc;
    public MinigamePanel(GameController gc){
        super(gc);
        c = getCamera();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0,0,getWidth(),getHeight());
    }
    public void physicsUpdate(){
        
    }
    public void cameraUpdate(){
        
    }
    public PlayerCharacter getPC(){ return pc; }
    public void pingClick(int x,int y){
        
    }
}