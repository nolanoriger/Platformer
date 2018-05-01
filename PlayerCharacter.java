import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class PlayerCharacter extends RigidBody{
    private boolean grounded;
    private String src;
    private static final int MAX_SPEED = 10;
    Animation anim;
    public PlayerCharacter(JPanel jp,int x,int y,String src){
        super(jp,x,y,72,81);
        this.src = src;
        getColliders().add(new CircleCollider(this,0,0,getWidth()/2));
        getColliders().add(new BoxCollider(this,0,getHeight()/2,getWidth(),getHeight()/2));
        anim = new Animation("images/idle.png",jp,x,y,72,81,10,0);
    }
    public int getMaxSpeed(){ return MAX_SPEED; }
    public boolean getGrounded(){ return grounded; }
    public void setGrounded(boolean g){ grounded = g; }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
            if(grounded&&getSpeed()==0&&!anim.getImageSource().equals("images/idle.png")) anim = new Animation("images/idle.png",getPanel(),getX(),getY(),getWidth(),getHeight(),10,0);
            else if(grounded&&getSpeed()>0&&!anim.getImageSource().equals("images/runR.png")) anim = new Animation("images/runR.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0);
            else if(grounded&&getSpeed()<0&&!anim.getImageSource().equals("images/runL.png")) anim = new Animation("images/runL.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0);
            else{
                anim.setX(getX());
                anim.setY(getY());
            }
            anim.draw(g);
        }
    }
}