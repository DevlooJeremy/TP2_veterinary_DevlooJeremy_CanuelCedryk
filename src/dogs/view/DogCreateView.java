
package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.IconView;

import dogs.controller.IDogController;
import dto.CustomerDTO;
import dto.DogDTO;


public class DogCreateView extends JDialog implements IView, ActionListener {
	
	private static final String VIEW_TITLE = "Inscription d'un chien";
	private static final Dimension DEFAULT_SIZE = new Dimension(300, 150);
	private static final String CREATE_DOG = "create_dog";

	private JTextField name = new JTextField(15);
	private JTextField breed = new JTextField(20);
	private JTextField weight = new JTextField(10);
	private JTextField ownerLastName = new JTextField(20);

	private IDogController controller;


	public DogCreateView(IDogController controller) {
		super();
		
		this.controller = controller;
		
		this.initialize();
		this.setUpComponents();
		this.pack();
	}

	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		this.setTitle(VIEW_TITLE);	
		this.setSize(DEFAULT_SIZE);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}

	private void setUpComponents() {
		this.setUpInputDataPanel();
		this.setUpActionPanel();		
	}

	private void setUpInputDataPanel() {
		// container interm�diaire JPanel qui contient les �tiquettes (JLabel) et les zones de textes (JTextField)
		// utiliser un GridLayout comme LayoutManager
		JPanel createDogPanel = new JPanel();
		createDogPanel.setLayout(new GridLayout(0,2));
		this.add(createDogPanel, null);
		
		addTextField(createDogPanel,"Nom:",this.name);
		addTextField(createDogPanel,"Race:",this.breed);
		addTextField(createDogPanel,"Poids:",this.weight);
		addTextField(createDogPanel,"Nom du propriétaire:",this.ownerLastName);
		
	}
	
	private void addTextField(JPanel panel, String labelText, JTextField textField) {
		
		panel.add(new JLabel(labelText));
		panel.add(textField);
	}

	private void setUpActionPanel() {
		// container interm�diaire JPanel qui contient le bouton pour inscrire le chien
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new BorderLayout());
		this.add(actionPanel,BorderLayout.SOUTH);
		
		addButton(actionPanel,"Inscrire",CREATE_DOG);
	}

	// m�me m�thode que dans WelcomeView
	// DRY -> m�thode utilitaire � extraire dans une classe utilitaire util.view.ViewUtil 
	private void addButton(JPanel actionPanel, String buttonText, String buttonAction) {   
		JButton button = new JButton(buttonText);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		actionPanel.add(button);
	}
	
	private void createDog() {
		System.out.println(this.name.getText());
		System.out.println(this.breed.getText());
		CustomerDTO customerDTO = new CustomerDTO(null,this.ownerLastName.getText(),null,null,0);
		DogDTO dogDTO = new DogDTO(this.name.getText(),this.breed.getText(),0,Float.valueOf(this.weight.getText()),customerDTO);
		this.controller.add(dogDTO);
		JOptionPane.showMessageDialog(this, "Merci d'avoir inscrit un chien!","Merci",JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == CREATE_DOG) {
			createDog();
			
		}
	}

}
