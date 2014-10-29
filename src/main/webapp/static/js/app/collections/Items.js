// Items.js
// -------------
define(["jquery","backbone","models/Item"],

   function($, Backbone, Item) {

	   var Items = Backbone.Collection.extend({
		   model: Item,

		   url: function() {
			   return window.location.origin + '/cart/items';
		   }
	   });

	   return Items;
   }
);
