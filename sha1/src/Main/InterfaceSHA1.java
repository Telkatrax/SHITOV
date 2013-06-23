package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import Images.ResourceLoader;

public class InterfaceSHA1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private	ImageIcon img=  new ImageIcon(ResourceLoader.getImage("sha1_24x24.png"));
	private File input = null;
	private File output = null;

	public InterfaceSHA1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("SHA1 Калькулятор");
		JLabel lblNewLabel = new JLabel("Укажите имя файла:");
		setVisible(true);
		setSize(500,250);
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
				
				
				btnNewButton_2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){				
						
						SHA1Digest rp = new SHA1Digest();
						
					    FileInputStream fis= null;
					    
						try {
							fis = new FileInputStream(input);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					    byte[] data = new byte[1024];
					    int read = 0; 
					    
					    
					    progressBar.setMinimum(0);
					    progressBar.setMaximum((int) input.length());
					  //  progressBar.setValue(30);
					    try {
							while ((read = fis.read(data)) != -1) {
							    rp.update(data, 0, read);
							    progressBar.setValue(data.length);
							    
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						};
					    byte[] hashBytes = new byte [rp.getDigestSize()];
					    rp.doFinal(hashBytes, 0);

					    StringBuffer sb = new StringBuffer();
					    for (int i = 0; i < hashBytes.length; i++) {
					      sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
					    }
					     
					    String fileHash = sb.toString();
					     
					  //  System.out.println( fileHash);	
					
					try {
						PrintWriter a = new PrintWriter (output);
						a.print(fileHash);
						a.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					
					}
						
					});
	
	
	
	
	}
}
