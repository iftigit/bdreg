function checkLocalExperience()
{
 
            var  jobCategory;
            var  jobSubCategory;
            var  jobSubSubCategory;
            var  expYear;
            
            var  jobCategory_Element;
            var  jobSubCategory_Element;
            var  jobSubSubCategory_Element;
            
            var  expYear_Element;
            var  delete_expAbroad_Element;

            var expHidden;
            expHidden = document.getElementById("localExpHidden");
            expHidden.value = "";

            for(var j=0; j < cntLX[0]; j++)
              {
            	jobSubCategory="";
                jobSubSubCategory="";
                
            	jobCategory_Element = document.getElementById("localExpJobCat"+j);
            	jobSubCategory_Element = document.getElementById("localSubJob_1_"+j);
            	jobSubSubCategory_Element = document.getElementById("localSubJob_2_"+j);
            	
            	
            	expYear_Element = document.getElementById("localExpYear"+j);
            	delete_expAbroad_Element=document.getElementById("delete_expLocal"+j);
            	
            	if(jobCategory_Element)
            	{

	                if(delete_expAbroad_Element.style.display != 'none')
	                {
	                
	                	jobCategory=jobCategory_Element.value;
	                	expYear=expYear_Element.value;
	                	
	
	                  if(trim(jobCategory) == '' || trim(expYear)=='')
	                    return false;
	                  if(jobSubCategory_Element)
	                  {
	                	  if(jobSubCategory_Element.value=='')
	                		  return false;
	                	  else
	                		  jobSubCategory=jobSubCategory_Element.value;
	                  }
	                  if(jobSubSubCategory_Element)
	                  {
	                	  if(jobSubSubCategory_Element.value=='')
	                		  return false;
	                	  else
	                		  jobSubSubCategory=jobSubSubCategory_Element.value;
	                  }
	                  expHidden.value += jobCategory+"88khayer88"+jobSubCategory+"88khayer88"+jobSubSubCategory+"88khayer88"+expYear+"99ifti99";
                }
            	}
              }
              
              
              return true;
}
function checkAbraodExperience()
{
            var  country;
            var  jobCategory;
            var  jobSubCategory;
            var  jobSubSubCategory;
            var  expYear;
            
            var  country_Element;
            var  jobCategory_Element;
            var  jobSubCategory_Element;
            var  jobSubCategory_Element;
            var  expYear_Element;
            var  delete_expAbroad_Element;

            var expHidden;
            expHidden = document.getElementById("aboradExpHidden");
            expHidden.value = "";

            for(var j=0; j < cntAX[0]; j++)
              {
            	
            	jobSubCategory="";
                jobSubSubCategory="";
                
                
            	country_Element = document.getElementById("abroadExpCountry"+j);
            	jobCategory_Element = document.getElementById("abroadExpJobCat"+j);
            	jobSubCategory_Element = document.getElementById("abroadSubJob_1_"+j);
            	jobSubSubCategory_Element = document.getElementById("abroadSubJob_2_"+j);
            	expYear_Element = document.getElementById("abroadExpYear"+j);
            	delete_expAbroad_Element=document.getElementById("delete_expAbroad"+j);
            	
            	if(country_Element)
            	{

	                if(delete_expAbroad_Element.style.display != 'none')
	                {
	                
	                	country=country_Element.value;
	                	jobCategory=jobCategory_Element.value;
	                	expYear=expYear_Element.value;
	
	                  if(trim(country) == '' || trim(jobCategory) == '' || trim(expYear)=='')
	                  {
	                    return false;
	                  }
	                  if(jobSubCategory_Element)
	                  {
	                	  if(jobSubCategory_Element.value=='')
	                		  return false;
	                	  else
	                		  jobSubCategory=jobSubCategory_Element.value;
	                  }
	                  if(jobSubSubCategory_Element)
	                  {
	                	  if(jobSubSubCategory_Element.value=='')
	                		  return false;
	                	  else
	                		  jobSubSubCategory=jobSubSubCategory_Element.value;
	                  }
	                  
	                  expHidden.value += country+"88khayer88"+jobCategory+"88khayer88"+jobSubCategory+"88khayer88"+jobSubSubCategory+"88khayer88"+expYear+"99ifti99";
                }
            	}
              }
              
              
              return true;
}
function checkJobPreference()
{
            var  mainJob;
            var  subJob_1;
            var  subJob_2;
            var  jobP;
            
            var  mainJob_Element;
            var  subJob_1_Element;
            var  subJob_2_Element;
            var  jobP_Element;

            var jobPreferenceHidden;
            jobPreferenceHidden = document.getElementById("jobPreferenceHidden");
            jobPreferenceHidden.value = "";

            for(var j=0; j < 100; j++)
              {
            	mainJob_Element = document.getElementById("mainJob_"+j);
            	subJob_1_Element = document.getElementById("subJob_1_"+j);
            	subJob_2_Element = document.getElementById("subJob_2_"+j);
            	jobP_Element=document.getElementById("jobP"+j);
            	
            	if(mainJob_Element)
            	{
	                if(jobP_Element.style.display != 'none')
	                {
	                
	                	mainJob=mainJob_Element.value;
	                	if(trim(mainJob) == '')
	                		return false;

	                	if(subJob_1_Element)
	                	{
	                		subJob_1=subJob_1_Element.value;
	                		if(trim(subJob_1) == '')
		                		return false;
	                	}
	                	if(subJob_2_Element)	
	                	{
	                		subJob_2=subJob_2_Element.value;
	                		if(trim(subJob_2) == '')
		                		return false;
	                	}
	

	                	
	                	jobPreferenceHidden.value += mainJob+"88khayer88"+subJob_1+"88khayer88"+subJob_2+"99ifti99";
                }
            	}
              }
              
              
              return true;
}

