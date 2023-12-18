package dogs.controller;

import dto.DogDTO;

public interface IDogController {
	void goToCreate();
	void add(DogDTO dogDTO);
	boolean verifyIfOwnerExist(String lastName);
}
