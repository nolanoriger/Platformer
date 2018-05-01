import java.awt.Graphics;
import java.awt.Color;
public class CircleCollider extends Collider{
    int radius;
    CircleCollider(GameObject obj,int x,int y,int r){
        super(obj,x,y);
        radius = r;
    }
    public int getRadius(){ return radius; }
    public boolean hit(GameObject obj){
        for(Collider c : obj.getColliders()){
            if(hit(c)) return true;
        }
        return false;
    }
    public boolean hit(Collider c){
        int x = getX(),y = getY(),cx = c.getX(),cy = c.getY();
        if(c instanceof BoxCollider){
            BoxCollider boxC = (BoxCollider) c;
            if(x+radius>=cx&&x+radius<=cx+boxC.getWidth()&&y+radius*2>=cy&&y<=cy+boxC.getHeight()||
                y+radius>=cy&&y+radius<=cy+boxC.getHeight()&&x+radius*2>=cx&&x<=cx+boxC.getWidth()||
                Math.hypot((double)(cx-x-radius),(double)(cy-y-radius))<radius||
                Math.hypot((double)(cx+boxC.getWidth()-x-radius),(double)(cy-y-radius))<radius||
                Math.hypot((double)(cx-x-radius),(double)(cy+boxC.getHeight()-y-radius))<radius||
                Math.hypot((double)(cx+boxC.getWidth()-x-radius),(double)(cy+boxC.getHeight()-y-radius))<radius){
                return true;
            }
        }
        else if(c instanceof CircleCollider){
            CircleCollider circleC = (CircleCollider) c;
            if(Math.hypot((double)(x+radius-cx-circleC.getRadius()),(double)(y+getRadius()-cy-circleC.getRadius()))<getRadius()+circleC.getRadius()){
                return true;
            }
        }
        return false;
    }
    public void draw(Graphics g){
        if(isVisible()){
            g.setColor(Color.green);
            g.fillOval(getX(),getY(),radius*2,radius*2);
        }
    }
}