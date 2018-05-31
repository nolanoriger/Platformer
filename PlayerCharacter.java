import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class PlayerCharacter extends RigidBody{
    private int coins,jumps,level;
    private boolean grounded,direction;
    private String src;
    private static final int MAX_SPEED = 10;
    Animation anim;
    public PlayerCharacter(JPanel jp,int x,int y,String src){
        super(jp,x,y,72,81);
        this.src = src;
        getColliders().add(new CircleCollider(this,20,0,getWidth()/2-20));
        getColliders().add(new BoxCollider(this,20,getHeight()/2-25,getWidth()-40,getHeight()/2+25));
        /*getColliders().add(new CircleCollider(this,5,5,31));
        getColliders().add(new BoxCollider(this,5,40,62,40));*/
        anim = new Animation("images/idle.png",jp,x,y,72,81,10,0,2);
        if(getPanel() instanceof ParLostLevel) level = 1;
        else if(getPanel() instanceof SatanLevel) level = 2;
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
                if(level==1){
                    if(getSpeed()==0&&!anim.getImageSource().equals("images/idle.png")) anim = new Animation("images/idle.png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0,2);
                    else if(ap&&getSpeed()<0&&!anim.getImageSource().equals("images/run.png")) anim = new Animation("images/run.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0,1);
                    else if(dp&&getSpeed()>0&&!anim.getImageSource().equals("images/run.png")) anim = new Animation("images/run.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0,1);
                    else if(!ap&&!dp&&!anim.getImageSource().equals("images/idle.png")) anim = new Animation("images/idle.png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0,2);
                }
                else{
                    if(getSpeed()==0&&!anim.getImageSource().equals("images/idleS.png")) anim = new Animation("images/idleS.png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0,2);
                    else if(ap&&getSpeed()<0&&!anim.getImageSource().equals("images/runS.png")) anim = new Animation("images/runS.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0,1);
                    else if(dp&&getSpeed()>0&&!anim.getImageSource().equals("images/runS.png")) anim = new Animation("images/runS.png",getPanel(),getX(),getY(),getWidth(),getHeight(),27,0,1);
                    else if(!ap&&!dp&&!anim.getImageSource().equals("images/idleS.png")) anim = new Animation("images/idleS.png",getPanel(),getX(),getY(),getWidth(),getHeight(),22,0,2);
                }
            }
            else{
                if(!anim.getImageSource().equals("images/jump.png")&&level==1) anim = new Animation("images/jump.png",getPanel(),getX(),getY(),getWidth(),getHeight(),8,0,1,1);
                else if(!anim.getImageSource().equals("images/jumpS.png")&&level==2) anim = new Animation("images/jumpS.png",getPanel(),getX(),getY(),getWidth(),getHeight(),8,0,1,1);
                anim.setFrame(8-(4-getFallSpeed()/5));
            }
            anim.setX(getX());
            anim.setY(getY());
            anim.setDir(direction);
            anim.draw(g);
        }
    }
}