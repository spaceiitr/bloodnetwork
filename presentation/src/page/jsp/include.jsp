<%@ taglib prefix="s" uri="/struts-tags" %>
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
			<li><a href="About Us.php">About Us</a>
				<ul>
				 <li><a href="How does blood network work.php"> How does Blood Network works?</a></li>
				</ul>
			</li>
			
			<li><a href="UpdateProfile?<s:property value='fbId'/>" >Update Profile</a></li>
			</li>

			<li><a href="FAQ.php">FAQ</a>
				<ul>
					<li><a href="blooddonationcriteria.php">Blood Donation Criteria</a></li>
					<li><a href="Tips On Blood Donation.php">Tips on Blood Donation</a></li>
					<li><a href="Do not Donate Blood If.php">Do not Donate Blood If</a></li>
					<li><a href="Misconceptions.php">Misconceptions</a></li>
				</ul>
			</li>
			
			<li><a href="FindDonors" id="current">Find Donor</a></li>
			<li><a href='#' onclick=invite_friends() >Invite Friends</a>
		
		</ul> <!-- Main menu ends here -->
	</div>