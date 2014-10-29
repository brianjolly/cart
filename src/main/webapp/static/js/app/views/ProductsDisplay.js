define(["jquery", "underscore", "backbone"],
	function($, _, Backbone) {

		var ProductsDisplay = Backbone.View.extend({
			el: $(".productsDisplay"),

			initialize: function() {
				this.listenTo(this.collection, "sync", this.render);
				this.items = this.collection;
			},

			events:{
				"click .item":"itemClicked"
			},

			itemClicked: function(e) {
				var id = $(e.currentTarget).data("id");
				var action = $(e.currentTarget).data("action");

				if (action === "buy") {
					this.itemsInCart.add(
						this.collection.get(id)
					);
				}
			},

			render: function(child, arr, obj) {
				var string = "<h2>Product List</h2><ul>";

				_.each(arr, function(item){
				    string += ("<li><em>" + item.name  + "</em> " + item.displayPrice 
							  + " <a href='#'"
							  + " data-action='buy'"
							  + " data-id='" + item.id + "'"
							  + " class='item'>Buy Now! -></a></li>");
				});
				string += "</ul>";

				this.$el.html(string);

                return this;
			}
		});

		return ProductsDisplay;
	}
);
