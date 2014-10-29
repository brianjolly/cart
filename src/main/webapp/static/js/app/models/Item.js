// Item.js
// --------
define(["jquery", "backbone"],

	function($, Backbone) {

		var Model = Backbone.Model.extend({
			initialize: function() {},
			validate: function(attrs) { }
		});

		return Model;
	}
);
