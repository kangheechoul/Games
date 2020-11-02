import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Champion extends JFrame implements ActionListener {
	JScrollPane scrollPane;
	ImageIcon backIcon, icon;
	
	JButton mainButton;
	
	JPanel backPanel, mainPanel, startPanel;
	JLabel selectLabel;
	JFrame startFrame;
	
	String teams[];
	String loginID;
	
	BufferedImage img = null;
	
	
	public Champion (String loginID){
		this.loginID = loginID;
		setTitle("����� ���߱�");
		
		//��׶��� �̹��� ����, �����г�
		
		backIcon = new ImageIcon("./�� ��ũ/chmapionsleague.jpg");
		
		Dimension frameSize = this.getSize();
	    // ����� ũ��
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    // (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
	    this.setLocation((screenSize.width - frameSize.width) /6, (screenSize.height - frameSize.height) /6);

	
		backPanel = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(backIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		mainPanel = new JPanel();
		mainButton = new JButton("���۹�ư");
		scrollPane = new JScrollPane(backPanel);
		setContentPane(scrollPane);
		JButton backButton = new JButton("����");
		backButton.addActionListener(this);
		
		backPanel.add(backButton, BorderLayout.SOUTH);
		
		
		
		mainPanel.add(mainButton);
		add(mainPanel);
		setSize(1280,720);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new teamSelect(loginID, this);
	}
	
	public void Close()
	{
		dispose();
	}	
}

class teamSelect extends JFrame implements ActionListener
{
	List<ImageIcon> list;
	String loginID;
	Champion parent;
	JComboBox<String> tim;
	
	public teamSelect(String loginID, Champion parent){
		this.parent = parent;
		this.loginID = loginID;
		list = new ArrayList<>();
		//������â
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("������");
		JPanel teamPanel = new JPanel(new BorderLayout());
		
		JPanel topPanel = new JPanel(new GridLayout(2,0));
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		JLabel teamImage = new JLabel();
		
		JLabel teamSelectLabel = new JLabel("�����ϴ� ���� �����ϼ���");
		JButton teamSelectButton = new JButton("����");
		teamSelectButton.addActionListener(this);

		ImageIcon img1 = new ImageIcon("./�� ��ũ/������ġ��.png");
		ImageIcon img2 = new ImageIcon("./�� ��ũ/��Ʈ��.png");
		ImageIcon img3 = new ImageIcon("./�� ��ũ/�߷��þ�.png");
		ImageIcon img4 = new ImageIcon("./�� ��ũ/��Ż��Ÿ.png");
		ImageIcon img5 = new ImageIcon("./�� ��ũ/PSG.png");
		ImageIcon img6 = new ImageIcon("./�� ��ũ/����Ʈ��Ʈ.png");
		ImageIcon img7 = new ImageIcon("./�� ��ũ/����Ǯ.png");
		ImageIcon img8 = new ImageIcon("./�� ��ũ/��Ʋ��Ƽ��.png");
		ImageIcon img9 = new ImageIcon("./�� ��ũ/��������.png");
		ImageIcon img10 = new ImageIcon("./�� ��ũ/����.png");
		ImageIcon img11 = new ImageIcon("./�� ��ũ/�ǽ�Ƽ.png");
		ImageIcon img12 = new ImageIcon("./�� ��ũ/���˸��帮��.png");
		ImageIcon img13 = new ImageIcon("./�� ��ũ/���̿�������.png");
		ImageIcon img14 = new ImageIcon("./�� ��ũ/ÿ��.png");
		ImageIcon img15 = new ImageIcon("./�� ��ũ/�ٸ����γ�.png");
		ImageIcon img16 = new ImageIcon("./�� ��ũ/������.png");
		
		list.add(img1);
		list.add(img2);
		list.add(img3);
		list.add(img4);
		list.add(img5);
		list.add(img6);
		list.add(img7);
		list.add(img8);
		list.add(img9);
		list.add(img10);
		list.add(img11);
		list.add(img12);
		list.add(img13);
		list.add(img14);
		list.add(img15);
		list.add(img16);
		
		
		String teams[] = 
		{"������ġ��","��Ʈ��","�߷��þ�","��Ż��Ÿ"
		,"PSG","����Ʈ��Ʈ","����Ǯ","��Ʋ��Ƽ��",
		"��������","����","�ǽ�Ƽ","���˸��帮��",
		"���̿�������","ÿ��","�ٸ����γ�","������"};
		
		tim = new JComboBox<>(teams);
		
		tim.addItemListener(new ItemListener()
		{	
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				int a = tim.getSelectedIndex();
				teamImage.setIcon(list.get(a));
			}
		});
		teamImage.setIcon(list.get(0));
		topPanel.add(teamSelectLabel);
		topPanel.add(tim);

		teamPanel.add(topPanel, BorderLayout.NORTH);
		
		centerPanel.add(teamImage);
		teamPanel.add(centerPanel, BorderLayout.CENTER);
		
		
		bottomPanel.add(teamSelectButton);
		
		teamPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		add(teamPanel);
		
		setSize(300,260);
		
		setVisible(true);
		
	}
	
	public void Close()
	{
		dispose();
		parent.Close();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		new tournament(list, tim.getSelectedIndex(), tim.getSelectedItem().toString(), loginID, this);
		
	}
}

