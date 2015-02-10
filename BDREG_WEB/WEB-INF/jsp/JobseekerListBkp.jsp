<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
<title>BMET-Admin</title>
	<link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/alternative.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/displaytag.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/maven-base.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/maven-theme.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/print.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/screen.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/site.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/css/teststyles.css">
</head>
 
<body>
    <h2>Jobseeker List</h2>
    <!-- To change column style please form this classes ISIS OR ITS OR Mars OR Simple OR Report OR Mark Column 
    We have chosen style class="Mars"-->
    <display:table export="false"  name="jobseekerList" requestURI="fetchJobseekerList.action" pagesize="15" class="Mars" >
        <display:column property="jobseekerId" title="Id" sortable="true"   />
        <display:column property="name" title="Name" sortable="true"   />
        <display:column property="fatherName" title="Father" sortable="true"   />
        <display:column property="motherName" title="Mother" sortable="true"   />
        <display:column property="birthDate" title="Birth Date" sortable="true"   />
        <display:column property="religion" title="Religion" sortable="true"   />
        <display:column property="gender" title="Gender" sortable="true"   />
        <display:column property="distName" title="Dist." sortable="true"   />        
    </display:table>    
    
</body>
</html>