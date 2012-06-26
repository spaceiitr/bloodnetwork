<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="http://connect.facebook.net/en_US/all.js"></script>

	<script>
		FB.init({
			appId  : '154547504595854',
			channelUrl : '//www.bloodnetwork.org/channel.html', // Channel File
			status     : true, // check login status
			cookie     : true, // enable cookies to allow the server to access the session
			xfbml      : true  // parse XFBML
	});

		function invite_friends() {
			FB.ui({
			method: 'apprequests',
			//frictionlessRequests : true
			message: 'Hi Guys, Mendate of this application is to help you find blood doners in your friend list at the crucial time when they need it. Do your bit. Spread this app. Its tremendously helpful.'
			}, requestCallback);
		}

		function requestCallback(response) {
                          
		}
	</script>
<div class="menu">
		<ul>
			<li><a href="aboutUs.jsp">About Us</a>
				<ul>
				 <li><a href="aboutUsMenu1.jsp"> How does Blood Network works?</a></li>
				</ul>
			</li>
			
			<li><a href="UpdateProfile?<s:property value='fbId'/>" >Update Profile</a></li>
			</li>

			<li><a href="faq.jsp">FAQ</a>
				<ul>
					<li><a href="faq1.jsp">Blood Donation Criteria</a></li>
					<li><a href="faq2.jsp">Tips on Blood Donation</a></li>
					<li><a href="faq3.jsp">Do not Donate Blood If</a></li>
					<li><a href="faq4.jsp">Misconceptions</a></li>
				</ul>
			</li>
			
			<li><a href="FindDonors" id="current">Find Donor</a></li>
			<li><a href='#' onclick=invite_friends() >Invite Friends</a>
		
		</ul> <!-- Main menu ends here -->
	</div>