package dogs.model;

abstract public class Entity {
	
	private int id;
	
	public Entity() {
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
