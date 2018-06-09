import java.awt.Graphics;
import javax.swing.ImageIcon;
public class CreditsPanel extends MyPanel{
    private ImageIcon img;
    public CreditsPanel(GameController gc){
        super(gc);
    }
    public void paintComponent(Graphics g){
        img = new ImageIcon(getClass().getResource("images/creditsscreen.png"));
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(),null);
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){
        getGameController().changePanel(TitlePanel.class);
    }
}