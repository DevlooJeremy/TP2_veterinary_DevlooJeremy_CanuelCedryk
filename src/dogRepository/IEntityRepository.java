package dogRepository;

import java.util.Collection;

import dogs.model.Entity;
import dogs.searcher.IEntitySearcher;

public interface IEntityRepository<T extends Entity> {
	public void add(T element);
	public int size();
	public Collection<T> getList();
	public T searchById(int id);
	public Collection<T> search(IEntitySearcher<T> entitySearcher);
}
