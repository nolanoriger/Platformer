import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TitlePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private Camera c;
    private JButton credits;
    private ImageIcon img;
    public TitlePanel(GameController gc){
        super(gc);
        c = getCamera();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        img = new ImageIcon(getClass().getResource("images/titlescreen.png"));
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(),null);
        img = new ImageIcon(getClass().getResource("images/playbutton.png"));
        g.drawImage(img.getImage(),325,219-18,150,24,null);
        img = new ImageIcon(getClass().getResource("images/creditsbutton.png"));
        g.drawImage(img.getImage(),325,324-26,150,24,null);
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){
        if(x>=325&&x<=325+150&&y>=219-18&&y<=219+24-18){
            getGameController().changeResetPanel(ParLostLevel.class);
        }
        if(x>=325&&x<=325+150&&y>=324-26&&y<=324-26+24) getGameController().changePanel(CreditsPanel.class);
    }
}