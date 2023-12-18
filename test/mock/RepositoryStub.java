package mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogRepository.IEntityRepository;
import dogs.model.Entity;
import dogs.searcher.IEntitySearcher;

public class RepositoryStub<T extends Entity> implements IEntityRepository<T>{
	
	public Map<Integer,T> map;
	
	public RepositoryStub() {
		this.map = new HashMap();
	}

	@Override
	public void add(T element) {
		this.map.put(this.map.size(), element);
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList search(IEntitySearcher entitySearcher) {
		ArrayList<T> listOfResult = new ArrayList<T>();
		for (T t : this.map.values()) {
			if(entitySearcher.isMatching(t)) {
				listOfResult.add(t);
			}
		}
		return listOfResult;
	}

}
