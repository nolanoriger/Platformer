import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlayerCharacter extends Rigidbody{
    private int speed = 10;
    private String src;
    
    public PlayerCharacter(JPanel jp,int x, int y, String src) {
        super(jp,x, y, 72, 81);
        this.src = src;
        CircleCollider cc = new CircleCollider(this, getWidth()/2, getHeight()/2,36);
        cc.setVisible(true);
        getColliders().add(cc);
        BoxCollider bc = new BoxCollider(this, 0, getHeight()/2, getWidth(), getHeight()/2);
        bc.setVisible(true);
        getColliders().add(bc);
    }
    
    public void draw(Graphics g) {
        if(isVisible() ) {
            ImageIcon imgPC = new ImageIcon(src);
            imgPC.paintIcon(getPanel(), g, getX(), getY());
            
            for(Collider c: getColliders()){
                c.draw(g);
            }
        }
    }
    
    public void moveLeft(){
        setX(getX() - speed);
    }
    
    public void moveRight(){
        setX(getX() + speed);
    }
    
    public void jump(){
        setFallSpeed(-16);
    }
}
