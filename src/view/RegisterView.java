package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import model.Model;
import model.ModelView;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameText;
	private JTextField emailText;
	private JTextField nameText;
	private JTextField ageText;
	private JPasswordField passwordText, confirmPasswordText;
	private JComboBox housesCombo;
	private JPanel panel_1;
	private ButtonGroup groupButtons;
	private JRadioButton buttonTeacher, buttonAlumn;
	private ModelView model;
	private JButton buttonSend;
	private ArrayList<JTextField> listTextFields;
	private ArrayList<JPasswordField> listPasswordFields;
	private LoginView viewLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		model = new ModelView();
		setTitle("REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel labelName = new JLabel("Nombre");
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelName);

		nameText = new JTextField();
		panel.add(nameText);
		nameText.setColumns(10);
		JLabel labelLastName = new JLabel("Apellidos");
		labelLastName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelLastName);
		lastNameText = new JTextField();
		panel.add(lastNameText);
		lastNameText.setColumns(10);
		JLabel labelEmail = new JLabel("Correo electrónico");
		labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelEmail);
		emailText = new JTextField();
		panel.add(emailText);
		emailText.setColumns(10);
		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelPassword);
		passwordText = new JPasswordField();
		panel.add(passwordText);
		passwordText.setColumns(10);
		JLabel labelconfirmPass = new JLabel("Confirmar contraseña");
		labelconfirmPass.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelconfirmPass);
		confirmPasswordText = new JPasswordField();
		panel.add(confirmPasswordText);
		confirmPasswordText.setColumns(10);
		JLabel labelAge = new JLabel("Edad");
		labelAge.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelAge);
		ageText = new JTextField();
		panel.add(ageText);
		ageText.setColumns(10);
		JLabel labelHouses = new JLabel("Casa en Hogwarts");
		labelHouses.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelHouses);
		housesCombo = new JComboBox();
		housesCombo.addItem("Gryffindor");
		housesCombo.addItem("Hufflepuff");
		housesCombo.addItem("Ravenclaw");
		housesCombo.addItem("Slytherin");
		panel.add(housesCombo);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		JLabel labelType = new JLabel("Tipo de usuario");
		labelType.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(labelType);
		groupButtons = new ButtonGroup();
		groupButtons.add(buttonTeacher = new JRadioButton(model.getButtonGroupText().get(0), true));
		buttonTeacher.setHorizontalAlignment(SwingConstants.RIGHT);
		groupButtons.add(buttonAlumn = new JRadioButton(model.getButtonGroupText().get(1)));
		buttonAlumn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(buttonTeacher);
		panel_1.add(buttonAlumn);
		panel_1.add(new JLabel(""));
		panel_1.add(new JLabel(""));
		buttonSend = new JButton("Enviar");
		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlBoxes();
				if (nameText.getText().isEmpty() || lastNameText.getText().isEmpty() || emailText.getText().isEmpty()
						|| passwordText.getText().isEmpty() || confirmPasswordText.getText().isEmpty()
						|| ageText.getText().isEmpty()) {
					System.out.println("AUN NO");
				} else {
					int reply = JOptionPane.showConfirmDialog(null,
							"Los datos son correctos, ¿seguro que desea registrarse?", "Registro",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Registrado correctamente");
					} else {

					}
				}
			}
		});
		panel_1.add(buttonSend);

	}

	private void checkAge() {
		int age = Integer.parseInt(ageText.getText());
		if (age < 18 || age > 65) {
			JOptionPane.showMessageDialog(null, "La edad introducida debe ser mayor de 18 y menor de 65 años");
			ageText.setText("");
		} else {
			age = Integer.parseInt(ageText.getText());
		}
	}

	private void checkStringAge() {
		String age = ageText.getText();
		if (age.matches("[0-9]*")) {
			checkAge();
		} else {
			JOptionPane.showMessageDialog(null, "La edad no puede contener caracteres que no sean numéricos");
			ageText.setText("");
		}
	}

	private void checkEmail() {
		String email = emailText.getText();
		if (!checkMail(email)) {
			JOptionPane.showMessageDialog(null, "El correo es incorrecto");
			emailText.setText("");
		}
	}

	private void containNumbers(String text) {
		Pattern p = Pattern.compile("([0-9])");
		Matcher m = p.matcher(text);
		if (m.find()) {
			JOptionPane.showMessageDialog(null, "Los campos Nombre y Apellidos no pueden contener números");
			nameText.setText("");
			lastNameText.setText("");
		} else {
		}
	}

	public boolean checkMail(String mail) {
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// El email a validar

		Matcher mather = pattern.matcher(mail);

		if (!mather.find()) {
			return false;
		}

		else {
			return true;
		}
	}

	private void controlBoxes() {
		if (nameText.getText().isEmpty() || lastNameText.getText().isEmpty() || emailText.getText().isEmpty()
				|| passwordText.getText().isEmpty() || confirmPasswordText.getText().isEmpty()
				|| ageText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos para completar el registro");
		} else {
			// TODOS LOS CAMPOS ESTÁN RELLENADOS, SE PASA A VALIDAR LOS DATOS.
			containNumbers(nameText.getText());
			containNumbers(lastNameText.getText());
			checkEmail();
			checkSamePasswords();
			checkStringAge();
		}
	}

	private void checkSamePasswords() {
		viewLogin = new LoginView();
		String password = new String(passwordText.getPassword());
		String confirmPassword = new String(confirmPasswordText.getPassword());
		if (password.length() > 8 && password.length() < 64 && viewLogin.checkSpace(password) == true
				&& confirmPassword.length() > 8 && confirmPassword.length() < 64
				&& viewLogin.checkSpace(confirmPassword) == true) {
			if (password.equals(confirmPassword)) {
				// CONTRASEÑA CORRECTA
				password = passwordText.getPassword().toString();
				confirmPassword = confirmPasswordText.getPassword().toString();
			} else {
				JOptionPane.showMessageDialog(null, "Las contraseñas introducidas no coinciden");
				passwordText.setText("");
				confirmPasswordText.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Contraseña no válida");
			passwordText.setText("");
			confirmPasswordText.setText("");
		}
	}
}
