import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class PlayerCharacter extends RigidBody{
    private boolean grounded,direction;
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
            boolean ap = ((MyPanel)getPanel()).getGameController().getAPressed();
            boolean dp = ((MyPanel)getPanel()).getGameController().getDPressed();
            if(ap) direction = false;
            else if(dp) direction = true;
            if(grounded){
                if(getSpeed()==0&&!anim.getImageSource().equals("images/idle.png")) anim = new Animation("images/idle.png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0);
                else if(ap&&getSpeed()<0&&!anim.getImageSource().equals("images/run.png")) anim = new Animation("images/run.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0);
                else if(dp&&getSpeed()>0&&!anim.getImageSource().equals("images/run.png")) anim = new Animation("images/run.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0);
                else if(!ap&&!dp&&!anim.getImageSource().equals("images/idle.png")) anim = new Animation("images/idle.png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0);
            }
            else{
                anim = new Animation("images/fall.png",getPanel(),getX(),getY(),getWidth(),getHeight(),10,0);
            }
            anim.setX(getX());
            anim.setY(getY());
            anim.setDir(direction);
            anim.draw(g);
        }
    }
}