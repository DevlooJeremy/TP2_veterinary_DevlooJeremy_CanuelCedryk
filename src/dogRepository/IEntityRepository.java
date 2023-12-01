package dogRepository;

import java.util.Collection;

import dogs.model.Entity;

public interface IEntityRepository<T extends Entity> {
	public void add(T element);
	public int size();
	public Collection<T> getList();
	public T searchById(int id);
}
