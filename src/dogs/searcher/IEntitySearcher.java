package dogs.searcher;

import dogs.model.Entity;

public interface IEntitySearcher<T extends Entity> {
	boolean isMatching(T element);
}
