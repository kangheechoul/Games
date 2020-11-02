import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addd extends JFrame implements ActionListener, ItemListener {
	JPanel Newframe1;
	JPanel Newframe2;
	JPanel Newframe3;

	JTextField text1;
	JTextField text2;
	JTextField text3;
	JTextField text4;

	JCheckBox name1;
	JCheckBox name2;
	JCheckBox name3;
	JCheckBox name4;

	JLabel label;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;

	int batting;
	String pangname;

	JButton but;

	Random random;
	String loginID;
	
	int z;
	int c;
	int v;
	int b;
	
	Playgame1 play;
	Wallpaper parent;
	
	public addd(String loginID, Wallpaper frame) 
	{
		parent = frame;
		this.loginID = loginID;
		Newframe1 = new JPanel();

		Newframe2 = new JPanel();
		Newframe3 = new JPanel();

		text1 = new JTextField(5);
		text2 = new JTextField(5);
		text3 = new JTextField(5);
		text4 = new JTextField(5);
		random = new Random();

		z = random.nextInt(5) + 2;
		c = random.nextInt(5) + 2;
		v = random.nextInt(5) + 2;
		b = random.nextInt(5) + 2;

		label = new JLabel("¼±ÅÃÇÏ¼¼¿ä");
		name1 = new JCheckBox("ÆØÀÌ" + "¹è´ç" + "X" + z, false);
		name2 = new JCheckBox("ÇªÇª" + "¹è´ç" + "X" + c, false);
		name3 = new JCheckBox("¶×¶ì" + "¹è´ç" + "X" + v, false);
		name4 = new JCheckBox("¹Î´Þ" + "¹è´ç" + "X" + b, false);

		// text1.setText(null);

		this.add(name1);
		this.add(name2);
		this.add(name3);
		this.add(name4);

		but = new JButton("°ÔÀÓ ½ÃÀÛ");
		but.addActionListener(this);

		Newframe1.add(label);

		GridLayout layout = new GridLayout(2, 1);
		Newframe2.setLayout(layout);
		Newframe2.add(name1);
		Newframe2.add(text1);

		Newframe2.add(name2);
		Newframe2.add(text2);

		Newframe2.add(name3);
		Newframe2.add(text3);

		Newframe2.add(name4);
		Newframe2.add(text4);

		Newframe3.add(but);

		add(Newframe1, BorderLayout.NORTH);
		add(Newframe2, BorderLayout.CENTER);
		add(Newframe3, BorderLayout.SOUTH);

		setBounds(1080, 600, 400, 200);
		// setSize(400,200);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		name1.addItemListener(this);
		name2.addItemListener(this);
		name3.addItemListener(this);
		name4.addItemListener(this);

	}

	private int random(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == name1) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				name2.setEnabled(false);
				text2.setEnabled(false);
				text2.setText("0");

				name3.setEnabled(false);
				text3.setEnabled(false);
				text3.setText("0");
				
				name4.setEnabled(false);
				text4.setEnabled(false);
				text4.setText("0");
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				name2.setEnabled(true);
				text2.setEnabled(true);

				name3.setEnabled(true);
				text3.setEnabled(true);

				name4.setEnabled(true);
				text4.setEnabled(true);
			}
		}
		if (e.getSource() == name2) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				name1.setEnabled(false);
				text1.setEnabled(false);
				text1.setText("0");

				name3.setEnabled(false);
				text3.setEnabled(false);
				text3.setText("0");

				name4.setEnabled(false);
				text4.setEnabled(false);
				text4.setText("0");
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				name1.setEnabled(true);
				text1.setEnabled(true);

				name3.setEnabled(true);
				text3.setEnabled(true);

				name4.setEnabled(true);
				text4.setEnabled(true);
			}
		}
		if (e.getSource() == name3) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				name1.setEnabled(false);
				text1.setEnabled(false);
				text1.setText("0");

				name2.setEnabled(false);
				text2.setEnabled(false);
				text2.setText("0");
				
				name4.setEnabled(false);
				text4.setEnabled(false);
				text4.setText("0");
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				name1.setEnabled(true);
				text1.setEnabled(true);

				name2.setEnabled(true);
				text2.setEnabled(true);

				name4.setEnabled(true);
				text4.setEnabled(true);
			}
		}
		if (e.getSource() == name4) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				name1.setEnabled(false);
				text1.setEnabled(false);
				text1.setText("0");

				name2.setEnabled(false);
				text2.setEnabled(false);
				text2.setText("0");

				name3.setEnabled(false);
				text3.setEnabled(false);
				text3.setText("0");
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				name1.setEnabled(true);
				text1.setEnabled(true);

				name2.setEnabled(true);
				text2.setEnabled(true);

				name3.setEnabled(true);
				text3.setEnabled(true);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == but) {

			if (name1.isSelected()) 
			{
				batting = z;
				pangname = "ÆØÀÌ";
				play = new Playgame1(pangname, batting, Integer.valueOf(text1.getText()), loginID, this);
			}
			else if (name2.isSelected())
			{
				batting = c;
				pangname = "ÇªÇª";
				play = new Playgame1(pangname, batting, Integer.valueOf(text2.getText()), loginID, this);
			} 
			else if (name3.isSelected()) 
			{
				batting = v;
				pangname = "¶×¶ì";
				play = new Playgame1(pangname, batting, Integer.valueOf(text3.getText()), loginID, this);
			} 
			else if (name4.isSelected()) 
			{
				batting = b;
				pangname = "¹Î´Þ";
				play = new Playgame1(pangname, batting, Integer.valueOf(text4.getText()), loginID, this);
			}

		}
	}
	
	public void Close()
	{
		dispose();
		parent.Close();
	}
}
