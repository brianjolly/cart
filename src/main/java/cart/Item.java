package cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id 
	@GeneratedValue
	private long id; 
	private String name;
	private String displayPrice;

	protected Item() {}

	public Item(long id, String name, String displayPrice) {
		this.id = id;
		this.name = name;
		this.displayPrice = displayPrice;
	}

	public Item(String name, String displayPrice) {
		this.name = name;
		this.displayPrice = displayPrice;
	}

	public long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getDisplayPrice() {
		return this.displayPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"Item[id=%d, name='%s', displayPrice='%s']",
				id, name, displayPrice);
	}   
}
