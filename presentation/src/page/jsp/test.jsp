<html xmlns="http://www.w3.org/1999/xhtml">
	<!-- head begins here -->
	<head>
		<meta name="generator" content="HTML Tidy for Linux (vers 6 November 2007), see www.w3.org" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/core.js"></script>
		<script type="text/javascript">
				var appID = 154547504595854;
		var str = window.location.toString();
		alert(str);
    	if (str.search("request") == -1) {
	        var path = 'https://www.facebook.com/dialog/oauth?';
	   		var queryParams = ['client_id=' + appID,'redirect_uri=' + "https://s14.phpfogapp.com/?key=8291339158_78868",'response_type=token', 'scope=user_location'];
	   		var query = queryParams.join('&');
	   		var url = path + query;
	   		
	   		window.location.href = url;
	   		alert(url);
	   		
		} 
		</script>
		
	</head>
</html>