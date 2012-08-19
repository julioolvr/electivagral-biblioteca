$(document).ready(function(){
	$('#libro').autocomplete({
		minLength: 2,
		source: '/biblioteca/libro/autocomplete',
		select: function(event, ui) {
			console.log(event, ui);
		}
	});
});