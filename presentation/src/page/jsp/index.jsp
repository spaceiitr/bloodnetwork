<html xmlns="http://www.w3.org/1999/xhtml">
	<!-- head begins here -->
	<head>
		<meta name="generator" content="HTML Tidy for Linux (vers 6 November 2007), see www.w3.org" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/core.js"></script>
		<script src="http://connect.facebook.net/en_US/all.js"></script>
		
		<title>Blood Network</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<script type="text/javascript">
		FB.init({
			appId  : '154547504595854',
			channelUrl : '//www.bloodnetwork.org/channel.html', // Channel File
			status     : true, // check login status
			cookie     : true, // enable cookies to allow the server to access the session
			xfbml      : true  // parse XFBML
	});
	
	FB.getLoginStatus(function(response) {
	  if (response.status === 'connected') {
	       FB.api('/me', function(response) {
	       		initializeUserData();
	     	});
		}
		else if (response.status === 'not_authorized') {
			askUserToLogin();
		}else{
			askUserToLogin();
		}
 });
 
  
 function initializeUserData()
 {	
 	 FB.api('/me', function(response) {
       ajaxRequest("Initialize", 'meJsonString='+JSON.stringify(response), addFBFriends);
     });
 }
 
 function addFBFriends()
 {
 	FB.api('/me/friends?fields=name,location&limit=1000&offset=0', function(response) {
 		response.paging.next = encodeURIComponent(response.paging.next);
       meFriendString = JSON.stringify(response);
       ajaxRequest("Initialize!addFriends", 'friendJsonString='+JSON.stringify(response), redirectCallback);
     });
 }	
 
 function redirectCallback()
 {
 	window.location = "Redirect";
 }
 
 function askUserToLogin()
 {
 	FB.login(function(response) {
   		if (response.authResponse) {
	     	FB.api('/me', function(response) {
	       		console.log('Good to see you, ' + response.location + '.');
	       		var uid = response.ID;
	       		initializeUserData();
	     	},{scope: 'user_location,friends_location'});
   		} 
   		else {
     		console.log('User cancelled login or did not fully authorize.');
   		}
 	});
 }
</script>
		
	</head>


	<!-- body begins here -->
	<body>
		Please wait while we initialize your data.....
	</body>
	
</html>
