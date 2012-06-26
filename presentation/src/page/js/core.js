function popitup (url) {
	newwindow=window.open(url,'name','height=200,width=350');
	if (window.focus) 
	{
		newwindow.focus()
	}
	return false;
}
		
	/*	var appID = 154547504595854;
		var str = window.location.toString();
		alert(str);
    	if (str.search("request") == -1) {
	        var path = 'https://www.facebook.com/dialog/oauth?';
	   		var queryParams = ['client_id=' + appID,'redirect_uri=' + "https://s14.phpfogapp.com/?key=8291339158_78868",'response_type=token'];
	   		var query = queryParams.join('&');
	   		var url = path + query;
	   		
	   		window.location.href = url;
	   		alert(url);
	   		
		} */ 
		
		

	


function testMe()
{
	alert('test');
	 $.get(  
            'https://www.facebook.com/dialog/oauth?',  
            {client_id: "154547504595854", redirect_uri: "http://s14.phpfogapp.com/?key=8291339158_78868", scope:"email,read_stream"},  
            function(responseText){  
                alert(responseText);
            }  
            
        ); 
    
}

function testYou()
{
	
            $.getJSON(  
                'https://www.facebook.com/dialog/oauth?',
                {client_id: "154547504595854", redirect_uri: "http://s14.phpfogapp.com/?key=8291339158_78868", scope:"email,read_stream"},
                function(json) {  
                    alert(json.responseData);
                }  
            );  
}

function test3()
{
	FB.login(function(response) {
   if (response.authResponse) {
     console.log('Welcome!  Fetching your information.... ');
     FB.api('/me', function(response) {
       console.log('Good to see you, ' + response.work[0].employer.name + '.');
     });
   } else {
     console.log('User cancelled login or did not fully authorize.');
   }
 });
}

function findDonors(elem)
{
	$.ajax({
                            url: 'FindDonors!refresh',
                            type: 'post',
                            dataType: 'html',
                            data: 'bloodGroup=' + encodeURIComponent(elem.value),
                            success: function(data)
                            	{
                            		$("#donorsTable").html(data);
                            		
                            	},
    						
                            beforeSend: function() {
                            },
                            
                            error: function(xhr, textStatus, errorThrown) {
                                alert("Some error has occured");
                            }
                        });
}


function ajaxRequest(url, params, onSuccCallback)
{
	$.ajax({
                            url: url,
                            type: 'post',
                            dataType: 'html',
                            data: params,
                            success: function()
                            	{
                            		if ($.isFunction(onSuccCallback))
                            			onSuccCallback();
                            		
                            	},
    						
                            beforeSend: function() {
                            },
                            
                            error: function(xhr, textStatus, errorThrown) {
                                alert("Some error has occured");
                            }
                        });
}
		
	
	