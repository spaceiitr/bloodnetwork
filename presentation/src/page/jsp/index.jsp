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
    // the user is logged in and has authenticated your
    // app, and response.authResponse supplies
    // the user's ID, a valid access token, a signed
    // request, and the time the access token 
    // and signed request each expire
    FB.login(function(response) {
   if (response.authResponse) {
     console.log('Welcome!  Fetching your information.... ');
     FB.api('/me', function(response) {
       console.log('Good to see you, ' + response.location + '.');
       var uid = response.ID;
       initializeUserData();
       
     },{scope: 'user_location,friends_location'});
   } else {
     console.log('User cancelled login or did not fully authorize.');
   }
 });
 
 return false;
    
    initializeUserData();
    return false;
    window.location = "Redirect?fbId="+uid;
  } else if (response.status === 'not_authorized') {
    // the user is logged in to Facebook, 
    // but has not authenticated your app
    FB.login(function(response) {
	   if (response.authResponse) {
	     console.log('Welcome!  Fetching your information.... ');
	     FB.api('/me', function(response) {
	       console.log('Good to see you, ' + response.location + '.');
	       var uid = response.ID;
	       initializeUserData();
	     },{scope: 'user_location,friends_location'});
	   } else {
	     console.log('User cancelled login or did not fully authorize.');
	   }
	 },{scope:'user_location,friends_location'});	
  } else {
    // the user isn't logged in to Facebook.
    FB.login(function(response) {
   if (response.authResponse) {
     console.log('Welcome!  Fetching your information.... ');
     FB.api('/me', function(response) {
       console.log('Good to see you, ' + response.work[0].employer.name + '.');
       var uid = response.ID;
       window.location = "Redirect?fb_id="+uid;
       
     });
   } else {
     console.log('User cancelled login or did not fully authorize.');
   }
 });	
  }
 },{scope: 'user_location,friends_location'});
 
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
 	window.location = "Redirect?fbId=";
 }
		</script>
		
	</head>


	<!-- body begins here -->
	<body>
		Please wait while we initialize your data.....
	</body>
	
</html>
