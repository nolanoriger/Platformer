import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Coin extends Interaction{
    public Coin(JPanel jp,int x,int y){
        super(jp,x,y,64,16);
        getColliders().add(new BoxCollider(this,0,0,64,16));
    }
    public void func(){
        ((GamePanel)getPanel()).getPC().addCoin();
    }
    public void draw(Graphics g){
        if(isVisible()){
            ImageIcon img = new ImageIcon("images/coin.png");
            g.drawImage(img.getImage(),getX(),getY(),getWidth(),getHeight(),null);
        }
    }
}