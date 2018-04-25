import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Animation extends GameObject{

	private int frameWidth; 
	private int frameHeight;
	private int numFrames;
	private ImageIcon imgIcon;
	private int cycles;	// number of times animation should loop, 0 is infinite.
	
	private int currentFrame = 0;
	private int currentCycle = 0;
	
	public Animation(JPanel jp,String src, int x, int y, int width, int height, int numFrames, int cycles) {
		super(jp,x, y, width * numFrames, height);
		this.frameWidth = width; 
		this.frameHeight = height;
		this.numFrames = numFrames;
		this.imgIcon = new ImageIcon(src);
		this.cycles = cycles;
	}
	
	public int getFrameWidth() {
		return this.frameWidth;
	}
	
	public int getFrameHeight() {
		return this.frameHeight;
	}
	
	public void draw(Graphics g) {
	    drawFrame((Graphics2D) g);
	   }
	
	private void drawFrame(Graphics2D g2d){
		if(this.cycles == 0 || this.currentCycle < this.cycles) {
			if(this.currentFrame == this.numFrames) {
				this.currentFrame = 0;
				this.currentCycle++;
			}
			
			int frameX = currentFrame * frameWidth;
			int frameY = 0 * frameHeight; // currently only supports sprite sheets with one row
			g2d.drawImage(this.imgIcon.getImage(), 
					this.getX() - frameWidth, this.getY() - frameHeight,
					this.getX() + this.frameWidth, this.getY() + this.frameHeight, 
					frameX, frameY,
					frameX + this.frameWidth, frameY + this.frameHeight,
					null);
			
			currentFrame++;
		}
	}
}
