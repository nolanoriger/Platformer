import java.util.ArrayList;
public class ParLostLevel extends GamePanel{
    public ParLostLevel(GameController gc){
        super(gc);
        //Construct the level
        ArrayList<GameObject> gameObjects = getGameObjects();
        gameObjects.add(new Platform(this,0,0,1,18));
        gameObjects.add(new Platform(this,1,2,10,1));
        gameObjects.add(new Platform(this,7,1,4,1));
        gameObjects.add(new Platform(this,1,3,28,2));
        gameObjects.add(new Platform(this,29,4,8,1));
        gameObjects.add(new Platform(this,31,1,3,1));
        gameObjects.add(new Platform(this,14,0,3,1));
        gameObjects.add(new Platform(this,19,2,10,1));
        gameObjects.add(new Platform(this,21,1,8,1));
        gameObjects.add(new Platform(this,27,0,2,1));
        gameObjects.add(new Platform(this,42,0,1,18));
        gameObjects.add(new Platform(this,3,10,38,1));
        gameObjects.add(new Platform(this,13,7,1,3));
        gameObjects.add(new Platform(this,14,8,1,2));
        gameObjects.add(new Platform(this,15,9,1,1));
        gameObjects.add(new Platform(this,19,7,4,1));
        gameObjects.add(new Platform(this,28,9,1,1));
        gameObjects.add(new Platform(this,29,8,1,2));
        gameObjects.add(new Platform(this,30,7,1,3));
        gameObjects.add(new Platform(this,33,7,1,3));
        gameObjects.add(new Platform(this,34,8,1,2));
        gameObjects.add(new Platform(this,35,9,1,1));
        gameObjects.add(new Platform(this,4,15,1,2));
        gameObjects.add(new Platform(this,5,16,1,1));
        gameObjects.add(new Platform(this,8,16,1,1));
        gameObjects.add(new Platform(this,9,15,1,2));
        gameObjects.add(new Platform(this,1,17,40,1));
        gameObjects.add(new Platform(this,12,13,2,1));
        gameObjects.add(new Platform(this,16,15,1,2));
        gameObjects.add(new Platform(this,17,16,1,1));
        gameObjects.add(new Platform(this,21,16,1,1));
        gameObjects.add(new Platform(this,23,15,1,2));
        gameObjects.add(new Platform(this,25,14,1,3));
        gameObjects.add(new Platform(this,27,15,1,2));
        gameObjects.add(new Platform(this,29,16,1,1));
        gameObjects.add(new Minigame(this,0,0,100,100,MinigamePanel.class));
    }
}