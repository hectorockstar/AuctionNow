$(document).ready(function(){
	$("#rateYo").rateYo({
		starWidth: "20px",
		rating: 3.6,
		readOnly: true,
//		 onChange: function (rating, rateYoInstance) {		
//		  $(this).next().text(rating);
//		}
	});
	
	$(".rateYo").rateYo({
		starWidth: "20px",
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