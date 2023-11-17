package mock;

import java.util.Collection;

import dogRepository.IDogRepository;
import dogs.model.Dog;

public class RepositorySpy implements IDogRepository{
	
	public boolean hasAddBeenCalled = false; 
	public Dog dogAdded;

	@Override
	public void add(Dog dog) {
		this.hasAddBeenCalled = true;
		this.dogAdded = dog;
		
	}

	@Override
	public Collection<Dog> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dog searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
