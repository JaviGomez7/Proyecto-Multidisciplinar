package view;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;

import model.ModelView;

public class HyperLink implements MouseListener {
	private LoginView loginView;
	private RegisterView registerView;
	private ModelView model;

	public HyperLink(LoginView loginView, RegisterView registerView,ModelView model) {
		this.loginView = loginView;
		this.registerView = registerView;
		this.model = model;
		loginView.getLabelSignUp().addMouseListener(this);
	}

	/**
	 * Método que asigna un hipervínculo a un JLabel.
	 */
	public void setLink(JLabel label) {
		try {
			Desktop.getDesktop().browse(new URI("http://www.google.es"));
		} catch (IOException | URISyntaxException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//setLink(loginView.getLabelSignUp());
		registerView = new RegisterView(model,loginView);
		loginView.dispose();
		registerView.setVisible(true);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}