class tournament extends JFrame 
{
	List<ImageIcon> list;
	JLabel label1,label2,label3,label4,
		   label5,label6,label7,label8,
		   label9,label10,label11,label12,
		   label13,label14,label15,label16;
	
	String loginID;
	String cheerteam;
	String winteam1;
	teamSelect parent;
	
	public tournament
	(List<ImageIcon> iconlist, int winteamIndex, String winteamname, String loginID,teamSelect parent)
	{
		this.parent = parent;
		this.loginID = loginID;
		
		list = new ArrayList<>(iconlist);
		
		Dimension frameSize = this.getSize();
	    // ����� ũ��
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    // (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
	    this.setLocation((screenSize.width - frameSize.width) /17, (screenSize.height - frameSize.height) /8);
		
		
		
		//������
		JPanel toppanel = new JPanel();
		//16�� ��ü ���
		JPanel team16panel = new JPanel();
		//8�� ��ü ���
		JPanel team8panel = new JPanel();
		//4�� ��ü ���
		JPanel team4panel = new JPanel();
		//��� ���
		JPanel team2panel = new JPanel();
		//����� ���
		JPanel winteam = new JPanel();
		
		JPanel back = new JPanel(new GridLayout(6,0));


		JLabel labelTop = new JLabel("������ : "  );
		toppanel.add(labelTop);

		toppanel.add(new JLabel(list.get(winteamIndex)));
		
		String winString =	list.get(winteamIndex).toString();

		JLabel sixTeen = new JLabel("16��");
		team16panel.add(sixTeen);

		
		for(int i = 0; i < list.size(); i++)
		{
			
			team16panel.add(new JLabel(list.get(i)));
		}

		for(int i = 0; i < 8; i++)
		{
			Random rd = new Random();
			int a = rd.nextInt(list.size());
			list.remove(a);
		}
		
		JLabel eightTeam = new JLabel("8��");
		team8panel.add(eightTeam);
		for(int i = 0; i< list.size();i++)
		{
			team8panel.add(new JLabel(list.get(i)));
		
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			Random rd = new Random();
			int a = rd.nextInt(list.size());
			list.remove(a);
		}
		
		
		JLabel fourTeam = new JLabel("4��");
		team4panel.add(fourTeam);
		for(int i = 0; i< list.size();i++)
		{
			team4panel.add(new JLabel(list.get(i)));
		}

		for(int i = 0; i < list.size(); i++)
		{
			Random rd = new Random();
			int a = rd.nextInt(list.size());
			list.remove(a);
		}
		
		JLabel twoTeam = new JLabel("���");
		team2panel.add(twoTeam);
		for(int i = 0; i< list.size();i++)
		{
			team2panel.add(new JLabel(list.get(i)));
		}

		for(int i = 0; i < list.size(); i++)
		{
			Random rd = new Random();
			int a = rd.nextInt(list.size());
			list.remove(a);
		}
		
		JLabel winteamLabel = new JLabel("�����");
		
		JButton closebtn = new JButton("������");
		
		winteam.add(winteamLabel);
		JLabel winlabel = new JLabel(list.get(0));
		winteam.add(winlabel);
		winteam.add(closebtn);

		back.add(toppanel);
		back.add(winteam);
		back.add(team2panel);
		back.add(team4panel);
		back.add(team8panel);
		back.add(team16panel);
		
		
		add(back);
		
		
		closebtn.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Close();					
			}
		});
		
		
		// �����
		winteam1 = list.get(0).toString().replace("./�� ��ũ/", "").replace(".png", "");
		// ������
		cheerteam = winString.replace("./�� ��ũ/", "").replace(".png", "");

		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setVisible(true);
		Resultappend();
	}
	
	public void Close()
	{
		dispose();
		parent.Close();
	}
	
	
	public void Resultappend()
	{
		PrintWriter ss = null;
		String result = "";
		
		if(winteam1.equals(cheerteam))
		{
			result = "����";
		}
		else
		{
			result = "������";
		}
		
		new Option(this, result+"�Դϴ�.");
		
		try
		{
			ss = new PrintWriter(new FileWriter("./����/"+ loginID +".txt", true));
			String resultprint = "����� ���߱�" + "\n"
								+ "���� : " + loginID + "\n"
								+ "��� �� : " + winteam1 + "\n"
								+ "���� �� : " + cheerteam + "\n"
						    	+ loginID + "��" + result;
		
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


