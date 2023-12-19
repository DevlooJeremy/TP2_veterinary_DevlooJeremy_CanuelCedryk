package mock;

import dogs.controller.IDogController;
import dogs.observer.IObserver;
import dto.DogDTO;

public class DogControllerSpy implements IDogController{

	public boolean hasGoToCreateBeenCalled = false;
	public boolean hasAddBeenCalled = false;
	
	@Override
	public void goToCreate() {
		this.hasGoToCreateBeenCalled = true;
	}

	@Override
	public void add(DogDTO dogDTO) {
		this.hasAddBeenCalled = true;
	}

	@Override
	public boolean verifyIfOwnerExist(String lastName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addObserver(IObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(IObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

}
