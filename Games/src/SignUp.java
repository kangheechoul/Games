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
		setTitle("ȸ������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//�ߺ��˻�
		overboolean = false;
		
		back = new JPanel(new GridLayout(4,0));
		//����� �ֱ�
		emptypanel = new JPanel();
		
		idpanel = new JPanel(new GridLayout(0,3));
		idlabelpanel = new JPanel();
		idlabel = new JLabel("ID");
		id = new JTextField(15);
		overpanel = new JPanel();
		over = new JButton("�ߺ�Ȯ��");
		idex = new JLabel("ID 8���� �̻�");
		
		idlabelpanel.add(idlabel);
		overpanel.add(over);
		idpanel.add(idlabelpanel);
		idpanel.add(id);
		idpanel.add(overpanel);
		
		pwpanel = new JPanel(new GridLayout(0,3));
		pwlabelpanel = new JPanel();
		pwlabel = new JLabel("��й�ȣ");
		pw = new JPasswordField(15);
		
		pwlabelpanel.add(pwlabel);
		pwpanel.add(pwlabelpanel);
		pwpanel.add(pw);
		
		repwpanel = new JPanel(new GridLayout(0,3));
		repwlabelpanel = new JPanel();
		repwlabel = new JLabel("��й�ȣ Ȯ��");
		repw = new JPasswordField(15);
		
		repwlabelpanel.add(repwlabel);
		repwpanel.add(repwlabelpanel);
		repwpanel.add(repw);
		
		joinpanel = new JPanel();
		join = new JButton("�����ϱ�");
		
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
		//ȸ������
		if(e.getSource() == join)
		{
			Writer();
		}
		//�ߺ��˻�
		if(e.getSource() == over)
		{
			OverTest(idlist);
		}
	}
	
	
	public void OverTest(List list)
	{
		if(id.getText().length() < 8)
		{
			new Option(this,"ID�� 8���� �̻����� ���ּ���");
		}
		else
		{
			if(list.contains(id.getText()))
			{
				new Option(this,"�ߺ��� ���̵� �Դϴ�.");
				overboolean = false;
			}
			else
			{
				new Option(this,"��� ������ ���̵��Դϴ�.");
				overboolean = true;
			}
		}
	}
	
	//ȸ������ �� ���Ͽ� �Է�
	public void Writer()
	{
		PrintWriter ss = null;
		try
		{
			ss = new PrintWriter(new FileWriter("./����/���� ���.txt", true));
			
			if(overboolean == true && pw.getText().equals(repw.getText()) && !pw.getText().equals(""))
			{
				ss.println("ID : " + id.getText() + " PW : " + pw.getText());
				ss.flush();
				new FileWriter("./����/" + id.getText() + ".txt");
				new Option(this,"���ԿϷ�");
				this.dispose();
			}
			else if(id.getText().equals("") || pw.getText().equals("") || repw.getText().equals(""))
			{
				new Option(this,"��ĭ�� ä���ּ���");
			}
			else if(!pw.getText().equals(repw.getText()))
			{
				new Option(this,"��й�ȣ�� �ٸ��ϴ�.");
			}
		
			else if(overboolean == false)
			{
				new Option(this,"�ߺ� �˻縦 ���ּ���");
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
