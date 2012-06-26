<%@ taglib prefix="s" uri="/struts-tags" %>
<table class="TableA" cellpadding="5px" border="1">
<tr class="even">
    <th>Name</th>
    <th>Availability</th>
    <th>Location</th>
</tr>
<s:iterator value="donorIds" status="obj" id="myTable">
    <tr id="tr_<s:property value='fbId'/>">
        <td id="name_<s:property value='fbId'/>"><img src="https://graph.facebook.com/<s:property value='fbId'/>/picture"/></td>
        <td><s:property value="availability"/></td>
        <td><s:property value="location"/></td>
    </tr>
    <script>
    	function onload_<s:property value='fbId'/>()
    	{
    		FB.api('/<s:property value='fbId'/>/', function(response) {
       			var name = response.name;
       			var link = response.link;
       			var html = "<a href='"+link+"'>"+name+ "</a>";
       			$("#name_<s:property value='fbId'/>").append(html);
     		});
    	}
		onload_<s:property value='fbId'/>();
    </script>
</s:iterator>