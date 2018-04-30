import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class Minigame extends Interaction{
    private Class<?> minigame;
    public Minigame(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
    }
    public void func(){
        ((MyPanel)(getPanel())).getGameController().minigame();
    }
    public void draw(Graphics g){
        g.setColor(Color.cyan);
        g.fillRect(0,0,0,0);
    }
}