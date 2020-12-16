package viewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import view.LoginView;
import view.RegisterView;

public class Controller implements ActionListener {
	private RegisterView registerView;
	private LoginView loginView;

	public Controller(RegisterView registerView, LoginView loginView) {
		this.registerView = registerView;
		this.loginView = loginView;
		

	}

	public Controller() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerView.getBtnRegisterSend()) {
			controlEmail(registerView.getRegisterTexts().get(2).getText());
			System.out.println(String.valueOf(registerView.getRegisterPassword().getPassword()));
		}
		if (e.getSource() == loginView.getButtonLogin()) {
			controlEmail(loginView.getTextLogin().getText());
		}
	}

	/**
	 * Método que recoge el email introducido y comprueba si la estructura es
	 * válida.
	 * 
	 * @param text , Variable string para usar en caso de querer comprobar varios
	 *             emails.
	 */
	public void controlEmail(String text) {
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// El email a validar
		String email = text;
		Matcher mather = pattern.matcher(email);
		if (mather.find() == true) {
			JOptionPane.showMessageDialog(null, "El email es válido");
		} else {
			JOptionPane.showMessageDialog(null, "El email es no es válido");
		}
	}
}
