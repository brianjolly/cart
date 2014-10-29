// Cart.js
// -------
define(["jquery", "backbone", "models/Model"],

    function($, Backbone, Model){

        var Cart = Backbone.View.extend({

            el: ".cart",

            initialize: function() {
                this.render();
				this.listenTo(this.collection, "add", this.render);
				this.listenTo(this.collection, "remove", this.render);
				this.items = this.collection;
			},

			events:{
				"click .item":"itemClicked"
			},

			itemClicked: function(e) {

				var id = $(e.currentTarget).data("id");
				var action = $(e.currentTarget).data("action");

				if (action === "remove") {
					this.collection.remove(
						this.collection.get(id)
					);
				}
			},

			render: function(child, arr, obj) {
				var string = "";

				if (child && this.items.models.length > 0) {
					string += "<h3>Shopping Cart</h3><ul>";

					_.each(this.items.models, function(item){
						string += ("<li><a href='#' "
								   + " class='item'"
								   + " data-action='remove'"
								   + " data-id='" + item.get("id") + "'"
								   + "><em>" + item.get("name")  + "</em> " + item.get("displayPrice")
								   + "</a></li>");
					});
					string += "</ul>";

				};

				this.$el.html(string);

                return this;
            }
        });

        return Cart;
    }
);
