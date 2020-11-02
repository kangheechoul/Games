import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class Playgame1 extends JFrame implements ActionListener {
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	ImageIcon icon4;
	ImageIcon icon5;

	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;

	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9;
	JLabel label10;
	JLabel label11;
	JLabel label12;

	JButton but;
	int x = 100, y = 100, sel = 1;

	String pangname;
	String winname;
	int batting, money;
	int sum;

	Timer timer;
	String loginID;
	addd parent;
	
	public Playgame1(String pangname, int batting, int money, String loginID, addd frame) {
		parent = frame;
		this.loginID = loginID;
		// ¥ﬁ∆ÿ¿Ã ¿Ã∏ß
		this.pangname = pangname;
		// πË¥Á∑¸
		this.batting = batting;
		// ¿‘∑¬«— µ∑
		this.money = money;
		winname ="";
		icon1 = new ImageIcon("./¥ﬁ∆ÿ¿Ã/aa.png");
		icon2 = new ImageIcon("./¥ﬁ∆ÿ¿Ã/bb.png");
		icon3 = new ImageIcon("./¥ﬁ∆ÿ¿Ã/cc.png");
		icon4 = new ImageIcon("./¥ﬁ∆ÿ¿Ã/dd.png");
		icon5 = new ImageIcon("./¥ﬁ∆ÿ¿Ã/panel12.jpg");

		// panel = new JPanel();
		label1 = new JLabel(icon1);
		label2 = new JLabel(icon2);
		label3 = new JLabel(icon3);
		label4 = new JLabel(icon4);
		label9 = new JLabel(icon5);
		label10 = new JLabel(icon5);
		label11 = new JLabel(icon5);
		label12 = new JLabel(icon5);

		label5 = new JLabel("1.∆ÿ¿Ã");
		label6 = new JLabel("2.«™«™");
		label7 = new JLabel("3.∂◊∂Ï");
		label8 = new JLabel("4.πŒ¥ﬁ");

		Font font1 = new Font("±√º≠", Font.BOLD, 30);
		label5.setFont(font1);
		Font font2 = new Font("±√º≠", Font.BOLD, 30);
		label6.setFont(font2);
		Font font3 = new Font("±√º≠", Font.BOLD, 30);
		label7.setFont(font3);
		Font font4 = new Font("±√º≠", Font.BOLD, 30);
		label8.setFont(font4);

		but = new JButton("!!Ω√¿€!!");
		// ((FlowLayout)but.getLayout()).setAlignment(FlowLayout.CENTER);

		panel1 = new JPanel();
		((FlowLayout) panel1.getLayout()).setAlignment(FlowLayout.LEFT);
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2 = new JPanel();
		((FlowLayout) panel2.getLayout()).setAlignment(FlowLayout.LEFT);
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3 = new JPanel();
		((FlowLayout) panel3.getLayout()).setAlignment(FlowLayout.LEFT);
		panel3.setBorder(BorderFactory.createLineBorder(Color.black));
		panel4 = new JPanel();
		((FlowLayout) panel4.getLayout()).setAlignment(FlowLayout.LEFT);
		panel4.setBorder(BorderFactory.createLineBorder(Color.black));

		GridLayout layout = new GridLayout(0, 1);
		setLayout(layout);

		panel1.add(label1);
		panel1.add(label5);
		panel1.add(label9);
		panel1.setBackground(new Color(100, 5, 10));

		panel2.add(label2);
		panel2.add(label6);
		panel2.add(but);
		panel2.add(label10);

		panel2.setBackground(new Color(10, 5, 100));

		panel3.add(label3);
		panel3.add(label7);
		panel3.add(label11);
		panel3.setBackground(new Color(10, 100, 10));

		panel4.add(label4);
		panel4.add(label8);
		panel4.add(label12);
		panel4.setBackground(new Color(100, 100, 100));

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);

		but.addActionListener(this);

		setLocation(0, 250); // ¿ßƒ° ¡ˆ¡§
		setSize(1900, 400);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent q) {
		if (q.getSource() == but) {

			but.setVisible(false);
			label5.setVisible(false);
			label6.setVisible(false);
			label7.setVisible(false);
			label8.setVisible(false);

			panel1.setLayout(null);
			label1.setLayout(null);
			panel2.setLayout(null);
			panel3.setLayout(null);
			panel4.setLayout(null);
			Timer();

		}
	}

	public void Close()
	{
		dispose();
		parent.Close();
	}
	
	public void Timerend(String name, int number) {

		JFrame ff = new JFrame();
		JPanel panelp = new JPanel();
		JButton bt = new JButton("µπæ∆∞°±‚");
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent q) {
				setVisible(false);
				ff.setVisible(false);
				ff.dispose();
				Close();
			}
		});
		JLabel texts = new JLabel();
		texts.setText(winname + "∞° ¿Ã∞ÂæÓø‰");

		GridLayout layout1 = new GridLayout(0, 1);
		setLayout(layout1);
		
		
		if (winname.equals(name) && number == 1)
		{
			int sum = batting * money;
			this.sum = sum;
			JLabel prizemoney = new JLabel(winname + "¥Á√∑±› : " + sum);
			panelp.add(new JLabel(icon1));
			panelp.add(prizemoney);
		} 
		else if (winname.equals(name) && number == 2)
		{
			int sum = batting * money;
			this.sum = sum;
			JLabel prizemoney = new JLabel(winname + "¥Á√∑±› : " + sum);
			panelp.add(new JLabel(icon2));
			panelp.add(prizemoney);
		} 
		else if (winname.equals(name) && number == 3) 
		{
			int sum = batting * money;
			this.sum = sum;
			JLabel prizemoney = new JLabel(winname + "¥Á√∑±› : " + sum);
			panelp.add(new JLabel(icon3));
			panelp.add(prizemoney);
		} 
		else if (winname.equals(name) && number == 4) 
		{
			int sum = batting * money;
			this.sum = sum;
			JLabel prizemoney = new JLabel(winname + "¥Á√∑±› : " + sum);
			panelp.add(new JLabel(icon4));
			panelp.add(prizemoney);
		}
		else
		{
			
			if(name.equals("∆ÿ¿Ã"))
			{
				panelp.add(new JLabel(icon1));
				if(winname.equals("«™«™"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon2));
				}
				else if(winname.equals("∂◊∂Ï"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon3));
				}
				else if(winname.equals("πŒ¥ﬁ"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon4));
				}
			}
			else if(name.equals("«™«™"))
			{
				panelp.add(new JLabel(icon2));
				if(winname.equals("∆ÿ¿Ã"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon1));
				}
				else if(winname.equals("∂◊∂Ï"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon3));
				}
				else if(winname.equals("πŒ¥ﬁ"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon4));
				}
			}
			else if(name.equals("∂◊∂Ï"))
			{
				panelp.add(new JLabel(icon3));
				if(winname.equals("∆ÿ¿Ã"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon1));
				}
				else if(winname.equals("«™«™"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon2));
				}
				else if(winname.equals("πŒ¥ﬁ"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon4));
				}
			}
			else if(name.equals("πŒ¥ﬁ"))
			{
				panelp.add(new JLabel(icon4));
				if(winname.equals("∆ÿ¿Ã"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon1));
				}
				else if(winname.equals("«™«™"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon2));
				}
				else if(winname.equals("∂◊∂Ï"))
				{
					int sum = 0 * money;
					this.sum = sum;
					JLabel prizemoney = new JLabel(name + "¥Á√∑±› : " + sum);
					panelp.add(prizemoney);
					panelp.add(new JLabel(icon3));
				}
			}	
		}
		Resultappend();
		panelp.add(texts);
		panelp.add(bt);

		ff.add(panelp);
		ff.pack();
		//ff.setSize(100, 300);
		ff.setLocation(250, 250);
		ff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ff.setVisible(true);
	}

	public void Timer() {
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rd = new Random();
				int a = rd.nextInt(10) + 5;
				int b = rd.nextInt(10) + 5;
				int c = rd.nextInt(10) + 5;
				int d = rd.nextInt(10) + 5;

				if (label1.getX() >= 1600) {
					timer.stop();
					if (label1.getX() > label4.getX() || label1.getX() > label3.getX()
							|| label1.getX() > label2.getX()) 
					{
						winname = "∆ÿ¿Ã";
						Timerend(pangname, 1);
						label1.setVisible(false);
					}

				}
				else if (label2.getX() >= 1600) {
					timer.stop();
					if (label2.getX() > label4.getX() || label2.getX() > label3.getX()
							|| label2.getX() > label1.getX())
					{
						winname = "«™«™";
						Timerend(pangname, 2);
						label2.setVisible(false);
					}
				}
				else if (label3.getX() >= 1600) {
					timer.stop();
					if (label3.getX() > label1.getX() || label3.getX() > label2.getX()
							|| label3.getX() > label4.getX()) 
					{
						winname = "∂◊∂Ï";
						Timerend(pangname, 3);
						label3.setVisible(false);
					}
				}
				else if (label4.getX() >= 1600) {
					timer.stop();
					if (label4.getX() > label1.getX() || label4.getX() > label2.getX()
							|| label4.getX() > label3.getX())
					{
						winname = "πŒ¥ﬁ";
						Timerend(pangname, 4);
						label4.setVisible(false);
					}
				}
				label1.setBounds(label1.getX() + a, label1.getY(), label1.getWidth(), label1.getHeight());
				label2.setBounds(label2.getX() + b, label2.getY(), label2.getWidth(), label2.getHeight());
				label3.setBounds(label3.getX() + c, label3.getY(), label3.getWidth(), label3.getHeight());
				label4.setBounds(label4.getX() + d, label4.getY(), label4.getWidth(), label4.getHeight());
			}

		});
		timer.start();
	}
	
	public void Resultappend()
	{
		PrintWriter ss = null;
		try
		{
			ss = new PrintWriter(new FileWriter("./∞¸∏Æ/"+ loginID +".txt", true));
			String resultprint = "¥ﬁ∆ÿ¿Ã ∞Ê¡÷" + "\n"
								+"∞Ë¡§ : " + loginID + "\n"
						    	+ "øÏΩ¬ ¥ﬁ∆ÿ¿Ã : " + winname + "\n"
						    	+ "º±≈√ ¥ﬁ∆ÿ¿Ã : " + pangname + "\n" 
						    	+ "∫£∆√ ±›æ◊ : " + money + "\n"
						    	+ "¥Á√∑ ±› : " + sum + "ø¯ ¿‘¥œ¥Ÿ.";
		
			ss.append(resultprint + "\n");
			ss.append("--------------------------------------\n");
			ss.flush();
						    	
			if(ss != null)
			{
				ss.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}	

}
