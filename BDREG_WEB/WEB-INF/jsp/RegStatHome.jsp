<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="java.util.ArrayList" %>
<style>
.panel-heading span {
    margin-top: -20px;
    font-size: 15px;
}
.clickable {
    cursor: pointer;
}   
</style>
<head>
<%@ include file="Header.jsp" %>
<script type="text/javascript">
  function fetchSubJob(jobId,targetElm,level){
  if(jobId=="")
   return;
  else
    {
    $("#"+targetElm).empty();     		
	var data_obj={};
	data_obj["id"]=jobId;
	data_obj["level"]=level;

	$("#"+targetElm).css("background-image","url('/BDREG_WEB/resources/images/loading-icons/ajax_loading.gif')");
	$("#"+targetElm).css("background-repeat","no-repeat");
	$("#"+targetElm).css("background-position","center");
	var objList = $.ajax({
		    url: "fetchJob.action",
		    data: data_obj,
		    async: false,
		    success: function(data, result) {
		        if (!result)
		            alert('Failure to retrieve List.');
		    }
		}).responseText;
	
	if(objList.length==0) return;
	if(objList.indexOf("<html>")>=0) return;
			
	if(level==2)
		$("#"+targetElm).append( '<option value="">Select Sub Job</option>' );
	else if(level==3)
		$("#"+targetElm).append( '<option value="">Select Sub Sub Job</option>' );
	
	$("#"+targetElm).css("background-image","none");
	if(objList.indexOf("<->")==0) return;	
	var targetList=objList.split(";");
	for(var i=0;i<targetList.length; i=i+1 )
	{
		var option=targetList[i].split(":");
			$("#"+targetElm).append( '<option value="' + option[0] + '">' + option[1] + '</option>' );
	}
	
  }

  }
  
  function fetchRegStat()
  {
    $("#resultTotal").html("<img src='/BDREG_WEB/resources/images/loading-icons/loading5.gif' />");
  	var validate = $.ajax({
		    url: "fetchRegStat.action",
		    data: { mainJob: $("#mainJob").val(),subJob:$("#subJob").val(),subSubJob:$("#subSubJob").val()},
		    async: true,
		    success: function(data, result) {
		    $("#resultTotal").html(data);	
		    $("#jobseekerDiv").html("");
		    $('.panel-heading span.clickable').on("click", function (e) {
		            if ($(this).hasClass('panel-collapsed')) {
		                // expand the panel
		                $(this).parents('.panel').find('.panel-body').slideDown();
		                $(this).removeClass('panel-collapsed');
		                $(this).find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
		            }
		            else {
		                // collapse the panel
		                $(this).parents('.panel').find('.panel-body').slideUp();
		                $(this).addClass('panel-collapsed');
		                $(this).find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
		            }
		        });			
		       
		    },
		    error:function(){
		    $("#resultTotal").html("");
		    }
			}).responseText;
  		
  }
  
  function fetchJobseekerList(gender)
  {
  $("#jobseekerDiv").html("<img src='/BDREG_WEB/resources/images/loading-icons/blank3.gif' />");
  $.ajax({url: "fetchJobseekerList.action",data: { mainJob: $("#mainJob").val(),subJob:$("#subJob").val(),subSubJob:$("#subSubJob").val(),gender:gender}, success: function(result){
        $("#jobseekerDiv").html(result);
        $(".panel-heading span.clickable").trigger("click");
        $("#dt_jobseeker_length").append("<a href='reportJobseekerList.action?mainJob="+$("#mainJob").val()+"&subJob="+$("#subJob").val()+"&subSubJob="+$("#subSubJob").val()+"&gender="+gender+"' ><img src='/BDREG_WEB/resources/images/pdf.png' /></a>");
    }});


  }
</script>

</head>
<body class=" theme-blue">
    
    <%@ include file="Banner.jsp" %>
    <%@ include file="Sidebar.jsp" %>

    <div class="content">
        <div class="header">            
            <h1 class="page-title">Search Registered Jobseeker</h1>            
        </div>
        <div class="main-content">            
<select name="mainJob" id="mainJob" onchange="fetchSubJob(this.value,'subJob',2)" class="form-control" style="width:230px;float:left;">
 <option value="">Select Main Job</option> 
 <s:iterator value="mainJobList">
 	<option value="<s:property value='jobId'/>"><s:property value="jobTitle"/></option>
 </s:iterator>
 </select>
<select name="subJob" id="subJob" onchange="fetchSubJob(this.value,'subSubJob',3)" class="form-control" style="width:230px;float:left;margin-left:15px;">
 <option value="">Select Sub Job</option> 
 </select>
<select name="subSubJob" id="subSubJob" class="form-control" style="width:230px;float:left;margin-left:15px;">
 <option value="">Select Sub Sub Job</option> 
 </select>
<a class="btn btn-primary" href="#" onclick="fetchRegStat()" style="margin-left: 20px;float: left;">Search Record</a> 
<p style="clear: both;">
	<div id="resultTotal" style="width: 720px;"></div>
</p>
<div id="jobseekerDiv"></div>
</div>
</div>

<script src="/BDREG_WEB/resources/lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>