
package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dogs.controller.IDogController;
import dto.CustomerDTO;
import dto.DogDTO;


public class DogCreateView extends JDialog implements IView, ActionListener {
	
	private static final String VIEW_TITLE = "Inscription d'un chien";
	private static final Dimension DEFAULT_SIZE = new Dimension(300, 150);
	private static final String SUBSCRIBE_BTN_TXT = "Inscrire";
	private static final String SUBSCRIBE_BTN = "inscription_chien";
	private static final String NAME_LABEL = "Nom:";
	private static final String BREED_LABEL = "Race:";
	private static final String OWNER_NAME_LABEL = "Nom de famille du propriétaire:";
	private static final String WEIGHT_LABEL = "Poids:";

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
		this.add(createDogPanel);
		
		addTextField(createDogPanel,NAME_LABEL,this.name);
		addTextField(createDogPanel,BREED_LABEL,this.breed);
		addTextField(createDogPanel,WEIGHT_LABEL,this.weight);
		addTextField(createDogPanel,OWNER_NAME_LABEL,this.ownerLastName);
		
	}
	
	private void addTextField(JPanel panel, String labelText, JTextField textField) {
		
		panel.add(new JLabel(labelText));
		panel.add(textField);
	}

	private void setUpActionPanel() {
		// container interm�diaire JPanel qui contient le bouton pour inscrire le chien
		JPanel actionPanel = new JPanel();
		this.add(actionPanel,BorderLayout.SOUTH);
		
		ViewUtil.addButton(this, actionPanel, SUBSCRIBE_BTN_TXT, SUBSCRIBE_BTN);
	}
	
	private void createDog() {
		String errorMessage = "";
		if(this.name.getText().isBlank()) {
			errorMessage += " Le nom du chien est invalid. ";
		}
		
		try {
			if(this.weight.getText().isBlank() || Integer.parseInt(this.weight.getText()) < 0){
				errorMessage += " Le poids du chien est invalid. ";
			}
		}catch(NumberFormatException e){
			errorMessage += " Le poids du chien doit être un chiffre. ";
		}
		
		if(this.ownerLastName.getText().isBlank() || !this.controller.verifyIfOwnerExist(this.ownerLastName.getText())){
			errorMessage += " Le nom de famille du propriétaire est invalid. ";
		}
		
		if(errorMessage == "") {
			CustomerDTO customerDTO = new CustomerDTO(null,this.ownerLastName.getText(),null,null,0);
			DogDTO dogDTO = new DogDTO(this.name.getText(),this.breed.getText(),0,Float.parseFloat(this.weight.getText()),customerDTO);
			this.controller.add(dogDTO);
			JOptionPane.showMessageDialog(this, "Merci d'avoir inscrit un chien!","Merci",JOptionPane.INFORMATION_MESSAGE);
		}else {
			dispalyErrorMessage(errorMessage);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == SUBSCRIBE_BTN) {
			createDog();
			
		}
	}

	@Override
	public void dispalyErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, "Voici les erreurs qui ont stoppées l'inscription :" + message,"Liste des erreurs",JOptionPane.ERROR_MESSAGE);
	}

}
