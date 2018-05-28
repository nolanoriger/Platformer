import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Coin extends GameObject{
    public Coin(JPanel jp,int x,int y){
        super(jp,x,y,64,16);
        getColliders().add(new BoxCollider(this,0,0,64,16));
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()){
                c.draw(g);
            }
            ImageIcon img = new ImageIcon("images/coin.png");
            g.drawImage(img.getImage(),getX(),getY(),getWidth(),getHeight(),null);
        }
    }
}