var main=function(){
	
	$("#email").change(function(){
		$.get("AjaxUserController.do", $(this).serialize(), function(data){
			$("#emailerror").text(data);
		});//eoget
		
		
	});
	
	$("#password").change(function(){
		$.get("AjaxUserController.do", $(this).serialize(), function(data){
			$("#passworderror").text(data);
		});//eoget
		
		
	});
	
	
};

$(document).ready(main);