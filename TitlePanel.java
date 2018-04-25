import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TitlePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private PlayerCharacter pc;
	
	public TitlePanel() {
		pc = new PlayerCharacter(this,400, 180, "images/pc_singleFrame.png");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.setColor(Color.RED);
		g.drawString("PLATFORMER GAME", 200, 100);
		pc.draw(g);
	}
}
