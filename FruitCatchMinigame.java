import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
public class FruitCatchMinigame extends MinigamePanel{
    private int counter,points,lives;
    private MinigameObject pc;
    /* id 0 = good
    id 1 = bad
    id 2 = char */
    public FruitCatchMinigame(GameController gc){
        super(gc);
        pc = new MinigameObject(this,0,getGameController().getHeight()-100,100,50,2,"images/hands.png");
        getGameObjects().add(pc);
        lives = 3;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(counter<=0){
            counter = (int)(Math.random()*75+25);
            int id = (int)(Math.random()*2);
            String src = "images/cake.png";
            if(id==0) src = "images/fruit_1.png";
            getGameObjects().add(new MinigameObject(this,(int)(Math.random()*(getWidth()-50)),-50,50,50,id,src));
        }
        counter--;
        for(GameObject obj : getGameObjects()){
            obj.draw(g);
        }
        g.setFont(Font.decode("Comic Sans MS-15"));
        g.setColor(Color.black);
        g.drawString("Points: "+points, getGameController().getWidth()-75, getHeight()-25);
        g.setColor(Color.orange);
        for(int i = 0;i<points;i++){
            g.fillRect(750,300-30*i,45,25);
        }
        g.setColor(Color.red);
        for(int i = 0;i<lives;i++){
            g.fillRect(10+25*i,10,20,20);
        }
    }
    public void physicsUpdate(){
        for(int i = 0;i<getGameObjects().size();i++){
            MinigameObject mg = (MinigameObject)getGameObjects().get(i);
            if(mg.getId()!=2){
                mg.move(0,5);
                if(mg.getY()>getHeight()){
                    getGameObjects().remove(mg);
                    i--;
                }
            }
        }
        ArrayList<MinigameObject> hit = hitTest(pc,MinigameObject.class);
        if(hit!=null){
            for(int i = 0;i>=0&&i<hit.size();i++){
                MinigameObject mg = hit.get(i);
                if(hit.get(i).getId()!=2){
                    if(hit.get(i).getId()==0) points++;
                    lives -= hit.get(i).getId();
                    getGameObjects().remove(hit.get(i));
                }
            }
        }
        if(points>=10){
            getGameController().changePanel(getGameController().getGamePanel().getClass());
            ((ParLostLevel)(getGameController().getGamePanel())).gluttonyWin();
        }
        else if(lives<=0){
            getGameController().changePanel(getGameController().getGamePanel().getClass());
        }
    }
    public void control(boolean w,boolean a,boolean s,boolean d){
        if(a) pc.move(-15,0);
        if(d) pc.move(15,0);
        if(pc.getX()<0) pc.setX(0);
        if(pc.getX()>getGameController().getWidth()-pc.getWidth()) pc.setX(getGameController().getWidth()-pc.getWidth());
    }
    public void pingClick(int x,int y){ }
}