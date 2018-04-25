import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
public class GameController extends JFrame implements KeyListener,MouseListener{
    private static final long serialVersionUID = 1L;
    private GamePanel gamePanel;
    private TitlePanel titlePanel;
    private boolean aPressed,wPressed,dPressed,sPressed,jump = true; // default values are false
    private Timer gameloopTimer,jumpTimer;
    private ArrayList<GameObject> gameObjects;
    private static final int GAMELOOP_FREQUENCY = 20;   // 50 fps
    public GameController(int width, int height){
        addKeyListener(this);
        addMouseListener(this);
        setTitle("PLATFORMER GAME");
        setSize(width, height);
        setVisible(true);
        setResizable(false);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        gamePanel = new GamePanel(this);
        getContentPane().add(gamePanel);
        //titlePanel = new TitlePanel();
        //getContentPane().add(titlePanel);
        //setComponentZOrder(titlePanel, 0);
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                ActionListener gameloopListener = new ActionListener(){
                    public void actionPerformed(ActionEvent actionEvent){
                        gameloop();
                    }
                };
                gameloopTimer = new Timer(GAMELOOP_FREQUENCY, gameloopListener);
                gameloopTimer.start();
            }
        });
    }
    private void gameloop(){
        gameObjects = gamePanel.getGameObjects();
        controlChar();
        gamePanel.getCamera().setLocation(gamePanel.getPC());
        gamePanel.physicsUpdate();
        gamePanel.repaint();
    }
    public void controlChar(){
        PlayerCharacter pc = gamePanel.getPC();
        int speed = pc.getSpeed();
        int fallSpeed = pc.getFallSpeed();
        boolean grounded = pc.getGrounded();
        if(wPressed&&grounded&&jump){
            pc.setFallSpeed(-20);
            grounded = false;
            jump = false;
            EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    ActionListener jumpListener = new ActionListener(){
                        public void actionPerformed(ActionEvent actionEvent){
                            jump = true;
                            Thread.currentThread().stop();
                        }
                    };
                    jumpTimer = new Timer(250, jumpListener);
                    jumpTimer.start();
                }
            });
        }
        if(aPressed&&speed>-pc.getMaxSpeed()) pc.setSpeed(speed-1);
        if(dPressed&&speed<pc.getMaxSpeed()) pc.setSpeed(speed+1);
        if(!aPressed&&!dPressed&&speed!=0) pc.setSpeed(speed-speed/Math.abs(speed));
        pc.applyGravity();
    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A) aPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_W) wPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_D) dPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_S) sPressed = true;
    }
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A) aPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_W) wPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_D) dPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_S) sPressed = false;
    }
    public void mouseClicked(MouseEvent e){
        gamePanel.pingClick(e.getX(),e.getY());
    }
    public void keyTyped(KeyEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}