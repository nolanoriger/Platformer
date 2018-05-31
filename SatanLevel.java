import java.util.ArrayList;
public class SatanLevel extends GamePanel{
    public SatanLevel(GameController gc){
        super(gc);
        getPC().setX(64);
        getPC().setY(7*64);
        ArrayList<GameObject> gameObjects = getGameObjects();
        gameObjects.add(new Platform(this,0,9,8,7));
        gameObjects.add(new Platform(this,8,5,3,11));
        gameObjects.add(new Platform(this,10,4,1,1));
        gameObjects.add(new Platform(this,11,4,3,5));
        gameObjects.add(new Platform(this,11,13,3,3));
        gameObjects.add(new Platform(this,14,6,2,3));
        gameObjects.add(new Platform(this,16,7,5,2));
        gameObjects.add(new Platform(this,19,3,5,1));
        gameObjects.add(new Platform(this,17,13,3,3));
        gameObjects.add(new Platform(this,20,11,13,5));
        gameObjects.add(new Platform(this,24,0,9,1));
        gameObjects.add(getPC());
    }
    public void cameraUpdate(){
        Camera c = getCamera();
        PlayerCharacter pc = getPC();
        int x = c.getX();
        int y = c.getY();
        if(pc.getX()+pc.getWidth()/2-x>getWidth()*3/5) x = pc.getX()-getWidth()*3/5+pc.getWidth()/2;
        else if(pc.getX()+pc.getWidth()/2-x<getWidth()*2/5) x = pc.getX()-getWidth()*2/5+pc.getWidth()/2;
        y = pc.getY()+pc.getHeight()/2-getHeight()/2;
        if(x<0) x = 0;
        else if(x>7360+pc.getWidth()/2-getWidth()-64) x = 7360+pc.getWidth()/2-getWidth()-64;
        if(y<-4*64) y = -4*64;
        if(y>16*64-pc.getHeight()/2-getHeight()) y = 16*64-pc.getHeight()/2-getHeight();
        c.setLocation(x,y);
    }
}