import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TitlePanel extends MyPanel{
    private static final long serialVersionUID = 1L;
    private Camera c;
    private JButton start;
    public TitlePanel(GameController gc){
        super(gc);
        c = getCamera();
        start = new JButton("Start");
        start.setFocusable(false);
        start.setBounds(350,250,100,50);
        add(start);
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