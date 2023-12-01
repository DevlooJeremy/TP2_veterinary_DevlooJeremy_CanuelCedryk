
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
import dto.DogDTO;


public class DogCreateView extends JDialog implements IView, ActionListener {
	
	private static final String VIEW_TITLE = "Inscription d'un chien";
	private static final Dimension DEFAULT_SIZE = new Dimension(300, 150);
	private static final String SUBSCRIBE_BTN_TXT = "Inscrire";
	private static final String SUBSCRIBE_BTN = "inscription_chien";
	private static final String NAME_LABEL = "Nom:";
	private static final String BREED_LABEL = "Race:";

	private JTextField name = new JTextField(15);
	private JTextField breed = new JTextField(20);

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
		createDogPanel.setLayout(new GridLayout(2,2));
		this.add(createDogPanel);
		
		addTextField(createDogPanel,NAME_LABEL,this.name);
		addTextField(createDogPanel,BREED_LABEL,this.breed);
		
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
		if(!name.getText().isBlank() && !breed.getText().isBlank()) {
			System.out.println(this.name.getText());
			System.out.println(this.breed.getText());
			DogDTO dto = new DogDTO(this.name.getText(),this.breed.getText(),0);
			this.controller.add(dto);
			JOptionPane.showMessageDialog(this, "Merci d'avoir inscrit un chien!","Merci",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == SUBSCRIBE_BTN) {
			createDog();
			
		}
	}

}
