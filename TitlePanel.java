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
    private JButton start,credits;
    private ImageIcon icon;
    public TitlePanel(GameController gc){
        super(gc);
        c = getCamera();
        start = new JButton("Start");
        start.setFocusable(false);
        start.setBounds(325,219,150,24);//325 219 150 24
        start.setVerticalAlignment(SwingConstants.CENTER);
        start.setHorizontalAlignment(SwingConstants.CENTER);
        icon = new ImageIcon("images/playbutton.png");
        start.setIcon(icon);
        credits = new JButton("Credits");
        credits.setFocusable(false);
        credits.setBounds(325,324,150,24);//325 324 150 24
        credits.setVerticalAlignment(SwingConstants.CENTER);
        credits.setHorizontalAlignment(SwingConstants.CENTER);
        icon = new ImageIcon("images/creditsbutton.png");
        credits.setIcon(icon);
        add(start);
        add(credits);
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                getGameController().changePanel(ParLostLevel.class);
            }
        });
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setFont(Font.decode("Comic Sans MS-50"));
        g.setColor(Color.black);
        g.drawString("PLATFORMER GAME", 150, 100);
    }
    public void physicsUpdate(){ }
    public void pingClick(int x,int y){ }
}