package dogRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogs.model.Entity;
import dogs.searcher.IEntitySearcher;

public class EntityMemoryRepository<T extends Entity> implements IEntityRepository<T>{

	private Map<Integer,T> map;
	
	public EntityMemoryRepository() {
		this.map = new HashMap<Integer,T>();
	}
	
	@Override
	public void add(T element) {
		element.setId(map.size()+1);
		map.put(map.size(), element);
		
	}

	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public Collection<T> getList() {
		return this.map.values();
	}

	@Override
	public T searchById(int id) {
		return this.map.get(id);
	}
	
	@Override
	public Collection<T> search(IEntitySearcher<T> entitySearcher){
		ArrayList<T> listOfResult = new ArrayList<T>();
		for (T t : this.map.values()) {
			if(entitySearcher.isMatching(t)) {
				listOfResult.add(t);
			}
		}
		return listOfResult;
	}

}
