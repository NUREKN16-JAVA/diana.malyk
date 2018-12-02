package nure.itkn.malyk.usermanagement.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import nure.itkn.malyk.usermanagement.User;
import nure.itkn.malyk.usermanagement.db.DaoFactory;
import nure.itkn.malyk.usermanagement.db.DatabaseException;
import nure.itkn.malyk.usermanagement.db.UserDao;
import nure.itkn.malyk.usermanagement.util.Messages;

public class MainFrame extends JFrame {

	private static final int FRAME_HEIGHT = 600;
	private static final int FRAME_WIDTH = 800;
	private JPanel contentPanel;
	private BrowsePanel browsePanel;
	private AddPanel addPanel;
	private UserDao dao;
	private EditPanel editPanel;

	public MainFrame() {
		super();
		dao = DaoFactory.getInstance().getUserDao();
		initialize();
	}

	/**
	 * @return the dao
	 */
	public UserDao getDao() {
		return dao;
	}

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle(Messages.getString("MainFrame.user_management")); //$NON-NLS-1$
		this.setContentPane(getContentPanel());
	}

	private JPanel getContentPanel() {
		if (contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
		}
		return contentPanel;
	}

	private BrowsePanel getBrowsePanel() {
		if (browsePanel == null) {
			browsePanel = new BrowsePanel(this);
		}
		((BrowsePanel) browsePanel).initTable();
		return browsePanel;
	}

	private void showPanel(JPanel panel) {
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
	}

	private AddPanel getAddPanel() {
		if (addPanel == null) {
			addPanel = new AddPanel(this);
		}
		return addPanel;
	}

	private EditPanel getEditPanel(Long user_id) {
		if (editPanel == null) {
			editPanel = new EditPanel(this);
		}
		User user = null;
		if (user_id >= 0) {
			try {
				user = getDao().find(user_id);
			} catch (DatabaseException e) {
				new RuntimeException(e);
			}
		}
		editPanel.fillFields(user);
		return editPanel;
	}

	public void showBrowsePanel() {
		showPanel(getBrowsePanel());
	}

	public void showAddPanel() {
		showPanel(getAddPanel());
	}

	public void showEditPanel(Long user_id) {
		showPanel(getEditPanel(user_id));
	}



	public void showDetailsPanel() {
		showPanel(getDetailsPanel());
	}

	private JPanel getDetailsPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}
