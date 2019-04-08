
function loadModal(h)	{
	
	$('#desafioModal').foundation('reveal', 'open')
	$('#desafioModal').html("<div class='panel'> Carregando ... </div>");
	$.get(h, function(data){
		$('#desafioModal').html(data);
	}).fail(function(jqXHR, textStatus, error) {
		$('#desafioModal').html(error);
	});
}

function protectSubmitFunction(button, idForm)	{
	$(button).on("click", function() {
        $(this).prop("disabled", "disabled");
        $(this).text("Enviando...");
        if (!idForm)	{
        	this.form.submit();
        }	else	{
        	$(idForm).submit();
        }
        
    });
}