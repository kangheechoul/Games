import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Option extends JOptionPane 
{
	public Option(JFrame frame, String message)
	{
		JOptionPane.showMessageDialog(frame, message);
	}
}
