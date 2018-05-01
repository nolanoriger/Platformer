import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class BoxCollider extends Collider{
    int width,height;
    BoxCollider(GameObject obj,int x,int y,int w,int h){
        super(obj,x,y);
        width = w;
        height = h;
    }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
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
            if(x+width>=cx&&x<=cx+boxC.getWidth()&&y<=cy+boxC.getHeight()&&y+height>=cy){
                return true;
            }
        }
        else if(c instanceof CircleCollider){
            CircleCollider circleC = (CircleCollider) c;
            if(cx+circleC.getRadius()>=x&&cx+circleC.getRadius()<=x+width&&cy+circleC.getRadius()*2>=y&&cy<=y+height||
                cy+circleC.getRadius()>=y&&cy+circleC.getRadius()<=y+height&&cx+circleC.getRadius()*2>=x&&cx<=x+width||
                Math.hypot((double)(x-cx-circleC.getRadius()),(double)(y-cy-circleC.getRadius()))<circleC.getRadius()||
                Math.hypot((double)(x+width-cx-circleC.getRadius()),(double)(y-cy-circleC.getRadius()))<circleC.getRadius()||
                Math.hypot((double)(x-cx-circleC.getRadius()),(double)(y+height-cy-circleC.getRadius()))<circleC.getRadius()||
                Math.hypot((double)(x+width-cx-circleC.getRadius()),(double)(y+height-cy-circleC.getRadius()))<circleC.getRadius()){
                return true;
            }
        }
        return false;
    }
    public void draw(Graphics g){
        if(isVisible()){
            g.setColor(Color.green);
            g.fillRect(getX(),getY(),width,height);
        }
    }
}