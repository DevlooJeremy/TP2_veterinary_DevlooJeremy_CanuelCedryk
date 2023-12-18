package mock;

import java.util.ArrayList;
import java.util.Collection;

import dogRepository.IEntityRepository;
import dogs.model.Dog;
import dogs.model.Entity;
import dogs.searcher.IEntitySearcher;

public class RepositorySpy<T extends Entity> implements IEntityRepository<T>{
	
	public boolean hasAddBeenCalled = false; 
	public T elementAdded;

	@Override
	public void add(T element) {
		this.hasAddBeenCalled = true;
		this.elementAdded = element;
		
	}

	@Override
	public Collection<T> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<T> search(IEntitySearcher<T> entitySearcher) {
		// TODO Auto-generated method stub
		return null;
	}


}
