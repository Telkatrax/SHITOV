package AlgorithmRsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import Images.ResourceLoader;

public class RSA extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private	ImageIcon img=  new ImageIcon(ResourceLoader.getImage("rsa_24x_24.png"));
	private File input = null;
	private File output = null;
	private JTextField textField_2;
	private JTextField textField_3;

	public RSA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("RSA �����������");
		JLabel lblNewLabel = new JLabel("������� ��� �����:");
		setVisible(true);
		setSize(500,350);
		setLocationRelativeTo(null);//���� � ������ ������
		setIconImage(img.getImage());
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("�����...");
		
		JLabel lblNewLabel_1 = new JLabel("��������� ��������� � ����:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("�����...");
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		
		JLabel lblNewLabel_2 = new JLabel("�������������� ����:");
		
		JButton btnNewButton_2 = new JButton("����");
		
		JLabel lblNewLabel_3 = new JLabel("Public key(default 65537)");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText("65537");
		
		JLabel lblNewLabel_4 = new JLabel("bit length prime random p and q (> 2)");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText("300");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE))
								.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
		
		// �������� ������� ������ "open"
		btnNewButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){				
					
					JFileChooser fileopen = new JFileChooser();  //������� ����� ������ �������� �������         
					int ret = fileopen.showDialog(null, "������� ����");//���������� ������ ������ ����� ������������
					if (ret == JFileChooser.APPROVE_OPTION) {// ���� ������ ������� "�������� ����"
					    File file = fileopen.getSelectedFile(); //���������� ��������� ����
					    //Scanner sc = new Scanner (new File (file.getAbsolutePath()));
						try{
						textField.setText(file.getAbsolutePath());
					    input=new File (file.getAbsolutePath());
						}catch(Exception e)
						{  new InterfaceError(e.getMessage());}
					   	}}
				});
				
				// �������� ������� ������ "save as"
				btnNewButton_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){				
					
					JFileChooser filesave = new JFileChooser();  //������� ����� ������ �������� �������         
					int ret = filesave.showSaveDialog(filesave);//���������� ������ ������ ����� ������������
					if(ret == JFileChooser.APPROVE_OPTION)
					{
					
					File file = filesave.getSelectedFile(); //���������� ��������� ����
					textField_1.setText(file.getAbsolutePath());
					try {
						//PrintWriter pw = new PrintWriter (file);
					output = filesave.getSelectedFile();
					//pw.close();
					} catch (Exception e) {
						new InterfaceError(e.getMessage());
					}
					
					
					
					//���������� ������ � ����� �����
					}
					}
				});
				
				
				btnNewButton_2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){				
						
						 int N = Integer.parseInt(textField_3.getText());
					      AlgorithmRsa key = new AlgorithmRsa(N,textField_2.getText());
					   
			
					    String ms = new String();
					    progressBar.setMinimum(0);
					    progressBar.setMaximum((int) input.length());
					    
					    try {
					    	
							Scanner sc = new Scanner (input);
							ms=sc.next();
							progressBar.setValue(ms.length());
							
							
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						 BigInteger message = new BigInteger(ms);

					      BigInteger encrypt = key.encrypt(message);
					      BigInteger decrypt = key.decrypt(encrypt);
					//      System.out.println("message   = " + message);
					 //     System.out.println("encrpyted = " + encrypt);
					   //   System.out.println("decrypted = " + decrypt);
					try {
						PrintWriter a = new PrintWriter (output);
						a.println(encrypt);
						a.println(decrypt);
						a.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					
					}
						
					});
	
	
	
	
	}
}
