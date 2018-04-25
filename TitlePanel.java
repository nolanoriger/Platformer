import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public class TitlePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private PlayerCharacter pc;
    private Camera c;
    public TitlePanel(){
        pc = new PlayerCharacter(this,400,180,"images/pc_singleFrame.png");
        c = new Camera(0,0);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.setColor(Color.RED);
        g.drawString("PLATFORMER GAME", 200, 100);
        pc.draw(g);
    }
    public Camera getCamera(){ return c; }
    public void pingClick(int x,int y){
        
    }
}