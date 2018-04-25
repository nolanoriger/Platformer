import java.awt.Graphics;
public class BoxCollider extends Collider {
    private int width;
    private int height;
    
    public BoxCollider(GameObject go,int x,int y, int w,int h) {
        super(go,x,y);
        width = w;
        height= h;
    }
    
    public void draw(Graphics g) {
        if(isVisible() ) {
            g.setColor(getColor() );
            g.fillRect(getX(),getY(), getWidth(),getHeight());
        }
        
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public boolean hit(GameObject obj) {
        for(Collider c: obj.getColliders()) {
            if(c instanceof BoxCollider) {
               int aX1 = this.getX();
               int aY1 = this.getY();
               int aX2 = this.getX() + this.getWidth();
               int aY2 = this.getY() + this.getHeight();
               
               int bX1 = c.getX();
               int bY1 = c.getY();
               int bX2 = c.getX() + ((BoxCollider) c).getWidth();
               int bY2 = c.getY() + ((BoxCollider) c).getHeight();
               
               boolean horOverlap = true;
               if(aX1 < bX1 && aX2 < bX1) horOverlap = false;
               if(aX1 > bX2 && aX2 > bX2) horOverlap = false;
               
               boolean vertOverlap = true;
               if(aY1 < bY1 && aY2 < bY1) vertOverlap = false;
               if(aY1 > bY2 && aY2 > bY2) vertOverlap = false;
               
               if(horOverlap && vertOverlap) return true;
               else return false;
            }
            else if(c instanceof CircleCollider) {
              //check if vertical diameter of circle collides with rect b
              int ax1 = c.getX();
              int ay1 = c.getY() - ((CircleCollider) c).getRadius();
              int ax2 = c.getX();
              int ay2 = c.getY() + ((CircleCollider) c).getRadius();
              
              int bx1 = getX();
              int by1 = getY();
              int bx2 = bx1 + width;
              int by2 = by1 + height;
              
              boolean hOverlap = true;
              if(ax2<bx1) hOverlap = false;
              if(ax1>bx2) hOverlap = false;
       
              boolean vOverlap = true;
              if(ay2<by1) vOverlap = false;
              if(ay1>by2) vOverlap = false;
              
              boolean circleVOverlap = true;
              if(!(hOverlap && vOverlap)) circleVOverlap = false;
              
              //check if horizontal diameter of circle collides with rect b
              ax1 = getX() - ((CircleCollider) c).getRadius();
              ay1 = getY();
              ax2 = getX() + ((CircleCollider) c).getRadius();
              ay2 = getY();
              
              hOverlap = true;
              if(ax2<bx1) hOverlap = false;
              if(ax1>bx2) hOverlap = false;
       
              vOverlap = true;
              if(ay2<by1) vOverlap = false;
              if(ay1>by2) vOverlap = false;
              
              boolean circleHOverlap = true;
              if(!(hOverlap && vOverlap)) circleHOverlap = false;
              
              //top left rect corner distance to circle < radius
              int ax = c.getX();
              int ay = c.getY();
              int ar = ((CircleCollider) c).getRadius();
              
              int bx = getX();
              int by = getY();
              
              int cxs = (ax-bx) * (ax-bx);
              int cys = (ay-by) * (ay-by);
              double distance = Math.sqrt(cxs + cys);
              boolean TLOverlap;
              if(distance < ar) TLOverlap = true;
              else TLOverlap = false;
              
              //bottom left rect corner distance to circle < radius
              bx = getX();
              by = getY() + height;
              
              cxs = (ax-bx) * (ax-bx);
              cys = (ay-by) * (ay-by);
              distance = Math.sqrt(cxs + cys);
              boolean BLOverlap;
              if(distance < ar) BLOverlap = true;
              else BLOverlap = false;
              
              //top right rect corner distance to circle < radius
              bx = getX() + width;
              by = getY();
              
              cxs = (ax-bx) * (ax-bx);
              cys = (ay-by) * (ay-by);
              distance = Math.sqrt(cxs + cys);
              boolean TROverlap;
              if(distance < ar) TROverlap = true;
              else TROverlap = false;
              
              //top right rect corner distance to circle < radius
              bx = getX() + width;
              by = getY() + height;
              
              cxs = (ax-bx) * (ax-bx);
              cys = (ay-by) * (ay-by);
              distance = Math.sqrt(cxs + cys);
              boolean BROverlap;
              if(distance < ar) BROverlap = true;
              else BROverlap = false;
              
              if(circleVOverlap || circleHOverlap || TLOverlap || BLOverlap || TROverlap || BROverlap) return true;
              else return false;
            }
        }
        return false;
    }
    
}
