package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;
import model.ModelView;

public class LoginView extends JFrame {
	private JTextField textLogin;
	private JPasswordField passwordLogin;
	private ArrayList<JLabel> labelsLogin;
	private JPanel containerPanel;
	private JButton buttonLogin;
	private JLabel labelSignUp;
	private ModelView model;

	public LoginView(ModelView model) {
		setTitle("Universidad Howards");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.model = model;
		createWindow();
	}

	/**
	 * Método que asigna características JFrame a la interfaz.
	 */
	private void createWindow() {
		setLocation(800, 400);
		addPanel();
		addTextsLabels();
		addButtonLogin();
		addLabelSignUp();
		makeVisible();
		setSize(300, 300);
	}

	/**
	 * Método que inicializa el panel y le asigna sus propiedades
	 */
	private void addPanel() {
		containerPanel = new JPanel();
		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		add(containerPanel);
	}

	/**
	 * Método que inicializa las cajas de texto y las etiquetas y les asigna sus
	 * propiedades.
	 */
	private void addTextsLabels() {
		labelsLogin = new ArrayList<JLabel>();
		for (int i = 0; i < model.getLabelsTexts().size(); i++) {
			labelsLogin.add(new JLabel());
			labelsLogin.get(i).setText(model.getLabelsTexts().get(i));
			labelsLogin.get(i).setAlignmentX(CENTER_ALIGNMENT);
		}	
			textLogin = new JTextField();
			textLogin.setAlignmentX(CENTER_ALIGNMENT);
		containerPanel.add(labelsLogin.get(0));
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(textLogin);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		containerPanel.add(labelsLogin.get(1));
		containerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		passwordLogin = new JPasswordField();
		containerPanel.add(passwordLogin);
	}

	/**
	 * Método que inicializa el botón de iniciar sesión y le asigna propiedades.
	 */
	private void addButtonLogin() {
		buttonLogin = new JButton(model.getBtnLoginText());
		buttonLogin.setAlignmentX(CENTER_ALIGNMENT);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		RegisterView registerView = new RegisterView(model,this);
		buttonLogin.addActionListener(new Controller(registerView, this));
		containerPanel.add(buttonLogin);
	}

	/**
	 * Método que inicializa la etiqueta de registrarse y le asigna propiedades
	 */
	private void addLabelSignUp() {
		labelSignUp = new JLabel(model.getSignUpText());
		containerPanel.add(Box.createRigidArea(new Dimension(0, 35)));
		labelSignUp.setAlignmentX(CENTER_ALIGNMENT);
		labelSignUp.setForeground(Color.BLUE.darker());
		containerPanel.add(labelSignUp);
	}

	/**
	 * Hace la ventana visible y la posiciona en el centro de la pantalla
	 */
	public void makeVisible() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setResizable(false);
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setVisible(true);
	}

	public ArrayList<JLabel> getLabelsLogin() {
		return labelsLogin;
	}

	public void setLabelsLogin(ArrayList<JLabel> labelsLogin) {
		this.labelsLogin = labelsLogin;
	}

	public JPanel getContainerPanel() {
		return containerPanel;
	}

	public void setContainerPanel(JPanel containerPanel) {
		this.containerPanel = containerPanel;
	}

	public JButton getButtonLogin() {
		return buttonLogin;
	}

	public void setButtonLogin(JButton buttonLogin) {
		this.buttonLogin = buttonLogin;
	}

	public JLabel getLabelSignUp() {
		return labelSignUp;
	}

	public void setLabelSignUp(JLabel labelSignUp) {
		this.labelSignUp = labelSignUp;
	}

	public JTextField getTextLogin() {
		return textLogin;
	}

	public void setTextLogin(JTextField textLogin) {
		this.textLogin = textLogin;
	}

	public JPasswordField getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(JPasswordField passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

}