import java.awt.Graphics;
import javax.swing.JPanel;
public class Coin extends Interaction{
    public Coin(JPanel jp,int x,int y){
        super(jp,x,y,100,20);
        getColliders().add(new BoxCollider(this,0,0,100,20));
    }
    public void func(){
        ((GamePanel)getPanel()).getPC().addCoin();
    }
    public void draw(Graphics g){
        
    }
}