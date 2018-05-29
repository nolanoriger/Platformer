import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class Minigame extends Interaction{
    private Class<? extends MyPanel> minigame;
    public Minigame(JPanel jp,int x,int y,int w,int h,Class<? extends MyPanel> mg){
        super(jp,x,y,w,h);
        minigame = mg;
    }
    public void func(){
        ((MyPanel)(getPanel())).getGameController().changePanel(minigame);
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
        }
    }
}