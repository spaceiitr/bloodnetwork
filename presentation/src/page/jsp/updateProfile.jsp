<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta name="generator" content="HTML Tidy for Linux (vers 6 November 2007), see www.w3.org" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="http://connect.facebook.net/en_US/all.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/core.js"></script>
<title>Blood Network</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">
/*<![CDATA[*/
 div.c6 {clear: both; color: #333333}
 span.c5 {color: #333333}
 p.c4 {color: #333333}
 span.c3 {color: #CC0000; font-size:14px }
 span.c2 {color: #FFFFFF; font-size: 144%}
 span.c1 {color: #CC0000}
/*]]>*/
</style>
</head>
<body>
<!-- end #header-wrapper -->
<jsp:include page="includeLogo.jsp"/>
<br/><br/><br/><br/><br/>
<br />
<jsp:include page="include.jsp"/>
        
      
<!-- end #search -->
<!-- end #header -->

<!-- end #logo -->
<!-- start -->
<div id="page">
<div id="page-bgtop">
<div id="content">
<div class="post">

<script>
function validate(){
var temp
if (document.form1.text1.value=="") {
alert("Please enter your name.")
return false
}

else if (document.form1.Select1.value=="blank") {
alert("Please enter your bloodgroup")
return false
}
else if (document.form1.Select.value=="blank") {
alert("Please enter your Gender")
return false
}
else if (document.form1.Select2.value=="blank") {
alert("Please enter your Blood Donation Frequency")
return false
}
else if (document.form1.parentdrop1.value=="blank") {
alert("Please Select Country")
return false
}
return true
}

function fetchFacebookName()
{
	FB.api('/me', function(response) {
		alert(response.ID);
	});
}

//fetchFacebookName();
</script>

<p class="meta"> </p>
<h2 class="title"><a href="#"><b>Update Profile</b></a></h2>
<div class="entry">
<form id="form1" name="form1" action="UpdateProfile!updateUser" method="post" onsubmit="return validate()">
<img src="https://graph.facebook.com/<s:property value='fbId' />/picture"/>
&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<span id="name"><s:property value='fbId' /></span>

<br /><br/>
Blood Group   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;      &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;   &nbsp;  &nbsp;  &nbsp;&nbsp;
<s:select 
		headerKey="-1" headerValue="--Select--"
		list="bloodGroups" 
		name="bloodGroup" 
		value="bloodGroup" />
<br/><br/>
                        
                       
 Availibility &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <s:select  
		headerKey="-1" headerValue="--Select--"
		list="availibilityOptions" 
		name="availibility" 
		value="availibility" />
<br/><br/>
<!--Remarks &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;   &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;     &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;                <textarea name="comments" cols="20" rows="2">
Type comments here.</textarea>-->
<!-- HTML codes by Quackit.com -->

  
 




<br/><br/>
<s:hidden name="fbId" value="%{fbId}" />
<button name="Submit" type="submit"><span class="c4">Submit</span></button></p>
</form>

<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>


</div>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
	FB.api("/<s:property value='fbId' />", function(response) {
       console.log('Good to see you, ' + JSON.stringify(response) + '.');
       $("#name").html(response.name);
     });
</script>
</html>

