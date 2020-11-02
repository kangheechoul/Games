import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Mukchipa extends JFrame implements ActionListener
{
	JLabel ga,ba,bo;
	JPanel back, select, btnpanel;
	JButton gabtn, babtn, bobtn;

	List<ImageIcon> labellist;
	
	Timer timer;
	
	String guestselect;
	String adminselect;
	String loginID;
	String result;
	
	List<String> gababo;
	
	public Mukchipa(String ID)
	{
		loginID = ID;
		setTitle(ID + "님 가위바위보");
		setSize(400,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		labellist = new ArrayList<>();
		
		gababo = new ArrayList<>();
		
		gababo.add("가위");
		gababo.add("바위");
		gababo.add("보");
		
		back = new JPanel(new BorderLayout());
		select = new JPanel();
		ImageIcon gaimg = new ImageIcon("./가위바위보/가위.png");
		ImageIcon baimg = new ImageIcon("./가위바위보/바위.png");
		ImageIcon boimg = new ImageIcon("./가위바위보/보.png");

		ga = new JLabel(img(gaimg));
		ba = new JLabel(img(baimg));
		bo = new JLabel(img(boimg));
		
		ga.setName("가위");
		ba.setName("바위");
		bo.setName("보");
		

		select.add(ga);
		select.add(ba);
		select.add(bo);
		labellist.add(img(gaimg));
		labellist.add(img(baimg));
		labellist.add(img(boimg));
		
		
		btnpanel = new JPanel();
		
		gabtn = new JButton("가위");
		babtn = new JButton("바위");
		bobtn = new JButton("보");
		
		btnpanel.add(gabtn);
		btnpanel.add(babtn);
		btnpanel.add(bobtn);
		
		back.add(select, BorderLayout.CENTER);
		back.add(btnpanel, BorderLayout.SOUTH);
		add(back);
		
		gabtn.addActionListener(this);
		babtn.addActionListener(this);
		bobtn.addActionListener(this);
		
		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == gabtn)
		{
			result(ga);
			guestselect = "가위";
		}
		
		if(e.getSource() == babtn)
		{
			result(ba);
			guestselect = "바위";
		}
		
		if(e.getSource() == bobtn)
		{
			result(bo);
			guestselect = "보";
		}
	}

	//이미지 사이즈 조절
	public ImageIcon img(ImageIcon ag)
	{
		Image img1 = ag.getImage();
		Image img2 = img1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); 
		ag = new ImageIcon(img2);
		
		return ag;
	}
	
	
	public void result(JLabel label)
	{
		JFrame ff = new JFrame();
		ff.setSize(300,300);
		ff.setTitle("두구두구");
		ff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ff.setLocationRelativeTo(null);
		
		JPanel back1 = new JPanel(new BorderLayout());
		
		JPanel guest1 = new JPanel();
		
		JPanel admin1 = new JPanel();
		
		JPanel btnpan1 = new JPanel();
		
		JButton stop = new JButton("정지");
		JButton closebtn = new JButton("나가기");

		btnpan1.add(stop);
		btnpan1.add(closebtn);
		JLabel lab = new JLabel(labellist.get(0));
		guest1.add(label);
		admin1.add(lab);
		timer = new Timer(70, new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					Random rd = new Random();
					int a = rd.nextInt(3);
					lab.setIcon(labellist.get(a));
					adminselect = gababo.get(a);
			}
		});
		timer.start();
		
		stop.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Stop(guestselect, adminselect);
				stop.setEnabled(false);
			}
		});
		closebtn.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Close(ff);
			}
		});
		
		back1.add(guest1, BorderLayout.WEST);
		back1.add(admin1, BorderLayout.EAST);
		back1.add(btnpan1, BorderLayout.SOUTH);
		ff.add(back1);
		ff.setVisible(true);
	}
	
	public void Close(JFrame af)
	{
		af.dispose();
		this.dispose();
	}
	
	public void Stop(String guest, String admin)
	{
		timer.stop();
		result = "";
		
		if(guest == "가위" && admin == "바위" || guest == "바위" && admin == "보" || guest == "보" && admin == "가위")
		{
			result = "졌습니다";
		}
		else if(guest == "가위" && admin == "보"||guest == "바위" && admin == "가위" ||guest == "보" && admin == "바위")
		{
			result = "이겼습니다!";
		}
		else
		{
			result = "무승부입니다";
		}
		new Option(this,result);
		Resultappend();
	}
	
	public void Resultappend()
	{
		PrintWriter ss = null;
		try
		{
			ss = new PrintWriter(new FileWriter("./관리/"+ loginID +".txt", true));
			String resultprint = "가위바위보" + "\n"
								+"계정 : " + loginID + "\n"
						    	+ loginID + "님 : " + guestselect + "\n"
						    	+ "컴퓨터 : " + adminselect+ "\n" 
						    	+ result;
		
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
