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
            ((ParLostLevel)getPanel()).getGameController().changePanel(GameOverPanel.class);
        }
        else{
            ((ParLostLevel)getPanel()).lustWin();
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.cyan);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}