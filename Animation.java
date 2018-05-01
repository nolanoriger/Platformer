import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Animation extends GameObject{
    private int frameWidth,frameHeight,numFrames,cycles,currentFrame,currentCycle;
    private boolean direction;
    private ImageIcon imgIcon;
    public Animation(String src,JPanel jp,int x,int y,int width,int height,int numFrames,int cycles){
        super(jp,x,y,width*numFrames,height);
        frameWidth = width;
        frameHeight = height;
        this.numFrames = numFrames;
        imgIcon = new ImageIcon(src);
        this.cycles = cycles;
        direction = true;
    }
    public int getFrameWidth(){ return frameWidth; }
    public int getFrameHeight(){ return frameHeight; }
    public void draw(Graphics g){ drawFrame((Graphics2D)g); }
    public String getImageSource(){ return imgIcon.toString(); }
    public void setDir(boolean d){ direction = d; }
    public boolean getDir(){ return direction; }
    private void drawFrame(Graphics2D g2d){
        if(cycles == 0 || currentCycle < cycles){
            if(currentFrame == numFrames){
                currentFrame = 0;
                currentCycle++;
            }
            int frameX = currentFrame * frameWidth;
            int frameY = 0 * frameHeight; // currently only supports sprite sheets with one row
            if(direction){
                g2d.drawImage(imgIcon.getImage(),
                    getX(), getY(),
                    getX()+frameWidth, getY()+frameHeight,
                    frameX, frameY,
                    frameX+frameWidth, frameY+frameHeight,
                    null);
            }
            else{
                g2d.drawImage(imgIcon.getImage(),
                    getX()+frameWidth, getY(),
                    getX(), getY()+frameHeight,
                    frameX, frameY,
                    frameX+frameWidth, frameY+frameHeight,
                    null);
            }
            currentFrame++;
        }
    }
}
