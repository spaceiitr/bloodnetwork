<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-- head begins here -->
	<head>
		<meta name="generator" content="HTML Tidy for Linux (vers 6 November 2007), see www.w3.org" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<script src="http://connect.facebook.net/en_US/all.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/core.js"></script>

		<title>Blood Network</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<link href="style.css" rel="stylesheet" type="text/css" media="screen" />

		<style type="text/css">
		<![CDATA[
		 div.c6 {clear: both;}
		 div.c5 {color: #000000}
		 span.c4 {color: #000000}
		 div.c3 {color: #000000}
		 span.c2 {color: #FFFFFF; font-size: 144%}
		 span.c1 {color: #CC0000}
		]]>
		</style>

		<script>
		function validate(){
		var temp
		 if (document.form1.Select1.value=="blank") {
		alert("Please enter your bloodgroup")
		return false
		}

		else if (document.form1.parentdrop1.value=="blank") {
		alert("Please Select Country")
		return false
		}

		return true
		}
		</script>

		<script src="Scripts/swfobject_modified.js" type="text/javascript">
		</script>
	</head>


	<!-- body begins here -->
	<body>

	<!-- FOR INVITING FRIENDS -->
	<!------------------------>
	
	<!------------------------>

<jsp:include page="includeLogo.jsp"/>
<br/><br/><br/><br/><br/>
<br />
<jsp:include page="include.jsp"/>

	<div id="page">
	<div id="page-bgtop">
	<div id="content">
	<div class="post">
	<p class="meta"></p>
	<h2 class="title"><a href="#"><strong>Find Donor</strong></a></h2>
	<div class="entry">
	<form id="form1" name="form1" action="Retrieval for find donor.php" method="post" onsubmit="return validate()">
	<div class="c3"><br />
	Blood Group  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;
	<s:select 
		headerKey="-1" headerValue="--Select--"
		list="bloodGroups" 
		name="bloodGroup" 
		value="bloodGroup" onchange="findDonors(this);"/>
	</div>
	<span class="c4"><br /></span>
	 
	<br/><br/>
	<div id="donorsTable" />

	
	</form>
	</div>
	</div>
	</div>
	</div>
	</body>
</html>
