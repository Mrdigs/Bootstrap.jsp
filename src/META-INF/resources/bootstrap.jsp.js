/*
 * Support for data-forward attribute
 * 
 * A value of "click=close" would trigger a "close" event on
 * the element when it receives a "click" event. Multiple forwards
 * can be separated by commas.
 */
$(document).on('ready', function() { 
	var data = 'data-forward';
	$('[' + data + ']').each(function() {
		var element = $(this), forwards = element.attr(data);
		$.each(forwards.split(','), function() {
			var forward = this.split('=');
			element.on(forward[0], function() {
				element.trigger(forward[1]);
			});
		});
	});
});
