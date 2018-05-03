import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
public class GameController extends JFrame implements KeyListener,MouseListener{
    private static final long serialVersionUID = 1L;
    private GamePanel gamePanel;
    private MyPanel minigame;
    private TitlePanel titlePanel;
    private boolean aPressed,wPressed,dPressed,sPressed,spacePressed,jump = true; // default values are false
    private Timer gameloopTimer,jumpTimer,minigameTimer;
    private ArrayList<GameObject> gameObjects;
    private static final int GAMELOOP_FREQUENCY = 20;   // 50 fps
    private long startTime;
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
        //titlePanel = new TitlePanel(this);
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
                ActionListener minigameListener = new ActionListener(){
                    public void actionPerformed(ActionEvent actionEvent){
                        minigame();
                    }
                };
                minigameTimer = new Timer(GAMELOOP_FREQUENCY, minigameListener);
                gameloopTimer.start();
            }
        });
    }
    private void gameloop(){
        gameObjects = gamePanel.getGameObjects();
        controlChar(gamePanel);
        gamePanel.cameraUpdate();
        gamePanel.physicsUpdate();
        gamePanel.repaint();
    }
    public void newMinigame(){
        gameloopTimer.stop();
        minigameTimer.start();
    }
    public void minigame(){
        
    }
    /*
    public void changePanel(){
        if(this.gamePanel.isVisible()&&this.gamePanel.getShip().getHealth()>0){
            this.shopPanel.setVisible(true);
            this.gamePanel.setVisible(false);
            this.getContentPane().removeAll();
            this.getContentPane().add(this.shopPanel);
        }
        else if(this.gamePanel.getShip().getHealth()>0){
            this.shopPanel.setVisible(false);
            this.gamePanel.setVisible(true);
            this.getContentPane().removeAll();
            this.getContentPane().add(this.gamePanel);
            this.shopPanel.startTimer();
        }
    }*/
    public void controlChar(MyPanel gp){
        PlayerCharacter pc = gp.getPC();
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
        if(spacePressed&&gamePanel.hitTest(pc,Interaction.class)!=null) ((Interaction)gp.hitTest(pc,Interaction.class).get(0)).func();
        pc.applyGravity();
    }
    public boolean getAPressed(){ return aPressed; }
    public boolean getDPressed(){ return dPressed; }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A) aPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_W) wPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_D) dPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_S) sPressed = true;
        else if(e.getKeyCode() == KeyEvent.VK_SPACE) spacePressed = true;
    }
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A) aPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_W) wPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_D) dPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_S) sPressed = false;
        else if(e.getKeyCode() == KeyEvent.VK_SPACE) spacePressed = false;
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