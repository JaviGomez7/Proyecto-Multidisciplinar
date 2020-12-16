package model;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Message;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField boxPassword;
	private JTextField boxMail;
	private Message message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\salva\\OneDrive\\Im\u00E1genes\\Saved Pictures\\Hogwarts-logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Universidad Hogwarts");
		setBounds(450, 180, 346, 363);		
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbRegistry = new JLabel("Registrarse");
		lbRegistry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//RegisterView registerView = new RegisterView();
			}
		});
		lbRegistry.setForeground(new Color(255, 255, 255));
		lbRegistry.setBounds(127, 264, 63, 14);
		panel.add(lbRegistry);
		
		/**
		 * Evento de Botón
		 */
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mail = boxMail.getText();
				String password = new String(boxPassword.getPassword());
				if(!CheckMail(mail)) {JOptionPane.showMessageDialog(null, "El correo es incorrecto");}
				if(password.length() > 8 && password.length() < 64 && CheckSpace(password) == true) {
					System.out.println("Datos correctos");
				}
				else {
				JOptionPane.showMessageDialog(null, "El password es incorrecto");
			}
				}
		});
		btnNewButton.setBounds(106, 223, 105, 20);
		panel.add(btnNewButton);
		
		boxPassword = new JPasswordField();
		boxPassword.setBounds(83, 175, 150, 20);
		panel.add(boxPassword);
		
		JLabel lbPassword = new JLabel("CONTRASE\u00D1A");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbPassword.setForeground(new Color(255, 255, 255));
		lbPassword.setBounds(96, 132, 124, 32);
		panel.add(lbPassword);
		
		boxMail = new JTextField();
		boxMail.setBackground(Color.WHITE);
		boxMail.setBounds(83, 101, 150, 20);
		panel.add(boxMail);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(127, 56, 63, 22);
		panel.add(lblEmail);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblLogin.setBounds(80, 0, 156, 45);
		panel.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\salva\\OneDrive\\Im\u00E1genes\\Saved Pictures\\donde-se-filmo-hogwarts.jpg"));
		lblNewLabel.setBounds(-242, -70, 562, 384);
		panel.add(lblNewLabel);
	}	
	
   /**
    * Método que verifica el email
    * @param mail String
    * @return true or false
    */
	public boolean CheckMail(String mail) {
		 // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); 
        // El email a validar     
 
        Matcher mather = pattern.matcher(mail);
 
        if (!mather.find()) {    return false; }      
        
        else { return true; }
	}
	/**
	 * Método que verifica si hay espacios en el password
	 * @param password contraseña introducida por el usuario
	 * @return true or false
	 */
	public boolean CheckSpace(String password) {
		
		byte number = 0;
		 for(char c : password.toCharArray()){
	           if (c == ' ') {number ++;}          
	       }
		if (number>0) {return false;}
		else {return true;}
	}
	//Getters y Setters
		public JTextField getBoxMail() {
			return boxMail;
		}

		public void setBoxMail(JTextField boxMail) {
			this.boxMail = boxMail;
		}

		public JPasswordField getBoxPassword() {
			return boxPassword;
		}

		public void setBoxPassword(JPasswordField boxPassword) {
			this.boxPassword = boxPassword;
		}
}