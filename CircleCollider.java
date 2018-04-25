import java.awt.Graphics;
public class CircleCollider extends Collider {
    private int radius;
    
    public CircleCollider(GameObject go, int x, int y, int r) {
        super(go,x,y);
        radius = r;
    }
    
    public void draw(Graphics g) {
        if(isVisible() ) {
            g.setColor(getColor() );
            int x = getX() - radius;
            int y = getY() - radius;
            g.fillOval(x,y,radius*2,radius*2);
        }
    }
    
    public int getRadius() {
        return radius;
    }
    
    public boolean hit(GameObject obj) {
        for(Collider c: obj.getColliders()) {
            if(c instanceof BoxCollider) {
              //check if vertical diameter of circle collides with rect b
              int ax1 = getX();
              int ay1 = getY() - radius;
              int ax2 = getX();
              int ay2 = getY() + radius;
              
              int bx1 = c.getX();
              int by1 = c.getY();
              int bx2 = bx1 + ((BoxCollider) c).getWidth();
              int by2 = by1 + ((BoxCollider) c).getHeight();
              
              boolean hOverlap = true;
              if(ax2<bx1) hOverlap = false;
              if(ax1>bx2) hOverlap = false;
       
              boolean vOverlap = true;
              if(ay2<by1) vOverlap = false;
              if(ay1>by2) vOverlap = false;
              
              boolean circleVOverlap = true;
              if(!(hOverlap && vOverlap)) circleVOverlap = false;
              
              //check if horizontal diameter of circle collides with rect b
              ax1 = getX() - radius;
              ay1 = getY();
              ax2 = getX() + radius;
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
              int ax = getX();
              int ay = getY();
              int ar = getRadius();
              
              int bx = c.getX();
              int by = c.getY();
              
              int cxs = (ax-bx) * (ax-bx);
              int cys = (ay-by) * (ay-by);
              double distance = Math.sqrt(cxs + cys);
              boolean TLOverlap;
              if(distance < ar) TLOverlap = true;
              else TLOverlap = false;
              
              //bottom left rect corner distance to circle < radius
              
              bx = c.getX();
              by = c.getY() + ((BoxCollider) c).getHeight();
              
              cxs = (ax-bx) * (ax-bx);
              cys = (ay-by) * (ay-by);
              distance = Math.sqrt(cxs + cys);
              boolean BLOverlap;
              if(distance < ar) BLOverlap = true;
              else BLOverlap = false;
              
              //top right rect corner distance to circle < radius
              
              bx = c.getX() + ((BoxCollider) c).getWidth();
              by = c.getY();
              
              cxs = (ax-bx) * (ax-bx);
              cys = (ay-by) * (ay-by);
              distance = Math.sqrt(cxs + cys);
              boolean TROverlap;
              if(distance < ar) TROverlap = true;
              else TROverlap = false;
              
              //top right rect corner distance to circle < radius
              
              bx = c.getX() + ((BoxCollider) c).getWidth();
              by = c.getY() + ((BoxCollider) c).getHeight();
              
              cxs = (ax-bx) * (ax-bx);
              cys = (ay-by) * (ay-by);
              distance = Math.sqrt(cxs + cys);
              boolean BROverlap;
              if(distance < ar) BROverlap = true;
              else BROverlap = false;
              
              if(circleVOverlap || circleHOverlap || TLOverlap || BLOverlap || TROverlap || BROverlap) return true;
              else return false;
            }
            else if(c instanceof CircleCollider) {
              int ax = getX();
              int ay = getY();
              int ar = getRadius();
              
              int bx = c.getX();
              int by = c.getY();
              int br = ((CircleCollider) c).getRadius();
              
              int minDistance = ar + br;
              
              int cxs = (ax-bx) * (ax-bx);
              int cys = (ay-by) * (ay-by);
              double distance = Math.sqrt(cxs + cys);
              if(distance < minDistance) return true;
              else return false;
            }
        }
        return false;
    }
}
