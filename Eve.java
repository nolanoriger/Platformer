import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class Eve extends Interaction{
    private int id;
    public Eve(JPanel jp,int x,int y,int w,int h,int id){
        super(jp,x,y,w,h);
        this.id = id;
    }
    public void func(){
        if(id==0){
            ((MyPanel)getPanel()).getGameController().changePanel(GameOverPanel.class);
            ((GameOverPanel)(((MyPanel)(getPanel())).getGameController().getCurrentPanel())).setScreen("images/gameoverscreen_lust.png");
        }
        else{
            ((ParLostLevel)getPanel()).lustWin();
        }
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
        }
    }
}