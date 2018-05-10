import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
public class GameController extends JFrame implements KeyListener,MouseListener{
    private static final long serialVersionUID = 1L;
    private GamePanel gamePanel;
    private MyPanel currentPanel;
    private TitlePanel titlePanel;
    private boolean aPressed,wPressed,dPressed,sPressed,spacePressed,jump = true;
    private Timer gameloopTimer,jumpTimer,minigameTimer;
    private ArrayList<GameObject> gameObjects;
    private static final int GAMELOOP_FREQUENCY = 20;
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
        currentPanel = new TitlePanel(this);
        getContentPane().add(currentPanel);
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
        gameObjects = currentPanel.getGameObjects();
        control();
        currentPanel.cameraUpdate();
        currentPanel.physicsUpdate();
        currentPanel.repaint();
    }
    public void changePanel(Class<? extends MyPanel> varClass){
        MyPanel p;
        try{
            if(!varClass.equals(GamePanel.class)){
                currentPanel.setVisible(false);
                currentPanel = varClass.getConstructor(GameController.class).newInstance(this);
                currentPanel.setVisible(true);
                getContentPane().removeAll();
                getContentPane().add(currentPanel);
            }
            else{
                currentPanel.setVisible(false);
                currentPanel = gamePanel;
                currentPanel.setVisible(true);
                getContentPane().removeAll();
                getContentPane().add(currentPanel);
            }
        }
        catch(Exception NoSuchMethodException){
            System.out.println("Error, no such panel");
        }
    }
    public void control(){
        if(currentPanel.equals(gamePanel)){
            controlChar(gamePanel);
        }
    }
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
        if(aPressed&&speed>-pc.getMaxSpeed()&&!dPressed) pc.setSpeed(speed-1);
        else if(dPressed&&speed<pc.getMaxSpeed()&&!aPressed) pc.setSpeed(speed+1);
        else if(aPressed&&dPressed){
            if(speed>0) pc.setSpeed(speed-1);
            else if(speed<0) pc.setSpeed(speed+1);
        }
        if(!aPressed&&!dPressed&&speed!=0) pc.setSpeed(speed-speed/Math.abs(speed));
        if(spacePressed&&gamePanel.hitTest(pc,Interaction.class)!=null&&gamePanel.isVisible()) ((Interaction)gp.hitTest(pc,Interaction.class).get(0)).func();
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
        currentPanel.pingClick(e.getX(),e.getY());
    }
    public void keyTyped(KeyEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}