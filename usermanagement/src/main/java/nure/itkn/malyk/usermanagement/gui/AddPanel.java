package nure.itkn.malyk.usermanagement.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AddPanel extends JPanel implements ActionListener {
	private MainFrame parent;
	private JPanel buttonPanel;
	private JPanel fieldPanel;
	private JButton okButton;
	private JButton cancelButton;
	
	public AddPanel(MainFrame mainFrame) {
		this.parent = mainFrame;
		initialize();
	}
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.add(getFieldPanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.NORTH);
	}
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getOkButton(), null);
			buttonPanel.add(getCancelButton(), null);
		}
		return buttonPanel;
	}
	
	private JButton getOkButton() {
		if (okButton == null){
			okButton = new JButton();
			okButton.setText("Добавить");
			okButton.setName("okButton");
			okButton.setActionCommand("ok");
			okButton.addActionListener(this);
		}
		return okButton;
	}
	private JButton getCancelButton() {
		if (cancelButton == null){
			cancelButton = new JButton();
			cancelButton.setText("Отменить");
			cancelButton.setName("cancelButton");
			cancelButton.setActionCommand("cancel");
			cancelButton.addActionListener(this);
		}
		return cancelButton;
	}

	private JPanel getFieldPanel() {
		// TODO Auto-generated method stub
		return fieldPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
