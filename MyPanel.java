import javax.swing.JPanel;
public abstract class MyPanel extends JPanel{
    public abstract Camera getCamera();
    public abstract void pingClick(int x,int y);
}