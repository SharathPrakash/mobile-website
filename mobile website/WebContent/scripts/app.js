var main=function(){
	$('#password').keypress(
	function(event){
		var pwd=$(this).val();
		if(pwd.length<3){
			$('#jpwd').text("password too short");
			
		}
		else{
			$('#jpwd').text("");
			
		}
		
	}		
	);
	
	
	
}
$(document).ready(main);