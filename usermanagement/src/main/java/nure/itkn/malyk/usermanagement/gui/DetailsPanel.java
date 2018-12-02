package nure.itkn.malyk.usermanagement.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nure.itkn.malyk.usermanagement.User;
import nure.itkn.malyk.usermanagement.db.DatabaseException;
import nure.itkn.malyk.usermanagement.util.Messages;

public class DetailsPanel extends JPanel implements ActionListener {

	private MainFrame parent;
	private JPanel fieldPanel;
	private JPanel buttonPanel;
	private JTextField firstNameField;
	private JTextField dateOfBirthField;
	private JTextField lastNameField;
	private JButton okButton;
	private JButton cancelButton;
	private Color bgColor = Color.WHITE;
	User user;
	private JTextField idField;

	public DetailsPanel(MainFrame mainFrame) {
		parent = mainFrame;
		user = new User();
		initialize();
	}

	private void initialize() {
		this.setName("DetailsPanel"); //$NON-NLS-1$
		this.setLayout(new BorderLayout());
		this.add(getFieldPanel(), BorderLayout.NORTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
	}

	public void fillFields(User user) {
		this.user = user;
		this.getIDField().setText(user.getId().toString());
		this.getFirstNameField().setText(user.getFirstName());
		this.getLastNameField().setText(user.getLastName());
		this.getDateOfBirthField().setText(new java.text.SimpleDateFormat("dd.MM.yyyy")
				.format(user.getDateOfBirth()));
	}
	
 	private JPanel getFieldPanel() {
		if(fieldPanel == null) {
			fieldPanel = new JPanel();
			fieldPanel.setLayout(new GridLayout(4, 2));
			addLabeledField(fieldPanel, "ID", getIDField()); 
			addLabeledField(fieldPanel, "Имя", getFirstNameField()); 
			addLabeledField(fieldPanel, "Фамилия", getLastNameField()); 
			addLabeledField(fieldPanel, "Дата рождения", getDateOfBirthField()); 
		}
		return fieldPanel;
	}
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getOkButton(), null);
		}
		return buttonPanel;
	}
	
	private void addLabeledField(JPanel panel, String labelText, JTextField textField) {
		JLabel label = new JLabel(labelText);
		label.setLabelFor(textField);
		panel.add(label);
		panel.add(textField);
	}

	private JTextField getIDField() {
		if(idField == null) {
			idField = new JTextField();
			idField.setName("idField"); //$NON-NLS-1$
			idField.setEditable(false);
		}
		return idField;
	}
	private JTextField getFirstNameField() {
		if(firstNameField == null) {
			firstNameField = new JTextField();
			firstNameField.setName("firstNameField"); //$NON-NLS-1$
			firstNameField.setEditable(false);
		}
		return firstNameField;
	}
	private JTextField getDateOfBirthField() {
		if(dateOfBirthField == null) {
			dateOfBirthField = new JTextField();
			dateOfBirthField.setName("dateOfBirthField"); //$NON-NLS-1$
			dateOfBirthField.setEditable(false);
		}
		return dateOfBirthField;
	}
	private JTextField getLastNameField() {
		if(lastNameField == null) {
			lastNameField = new JTextField();
			lastNameField.setName("lastNameField"); //$NON-NLS-1$
			lastNameField.setEditable(false);
		}
		return lastNameField;
	}
	
	
	private JButton getOkButton() {
		if (okButton == null){
			okButton = new JButton();
			okButton.setText("Ok"); 
			okButton.setName("okButton"); //$NON-NLS-1$
			okButton.setActionCommand("ok"); //$NON-NLS-1$
			okButton.addActionListener(this);
		}
		return okButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		clearFields();
		this.setVisible(false);
		parent.showBrowsePanel();
	}
	private void clearFields() {
		getFirstNameField().setText("");
		getFirstNameField().setBackground(bgColor);
		
		getLastNameField().setText("");
		getLastNameField().setBackground(bgColor);
		
		getDateOfBirthField().setText("");
		getDateOfBirthField().setBackground(bgColor);
	}
}
