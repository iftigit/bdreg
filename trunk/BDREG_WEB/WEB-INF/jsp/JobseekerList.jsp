<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>BMET-Admin</title>
<head>
	<link rel="stylesheet" href="/BDREG_WEB/resources/datatable/css/jquery.dataTables.min.css" type="text/css">
	<script src="/BDREG_WEB/resources/datatable/js/jquery.dataTables.min.js"></script>	
</head> 
<body>
	<table id="dt_jobseeker" class="dataTables_full table table-striped">
                <thead>
	                <tr>
	                  <th style="width: 10%">ID</th>
	                  <th style="width: 22%">Name</th>
	                  <th style="width: 22%">Father Name</th>
	                  <th style="width: 22%">Mother Name</th>
	                  <th style="width: 10%">DoB</th>
	                  <th style="width: 10%">Religion</th>
	                  <th style="width: 10%">Gender</th>
	                  <th style="width: 10%">Dist</th>
	                </tr>
                </thead>
                <tbody>

                </tbody>
    </table> 	
	    
</body>
<script type="text/javascript">
$('#dt_jobseeker').dataTable({
      "bServerSide"    : true,
      "bFilter": false,
      "oScroller": {"loadingIndicator": true},
      "bProcessing" : true,
      "sAjaxSource"    : "jobseekerTableData?mainJob=<s:property value='mainJob'/>&subJob=<s:property value='subJob'/>&subSubJob=<s:property value='subSubJob'/>&gender=<s:property value='gender'/>"      
    });
</script>
</html>