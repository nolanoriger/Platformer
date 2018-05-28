import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class FightClub extends Interaction{
    public FightClub(JPanel jp,int x,int y,int w,int h){
        super(jp,x,y,w,h);
    }
    public void func(){
        
    }
    public void draw(Graphics g){
        if(isVisible()){
            ImageIcon img = new ImageIcon("images/sword.png");
            g.drawImage(img.getImage(),getX(),getY(),getWidth(),getHeight(),null);
        }
    }
}