package dogRepository;

import java.util.Collection;

import dogs.model.Dog;

public interface IDogRepository {
	
	public void add(Dog dog);
	
	public Collection<Dog> getList();
	
	public int size();
	
	public Dog searchById(int id);

}
