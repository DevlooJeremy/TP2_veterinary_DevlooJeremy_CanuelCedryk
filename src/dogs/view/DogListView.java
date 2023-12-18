package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dogRepository.IEntityRepository;
import dogs.controller.IDogListController;
import dogs.model.Dog;

public class DogListView extends JFrame implements IView, ActionListener{

	
	private static final String VIEW_TITLE = "Listes des chiens";
	private static final Dimension DEFAULT_SIZE = new Dimension(400, 200);
	private static final String ID_TITLE = "ID";
	private static final String NAME_TITLE = "NOM";
	private static final String BREED_TITLE = "RACE";
	private static final String CLOSE_BTN_TXT = "OK";
	private static final String CLOSE_BTN = "close_frame";

	
	private IDogListController controller;
	private IEntityRepository<Dog> repository;
	
	public DogListView(IDogListController dogListController, IEntityRepository<Dog> repository)
	{
		super();
		
		this.controller = dogListController;
		this.repository = repository;
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
	}
	
	private void setUpComponents() {
		this.setUpInputDataPanel();
		this.setUpActionPanel();		
	}
	
	private void setUpActionPanel() {
		// container interm�diaire JPanel qui contient le bouton pour inscrire le chien
		JPanel actionPanel = new JPanel();
		this.add(actionPanel,BorderLayout.SOUTH);

		ViewUtil.addButton(this, actionPanel, CLOSE_BTN_TXT, CLOSE_BTN);
	}
	
	private void setUpInputDataPanel() {
		// container interm�diaire JPanel qui contient les �tiquettes (JLabel) et les zones de textes (JTextField)
		// utiliser un GridLayout comme LayoutManager
		JPanel createDogPanel = new JPanel();
		createDogPanel.setLayout(new GridLayout(0,3));
		this.add(createDogPanel, null);
		this.addTitleTextField(createDogPanel);
		Collection<Dog> dogList = this.repository.getList();
		for (Dog dog : dogList) {
			addTextField(createDogPanel,dog.getId(),dog.getName(),dog.getBreed());
		}
		
	}
	
	private void addTitleTextField(JPanel panel) {
		panel.add(new JLabel(ID_TITLE));
		panel.add(new JLabel(NAME_TITLE));
		panel.add(new JLabel(BREED_TITLE));
	}
	
	private void addTextField(JPanel panel, int id, String name, String breed) {
		
		panel.add(new JLabel(Integer.toString(id))); 
		panel.add(new JLabel(name));
		panel.add(new JLabel(breed));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == CLOSE_BTN) {
			this.dispose();
		}
		
	}

}
