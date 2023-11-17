package dogs.controller;

import dataSeeder.DataSeeder;
import dogRepository.DogMemoryRepository;
import dogRepository.IDogRepository;
import dogs.view.IView;
import dogs.view.WelcomeView;

public class WelcomeController implements IWelcomeController {

	private IDogController controller;
	private IDogListController listController;
	
	public WelcomeController(IDogController controller, IDogListController listController) {
		this.controller = controller;
		this.listController = listController;
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
}
