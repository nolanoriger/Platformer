import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Animation extends GameObject{
    private int frameWidth,frameHeight,numFrames,cycles,currentFrame,currentCycle,rate,counter,frame;
    private boolean direction;
    private ImageIcon imgIcon;
    public Animation(String src,JPanel jp,int x,int y,int width,int height,int numFrames,int cycles,int animRate){
        super(jp,x,y,width*numFrames,height);
        frameWidth = width;
        frameHeight = height;
        this.numFrames = numFrames;
        imgIcon = new ImageIcon(src);
        this.cycles = cycles;
        direction = true;
        rate = animRate;
    }
    public Animation(String src,JPanel jp,int x,int y,int width,int height,int numFrames,int cycles,int animRate,int frame){
        this(src,jp,x,y,width,height,numFrames,cycles,animRate);
        this.frame = frame;
    }
    public int getFrameWidth(){ return frameWidth; }
    public int getFrameHeight(){ return frameHeight; }
    public void draw(Graphics g){ drawFrame((Graphics2D)g); }
    public String getImageSource(){ return imgIcon.toString(); }
    public void setDir(boolean d){ direction = d; }
    public boolean getDir(){ return direction; }
    public void setFrame(int n){ frame = n; }
    private void drawFrame(Graphics2D g2d){
        if(frame==0){
            if(cycles == 0 || currentCycle < cycles){
                if(currentFrame == numFrames){
                    currentFrame = 0;
                    currentCycle++;
                }
                int frameX = currentFrame * frameWidth;
                if(direction){
                    g2d.drawImage(imgIcon.getImage(),getX(),getY(),getX()+frameWidth,getY()+frameHeight,frameX,0,frameX+frameWidth,frameHeight,null);
                }
                else{
                    g2d.drawImage(imgIcon.getImage(),getX()+frameWidth,getY(),getX(),getY()+frameHeight,frameX,0,frameX+frameWidth,frameHeight,null);
                }
                if(counter%rate==0){
                    currentFrame++;
                    counter = 0;
                }
                counter++;
            }
        }
        else{
            int frameX = (frame-1)*frameWidth;
            if(direction){
                g2d.drawImage(imgIcon.getImage(),getX(),getY(),getX()+frameWidth,getY()+frameHeight,(frame-1)*frameWidth,0,frameX+frameWidth,frameHeight,null);
            }
            else{
                g2d.drawImage(imgIcon.getImage(),getX()+frameWidth,getY(),getX(),getY()+frameHeight,(frame-1)*frameWidth,0,frameX+frameWidth,frameHeight,null);
            }
        }
    }
}