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
        g.setFont(Font.decode("Comic Sans MS-50"));
        g.setColor(Color.black);
        g.drawString("PLATFORMER GAME", 150, 100);
        img = new ImageIcon("images/playbutton.png");
        g.drawImage(img.getImage(),325,219,150,24,null);
        img = new ImageIcon("images/creditsbutton.png");
        g.drawImage(img.getImage(),325,324,150,24,null);
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){
        if(x>=325&&x<=325+150&&y>=219&&y<=219+24) getGameController().changePanel(ParLostLevel.class);
    }
}