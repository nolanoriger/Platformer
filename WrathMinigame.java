import java.awt.Graphics;
import javax.swing.ImageIcon;
public class WrathMinigame extends MinigamePanel{
    public WrathMinigame(GameController gc){
        super(gc);
    }
    public void paintComponent(Graphics g){
        ImageIcon img = new ImageIcon(getClass().getResource("images/wrathscreen.png"));
        g.drawImage(img.getImage(),0,0,getGameController().getWidth(),getGameController().getHeight(),null);
        img = new ImageIcon(getClass().getResource("images/slaybutton.png"));
        g.drawImage(img.getImage(),153,188,150,24,null);
        img = new ImageIcon(getClass().getResource("images/sparebutton.png"));
        g.drawImage(img.getImage(),497,188,150,24,null);
    }
    public void physicsUpdate(){ }
    public void control(boolean w,boolean a,boolean s,boolean d){ }
    public void pingClick(int x,int y){
        if(x>=153&&x<=153+150&&y>=188&&y<=188+24){
            getGameController().changePanel(GameOverPanel.class);
            ((GameOverPanel)getGameController().getCurrentPanel()).setScreen("images/gameoverscreen_wrath.png");
        }
        if(x>=497&&x<=497+150&&y>=188&&y<=188+24){
            getGameController().changePanel(GameOverPanel.class);
            ((GameOverPanel)getGameController().getCurrentPanel()).setScreen("images/endscreen.png");
        }
    }
}