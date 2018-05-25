import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class PlayerCharacter extends RigidBody{
    private int coins = 1;
    private boolean grounded,direction;
    private String src;
    private static final int MAX_SPEED = 10;
    Animation anim;
    public PlayerCharacter(JPanel jp,int x,int y,String src){
        super(jp,x,y,72,81);
        this.src = src;
        getColliders().add(new CircleCollider(this,0,0,getWidth()/2));
        getColliders().add(new BoxCollider(this,0,getHeight()/2,getWidth(),getHeight()/2));
        anim = new Animation("images/idle.png",jp,x,y,72,81,10,0,2);
    }
    public int getMaxSpeed(){ return MAX_SPEED; }
    public boolean getGrounded(){ return grounded; }
    public void setGrounded(boolean g){ grounded = g; }
    public void addCoin(){ coins++; }
    public int getCoin(){ return coins; }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
            boolean ap = ((MyPanel)getPanel()).getGameController().getAPressed();
            boolean dp = ((MyPanel)getPanel()).getGameController().getDPressed();
            if(ap) direction = false;
            else if(dp) direction = true;
            if(grounded){
                if(getSpeed()==0&&!anim.getImageSource().equals("images/idle_"+coins+".png")) anim = new Animation("images/idle_"+coins+".png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0,2);
                else if(ap&&getSpeed()<0&&!anim.getImageSource().equals("images/run_"+coins+".png")) anim = new Animation("images/run_"+coins+".png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0,1);
                else if(dp&&getSpeed()>0&&!anim.getImageSource().equals("images/run_"+coins+".png")) anim = new Animation("images/run_"+coins+".png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0,1);
                else if(!ap&&!dp&&!anim.getImageSource().equals("images/idle_"+coins+".png")) anim = new Animation("images/idle_"+coins+".png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0,2);
            }
            else{
                if(!anim.getImageSource().equals("images/fall.png")) anim = new Animation("images/fall.png",getPanel(),getX(),getY(),getWidth(),getHeight(),10,0,1);
                if(getFallSpeed()<=20) anim.setFrame(1); //set to maximum upwards velocity frame
                else if(getFallSpeed()<=10) anim.setFrame(2); //set to next highest upwards velocity frame
                //continue this pattern for the amount of jump frames
            }
            anim.setX(getX());
            anim.setY(getY());
            anim.setDir(direction);
            anim.draw(g);
        }
    }
}