/*````````````````````````````````````````````````````````````````*/
/***************!!!  Language Information !!!**********************/
function checkLanguageInformation()
{
            var  language;
            var  oral;
            var  writing;
            
            var  language_Element;
            var  oral_Element;
            var  writing_Element;

            var languageHidden;
            languageHidden = document.getElementById("languageHidden");
            languageHidden.value = "";
            
            for(var j=0; j < cntL[0]; j++)
              {
                language_Element = document.getElementById("language"+j);
                oral_Element = document.getElementById("oral"+j);
                writing_Element = document.getElementById("writing"+j);
                if(language_Element)
                {
	                if(language_Element.style.display != 'none')
	                {
	                
			            language=language_Element.value;
			            oral=oral_Element.value;
			            writing=writing_Element.value;
	
	                  if(trim(language) == 'select' || trim(oral) == 'select' || trim(writing)=='select')
	                  {
	                    return false;
	                  }
						languageHidden.value += language+"88khayer88"+oral+"88khayer88"+writing+"99ifti99";
	                }
                }
              }
              
              
              return true;
}
/*```````````````````````````````````````````````````````````````*/


/*````````````````````````````````````````````````````````````````*/
/**************!!!  Training Information !!!***********************/
function checkTrainingInformation()
{
            var  trainingName;
            var  trainingFrom;
            var  trainingDuration;
            var  trainingDesc;
            
            
            var  trainingName_Element;
            var  trainingFrom_Element;
            var  trainingDuration_Element;
            var  trainingDesc_Element;
            

            var trainingHidden;
            trainingHidden = document.getElementById("trainingHidden");
            trainingHidden.value = "";
            
            
            for(var j=0; j < cntT[0]; j++)
              {
                trainingName_Element = document.getElementById("trainingName"+j);
                trainingFrom_Element = document.getElementById("trainingFrom"+j);
                trainingDuration_Element = document.getElementById("trainingDuration"+j);
                trainingDesc_Element = document.getElementById("trainingDesc"+j);
                if(trainingName_Element)
                {
	                if(trainingName_Element.style.display != 'none')
	                {
	                
			            trainingName=trainingName_Element.value;
			            trainingFrom=trainingFrom_Element.value;
			            trainingDuration=trainingDuration_Element.value;
			            trainingDesc=trainingDesc_Element.value;
	
	                  if(trim(trainingName) == '' || trim(trainingFrom) == '' || trim(trainingDuration)==''||
						 trim(trainingDesc) == ''	                     
	                    )
	                  {
	                    return false;
	                  }
						trainingHidden.value += trainingName+"88khayer88"+trainingFrom+"88khayer88"+trainingDuration+"88khayer88"+trainingDesc+"99ifti99";
	                }
                }
              }
              
              return true;
}


