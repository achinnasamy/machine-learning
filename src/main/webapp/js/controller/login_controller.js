$(document).ready(function() {

	$("#loginButton").submit(function() {
		alert('sss');
	    var url = "http://localhost:8080/dmac-machine-learning-1.0-SNAPSHOT/api/v1/login/loginUserAuthentication";
	   
	    var formData = {
	            'userName'              : $('input[name=userName]').val(),
	            'password'              : $('input[name=password]').val()
	    };
	    
	    
	    $.ajax({
	           type: "POST",
	           url: url,
	           data: formData,
	           success: function(data)
	           {
	               if (data.key == "loginResponse" && data.value == "success")
	            	   $(location).attr('href','http://localhost:8080/dmac-machine-learning-1.0-SNAPSHOT/dashboard/pages/index.html');
	               else
	            	   alert('Login Failed')
	           },	    		
	         });
	
	    return false; 
	});

});