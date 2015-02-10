 function refreshCaptcha(queryParam)
  {
  var rightnow = new Date();
if (document.images)
 document.images.captchaImage.src = 'BMREG_WEB/CaptchaServlet.cap?'+queryParam+"&dateTime="+ rightnow.getTime();

  }
function trim(str, chars) {
    return ltrim(rtrim(str, chars), chars);
}

function ltrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("^[" + chars + "]+", "g"), "");
}

function rtrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("[" + chars + "]+$", "g"), "");
}

function IsNumeric(sText)
{
   var ValidChars = "0123456789.";
   var IsNumber=true;
   var Char;

 
   for (i = 0; i < sText.length && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
   
}

function IsNumber(sText)
{
   var ValidChars = "0123456789";
   var IsNumber=true;
   var Char;

 
   for (i = 0; i < sText.length && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
}

function validateFloatNumber(elem, event) {
		var val = elem.value;
		var temp = "";
		for (var i = 0; i < val.length; i++) {
			if ((val.charAt(i) < "0" || val.charAt(i) > "9") && val.charAt(i) != ".") {
				alert("Numerical Value Required");
				elem.value = temp;
				return false;
			}
			temp += val.charAt(i);
		}
	}

function $1(id)
{
 return document.getElementById(id);
}

function $find(field)
{
	 return document.getElementById(field);
}

function ageCount(dob) {
    var date1 = new Date();
    
    var date2=new Date(dob);
    //var pattern = /^\d{1,2}\/\d{1,2}\/\d{4}$/; //Regex to validate date format (dd/mm/yyyy)
    //if (pattern.test(dob)) {
      //  var y1 = date1.getFullYear(); //getting current year
      //  var y2 = date2.getFullYear(); //getting dob year
      //  var age = y1 - y2;           //calculating age 
        //document.write("Age : " + age);
        //return age+"    Years";
        return new Number((new Date().getTime() - dob.getTime()) / 31536000000).toFixed(0);
        //return age;
   // } else {
    //    alert("Invalid date format. Please Input in (dd/mm/yyyy) format!");
    //    return false;
   // }

}
function calculateAge(ageField,dobField)
{
	
	var dob=document.getElementById(dobField).value;
	var dobArr=dob.split("-");


	var bDate = new Date(dobArr[2], dobArr[1] - 1, dobArr[0]);
	
	document.getElementById(ageField).value=ageCount(bDate);
}

