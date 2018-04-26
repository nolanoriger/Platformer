public class Camera{
    private int x,y;
    Camera(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){ return x; }
    public int getY(){ return y; }
    public void setLocation(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void smooth(int x,int y){
        
    }
}