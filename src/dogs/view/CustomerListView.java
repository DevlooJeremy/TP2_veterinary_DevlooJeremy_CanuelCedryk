package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dogRepository.ICustomerRepository;
import dogRepository.IDogRepository;
import dogs.controller.ICustomerController;
import dogs.controller.IDogListController;
import dogs.model.Customer;
import dogs.model.Dog;

public class CustomerListView extends JFrame implements IView,ActionListener{

	private static final String VIEW_TITLE = "Listes des clients";
	private static final Dimension DEFAULT_SIZE = new Dimension(400, 200);
	private static final Dimension BUTTON_SIZE = new Dimension(10,50);
	private static final String LIST_CUSTOMER = "list_customer";

	
	private ICustomerController controller;
	private ICustomerRepository repository;
	
	public CustomerListView(ICustomerController customerController, ICustomerRepository repository)
	{
		super();
		
		this.controller = customerController;
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
		actionPanel.setLayout(new BorderLayout());
		this.add(actionPanel,BorderLayout.SOUTH);
		
		addButton(actionPanel,"OK",LIST_CUSTOMER);
	}
	
	private void setUpInputDataPanel() {
		// container interm�diaire JPanel qui contient les �tiquettes (JLabel) et les zones de textes (JTextField)
		// utiliser un GridLayout comme LayoutManager
		JPanel listCustomerPanel = new JPanel();
		listCustomerPanel.setLayout(new GridLayout(0,4));
		this.add(listCustomerPanel, null);
		this.addTitleTextField(listCustomerPanel);
		Collection<Customer> customerList = this.repository.getList();
		for (Customer customer : customerList) {
			addTextField(listCustomerPanel,customer.getId(),customer.getName(),customer.getLastName(),customer.getPhone());
		}
		
	}
	
	private void addTitleTextField(JPanel panel) {
		panel.add(new JLabel("id"));
		panel.add(new JLabel("Name"));
		panel.add(new JLabel("Last name"));
		panel.add(new JLabel("Phone number"));
	}
	
	private void addTextField(JPanel panel, int id, String name, String lastName,String phoneNumber) {
		
		panel.add(new JLabel(Integer.toString(id))); 
		panel.add(new JLabel(name));
		panel.add(new JLabel(lastName));
		panel.add(new JLabel(phoneNumber));

	}
	
	private void addButton(JPanel actionPanel, String buttonText, String buttonAction) {   
		JButton button = new JButton(buttonText);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		//button.setPreferredSize(BUTTON_SIZE);
		actionPanel.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == LIST_CUSTOMER) {
			this.dispose();
		}
		
	}

}
