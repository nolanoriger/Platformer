import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public class TitlePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private Camera c;
    public TitlePanel(GameController gc){
        super(gc);
        c = getCamera();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setFont(Font.decode("Comic Sans MS-50"));
        g.setColor(Color.black);
        g.drawString("PLATFORMER GAME", 150, 100);
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){
        getGameController().changePanel(ParLostLevel.class);
    }
}