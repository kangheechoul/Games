import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Vision extends JFrame implements ActionListener
{
	List<RanBtn> number;
	JPanel backpanel, center, south, north;
	JLabel northLabel, southLabel;
	Set<Integer> aa;
	List<String> Answer;
	Timer timer;
	RanBtn ran;
	Random rd;
	int r,g,b;
	Color col;
	
	
	String loginID;
	int ss, se;
	
	public Vision(String ID)
	{
		loginID = ID;
		setTitle(ID + "님 동체 시력 테스트");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		backpanel = new JPanel(new BorderLayout());
		
		center = new JPanel(new GridLayout(5,5));
		
		north = new JPanel();
		northLabel = new JLabel("동체시력 테스트");
		northLabel.setFont(new Font("DIALOG",Font.BOLD,35));
		north.add(northLabel);
		
		
		south = new JPanel();
		southLabel = new JLabel("타이머 자리");
		southLabel.setFont(new Font("DIALOG",Font.BOLD,35));
		south.add(southLabel);

		
		//버튼 리스트
		number = new ArrayList<>();
		
		//순서 리스트
		Answer = new ArrayList<>();
		
		//답지
		for(int i = 1; i <= 25; i++)
		{
			Answer.add("" + i);
		}
		
		aa = new LinkedHashSet<>();
		
		//중복되지 않는 랜덤 수 만들기
		while(aa.size() < 25)
		{
			Random rnd = new Random();
			int a = rnd.nextInt(25) + 1;
			aa.add(a);
		}
		Iterator<Integer> iter = aa.iterator(); 
		
		//랜덤적으로 버튼 배치하기
		while(iter.hasNext())
		{
			ran = new RanBtn();
			ran.setText("" + iter.next());
			Random rd = new Random();
			ran.setFont(new Font("DIALOG",Font.BOLD,15));
			ran.setBackground(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));

			number.add(ran);
			center.add(ran);
		}
		
		for(int i = 0; i< number.size(); i++)
		{
			number.get(i).addActionListener(this);
		}
			

		backpanel.add(north , BorderLayout.NORTH);
		backpanel.add(center , BorderLayout.CENTER);
		backpanel.add(south , BorderLayout.SOUTH);
		TimeRun();
		add(backpanel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String aa = e.getActionCommand();
		
		RanBtn btt = (RanBtn) e.getSource();
		
		if(aa.equals(Answer.get(0)))
		{
			Answer.remove(0);
			remove(btt);
			if(aa.equals("25"))
			{
				Ending();
			}
		}
	}
	
	public void remove(RanBtn btn)
	{
		btn.setVisible(false);
	}
	
	public void Ending()
	{
		timer.stop();
		JOptionPane.showMessageDialog(this, "기록은 " + southLabel.getText() + "입니다");
		Resultappend();
		dispose();
	}
	
	public void TimeRun()
	{
		ss = 0;
		se = 0;
		timer = new Timer(100, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				southLabel.setText(ss + "." + se + "초");
				if(se == 59)
				{
					se = 00;
					ss++;
				}
				se++;
			}
		});
		timer.start();
	}
	
	public void Resultappend()
	{
		PrintWriter ss = null;
		try
		{
			ss = new PrintWriter(new FileWriter("./관리/"+ loginID +".txt", true));
			String resultprint = "동체 시력 테스트" + "\n"
								+ "계정 : " + loginID + "\n"
						    	+ loginID + "님 : " + southLabel.getText() + "만에 성공";
		
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

class RanBtn extends JButton 
{
	JButton btn ;
	
	public RanBtn()
	{
		btn = new JButton();
	}
}