var main=function(){
	
	$("#Managerid").change(function(){
		/*$("#managererror").text("script is working");*/
	$.get("AjaxManagerVerify.do", $(this).serialize(), function(data){
			$("#managererror").text(data);
		});//eoget
		
		
	});
	
	$("#password").change(function(){
		//$("#passworderror").text("script is working");
		$.get("AjaxManagerVerify.do", $(this).serialize(), function(data){
			$("#passworderror").text(data);
		});//eoget
		
		
	});
	
	
};
$(document).ready(main);