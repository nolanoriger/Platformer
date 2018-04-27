import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class PlayerCharacter extends RigidBody{
    private int speed;
    private boolean grounded;
    private String src;
    private static final int MAX_SPEED = 10;
    public PlayerCharacter(JPanel jp,int x,int y,String src){
        super(jp,x,y,72,81);
        this.src = src;
        getColliders().add(new CircleCollider(this,0,0,getWidth()/2));
        getColliders().add(new BoxCollider(this,0,getHeight()/2,getWidth(),getHeight()/2));
    }
    public int getMaxSpeed(){ return MAX_SPEED; }
    public boolean getGrounded(){ return grounded; }
    public void setGrounded(boolean g){ grounded = g; }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
            ImageIcon imgPC = new ImageIcon(src);
            Camera c = ((MyPanel)getPanel()).getCamera();
            imgPC.paintIcon(getPanel(),g,getX(),getY());
        }
    }
}