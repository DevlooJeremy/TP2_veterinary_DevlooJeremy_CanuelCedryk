package dogRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogs.model.Dog;

public class DogMemoryRepository implements IDogRepository{
	
	private Map<Integer,Dog> map;
	
	public DogMemoryRepository() {
		this.map = new HashMap<Integer,Dog>();
	}

	@Override
	public void add(Dog dog) {
		dog.setId(this.size() + 1);
		this.map.put(dog.getId(), dog);
	}

	@Override
	public Collection<Dog> getList() {
		return this.map.values();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Dog searchById(int id) {
		return this.map.get(id);
	}

}
