package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dataSeeder.DogSeeder;
import dogs.controller.DogController;
import dogs.controller.IDogController;
import dogs.controller.IWelcomeController;

@SuppressWarnings("serial")
public class WelcomeView extends JFrame implements IView, ActionListener {   // Configurer Eclipse pour ignorer les avertissements sur serial Id
	
	private static final String VIEW_TITLE = "Gestion des chiens";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	private static final String ADD_DOG = "add_dog";
	private static final String LIST_DOG = "list_dog";
	private static final String LIST_CUSTOMER = "list_customer";
	private static final String ADD_DOG_BTN_TXT = "Inscrire un chien";
	private static final String LIST_DOG_BTN_TXT = "Lister les chiens";
	private static final String LIST_CUSTOMER_BTN_TXT = "Liste des clients";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";

	private static final Dimension DEFAULT_SIZE = new Dimension(775, 350);
	
	private IWelcomeController controller;		// Pas encore utilis� dans cette version...
	
	public WelcomeView(IWelcomeController controller) {
		super(VIEW_TITLE);
		
		this.controller = controller;
		
		this.initialize();
		this.setUpComponents();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		// setSize(): uniquement car JFrame avec une image - Ne pas utiliser avec les gestionnaires de mise en forme-Utiliser la m�thode pack() � la place
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// par d�faut: HIDE_ON_CLOSE
	}
	
	private void setUpComponents() {
		//this.setLayout(new BorderLayout());  					// Inutile car par d�faut...
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER);  // CENTER -> par d�faut

		welcomePanel.setLayout(new BorderLayout());   // Strategy pattern: le gestionnaire de mise en forme		
		addWelcomePicture(welcomePanel);		
		addWelcomeMessage(welcomePanel);		
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = new ImageIcon(this.getClass().getResource(WELCOME_PICTURE));
		JLabel welcomePicture = new JLabel(image);		
		welcomePanel.add(welcomePicture, BorderLayout.CENTER);   // CENTER -> par d�faut
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel, BorderLayout.SOUTH);
		
		ViewUtil.addButton(this, actionPanel, ADD_DOG_BTN_TXT, ADD_DOG);
		ViewUtil.addButton(this, actionPanel, LIST_DOG_BTN_TXT, LIST_DOG);
		ViewUtil.addButton(this, actionPanel, LIST_CUSTOMER_BTN_TXT, LIST_CUSTOMER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == ADD_DOG) {
			this.controller.wantToCreateDog();
		}
		
		if (e.getActionCommand() == LIST_DOG) {
			this.controller.wantToListDog();
		}
		
		if (e.getActionCommand() == LIST_CUSTOMER) {
			this.controller.wantToListCustomer();
		}
		
	}

	@Override
	public void dispalyErrorMessage(String message) {
		// TODO Auto-generated method stub
		
	}


}
