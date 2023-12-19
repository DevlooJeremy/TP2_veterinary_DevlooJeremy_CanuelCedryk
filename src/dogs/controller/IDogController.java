package dogs.controller;

import dogs.observer.IObserver;
import dto.DogDTO;

public interface IDogController {
	void goToCreate();
	void add(DogDTO dogDTO);
	boolean verifyIfOwnerExist(String lastName);
	void addObserver(IObserver observer);
	void removeObserver(IObserver observer);
	void notifyObserver();
}
