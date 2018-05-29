import java.util.ArrayList;
public class ParLostLevel extends GamePanel{
    private Platform Eve,EveChoice;
    private Interaction LoveEve,LustEve;
    private MinigameObject treeBlock = new MinigameObject(this,53*64,-64,64,64,0,"images/box.png");
    private MinigameObject eveBlock1 = new MinigameObject(this,61*64,-128,64,64,0,"images/box.png");
    private MinigameObject eveBlock2 = new MinigameObject(this,61*64,-64,64,64,0,"images/box.png");
    private MinigameObject eveBlock3 = new MinigameObject(this,61*64,-128,64,64,0,"images/box.png");
    private MinigameObject eveBlock4 = new MinigameObject(this,61*64,0,64,64,0,"images/box.png");
    private MinigameObject eveBlock5 = new MinigameObject(this,61*64,64,64,64,0,"images/box.png");
    private MinigameObject eveBlock6 = new MinigameObject(this,61*64,128,64,64,0,"images/box.png");
    private MinigameObject eveBlock7 = new MinigameObject(this,61*64,-128-64,64,64,0,"images/box.png");
    private MinigameObject eveBlock8 = new MinigameObject(this,61*64,-128*2,64,64,0,"images/box.png");
    public ParLostLevel(GameController gc){
        super(gc);
        //Construct the level
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
        gameObjects.add(new Minigame(this,49*64,1*64,2*64,2*64,FruitCatchMinigame.class));
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
        gameObjects.add(new KillBox(this,-10*64,10*64,100*64,10*64));
        gameObjects.add(new MinigameObject(this,-32,64,64,3*64,0,"images/heavengate.png"));
        gameObjects.add(new MinigameObject(this,115*64,64,64,3*64,0,"images/hellgate.png"));
        gameObjects.add(new Mirror(this,40*64,-3*64,64,2*64));
        gameObjects.add(new Couch(this,65*64,2*64,2*64,64));
        gameObjects.add(new Couch(this,70*64,2*64,2*64,64));
        gameObjects.add(new Envy(this,80*64+32,-3*64,2*64,2*64));
        gameObjects.add(new FightClub(this,107*64+32,64,64,2*64));
        gameObjects.add(treeBlock);
        gameObjects.add(getPC());
        gameObjects.add(eveBlock1);
        gameObjects.add(eveBlock2);
        gameObjects.add(eveBlock3);
        gameObjects.add(eveBlock4);
        gameObjects.add(eveBlock5);
        gameObjects.add(eveBlock6);
        gameObjects.add(eveBlock7);
        gameObjects.add(eveBlock8);
    }
    public void gluttonyWin(){ 
        getGameObjects().remove(Eve);
        getGameObjects().remove(treeBlock);
    }
    public void lustWin(){
        getGameObjects().remove(LustEve);
        getGameObjects().remove(EveChoice);
        getGameObjects().remove(eveBlock1);
        getGameObjects().remove(eveBlock2);
        getGameObjects().remove(eveBlock3);
        getGameObjects().remove(eveBlock4);
        getGameObjects().remove(eveBlock5);
        getGameObjects().remove(eveBlock6);
        getGameObjects().remove(eveBlock7);
        getGameObjects().remove(eveBlock8);
    }
}