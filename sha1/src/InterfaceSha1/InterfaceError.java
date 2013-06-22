package InterfaceSha1;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfaceError  {

	private String textError = null;
	public InterfaceError(String textError) {
		
		this.textError=textError;
		JOptionPane errorPane = new JOptionPane(this.textError, JOptionPane.QUESTION_MESSAGE);
		JDialog dialog = errorPane.createDialog(new JFrame(), "Manual Creation");
	    dialog.setLocationRelativeTo(null);//окно в центре экрана
		dialog.setTitle("ОШИБКА");
		dialog.setVisible(true);
		
	}

}
