package dogs.controller;

import dataSeeder.DogSeeder;
import dogRepository.DogMemoryRepository;
import dogRepository.IDogRepository;
import dogs.view.IView;
import dogs.view.WelcomeView;

public class WelcomeController implements IWelcomeController {

	private IDogController controller;
	private IDogListController listController;
	private ICustomerController customerController;
	
	public WelcomeController(IDogController controller, IDogListController listController,ICustomerController customerController) {
		this.controller = controller;
		this.listController = listController;
		this.customerController = customerController;
	}
	
	@Override
	public void startApplication() {
		IView welcomeView = new WelcomeView(this);
		welcomeView.display();
	}
	
	@Override
	public void wantToCreateDog() {
		this.controller.goToCreate();
	}

	@Override
	public void wantToListDog() {
		this.listController.goToCreate();
	}

	@Override
	public void wantToListCustomer() {
		this.customerController.listCustomer();
	}
}
