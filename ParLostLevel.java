import java.util.ArrayList;
public class ParLostLevel extends GamePanel{
    private Platform Eve,EveChoice;
    private Interaction LoveEve,LustEve;
    private Minigame Gluttony = new Minigame(this,49*64,1*64,2*64,2*64,FruitCatchMinigame.class);
    private MinigameObject treeBlock = new MinigameObject(this,53*64,-64,64,64,0,"images/box.png");
    private MinigameObject eveBlock = new MinigameObject(this,61*64,-64*5,64,8*64,0,"images/boxwall.png");
    public ParLostLevel(GameController gc){
        super(gc);
        getPC().setX(80);
        getPC().setY(0);
        Eve = new Platform(this,53,-2,1,2);
        LoveEve = new Eve(this,59*64,-3*64,64,128,1);
        LustEve = new Eve(this,59*64,64,64,128,0);
        EveChoice = new Platform(this,61,-8,2,11);
        ArrayList<GameObject> gameObjects = getGameObjects();
        gameObjects.add(new MinigameObject(this,0,-4*64-6,7360,1216,0,"images/platforms.png"));
        gameObjects.add(new Platform(this,-2,-5,2,20));
        gameObjects.add(new Platform(this,0,3,7,10));
        gameObjects.add(new Platform(this,7,2,4,10));
        gameObjects.add(new Platform(this,11,4,11,10));
        gameObjects.add(new Platform(this,15,1,3,1));
        gameObjects.add(new Platform(this,22,3,2,10));
        gameObjects.add(new Platform(this,24,2,2,10));
        gameObjects.add(new Platform(this,26,1,5,10));
        gameObjects.add(new Platform(this,31,0,3,10));
        gameObjects.add(new Platform(this,38,-1,3,1));
        gameObjects.add(new Platform(this,34,2,2,10));
        gameObjects.add(new Platform(this,36,3,8,10));
        gameObjects.add(new Platform(this,47,3,6,10));
        gameObjects.add(new Platform(this,53,0,2,10));
        gameObjects.add(new Platform(this,58,-1,3,1));
        gameObjects.add(new Platform(this,76,2,1,1));
        gameObjects.add(new Platform(this,77,1,1,2));
        gameObjects.add(new Platform(this,80,-1,3,1));
        gameObjects.add(new Platform(this,91,2,1,1));
        gameObjects.add(new Platform(this,94,1,1,2));
        gameObjects.add(new Platform(this,97,0,1,3));
        gameObjects.add(new Platform(this,100,1,1,2));
        gameObjects.add(new Platform(this,103,2,1,1));
        gameObjects.add(new Platform(this,55,3,60,10));
        gameObjects.add(new Platform(this,115,-5,2,20));
        gameObjects.add(Gluttony);
        gameObjects.add(Eve);
        gameObjects.add(LoveEve);
        gameObjects.add(LustEve);
        gameObjects.add(EveChoice);
        gameObjects.add(new Coin(this,8*64,(int)(1.75*64)));
        gameObjects.add(new Coin(this,16*64,(int)(0.75*64)));
        gameObjects.add(new Coin(this,24*64,(int)(1.75*64)));
        gameObjects.add(new Coin(this,39*64,(int)(2.75*64)));
        gameObjects.add(new Coin(this,92*64+32,(int)(2.75*64)));
        gameObjects.add(new Coin(this,95*64+32,(int)(2.75*64)));
        gameObjects.add(new Coin(this,98*64+32,(int)(2.75*64)));
        gameObjects.add(new Coin(this,101*64+32,(int)(2.75*64)));
        gameObjects.add(new KillBox(this,-10*64,10*64,100*64,10*64,"sloth"));
        gameObjects.add(new MinigameObject(this,-32,64,64,3*64,0,"images/heavengate.png"));
        gameObjects.add(new MinigameObject(this,115*64,64,64,3*64,0,"images/hellgate.png"));
        gameObjects.add(new KillBox(this,40*64,-3*64+40,64,2*64-40,"pride"));
        gameObjects.add(new KillBox(this,65*64,2*64,2*64,64,"sloth"));
        gameObjects.add(new KillBox(this,70*64,2*64,2*64,64,"sloth"));
        gameObjects.add(new KillBox(this,80*64+32,-3*64,2*64,2*64,"envy"));
        gameObjects.add(new FightClub(this,107*64+32,64,64,2*64));
        gameObjects.add(treeBlock);
        gameObjects.add(getPC());
        gameObjects.add(eveBlock);
    }
    public void gluttonyWin(){ 
        getGameObjects().remove(Eve);
        getGameObjects().remove(treeBlock);
        getGameObjects().remove(Gluttony);
    }
    public void lustWin(){
        getGameObjects().remove(LustEve);
        getGameObjects().remove(EveChoice);
        getGameObjects().remove(eveBlock);
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
        else if(y>2*64) y = 2*64;
        c.setLocation(x,y);
    }
}