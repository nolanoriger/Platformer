import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class FightClub extends Interaction{
    public FightClub(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
    }
    public void func(){
        ((MyPanel)getPanel()).getGameController().changePanel(WrathMinigame.class);
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
        }
    }
}