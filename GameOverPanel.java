import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
public class GameOverPanel extends MyPanel{
    private Camera c;
    private String screen = "images/gameoverscreen_sloth.png";
    public GameOverPanel(GameController gc){
        super(gc);
        c = getCamera();
    }
    public void paintComponent(Graphics g){
        ImageIcon img = new ImageIcon(getClass().getResource(screen));
        g.drawImage(img.getImage(),0,0,getGameController().getWidth(),getGameController().getHeight(),null);
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){
        getGameController().changePanel(TitlePanel.class);
    }
    public void setScreen(String src){
        screen = src;
    }
}