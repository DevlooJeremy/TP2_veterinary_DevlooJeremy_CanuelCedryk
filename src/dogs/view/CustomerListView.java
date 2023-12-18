package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dogRepository.IEntityRepository;
import dogs.controller.ICustomerController;
import dogs.model.Customer;
import dogs.searcher.CustomerSearcherFabric;

public class CustomerListView extends JFrame implements IView,ActionListener{

	private static final String VIEW_TITLE = "Listes des clients";
	private static final Dimension DEFAULT_SIZE = new Dimension(400, 200);
	private static final String CLOSE_BTN_TXT = "OK";
	private static final String CLOSE_BTN = "close_frame";
	private static final String SEARCH_BTN_TXT = "Rechercher";
	private static final String SEARCH_BTN = "search";
	private static final String LAST_NAME_LABEL = "Nom de famille:";
	private static final String ID_LABEL = "Numéro:";
	private static final String NAME_TITLE = "PRÉNOM";
	private static final String LAST_NAME_TITLE = "NOM DE FAMILLE";
	private static final String PHONE_TITLE = "NUMÉRO DE TÉLÉPHONE";
	private static final String ID_TITLE = "ID";


	private JTextField lastName = new JTextField(20);
	private JTextField id = new JTextField(20);
	
	private ICustomerController controller;
	private IEntityRepository<Customer> repository;
	
	private boolean resultOfSearch;
	private Collection<Customer> customerResultList;
	private JPanel listCustomerPanel = new JPanel();
	
	public CustomerListView(ICustomerController customerController, IEntityRepository<Customer> repository)
	{
		super();
		
		this.controller = customerController;
		this.repository = repository;
		this.resultOfSearch = false;
		this.initialize();
		this.setUpComponents();
		this.pack();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	public void insertResultOfSearch(Collection<Customer> result) {
		this.customerResultList = result;
		resultOfSearch = true;
		this.remove(listCustomerPanel);
		this.setUpInputDataPanel();
		this.revalidate();
		this.repaint();
	}
	
	private void initialize() {
		this.setTitle(VIEW_TITLE);	
		this.setSize(DEFAULT_SIZE);
	}
	
	private void setUpComponents() {
		this.setUpInputDataPanel();
		this.setUpActionPanel();	
		this.setUpSearchingPanel();
		this.setUpSearchingBtnPanel();
	}
	
	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel,BorderLayout.SOUTH);
		
		ViewUtil.addButton(this, actionPanel, CLOSE_BTN_TXT, CLOSE_BTN);
	}
	
	private void setUpSearchingPanel() {
		JPanel searchingPanel = new JPanel();
		this.add(searchingPanel,BorderLayout.NORTH);
		searchingPanel.setLayout(new GridLayout(2,2));
		
		addTextField(searchingPanel,ID_LABEL,this.id);
		addTextField(searchingPanel,LAST_NAME_LABEL,this.lastName);
	}
	
	private void setUpSearchingBtnPanel() {
		JPanel searchingBtnPanel = new JPanel();
		this.add(searchingBtnPanel,BorderLayout.SOUTH);
		searchingBtnPanel.setLayout(new GridLayout());
		ViewUtil.addButton(this, searchingBtnPanel, SEARCH_BTN_TXT, SEARCH_BTN);
	}
	
	private void addTextField(JPanel panel, String labelText, JTextField textField) {
		
		panel.add(new JLabel(labelText));
		panel.add(textField);
	}
	
	private void setUpInputDataPanel() {
		// container interm�diaire JPanel qui contient les �tiquettes (JLabel) et les zones de textes (JTextField)
		// utiliser un GridLayout comme LayoutManager
		listCustomerPanel = new JPanel();
		listCustomerPanel.setLayout(new GridLayout(0,4));
		this.add(listCustomerPanel, null);
		this.addTitleTextField(listCustomerPanel);
		Collection<Customer> customerList = this.repository.getList();
		if(resultOfSearch) {
			for (Customer customer : customerResultList) {
				addTextField(listCustomerPanel,customer.getId(),customer.getName(),customer.getLastName(),customer.getPhone());
			}
		}else {
			for (Customer customer : customerList) {
				addTextField(listCustomerPanel,customer.getId(),customer.getName(),customer.getLastName(),customer.getPhone());
			}
		}
	}
	
	private void addTitleTextField(JPanel panel) {
		panel.add(new JLabel(ID_TITLE));
		panel.add(new JLabel(NAME_TITLE));
		panel.add(new JLabel(LAST_NAME_TITLE));
		panel.add(new JLabel(PHONE_TITLE));
	}
	
	private void addTextField(JPanel panel, int id, String name, String lastName,String phoneNumber) {
		
		panel.add(new JLabel(Integer.toString(id))); 
		panel.add(new JLabel(name));
		panel.add(new JLabel(lastName));
		panel.add(new JLabel(phoneNumber));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == CLOSE_BTN) {
			this.dispose();
		}
		if (e.getActionCommand() == SEARCH_BTN) {
			CustomerSearcherFabric searcherFabric = new CustomerSearcherFabric();
			if(!lastName.getText().isBlank()) {
				String nameToFind = lastName.getText();
				Collection<Customer> result = this.repository.search(searcherFabric.getStrategyToResearchCustomerByName(nameToFind));
				this.dispose();
				this.controller.showResult(result);
			} else if (!id.getText().isBlank()) {
				Collection<Customer> result = this.repository.search(searcherFabric.getStrategyToResearchCustomerById(Integer.parseInt(id.getText())));
				this.dispose();
				this.controller.showResult(result);
			}
		}
	}

	@Override
	public void dispalyErrorMessage(String message) {
		// TODO Auto-generated method stub
		
	}
}
