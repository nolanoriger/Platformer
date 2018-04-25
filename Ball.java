import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
public class Ball extends RigidBody{
    private int radius;
    public Ball(JPanel jp,int x,int y,int r){
        super(jp,x,y,72,81);
        radius = r;
        getColliders().add(new CircleCollider(this,0,0,r));
    }
    public void draw(Graphics g){
        if(isVisible()){
            for(Collider c : getColliders()) c.draw(g);
            g.setColor(Color.red);
            Camera c = ((MyPanel)getPanel()).getCamera();
            g.fillOval(getX(),getY(),radius*2,radius*2);
        }
    }
}