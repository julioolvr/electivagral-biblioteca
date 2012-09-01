$(document).ready(function(){
	$('#libro').autocomplete({
		minLength: 2,
		source: '/biblioteca/libro/autocomplete',
		select: function(event, ui) {
			$('#libro\\.id').val(ui.item.id)
		}
	});
});