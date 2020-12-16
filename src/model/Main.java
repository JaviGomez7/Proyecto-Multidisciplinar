package model;

import controller.Controller;
import model.ModelView;
import view.HyperLink;
import view.LoginView;
import view.RegisterView;

public class Main {
	private static ModelView model;
	private static LoginView loginView;
	private static RegisterView registerView;
	private static Controller controller;

	public static void main(String[] args) {
		model = new ModelView();
		loginView = new LoginView(model);
		registerView = new RegisterView(model, loginView);
		HyperLink link = new HyperLink(loginView, registerView, model);
		controller = new Controller(registerView, loginView);
	}

}
