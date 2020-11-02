import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class MainScreen extends JFrame implements ActionListener
{
	JPanel back, center, north, south;
	JButton game1,game2,game3,game4, login, signUp;
	JTextField id, pw;
	List<String> idlist, pwlist;
	JPanel centerlabel,center_1,center_2;
	JLabel loginOkID;
	JButton idhistory, logoutbtn;
	
	String loginid,loginpw;
	
	public MainScreen() 
	{
		idlist = new ArrayList<>();
		pwlist = new ArrayList<>();
		listUpdate();
		
		setTitle("�̴ϰ��� õ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Dimension frameSize = this.getSize();
	    // ����� ũ��
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    // (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
	    this.setLocation((screenSize.width - frameSize.width) /3, (screenSize.height - frameSize.height) /3);
		
		
		back = new JPanel(new BorderLayout());
		
		north = new JPanel();
		JLabel label = new JLabel("�̴� ���� õ��");
		label.setFont(new Font("DIALOG",Font.BOLD,40));
		north.add(label);
		
		center = new JPanel();
		centerlabel = new JPanel(new GridLayout(2,0));
		center_1 = new JPanel(new GridLayout(2,0)); 
		center_2 = new JPanel(new GridLayout(2,0)); 
		
		JLabel idlabel = new JLabel("id", SwingConstants.RIGHT);
		JLabel pwlabel = new JLabel("pw", SwingConstants.RIGHT);
		id = new JTextField(15);
		pw = new JPasswordField(15);
		login = new JButton("�α���");
		signUp= new JButton("ȸ������");
		
		centerlabel.add(idlabel);
		centerlabel.add(pwlabel);		
		
		center_1.add(id);
		center_1.add(pw);
		center_2.add(login);
		center_2.add(signUp);
		center.add(centerlabel);
		center.add(center_1);
		center.add(center_2);

		south = new JPanel();
		
		game1 = new JButton("��ü �÷� �׽�Ʈ");
		game2 = new JButton("����������");
		game3 = new JButton("����� ���߱�");
		game4 = new JButton("������ ����");
		
		south.add(game1);
		south.add(game2);
		south.add(game3);
		south.add(game4);
		
		
		back.add(north, BorderLayout.NORTH);
		back.add(center, BorderLayout.CENTER);
		back.add(south, BorderLayout.SOUTH);
		
		add(back);
		
		game1.setEnabled(false);
		game2.setEnabled(false);
		game3.setEnabled(false);
		game4.setEnabled(false);
		
		game1.addActionListener(this);
		game2.addActionListener(this);
		game3.addActionListener(this);
		game4.addActionListener(this);
		login.addActionListener(this);
		signUp.addActionListener(this);
		
		pack();
		setVisible(true);
	}
	
	//���̵� ��� ������Ʈ
	public void listUpdate()
	{
		BufferedReader bb = null;
		try
		{
			bb = new BufferedReader(new FileReader("./����/���� ���.txt"));
			String s = "";
			while((s = bb.readLine()) != null)
			{
				String[] a = s.split(" PW : ");
				String ID = a[0].replace("ID : ", "");
				String PW = a[1];
				idlist.add(ID);
				pwlist.add(PW);
			}
			if(bb != null)
			{
				bb.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == game1)
		{
			new Vision(loginid);
		}
		if(e.getSource() == game2)
		{
			new Mukchipa(loginid);
		}
		if(e.getSource() == game3)
		{
			new Champion(loginid);
		}
		if(e.getSource() == game4)
		{
			new Wallpaper(loginid);
		}

		if(e.getSource() == login)
		{
			listUpdate();
			Login();
		}
		if(e.getSource() == signUp)
		{
			listUpdate();
			//ȸ�����Կ� ���̵� ��ϸ� �ʿ�
			new SignUp(idlist);
		}
	}
	
	//�α��� �˻�
	public void Login()
	{
		int index = idlist.indexOf(id.getText());
		
		if(index == -1)
		{
			new Option(this,"���̵� �����ϴ�");
		}
		else
		{
			loginid = idlist.get(index);
			loginpw = pwlist.get(index);
			if(id.getText().equals(loginid) && pw.getText().equals(loginpw))
			{
				new Option(this,"�α��� ����");
				LoginOk(loginid);
			}
			else if(id.getText().length() < 8)
			{
				new Option(this,"���̵�� 8���� �̻��Դϴ�.");
			}
			else
			{
				new Option(this, "ȸ�� ������ ��ġ���� �ʽ��ϴ�.");
			}
		}
	}

	//�α��� ������
	public void LoginOk(String id)
	{
		loginOkID = new JLabel(id + "�� ȯ���մϴ�");
		idhistory = new JButton("���� ����");
		logoutbtn = new JButton("�α׾ƿ�");
		centerlabel.setVisible(false);
		center_1.setVisible(false);
		center_2.setVisible(false);
		center.setLayout(new FlowLayout());
		center.add(loginOkID);
		center.add(idhistory);
		center.add(logoutbtn);
		
		game1.setEnabled(true);
		game2.setEnabled(true);
		game3.setEnabled(true);
		game4.setEnabled(true);
		
		idhistory.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				History(id);
			}
		});
		logoutbtn.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				LogOut();
			}
		});
		pack();
	}
	
	//���� ���ӳ���
	public void History(String loginID)
	{
		listUpdate();
		File file = new File("./����/"+ loginID +".txt");
		
		JFrame ff = new JFrame();
		ff.setLocationRelativeTo(this);
		//ff.setSize(400, 500);
		JPanel back = new JPanel();
		JPanel labelpa = new JPanel();
		labelpa.setLayout(new BoxLayout(labelpa, BoxLayout.Y_AXIS));
		
		JScrollPane scroll = new JScrollPane(labelpa);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(300, 450));
		scroll.setMaximumSize(new Dimension(300, 450));

		BufferedReader bb = null;
		
		try
		{
			bb = new BufferedReader(new FileReader(file));
			String aa = "";
			
			while((aa = bb.readLine()) != null)
			{
				JLabel fflabel = new JLabel();
				fflabel.setText(fflabel.getText() + aa + "\n");
				labelpa.add(fflabel);
			}
			
			if(bb != null)
			{
				bb.close();
			}
			if(labelpa.getComponentCount() == 0)
			{
				new Option(this, "���� ������ �����ϴ�.");
				ff.setVisible(false);
			}
			else
			{
				back.add(scroll);
				ff.add(back);
				ff.pack();
				ff.setVisible(true);
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void LogOut()
	{
		centerlabel.setVisible(true);
		center_1.setVisible(true);
		center_2.setVisible(true);
		
		center.remove(loginOkID);
		center.remove(idhistory);
		center.remove(logoutbtn);
		
		game1.setEnabled(false);
		game2.setEnabled(false);
		game3.setEnabled(false);
		game4.setEnabled(false);
		pack();
	}
	
}

public class Test 
{
	public static void main(String[] args)
	{
		new MainScreen();
	}
}
