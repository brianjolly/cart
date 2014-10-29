// DesktopRouter.js
// ----------------
define(["jquery", "backbone", "models/Item", "collections/Items", "views/Cart", "views/ProductsDisplay"],

    function($, Backbone, Item, Items, Cart, ProductsDisplay) {

		var itemsForSale = new Items();
		var itemsInCart = new Items();

		var productsDisplay = new ProductsDisplay({collection: itemsForSale});
		productsDisplay.itemsInCart = itemsInCart;

		var cartDisplay = new Cart({collection: itemsInCart});

		itemsForSale.fetch({
			success: function(collection, response) {
				console.log(collection);
				console.log(response);
			}
		});

        var DesktopRouter = Backbone.Router.extend({

            initialize: function() {
                Backbone.history.start();
            },

            routes: {
				"": "index"
			},

            index: function() { },
        });

        return DesktopRouter;
    }

);
