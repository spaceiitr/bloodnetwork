<html>
<head>
	<script src="http://connect.facebook.net/en_US/all.js"></script>
	<script type="text/javascript">
		FB.init({
			appId  : '154547504595854',
			channelUrl : '//www.bloodnetwork.org/channel.html', // Channel File
			status     : true, // check login status
			cookie     : true, // enable cookies to allow the server to access the session
			xfbml      : true  // parse XFBML
	});
	
	FB.getLoginStatus(function(response) {
		console.log(JSON.stringify(response));
		FB.login(function(response) {
			
		},{scope:'user_location'});
	});
	</script>
</head>
</html>