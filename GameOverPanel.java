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
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);
        g.setFont(Font.decode("Comic Sans MS-50"));
        g.drawString("Game over",200,100);
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){ }
}