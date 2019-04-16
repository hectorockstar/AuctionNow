$(document).ready(function(){
	$("#rateYo").rateYo({
		rating: 3.6,
		readOnly: true,
//		 onChange: function (rating, rateYoInstance) {		
//		  $(this).next().text(rating);
//		}
	});
	
	$("#rateYoEscoger").rateYo({
		starWidth: "20px",
		onChange: function (rating, rateYoInstance) {			
		  $(this).next().text(rating);		  		  
		}
	});	
});