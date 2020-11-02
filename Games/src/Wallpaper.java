import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Wallpaper extends JFrame implements ActionListener {
	BufferedImage img = null;
	JButton b1;
	JPanel pp;
	JPanel Newframe;

	JLayeredPane layeredPane;
	String loginID;
	addd add;

	
	public Wallpaper(String loginID) {
		setTitle("배경 화면");
		this.loginID = loginID;
		layeredPane = new JLayeredPane();
		layeredPane.setSize(1860, 1080);
		layeredPane.setLayout(null);

		pp = new JPanel();
		b1 = new JButton("클릭");
		b1.addActionListener(this);

		try 
		{
			img = ImageIO.read(new File("./달팽이/images.jpg"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		mypanel panel = new mypanel();
		pp.add(b1);
		panel.add(pp);

		panel.setSize(1080, 920);
		layeredPane.add(panel);

		setLayout(null);
		
		add(layeredPane);

		setBounds(450, 100, 1080, 840);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	class mypanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			 add = new addd(loginID, this);

		}
	}
	public void Close()
	{
		this.dispose();
	}
}
