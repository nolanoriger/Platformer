import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class FruitCatchMinigame extends MinigamePanel{
    private int counter,points,lives;
    private MinigameObject pc;
    /* id 0 = good
    id 1 = bad
    id 2 = char */
    public FruitCatchMinigame(GameController gc){
        super(gc);
        pc = new MinigameObject(this,0,getHeight()-50,50,50,2,"images/hands.png");
        lives = 3;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(counter<=0){
            counter = (int)(Math.random()*100+50);
            int id = (int)(Math.random()*2);
            String src = "images/run.png";
            if(id==0) src = "images/idle.png";
            getGameObjects().add(new MinigameObject(this,(int)(Math.random()*getWidth()),-20,20,20,id,src));
        }
        counter--;
        for(GameObject obj : getGameObjects()){
            obj.draw(g);
        }
    }
    public void physicsUpdate(){
        for(GameObject obj : getGameObjects()){
            obj.move(0,5);
            if(obj.getY()>getHeight()) getGameObjects().remove(obj);
        }
        ArrayList<MinigameObject> hit = hitTest(pc,MinigameObject.class);
        for(MinigameObject mg : hit){
            if(mg.id!=2){
                if(mg.id==0) points++;
                lives -= mg.id;
                getGameObjects().remove(mg);
            }
        }
        if(points>=10){
            //end game, send victory ping
        }
        else if(lives<=0){
            //end game, no response
        }
    }
}