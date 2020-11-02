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
		setTitle(ID + "�� ����������");
		setSize(400,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		labellist = new ArrayList<>();
		
		gababo = new ArrayList<>();
		
		gababo.add("����");
		gababo.add("����");
		gababo.add("��");
		
		back = new JPanel(new BorderLayout());
		select = new JPanel();
		ImageIcon gaimg = new ImageIcon("./����������/����.png");
		ImageIcon baimg = new ImageIcon("./����������/����.png");
		ImageIcon boimg = new ImageIcon("./����������/��.png");

		ga = new JLabel(img(gaimg));
		ba = new JLabel(img(baimg));
		bo = new JLabel(img(boimg));
		
		ga.setName("����");
		ba.setName("����");
		bo.setName("��");
		

		select.add(ga);
		select.add(ba);
		select.add(bo);
		labellist.add(img(gaimg));
		labellist.add(img(baimg));
		labellist.add(img(boimg));
		
		
		btnpanel = new JPanel();
		
		gabtn = new JButton("����");
		babtn = new JButton("����");
		bobtn = new JButton("��");
		
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
			guestselect = "����";
		}
		
		if(e.getSource() == babtn)
		{
			result(ba);
			guestselect = "����";
		}
		
		if(e.getSource() == bobtn)
		{
			result(bo);
			guestselect = "��";
		}
	}

	//�̹��� ������ ����
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
		ff.setTitle("�α��α�");
		ff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ff.setLocationRelativeTo(null);
		
		JPanel back1 = new JPanel(new BorderLayout());
		
		JPanel guest1 = new JPanel();
		
		JPanel admin1 = new JPanel();
		
		JPanel btnpan1 = new JPanel();
		
		JButton stop = new JButton("����");
		JButton closebtn = new JButton("������");

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
		
		if(guest == "����" && admin == "����" || guest == "����" && admin == "��" || guest == "��" && admin == "����")
		{
			result = "�����ϴ�";
		}
		else if(guest == "����" && admin == "��"||guest == "����" && admin == "����" ||guest == "��" && admin == "����")
		{
			result = "�̰���ϴ�!";
		}
		else
		{
			result = "���º��Դϴ�";
		}
		new Option(this,result);
		Resultappend();
	}
	
	public void Resultappend()
	{
		PrintWriter ss = null;
		try
		{
			ss = new PrintWriter(new FileWriter("./����/"+ loginID +".txt", true));
			String resultprint = "����������" + "\n"
								+"���� : " + loginID + "\n"
						    	+ loginID + "�� : " + guestselect + "\n"
						    	+ "��ǻ�� : " + adminselect+ "\n" 
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
