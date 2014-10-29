package cart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index() {
		return "site.homepage";
	}
}
