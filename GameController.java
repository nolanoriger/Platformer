import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;

public class GameController extends JFrame implements KeyListener{
    private static final long serialVersionUID = 1L;
    
    private GamePanel gamePanel;
    private TitlePanel titlePanel;
    private static boolean aPressed, wPressed, dPressed, spacePressed; // default values are false
    
    private Timer gameloopTimer;
    private static final int GAMELOOP_FREQUENCY = 20;   // 50 fps
    
    public GameController(int width, int height) {
        addKeyListener(this);
        
        setTitle("PLATFORMER GAME");
        setSize(width, height);
        setVisible(true);
        setResizable(false);
          
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        gamePanel = new GamePanel();
        getContentPane().add(gamePanel);
        
        //titlePanel = new TitlePanel();
        //getContentPane().add(titlePanel);
        
        //setComponentZOrder(titlePanel, 0);
        
        

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ActionListener gameloopListener = new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        gameloop();
                    }
                };
                gameloopTimer = new Timer(GAMELOOP_FREQUENCY, gameloopListener);
                gameloopTimer.start();
            }
        });
    }
    
    private void gameloop() {
        //if(spacePressed) gamePanel.getPC().jump();
        gamePanel.physicsUpdate();
        gamePanel.repaint();
    }
    
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A) aPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_W) wPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_D) dPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_SPACE) spacePressed = true;
    }
    
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A) aPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_W) wPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_D) dPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_SPACE) spacePressed = false;
    }
    
    public void keyTyped(KeyEvent e) {}
    
    public static boolean getSpacePressed(){
        return spacePressed;
    }
    
    public static boolean getWPressed(){
        return wPressed;
    }
    
    public static boolean getAPressed(){
        return aPressed;
    }
    
    public static boolean getDPressed(){
        return dPressed;
    }
}

