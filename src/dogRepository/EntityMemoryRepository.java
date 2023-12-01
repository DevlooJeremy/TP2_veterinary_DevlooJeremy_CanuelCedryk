package dogRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogs.model.Entity;

public class EntityMemoryRepository<T extends Entity> implements IEntityRepository<T>{

	private Map<Integer,T> map;
	
	public EntityMemoryRepository() {
		this.map = new HashMap<Integer,T>();
	}
	
	@Override
	public void add(T element) {
		map.put(element.getId(), element);
		
	}

	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public Collection getList() {
		return this.map.values();
	}

	@Override
	public T searchById(int id) {
		return this.map.get(id);
	}

}
