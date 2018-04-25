public class Camera{
    private int x,y;
    Camera(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){ return x; }
    public int getY(){ return y; }
    public void setLocation(PlayerCharacter pc){
        if(pc.getX()+pc.getWidth()/2-x>pc.getPanel().getWidth()*3/5) x = pc.getX()-pc.getPanel().getWidth()*3/5+pc.getWidth()/2;
        else if(pc.getX()+pc.getWidth()/2-x<pc.getPanel().getWidth()*2/5) x = pc.getX()-pc.getPanel().getWidth()*2/5+pc.getWidth()/2;
        y = 0;
        //y = pc.getY()-pc.getPanel().getHeight()/2+pc.getHeight()/2;
    }
    public void smooth(int x,int y){
        
    }
}