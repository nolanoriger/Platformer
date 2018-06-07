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
        setTitle("Paradise Lost");
        setSize(width, height);
        setVisible(true);
        setResizable(false);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        gamePanel = new ParLostLevel(this);
        currentPanel = new TitlePanel(this);
        getContentPane().add(currentPanel);
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                ActionListener gameloopListener = new ActionListener(){
                    public void actionPerformed(ActionEvent actionEvent){
                        gameloop();
                        setVisible(true);
                    }
                };
                gameloopTimer = new Timer(GAMELOOP_FREQUENCY, gameloopListener);
                gameloopTimer.start();
            }
        });
    }
    private void gameloop(){
        if(currentPanel instanceof GamePanel) ((GamePanel)currentPanel).cameraUpdate();
        gameObjects = currentPanel.getGameObjects();
        control();
        currentPanel.physicsUpdate();
        currentPanel.repaint();
    }
    public void changePanel(Class<? extends MyPanel> varClass){
        try{
            if(!varClass.isInstance(gamePanel)){
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
        if(varClass.equals(GameOverPanel.class)){
            System.out.print("\u000C");
            System.out.println((double)(System.currentTimeMillis()-startTime)/1000);
        }
    }
    public void changeResetPanel(Class<? extends MyPanel> varClass){
        try{
            if(varClass.equals(ParLostLevel.class)) gamePanel = new ParLostLevel(this);
            else if(varClass.equals(SatanLevel.class)) gamePanel = new SatanLevel(this);
            currentPanel.setVisible(false);
            currentPanel = gamePanel;
            currentPanel.setVisible(true);
            getContentPane().removeAll();
            getContentPane().add(currentPanel);
            startTime = System.currentTimeMillis();
        }
        catch(Exception NoSuchMethodException){
            System.out.println("Error, no such panel");
        }
    }
    public GamePanel getGamePanel(){ return gamePanel; }
    public MyPanel getCurrentPanel(){ return currentPanel; }
    public void control(){
        if(currentPanel.equals(gamePanel)){
            controlChar(gamePanel);
        }
        else if(currentPanel instanceof MinigamePanel){
            controlMini((MinigamePanel) currentPanel);
        }
    }
    public void controlChar(GamePanel gp){
        PlayerCharacter pc = gp.getPC();
        int speed = pc.getSpeed();
        int fallSpeed = pc.getFallSpeed();
        boolean grounded = pc.getGrounded();
        if(wPressed&&grounded&&jump){
            pc.setFallSpeed(-21);
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
        else if(gamePanel.hitTest(pc,Interaction.class)!=null) gamePanel.setInteracting(true);
        else gamePanel.setInteracting(false);
        if(gamePanel.hitTest(pc,Coin.class)!=null){
            changePanel(GameOverPanel.class);
            ((GameOverPanel)currentPanel).setScreen("images/gameoverscreen_greed.png");
        }
        if(gamePanel.hitTest(pc,KillBox.class)!=null){
            changePanel(GameOverPanel.class);
            ((GameOverPanel)currentPanel).setScreen("images/gameoverscreen_"+((KillBox)gamePanel.hitTest(pc,KillBox.class).get(0)).getID()+".png");
        }
        pc.applyGravity();
    }
    public void controlMini(MinigamePanel mg){
        mg.control(wPressed,aPressed,sPressed,dPressed);
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
        currentPanel.pingClick(e.getX()-2,e.getY()-26);
    }
    public void keyTyped(KeyEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}