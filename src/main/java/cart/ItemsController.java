package cart;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {

	@Autowired
	private ApplicationContext context;

	@Autowired
	ItemRepository itemRepository;

	@RequestMapping("/itemsh2")
	public Iterable<Item> allItems () {
		Iterable<Item> items = itemRepository.findAll();

		System.out.println("ItemsController /items");
		Iterator it = items.iterator();

		int i = 0;
		while(it.hasNext()) {
			i++;
			it.next();
		}
		System.out.println("num items: " + i);

		for (Item item : items) {
			System.out.println(item.toString());
		}

		return items;
	}   

	@RequestMapping("/items")
	public List<Item> getList()
	{
		final List<Item> list = new ArrayList<>();
		list.add(new Item(1, "Quad Copter", "$799.99"));
		list.add(new Item(2, "Laptop", "$500.98"));
		list.add(new Item(3, "Beablebone", "$45.00"));
		list.add(new Item(4, "Headphones", "$60.05"));
		list.add(new Item(5, "Pumpkin", "8.99"));
		return list;
	}

	@RequestMapping("/loaditems")
	public void loadItems () {
		ItemRepository repository = context.getBean(ItemRepository.class);

		repository.save(new Item("Quad Copter", "$799.99"));
		repository.save(new Item("Laptop", "$500.98"));
		repository.save(new Item("Beablebone", "$45.00"));
		repository.save(new Item("Headphones", "$60.05"));
		repository.save(new Item("Pumpkin", "8.99"));
	}   
}

