import java.awt.Graphics;
import java.awt.Color;
public abstract class MinigamePanel extends MyPanel{
    private Camera c;
    public MinigamePanel(GameController gc){
        super(gc);
        c = getCamera();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0,0,getWidth(),getHeight());
    }
    public abstract void physicsUpdate();
    public abstract void control(boolean w,boolean a,boolean s,boolean d);
    public void pingClick(int x,int y){
        getGameController().changePanel(getGameController().getGamePanel().getClass());
    }
}