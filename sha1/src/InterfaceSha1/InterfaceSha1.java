package InterfaceSha1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

import AlgorithmsSha1.AlgorithmSha1;
import Images.ResourceLoader;

public class InterfaceSha1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private	ImageIcon img=  new ImageIcon(ResourceLoader.getImage("sha1_24x24.png"));
	private File input = null;
	private File output = null;

	public InterfaceSha1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("SHA-1 �����������");
		JLabel lblNewLabel = new JLabel("������� ��� �����:");
		setVisible(true);
		setSize(500,250);
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE))
								.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
					.addContainerGap(95, Short.MAX_VALUE))
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
						
					AlgorithmSha1 sh = new AlgorithmSha1 ();	
					String hash = sh.sha1(input.getAbsolutePath(),progressBar);
					try {
						PrintWriter a = new PrintWriter (output);
						a.print(hash);
						a.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					
					}
						
					});
	
	
	
	
	}
}
