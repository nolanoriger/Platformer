import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
public class GameOverPanel extends MyPanel{
    private Camera c;
    public GameOverPanel(GameController gc){
        super(gc);
        c = getCamera();
    }
    public void paintComponent(Graphics g){
        
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){ }
}