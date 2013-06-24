package AlgorithmRsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
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
	private JTextField textField_4;
	private JTextField textField_5;
	int N=300;
	BigInteger p ;
	BigInteger q;
	   private final static SecureRandom random = new SecureRandom();

	public RSA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("RSA Калькулятор");
		JLabel lblNewLabel = new JLabel("Укажите имя файла:");
		setVisible(true);
		setSize(500,400);
		setLocationRelativeTo(null);//окно в центре экрана
		setIconImage(img.getImage());
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Обзор...");
		
		JLabel lblNewLabel_1 = new JLabel("Сохранить результат в файл:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Обзор...");
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		
		JLabel lblNewLabel_2 = new JLabel("Обрабатываемый файл:");
		
		JButton btnNewButton_2 = new JButton("Пуск");
		
		JLabel lblNewLabel_3 = new JLabel("Public key(default 65537)");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText("65537");
		
		JLabel lblNewLabel_4 = new JLabel("bit length prime random p and q (> 2)");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText("300");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("P:");
		
		JLabel lblNewLabel_6 = new JLabel("Q:");
		
		JButton btnNewButton_3 = new JButton("Generate");
		
		JButton btnNewButton_4 = new JButton("Generate");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
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
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_3)
									.addGap(18)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_4)
									.addGap(18)
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))))
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4)
						.addComponent(lblNewLabel_6))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
		
		// Обработа нажатия кнопки "open"
		btnNewButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){				
					
					JFileChooser fileopen = new JFileChooser();  //создаем новый объект каталога системы         
					int ret = fileopen.showDialog(null, "Открыть файл");//отображаем диалог выбора файла пользователю
					if (ret == JFileChooser.APPROVE_OPTION) {// если нажата клавиша "открыйть файл"
					    File file = fileopen.getSelectedFile(); //запоминаем выбранный файл
					    //Scanner sc = new Scanner (new File (file.getAbsolutePath()));
						try{
						textField.setText(file.getAbsolutePath());
					    input=new File (file.getAbsolutePath());
						}catch(Exception e)
						{  new InterfaceError(e.getMessage());}
					   	}}
				});
				
				// Обработа нажатия кнопки "save as"
				btnNewButton_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){				
					
					JFileChooser filesave = new JFileChooser();  //создаем новый объект каталога системы         
					int ret = filesave.showSaveDialog(filesave);//отображаем диалог выбора файла пользователю
					if(ret == JFileChooser.APPROVE_OPTION)
					{
					
					File file = filesave.getSelectedFile(); //определяем выбранный файл
					textField_1.setText(file.getAbsolutePath());
					try {
						//PrintWriter pw = new PrintWriter (file);
					output = filesave.getSelectedFile();
					//pw.close();
					} catch (Exception e) {
						new InterfaceError(e.getMessage());
					}
					
					
					
					//записываем данные в конец файла
					}
					}
				});
				
			//	BigInteger.probablePrime(N/2, random)
				
				btnNewButton_3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){				
						N = Integer.parseInt(textField_3.getText());
						p=BigInteger.probablePrime(N/2, random);
						textField_4.setText(p.toString());
					}
						
					});
				btnNewButton_4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){				
						N = Integer.parseInt(textField_3.getText());
						q=BigInteger.probablePrime(N/2, random);
						textField_5.setText(q.toString());
					}
						
					});
	
	
				
				btnNewButton_2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){				
						
						 N = Integer.parseInt(textField_3.getText());
						 p = new BigInteger(textField_4.getText());
						 q = new BigInteger(textField_5.getText());
						 //p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)).mod(new BigInteger(Integer.toString(N)).compareTo(BigInteger.ONE)
						 if(p==null||q==null   ) new InterfaceError("Некорректные начальные параметры");
						 else{
					      AlgorithmRsa key = new AlgorithmRsa(N,textField_2.getText(),p,q);
					   
			
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
						
						 BigInteger message = new BigInteger(ms.getBytes());

					      BigInteger encrypt = key.encrypt(message);
					      BigInteger decrypt = key.decrypt(encrypt);
					//      System.out.println("message   = " + message);
					 //     System.out.println("encrpyted = " + encrypt);
					   //   System.out.println("decrypted = " + decrypt);
					try {
						FileOutputStream out = new FileOutputStream (output);
					//	PrintWriter a = new PrintWriter (output);
						//a.println(encrypt);
					//	a.println(decrypt);
						//a.close();
						try {
							String str1= new String("encrypt:");
							out.write(str1.getBytes());
							byte tt [];
							tt=encrypt.toByteArray();
							for(int i=0;i<tt.length;i++)
							out.write(tt[i]);
							byte ss [];
							String str= new String(System.getProperty("line.separator")+"decrypt:");
							out.write(str.getBytes());
							ss=decrypt.toByteArray();
							for(int i=0;i<ss.length;i++)
							out.write(ss[i]);
							out.close();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
						 }
					
					}
						
					});
	
	
	
	
	}
}
