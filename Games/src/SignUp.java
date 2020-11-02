import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener
{
	JPanel back, idpanel, idlabelpanel, overpanel, 
	pwpanel, pwlabelpanel, repwpanel, repwlabelpanel, joinpanel, emptypanel; 
	
	JTextField id, pw, repw;
	JButton	over, join;
	JLabel idlabel, pwlabel, repwlabel;
	JLabel idex;
	Boolean overboolean;
	
	List<String> idlist;
	
	public SignUp(List list)
	{
		idlist = list;
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//중복검사
		overboolean = false;
		
		back = new JPanel(new GridLayout(4,0));
		//빈공간 주기
		emptypanel = new JPanel();
		
		idpanel = new JPanel(new GridLayout(0,3));
		idlabelpanel = new JPanel();
		idlabel = new JLabel("ID");
		id = new JTextField(15);
		overpanel = new JPanel();
		over = new JButton("중복확인");
		idex = new JLabel("ID 8글자 이상");
		
		idlabelpanel.add(idlabel);
		overpanel.add(over);
		idpanel.add(idlabelpanel);
		idpanel.add(id);
		idpanel.add(overpanel);
		
		pwpanel = new JPanel(new GridLayout(0,3));
		pwlabelpanel = new JPanel();
		pwlabel = new JLabel("비밀번호");
		pw = new JPasswordField(15);
		
		pwlabelpanel.add(pwlabel);
		pwpanel.add(pwlabelpanel);
		pwpanel.add(pw);
		
		repwpanel = new JPanel(new GridLayout(0,3));
		repwlabelpanel = new JPanel();
		repwlabel = new JLabel("비밀번호 확인");
		repw = new JPasswordField(15);
		
		repwlabelpanel.add(repwlabel);
		repwpanel.add(repwlabelpanel);
		repwpanel.add(repw);
		
		joinpanel = new JPanel();
		join = new JButton("가입하기");
		
		joinpanel.add(emptypanel);
		joinpanel.add(join);
		
		
		back.add(idpanel);
		back.add(pwpanel);
		back.add(repwpanel);
		back.add(joinpanel);
		
		over.addActionListener(this);
		join.addActionListener(this);
		
		add(back);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//회원가입
		if(e.getSource() == join)
		{
			Writer();
		}
		//중복검사
		if(e.getSource() == over)
		{
			OverTest(idlist);
		}
	}
	
	
	public void OverTest(List list)
	{
		if(id.getText().length() < 8)
		{
			new Option(this,"ID는 8글자 이상으로 해주세요");
		}
		else
		{
			if(list.contains(id.getText()))
			{
				new Option(this,"중복된 아이디 입니다.");
				overboolean = false;
			}
			else
			{
				new Option(this,"사용 가능한 아이디입니다.");
				overboolean = true;
			}
		}
	}
	
	//회원가입 후 파일에 입력
	public void Writer()
	{
		PrintWriter ss = null;
		try
		{
			ss = new PrintWriter(new FileWriter("./관리/계정 목록.txt", true));
			
			if(overboolean == true && pw.getText().equals(repw.getText()) && !pw.getText().equals(""))
			{
				ss.println("ID : " + id.getText() + " PW : " + pw.getText());
				ss.flush();
				new FileWriter("./관리/" + id.getText() + ".txt");
				new Option(this,"가입완료");
				this.dispose();
			}
			else if(id.getText().equals("") || pw.getText().equals("") || repw.getText().equals(""))
			{
				new Option(this,"빈칸을 채워주세요");
			}
			else if(!pw.getText().equals(repw.getText()))
			{
				new Option(this,"비밀번호가 다릅니다.");
			}
		
			else if(overboolean == false)
			{
				new Option(this,"중복 검사를 해주세요");
			}
			
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
