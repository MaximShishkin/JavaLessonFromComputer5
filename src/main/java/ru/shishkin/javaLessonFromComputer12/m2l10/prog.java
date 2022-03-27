package ru.shishkin.javaLessonFromComputer12.m2l10;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class prog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFile;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prog frame = new prog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(prog.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		setTitle("\u041E\u043F\u0435\u0440\u0430\u0446\u0438\u0438 \u0434\u043B\u044F \u0440\u0430\u0431\u043E\u0442\u044B \u0441 \u0444\u0430\u0439\u043B\u0430\u043C\u0438");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0423\u043A\u0430\u0436\u0438\u0442\u0435 \u043F\u0443\u0442\u044C \u043A \u0444\u0430\u0439\u043B\u0443:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(10, 21, 200, 29);
		contentPane.add(label);
		
		textFieldFile = new JTextField();
		textFieldFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFile.setBounds(209, 21, 304, 27);
		contentPane.add(textFieldFile);
		textFieldFile.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 61, 304, 228);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton buttonNoviy = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u043D\u043E\u0432\u044B\u0439");
		buttonNoviy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textFieldFile.getText().trim();
			    if (str.isEmpty())
			    {
			      JOptionPane.showMessageDialog(null,
			            "������� ���� � �����!","������",0);
			    }
			    else
			    {
			      File nf = new File(str);
			      try
			      {
			        nf.createNewFile();
			        JOptionPane.showMessageDialog(null, 
			              "���� ������!","���������",1);
			      }
			      catch(IOException exp)
			      {
			        JOptionPane.showMessageDialog(null, 
			               "���� �� ������!","������",0);
			      }
			    }					
			}
		});
		buttonNoviy.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonNoviy.setBounds(10, 61, 177, 35);
		contentPane.add(buttonNoviy);
		
		JButton buttonUdalit = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		buttonUdalit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String str = textFieldFile.getText().trim();
			    if (str.isEmpty())
			    {
			      JOptionPane.showMessageDialog(null, 
			             "������� ���� � �����!","������",0);
			    }
			    else
			    {
			      File nf = new File(str);
			      if (nf.exists())
			      {
			        nf.delete();
			        JOptionPane.showMessageDialog(null, 
			             "���� ������!","���������",1); 
			      }
			      else
			      {
			        JOptionPane.showMessageDialog(null, 
			              "���� �� ������!","������",0);
			      }                	  
			    }												
			}
		});		
		buttonUdalit.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonUdalit.setBounds(10, 106, 177, 35);
		contentPane.add(buttonUdalit);
		
		JButton buttonPereim = new JButton("\u041F\u0435\u0440\u0435\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u0442\u044C");
		buttonPereim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String str = textFieldFile.getText().trim();
			    if (str.isEmpty())
			    {
			      JOptionPane.showMessageDialog(null, 
			           "������� ���� � �����!","������",0);
			    }
			    else
			    {
			      File nf = new File(str);
			      if (nf.exists())
			      {
			         String newName = 
			           JOptionPane.showInputDialog("������� ����� ���:");
			         if (newName==null) newName=""; 
			         if (!newName.trim().isEmpty())
			         {
			           File newFile = 
			            new File(nf.getParent()+"\\"+newName);
			           nf.renameTo(newFile);
			           JOptionPane.showMessageDialog(null, 
			              "���� ������������!","���������",1);                
			         }                	   
			       }
			       else
			       {
			         JOptionPane.showMessageDialog(null, 
			               "���� �� ������!","������",0);
			       }                	  
			     }																
			}
		});				
		buttonPereim.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonPereim.setBounds(10, 151, 177, 35);
		contentPane.add(buttonPereim);
		
		JButton buttonProch = new JButton("\u041F\u0440\u043E\u0447\u0438\u0442\u0430\u0442\u044C");
		buttonProch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String str = textFieldFile.getText().trim();
			    if (str.isEmpty())
			    {
			      JOptionPane.showMessageDialog(null, 
			          "������� ���� � �����!","������",0);
			    }
			    else
			    {
			      File nf = new File(str);
			      if (nf.exists())
			      {
			        try
			        {
			        	InputStream obj = new FileInputStream(str);
			            BufferedReader in = 
			                  new BufferedReader(new InputStreamReader(obj));
			            String tmp = "";
			            while(in.ready())
			            {
			              tmp += (in.readLine()+"\n");
			            }
			            textArea.setText(tmp);                		  
			            in.close();
			            obj.close();                			        	
			        }
			        catch (Exception exp) {}                	  
			      }
			      else
			      {
			          JOptionPane.showMessageDialog(null, 
			              "���� �� ������!","������",0);
			       }                	  
			     }												
			}});
		buttonProch.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonProch.setBounds(10, 197, 177, 35);
		contentPane.add(buttonProch);
		
		JButton buttonZap = new JButton("\u0417\u0430\u043F\u0438\u0441\u0430\u0442\u044C");
		buttonZap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String str = textFieldFile.getText().trim();
			    String s =textArea.getText();
			    String p="12345";
		         String rez = "";
		         String shif= "";
		         int t=0;
			    if (str.isEmpty())
			    {
				 JOptionPane.showMessageDialog(null, 
			              "������� ���� � �����!","������",0);
			   }
			   else
			   {
			     File nf = new File(str);
			     if (nf.exists())
			     {

			       // ������ � ����
			       try
			       {
			         OutputStream obj = new FileOutputStream(str);
			         BufferedWriter out = 
			             new BufferedWriter(new OutputStreamWriter(obj));
			         
			        /* int N=p.length();
			         for (int i=0; i<s.length(); i++)
			         {
			        	 char ch =s.charAt(i);
			        	 
			        	 char ch1=p.charAt(i);
			        	 int k = ch;
			        	 t=i%10+1;
			        	 k=k+t;
			        	 char g =(char)k;
			        	 
			        	 rez = rez+g;
			         }
			         out.write(rez);
			         int N=rez.length();
			         for (int i=0; i<rez.length(); i++)
			         {
			        	 N=N-1;
			        	 char ch=rez.charAt(i);
			        	 int k= ch;
			        	 t=i%10+1;
			        	 k=k-1*t;
			        	 char g =(char)k;
			        	 shif =shif+g;
			        	 
			         }*/
			         
			         int N=p.length();
			         for (int i=0; i<s.length(); i++)
			         {
			        	 char ch =s.charAt(i);
			        	 char ch1=p.charAt(i%N);
			        	 int k = ch;
			        	 int k1 =ch1;
			        	 int R=k^k1;
			        	 char g =(char)R;
			        	 
			        	 rez = rez+g;
			         }
			         rez=rez+"\n";
			        // out.write(rez);
			         for (int i=0; i<s.length(); i++)
			         {
			        	 char ch =s.charAt(i);
			        	 char ch1=p.charAt(i%N);
			        	 int k = ch;
			        	 int k1 =ch1;
			        	 int R=(k^k1)^k1;
			        	 char g =(char)R;
			        	 
			        	 rez = rez+g;
			         }
			         out.write(rez);
			         
			         //out.write(textArea.getText());
			         //out.write(shif);
			         out.close();
			         obj.close();
			         JOptionPane.showMessageDialog(null, 
			                "������ ���������!!!","���������",1);
			       }
			       catch (IOException exp) {}                	  

			     }
			     else
			     {
			       JOptionPane.showMessageDialog(null,
			            "���� �� ������!","������",0);
			     }                	  
			   }}
		});						
		buttonZap.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonZap.setBounds(10, 243, 177, 35);
		contentPane.add(buttonZap);
	}
}
