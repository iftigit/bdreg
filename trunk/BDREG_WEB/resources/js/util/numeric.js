
var brName=  navigator.appName;


function getCode(event)
{
var code;

if(brName.indexOf("Microsoft")!=-1)
{
   event=window.event;
   code=event.keyCode;
   
}
  else if(brName.indexOf("Netscape")!=-1)
     code=event.which;

return code;     	
}
/*
function numericOnly(evt)
{
         var charCode = (evt.which) ? evt.which : evt.keyCode
         if(charCode==46 || (charCode>=37 && charCode<=40))
         	return true;
         
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;

}*/

function numericOnly(event)
{

var code =  getCode(event);

//var dotCount = checkDot(event,event.target.id);

if((code >= 48 && code <= 57) || code==8  || code==0)
 {
  return true;
 }
 else
  {
   return false;
  }

}
function numericOnlyWithDot(event)
{
//alert(getCode(event));
var code =  getCode(event);

//var dotCount = checkDot(event,event.target.id);

if((code >= 48 && code <= 57) || code==46 || code==8  || code==0 || code==190 || code==110)
 {
  return true;
 }
 else
  {
   return false;
  }

}

function numericOnlyWithTab(event)
{

var code =  getCode(event);


if((code >= 48 && code <= 57) || (code >= 96 && code <= 105) || code==8  || code==9  || code==0)
 {
  return true;
 }
 else
  {
   return false;
  }

}



function numericWithDot(event)
{

var code =  getCode(event);
//alert(code)
if((code >= 48 && code <= 57) || code==46 || code==8  || code==0)
 {
  return true;
 }
 else
  {
   return false;
  }

}


function trColorChange(textBoxObj,c)
{
 if(c=='Y')
   var color='#D0E8E8';
 else
   var color='';
 textBoxObj.parentNode.parentNode.style.background=color;
}

function trColorChangeCT(textBoxObj,c)
{
 if(c=='Y')
   var color='#D0E8E8';
 else
   var color='';
 textBoxObj.parentNode.parentNode.parentNode.style.background=color;
}