function ValidateEmail(mail)   
{  
     if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail.value))  
     {  
        
     }
     else
     {  
        mail.focus();
        alert("You have entered an invalid email address!");
        mail.value='';  
      }  
}  

function checkFutureDate(entrydate01)
{
	var dt = parseInt(entrydate01.value.substring(0, 2), 10);
	var mn = parseInt(entrydate01.value.substring(3, 5), 10);
	var yr = parseInt(entrydate01.value.substring(6, 10), 10);
	var myDate = new Date(yr, mn-1, dt);
	var today = new Date();
	{
    	if (myDate>today)
    	{
    		alert('You cannot enter a date in the future!');
    		entrydate01.value='';
     	}
	}
}

//http://en.wikipedia.org/wiki/Telephone_numbers_in_Bangladesh
/*
    Warid : 016
	Banglalink : 019
	Citycell : 011
	Grameenphone : 017
	Robi : 018
	TeleTalk : 015
*/

function validateMobileNumber(mobileNumber) {
   var mob = /^(016|019|011|017|018|015)[0-9]{8}$/;
   
   if (mob.test(mobileNumber) == false) {
       return false;
   }
   return true;
 }
//Declaring valid date character, minimum year and maximum year
var dtCh= "-";
var minYear=1900;
var maxYear=2100;

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isValidDate(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		//alert("The date format should be : dd-MM-yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		//alert("Please enter a valid month")
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		//alert("Please enter a valid day")
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		//alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		//alert("Please enter a valid date")
		return false
	}
return true
}



function getNomineeContactPhoneCount(fieldId,phoneNumber,mstFieldId)
{
var ajax_load="<img src='/BMREG_WEB/resources/images/ajax-loader.gif' border='0' /> " ;
if(phoneNumber=="")
	 return;
var loadUrl="getContactNumberCount.action";	

$("#"+mstFieldId)  
			.html(ajax_load)  
			.load(loadUrl, {contactNumber: phoneNumber},function(responseText){  
			   
				$("#"+mstFieldId).html("");
				if(parseInt(responseText,10)>=3)
				{
					document.getElementById(fieldId).value="";
					alert("This Number has already been used for 3 times.");
				}
	 
			});
}

function previewRegistrationForm()
{
	checkConnectivityAndSubmitForm("empRegForm");
}

function checkConnectivityAndSubmitForm(formName)
{
	  var newDataRequest = $.ajax({
			 url: "getContactNumberCount.action",
			 timeout: 30000, // timeout after 30 seconds
			 data: { timestamp: new Date().getTime() }
		});

		newDataRequest.done(function(data)
				{
					 //console.log(data);	
					 document.forms[formName].submit();
				});

		newDataRequest.fail(function(jqXHR, textStatus)
		{
			if (jqXHR.status === 0)
			{
				alert('No Internet Connection.\nPlease Verify Your Internet Connection.');
			}
			else if (jqXHR.status === 403) {
				alert("Sorry, your session has expired. Please login again to continue");
			}
			else if (jqXHR.status == 404)
			{
				alert('Requested page not found. [404]');
			}
			else if (jqXHR.status == 500)
			{
				alert('Internal Server Error [500].');
			}
			else if (jqXHR.status == 400)
			{
				alert('Bad Request. [400]');
			}
			else if (jqXHR.status == 200)
			{
				document.forms[formName].submit();
			}
			/*
			else if (exception === 'parsererror')
			{
				alert('Requested JSON parse failed.');
			}
			else if (exception === 'timeout')
			{
				alert('Time out error.');
			}
			else if (exception === 'abort')
			{
				alert('Ajax request aborted.');
			}*/
			else
			{
				alert('Uncaught Error.\n' + jqXHR.responseText);
			}

			});     
		     
}