package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import model.ModelView;

public class RegisterView extends JFrame {
	private ArrayList<JTextField> registerTexts;
	private ArrayList<JLabel> registerLabels;
	private JPanel registerPanel;
	private GridLayout gridLayout;
	private ModelView model;
	private ArrayList<JRadioButton> registerButtons;
	private JButton btnRegisterSend;
	private JPasswordField registerPassword;
	private LoginView loginView;

	public RegisterView(ModelView model,LoginView loginView) {
		this.model = model;
		this.loginView = loginView;
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(700, 300);
		setSize(600, 500);
		addRegisterPanel();
		addRegisterComponents();
	}

	/**
	 * Método que crea el panel para el registro del usuario y le asigna un
	 * GridLayout.
	 */
	private void addRegisterPanel() {
		registerPanel = new JPanel();
		registerPanel.setLayout(gridLayout = new GridLayout(0, 2));
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		add(registerPanel);
	}

	/**
	 * Método que añade las etiquetas y cajas de texto correspondientes al panel.
	 */
	private void addRegisterComponents() {
		registerTexts = new ArrayList<JTextField>();
		registerLabels = new ArrayList<JLabel>();
		registerButtons = new ArrayList<JRadioButton>();
		for (int i = 0; i < 3; i++) {
			registerTexts.add(new JTextField(10));
			registerLabels.add(new JLabel(model.getLabelsRegisterTexts().get(i)));
			registerPanel.add(registerLabels.get(i));
			registerPanel.add(registerTexts.get(i));
		}
		registerLabels.add(new JLabel(model.getLabelsRegisterTexts().get(3)));
		registerPanel.add(registerLabels.get(3));
		registerPanel.add(registerPassword = new JPasswordField());
		registerLabels.add(new JLabel(model.getLabelsRegisterTexts().get(4)));
		registerPanel.add(registerLabels.get(4));
		registerTexts.add(new JTextField(10));
		registerPanel.add(registerTexts.get(3));
		registerLabels.add(new JLabel(model.getLabelsRegisterTexts().get(5)));
		registerPanel.add(registerLabels.get(5));
		registerTexts.add(new JTextField(10));
		registerPanel.add(registerTexts.get(4));
		for (int i = 0; i < 2; i++) {
			registerButtons.add(new JRadioButton());
		}
		registerLabels.add(new JLabel(model.getLabelsRegisterTexts().get(6)));
		registerPanel.add(registerLabels.get(6));
		registerPanel.add(registerButtons.get(0));
		registerLabels.add(new JLabel(model.getLabelsRegisterTexts().get(7)));
		registerPanel.add(registerLabels.get(7));
		registerPanel.add(registerButtons.get(1));
		btnRegisterSend = new JButton(model.getLabelsRegisterTexts().get(8));
		btnRegisterSend.addActionListener(new Controller(this,loginView));
		registerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		registerPanel.add(btnRegisterSend);
	}

	public JPasswordField getRegisterPassword() {
		return registerPassword;
	}

	public void setRegisterPassword(JPasswordField registerPassword) {
		this.registerPassword = registerPassword;
	}

	public JButton getBtnRegisterSend() {
		return btnRegisterSend;
	}

	public void setBtnRegisterSend(JButton btnRegisterSend) {
		this.btnRegisterSend = btnRegisterSend;
	}

	public ArrayList<JTextField> getRegisterTexts() {
		return registerTexts;
	}

	public void setRegisterTexts(ArrayList<JTextField> registerTexts) {
		this.registerTexts = registerTexts;
	}

	public ArrayList<JLabel> getRegisterLabels() {
		return registerLabels;
	}

	public void setRegisterLabels(ArrayList<JLabel> registerLabels) {
		this.registerLabels = registerLabels;
	}

	public JPanel getRegisterPanel() {
		return registerPanel;
	}

	public void setRegisterPanel(JPanel registerPanel) {
		this.registerPanel = registerPanel;
	}

	public GridLayout getGridLayout() {
		return gridLayout;
	}

	public void setGridLayout(GridLayout gridLayout) {
		this.gridLayout = gridLayout;
	}

	public ArrayList<JRadioButton> getRegisterButtons() {
		return registerButtons;
	}

	public void setRegisterButtons(ArrayList<JRadioButton> registerButtons) {
		this.registerButtons = registerButtons;
	}

}