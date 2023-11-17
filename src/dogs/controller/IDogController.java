package dogs.controller;

import dto.DogDTO;

public interface IDogController {
	public void goToCreate();
	public void add(DogDTO dogDTO);
}
