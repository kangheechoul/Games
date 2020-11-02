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
		setTitle("우승팀 맞추기");
		
		//백그라운드 이미지 삽입, 메인패널
		
		backIcon = new ImageIcon("./팀 마크/chmapionsleague.jpg");
		
		Dimension frameSize = this.getSize();
	    // 모니터 크기
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    // (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
	    this.setLocation((screenSize.width - frameSize.width) /6, (screenSize.height - frameSize.height) /6);

	
		backPanel = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(backIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		mainPanel = new JPanel();
		mainButton = new JButton("시작버튼");
		scrollPane = new JScrollPane(backPanel);
		setContentPane(scrollPane);
		JButton backButton = new JButton("시작");
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
		//팀선택창
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("팀선택");
		JPanel teamPanel = new JPanel(new BorderLayout());
		
		JPanel topPanel = new JPanel(new GridLayout(2,0));
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		JLabel teamImage = new JLabel();
		
		JLabel teamSelectLabel = new JLabel("응원하는 팀을 선택하세요");
		JButton teamSelectButton = new JButton("선택");
		teamSelectButton.addActionListener(this);

		ImageIcon img1 = new ImageIcon("./팀 마크/라이프치히.png");
		ImageIcon img2 = new ImageIcon("./팀 마크/토트넘.png");
		ImageIcon img3 = new ImageIcon("./팀 마크/발렌시아.png");
		ImageIcon img4 = new ImageIcon("./팀 마크/아탈란타.png");
		ImageIcon img5 = new ImageIcon("./팀 마크/PSG.png");
		ImageIcon img6 = new ImageIcon("./팀 마크/도르트문트.png");
		ImageIcon img7 = new ImageIcon("./팀 마크/리버풀.png");
		ImageIcon img8 = new ImageIcon("./팀 마크/아틀레티코.png");
		ImageIcon img9 = new ImageIcon("./팀 마크/유벤투스.png");
		ImageIcon img10 = new ImageIcon("./팀 마크/리옹.png");
		ImageIcon img11 = new ImageIcon("./팀 마크/맨시티.png");
		ImageIcon img12 = new ImageIcon("./팀 마크/레알마드리드.png");
		ImageIcon img13 = new ImageIcon("./팀 마크/바이에른뮌헨.png");
		ImageIcon img14 = new ImageIcon("./팀 마크/첼시.png");
		ImageIcon img15 = new ImageIcon("./팀 마크/바르셀로나.png");
		ImageIcon img16 = new ImageIcon("./팀 마크/나폴리.png");
		
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
		{"라이프치히","토트넘","발렌시아","아탈란타"
		,"PSG","도르트문트","리버풀","아틀레티코",
		"유벤투스","리옹","맨시티","레알마드리드",
		"바이에른뮌헨","첼시","바르셀로나","나폴리"};
		
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
	    // 모니터 크기
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    // (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
	    this.setLocation((screenSize.width - frameSize.width) /17, (screenSize.height - frameSize.height) /8);
		
		
		
		//응원팀
		JPanel toppanel = new JPanel();
		//16강 전체 출력
		JPanel team16panel = new JPanel();
		//8강 전체 출력
		JPanel team8panel = new JPanel();
		//4강 전체 출력
		JPanel team4panel = new JPanel();
		//결승 출력
		JPanel team2panel = new JPanel();
		//우승팀 출력
		JPanel winteam = new JPanel();
		
		JPanel back = new JPanel(new GridLayout(6,0));


		JLabel labelTop = new JLabel("응원팀 : "  );
		toppanel.add(labelTop);

		toppanel.add(new JLabel(list.get(winteamIndex)));
		
		String winString =	list.get(winteamIndex).toString();

		JLabel sixTeen = new JLabel("16강");
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
		
		JLabel eightTeam = new JLabel("8강");
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
		
		
		JLabel fourTeam = new JLabel("4강");
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
		
		JLabel twoTeam = new JLabel("결승");
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
		
		JLabel winteamLabel = new JLabel("우승팀");
		
		JButton closebtn = new JButton("나가기");
		
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
		
		
		// 우승팀
		winteam1 = list.get(0).toString().replace("./팀 마크/", "").replace(".png", "");
		// 응원팀
		cheerteam = winString.replace("./팀 마크/", "").replace(".png", "");

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
			result = "적중";
		}
		else
		{
			result = "미적중";
		}
		
		new Option(this, result+"입니다.");
		
		try
		{
			ss = new PrintWriter(new FileWriter("./관리/"+ loginID +".txt", true));
			String resultprint = "우승팀 맞추기" + "\n"
								+ "계정 : " + loginID + "\n"
								+ "우승 팀 : " + winteam1 + "\n"
								+ "응원 팀 : " + cheerteam + "\n"
						    	+ loginID + "님" + result;
		
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


