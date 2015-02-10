var destiField="";
var pos;

function fetchJSONData_Dist(divId,dest){
        var url = 'JSONfindDistrict.action';
        destiField=dest;
     	var myAjax = new Ajax.Request(
                    url, 
                    {
                            method: 'post',
                            parameters: {'divisionId' : divId},
                            onComplete: fetchDistSuccess,
                            cache: true
                    });
         
   }
   function fetchDistSuccess(originalRequest){
       
     	var result = originalRequest.responseText.evalJSON();
     	var options="";
     	var tdId=""
     	if(destiField=="PERMANENT_DIST")
     	  {
     	   options="<select tabindex='502' name=\"pAddress.districtId\" id=\"PERMANENT_DIST\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UpazillaOrThana(this.value,'PERMANENT_UPAZILLA_OR_THANA')\">";
     	   tdId="PERMANENT_DIST_TD";
     	   document.getElementById(tdId).innerHTML="";
     	  }
     	else if(destiField=="MAILING_DIST")
     	 {
     	  options="<select tabindex='552' name=\"mAddress.districtId\" id=\"MAILING_DIST\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UpazillaOrThana(this.value,'MAILING_UPAZILLA_OR_THANA')\">";
     	  tdId="MAILING_DIST_TD";
     	  document.getElementById(tdId).innerHTML="";
     	 }
     	else if(destiField=="NOMINEE_DIST")
    	 {
    	  options="<select tabindex='37' name=\"nomineeDTO.address.districtId\" id=\"NOMINEE_DIST\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UpazillaOrThana(this.value,'NOMINEE_UPAZILLA_OR_THANA')\">";
    	  tdId="NOMINEE_DIST_TD";
    	  document.getElementById(tdId).innerHTML="";
    	 }
     	else if(destiField=="PASSWORD_DIST")
	   	  {
	   	   options="<select tabindex='31' name=\"addressDTO.pDistrict\" id=\"PASSWORD_DIST\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UpazillaOrThana(this.value,'PASSWORD_UPAZILLA_OR_THANA')\">";
	   	   tdId="PASSWORD_DIST_TD";
	   	   document.getElementById(tdId).innerHTML="";
	   	  }
 		
 		options+="<option value=''>--Select District--</option>";
 		for (var i=0;i<result.districtList.length;i=i+2)
 		{
        	options+="<option value='"+result.districtList[i+1]+"'>"+result.districtList[i]+"</option>"; 
        }
        options+="</select>";

        document.getElementById(tdId).innerHTML=options;

 	}
   function fetchJSONData_UpazillaOrThana(districtId,dest){
	   var divistionId;
	   if(dest=="PERMANENT_UPAZILLA_OR_THANA")
		   var divisionId=document.getElementById("PERMANENT_DIV").value;
	   else if(dest=="MAILING_UPAZILLA_OR_THANA")
		   var divisionId=document.getElementById("MAILING_DIV").value;
	   else if(dest=="NOMINEE_UPAZILLA_OR_THANA")
		   var divisionId=document.getElementById("NOMINEE_DIV").value;
	   else if(dest=="BIRTH_UPAZILLA_OR_THANA")
		   var divisionId="";
	   
       var url = 'JSONfindUpazillaOrThana.action';
       destiField=dest;
       
    	var myAjax = new Ajax.Request(
                   url, 
                   {
                           method: 'post',
                           parameters: {'divisionId' : divisionId, 'districtId' : districtId},
                           onComplete: fetchUpazillaOrThanaSuccess,
                           cache: true
                   });
        
  }
  function fetchUpazillaOrThanaSuccess(originalRequest){
      
    	var result = originalRequest.responseText.evalJSON();
    	var options="";
    	var tdId=""
    	if(destiField=="PERMANENT_UPAZILLA_OR_THANA")
    	  {
    	   options="<select tabindex='503' name=\"pAddress.upazillaOrThanaId\" id=\"PERMANENT_UPAZILLA_OR_THANA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UnionOrWard(this.value,'PERMANENT_UNION_OR_WARD')\">";
    	   tdId="PERMANENT_UPAZILLA_OR_THANA_TD";
    	   document.getElementById(tdId).innerHTML="";
    	  }
    	else if(destiField=="MAILING_UPAZILLA_OR_THANA")
    	 {
    	  options="<select tabindex='553' name=\"mAddress.upazillaOrThanaId\" id=\"MAILING_UPAZILLA_OR_THANA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UnionOrWard(this.value,'MAILING_UNION_OR_WARD')\">";
    	  tdId="MAILING_UPAZILLA_OR_THANA_TD";
    	  document.getElementById(tdId).innerHTML="";
    	 }
    	else if(destiField=="NOMINEE_UPAZILLA_OR_THANA")
	   	 {
	   	  options="<select tabindex='38' name=\"nomineeDTO.address.upazillaOrThanaId\" id=\"NOMINEE_UPAZILLA_OR_THANA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UnionOrWard(this.value,'NOMINEE_UNION_OR_WARD')\">";
	   	  tdId="NOMINEE_UPAZILLA_OR_THANA_TD";
	   	  document.getElementById(tdId).innerHTML="";
	   	 }
    	else if(destiField=="BIRTH_UPAZILLA_OR_THANA")
	   	 {
	   	  options="<select tabindex='7' name=\"personalDTO.empBirthUpazilaOrThana\" id=\"BIRTH_UPAZILLA_OR_THANA\" class=\"addressSelectBox\" style='width:200px;'>";
	   	  tdId="BIRTH_UPAZILLA_OR_THANA_TD";
	   	  document.getElementById(tdId).innerHTML="";
	   	 }
    	else if(destiField=="PASSWORD_UPAZILLA_OR_THANA")
        {
        	options="<select tabindex='32' name=\"addressDTO.pThana\" id=\"PASSWORD_THANA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_UnionOrWard(this.value,'PASSWORD_UNION_OR_WARD')\" >";
        	tdId="PASSWORD_THANA_TD";
        	document.getElementById(tdId).innerHTML="";
        }
			
		options+="<option value=''>--Select Upazilla/Thana/City Corp./Pourashava--</option>";
		for (var i=0;i<result.upazillaOrThanaList.length;i=i+2)
		{
       	options+="<option value='"+result.upazillaOrThanaList[i+1]+"'>"+result.upazillaOrThanaList[i]+"</option>"; 
       }
       options+="</select>";

       document.getElementById(tdId).innerHTML=options;

	}
  
  function fetchJSONData_UnionOrWard(upazillaOrThanaId,dest){
	   var divistionId;
	   var districtId;
	   
	   if(dest=="PERMANENT_UNION_OR_WARD"){
		   divisionId=document.getElementById("PERMANENT_DIV").value;
		   districtId=document.getElementById("PERMANENT_DIST").value;
	   }
	   else if(dest=="MAILING_UNION_OR_WARD"){
		   divisionId=document.getElementById("MAILING_DIV").value;
		   districtId=document.getElementById("MAILING_DIST").value;
	   }
	   else if(dest=="NOMINEE_UNION_OR_WARD"){
		   divisionId=document.getElementById("NOMINEE_DIV").value;
		   districtId=document.getElementById("NOMINEE_DIST").value;
	   }
	   else if(dest=="PASSWORD_UNION_OR_WARD"){
		   divisionId=0;
		   districtId=0;
	   }
	   
    var url = 'JSONfindUnionOrWard.action';
    destiField=dest;
      
   	var myAjax = new Ajax.Request(
                  url, 
                  {
                          method: 'post',
                          parameters: {'divisionId' : divisionId, 'districtId' : districtId, 'upazillaOrThanaId' : upazillaOrThanaId},
                          onComplete: fetchUnionOrWardSuccess,
                          cache: true
                  });
       
 }
 function fetchUnionOrWardSuccess(originalRequest){
     
   	var result = originalRequest.responseText.evalJSON();
   	var options="";
   	var tdId=""
   	if(destiField=="PERMANENT_UNION_OR_WARD")
   	  {
   	   options="<select tabindex='504' name=\"pAddress.unionOrWardId\" id=\"PERMANENT_UNION_OR_WARD\" class=\"addressSelectBox\" onchange=\"fetchJSONData_MauzaOrMoholla(this.value,'PERMANENT_MAUZA_OR_MOHOLLA')\">";
   	   tdId="PERMANENT_UNION_OR_WARD_TD";
   	   document.getElementById(tdId).innerHTML="";
   	  }
   	else if(destiField=="MAILING_UNION_OR_WARD")
   	 {
   	  options="<select tabindex='554' name=\"mAddress.unionOrWardId\" id=\"MAILING_UNION_OR_WARD\" class=\"addressSelectBox\" onchange=\"fetchJSONData_MauzaOrMoholla(this.value,'MAILING_MAUZA_OR_MOHOLLA')\">";
   	  tdId="MAILING_UNION_OR_WARD_TD";
   	  document.getElementById(tdId).innerHTML="";
   	 }
   	else if(destiField=="NOMINEE_UNION_OR_WARD")
  	 {
  	  options="<select tabindex='39' name=\"nomineeDTO.address.unionOrWardId\" id=\"NOMINEE_UNION_OR_WARD\" class=\"addressSelectBox\" onchange=\"fetchJSONData_MauzaOrMoholla(this.value,'NOMINEE_MAUZA_OR_MOHOLLA')\">";
  	  tdId="NOMINEE_UNION_OR_WARD_TD";
  	  document.getElementById(tdId).innerHTML="";
  	 }   	
   	else if(destiField=="PASSWORD_UNION_OR_WARD")
    {
    	options="<select tabindex='32' name=\"addressDTO.pUnion\" id=\"PASSWORD_UNION\" class=\"addressSelectBox\" onchange=\"fetchPasswordInformation(this.value)\" >";
    	tdId="PASSWORD_UNION_TD";
    	document.getElementById(tdId).innerHTML="";
    	
    }
		options+="<option value=''>--Select Union/Ward--</option>";
		for (var i=0;i<result.unionOrWardList.length;i=i+2)
		{
      	options+="<option value='"+result.unionOrWardList[i+1]+"'>"+result.unionOrWardList[i]+"</option>"; 
      }
      options+="</select>";

      document.getElementById(tdId).innerHTML=options;

	} 
 
 function fetchJSONData_MauzaOrMoholla(unionOrWardId,dest){
	   var divistionId;
	   var districtId;
	   var upazillaOrThanaId;
	   
	   if(dest=="PERMANENT_MAUZA_OR_MOHOLLA"){
		   divisionId=document.getElementById("PERMANENT_DIV").value;
		   districtId=document.getElementById("PERMANENT_DIST").value;
		   upazillaOrThanaId=document.getElementById("PERMANENT_UPAZILLA_OR_THANA").value;
		   
	   }
	   else if(dest=="MAILING_MAUZA_OR_MOHOLLA"){
		   divisionId=document.getElementById("MAILING_DIV").value;
		   districtId=document.getElementById("MAILING_DIST").value;
		   upazillaOrThanaId=document.getElementById("MAILING_UPAZILLA_OR_THANA").value;
	   }
	   else if(dest=="NOMINEE_MAUZA_OR_MOHOLLA"){
		   divisionId=document.getElementById("NOMINEE_DIV").value;
		   districtId=document.getElementById("NOMINEE_DIST").value;
		   upazillaOrThanaId=document.getElementById("NOMINEE_UPAZILLA_OR_THANA").value;
	   }
	   
  var url = 'JSONfindMauzaOrMoholla.action';
  destiField=dest;
  
  
    
 	var myAjax = new Ajax.Request(
                url, 
                {
                        method: 'post',
                        parameters: {'divisionId' : divisionId, 'districtId' : districtId, 'upazillaOrThanaId' : upazillaOrThanaId, 'unionOrWardId' : unionOrWardId},
                        onComplete: fetchMauzaOrMohollaSuccess,
                        cache: true
                });
     
}
function fetchMauzaOrMohollaSuccess(originalRequest){
   
 	var result = originalRequest.responseText.evalJSON();
 	var options="";
 	var tdId=""
 	if(destiField=="PERMANENT_MAUZA_OR_MOHOLLA")
 	  {
 	   options="<select tabindex='505' name=\"pAddress.mauzaOrMohollaId\" id=\"PERMANENT_MAUZA_OR_MOHOLLA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_Village(this.value,'PERMANENT_VILLAGE')\">";
 	   tdId="PERMANENT_MAUZA_OR_MOHOLLA_TD";
 	   document.getElementById(tdId).innerHTML="";
 	  }
 	else if(destiField=="MAILING_MAUZA_OR_MOHOLLA")
 	 {
 	  tdId="MAILING_MAUZA_OR_MOHOLLA_TD";
 	  options="<select tabindex='555' name=\"mAddress.mauzaOrMohollaId\" id=\"MAILING_MAUZA_OR_MOHOLLA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_Village(this.value,'MAILING_VILLAGE')\">";
 	  document.getElementById(tdId).innerHTML="";
 	 }
 	else if(destiField=="NOMINEE_MAUZA_OR_MOHOLLA")
	 {
	  options="<select tabindex='40' name=\"nomineeDTO.address.mauzaOrMohollaId\" id=\"NOMINEE_MAUZA_OR_MOHOLLA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_Village(this.value,'NOMINEE_VILLAGE')\">";
	  tdId="NOMINEE_MAUZA_OR_MOHOLLA_TD";
	  document.getElementById(tdId).innerHTML="";
	 }
		
		options+="<option value=''>--Select Mauza/Moholla--</option>";
		for (var i=0;i<result.mauzaOrMohollaList.length;i=i+2)
		{
    	options+="<option value='"+result.mauzaOrMohollaList[i+1]+"'>"+result.mauzaOrMohollaList[i]+"</option>"; 
    }
    options+="</select>";

    document.getElementById(tdId).innerHTML=options;

	}

function fetchJSONData_Village(mauzaOrMohollaId,dest){
	   var divistionId;
	   var districtId;
	   var upazillaOrThanaId;
	   var unionOrWardId;
	   
	   if(dest=="PERMANENT_VILLAGE"){
		   divisionId=document.getElementById("PERMANENT_DIV").value;
		   districtId=document.getElementById("PERMANENT_DIST").value;
		   upazillaOrThanaId=document.getElementById("PERMANENT_UPAZILLA_OR_THANA").value;
		   unionOrWardId=document.getElementById("PERMANENT_UNION_OR_WARD").value;
		   
	   }
	   else if(dest=="MAILING_VILLAGE"){
		   divisionId=document.getElementById("MAILING_DIV").value;
		   districtId=document.getElementById("MAILING_DIST").value;
		   upazillaOrThanaId=document.getElementById("MAILING_UPAZILLA_OR_THANA").value;
		   unionOrWardId=document.getElementById("MAILING_UNION_OR_WARD").value;
	   }
	   else if(dest=="NOMINEE_VILLAGE"){
		   divisionId=document.getElementById("NOMINEE_DIV").value;
		   districtId=document.getElementById("NOMINEE_DIST").value;
		   upazillaOrThanaId=document.getElementById("NOMINEE_UPAZILLA_OR_THANA").value;
		   unionOrWardId=document.getElementById("NOMINEE_UNION_OR_WARD").value;
	   }
	   
var url = 'JSONfindVillage.action';
destiField=dest;
 
	var myAjax = new Ajax.Request(
             url, 
             {
                     method: 'post',
                     parameters: {'divisionId' : divisionId, 'districtId' : districtId, 'upazillaOrThanaId' : upazillaOrThanaId, 'unionOrWardId' : unionOrWardId, 'mauzaOrMohollaId' : mauzaOrMohollaId},
                     onComplete: fetchVillageSuccess,
                     cache: true
             });
  
}
function fetchVillageSuccess(originalRequest){

	var result = originalRequest.responseText.evalJSON();
	var options="";
	var tdId=""
	if(destiField=="PERMANENT_VILLAGE")
	  {
	   options="<select tabindex='506' name=\"pAddress.villageId\" id=\"PERMANENT_VILLAGE\" class=\"addressSelectBox\" >";
	   tdId="PERMANENT_VILLAGE_TD";
	   document.getElementById(tdId).innerHTML="";
	  }
	else if(destiField=="MAILING_VILLAGE")
	 {
	  options="<select tabindex='556' name=\"mAddress.villageId\" id=\"MAILING_VILLAGE\" class=\"addressSelectBox\" >";
	  tdId="MAILING_VILLAGE_TD";
	  document.getElementById(tdId).innerHTML="";
	 }
	else if(destiField=="NOMINEE_VILLAGE")
	 {
	  options="<select tabindex='41' name=\"nomineeDTO.address.villageId\" id=\"NOMINEE_VILLAGE\" class=\"addressSelectBox\" >";
	  tdId="NOMINEE_VILLAGE_TD";
	  document.getElementById(tdId).innerHTML="";
	 }
		
		options+="<option value=''>--Select Village --</option>";
		for (var i=0;i<result.villageList.length;i=i+2)
		{
 	options+="<option value='"+result.villageList[i+1]+"'>"+result.villageList[i]+"</option>"; 
 }
 options+="</select>";

 document.getElementById(tdId).innerHTML=options;

	} 

  function copyPermanentAddress(checkValue)
  {
  
   if(checkValue==true)
   {
    
    
    $1('MAILING_DIV').value=$1('PERMANENT_DIV').value;
    document.getElementById('MAILING_DIV').readOnly =true;
    
    var t=getDropDown('PERMANENT_DIST');
    var selectedInd=t.selectedIndex;
    var tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    
    $1('MAILING_DIST_TD').innerHTML="<select tabindex='45' name=\"mAddress.districtId\" id=\"MAILING_DIST\" class=\"addressSelectBox\" ><option value='"+$1('PERMANENT_DIST').value+"'>"+tex+"</option></select>";
    document.getElementById('MAILING_DIST').readOnly =true;
    
    t=getDropDown('PERMANENT_UPAZILLA_OR_THANA');
    selectedInd=t.selectedIndex;
    tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    $1('MAILING_UPAZILLA_OR_THANA_TD').innerHTML="<select tabindex='46' name=\"mAddress.upazillaOrThanaId\" id=\"MAILING_UPAZILLA_OR_THANA\" class=\"addressSelectBox\" ><option  value='"+$1('PERMANENT_UPAZILLA_OR_THANA').value+"'>"+tex+"</option>";
    document.getElementById('MAILING_UPAZILLA_OR_THANA').readOnly =true;
    
    
    t=getDropDown('PERMANENT_UNION_OR_WARD');
    selectedInd=t.selectedIndex;
    tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    $1('MAILING_UNION_OR_WARD_TD').innerHTML="<select tabindex='46' name=\"mAddress.unionOrWardId\" id=\"MAILING_UNION_OR_WARD\" class=\"addressSelectBox\" ><option  value='"+$1('PERMANENT_UNION_OR_WARD').value+"'>"+tex+"</option>";
    document.getElementById('MAILING_UNION_OR_WARD').readOnly =true;
   
    t=getDropDown('PERMANENT_MAUZA_OR_MOHOLLA');
    selectedInd=t.selectedIndex;
    tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    $1('MAILING_MAUZA_OR_MOHOLLA_TD').innerHTML="<select tabindex='46' name=\"mAddress.mauzaOrMohollaId\" id=\"MAILING_MAUZA_OR_MOHOLLA\" class=\"addressSelectBox\" ><option  value='"+$1('PERMANENT_MAUZA_OR_MOHOLLA').value+"'>"+tex+"</option>";
    document.getElementById('MAILING_MAUZA_OR_MOHOLLA').readOnly =true;
   
    
    t=getDropDown('PERMANENT_VILLAGE');
    selectedInd=t.selectedIndex;
    tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    $1('MAILING_VILLAGE_TD').innerHTML="<select tabindex='46' name=\"mAddress.villageId\" id=\"MAILING_VILLAGE\" class=\"addressSelectBox\" ><option  value='"+$1('PERMANENT_VILLAGE').value+"'>"+tex+"</option>";
    document.getElementById('MAILING_VILLAGE').readOnly =true;
   
    
    $1('MAILING_POST_OFFICE').value=$1('PERMANENT_POST_OFFICE').value;
    $1('MAILING_POST_CODE').value=$1('PERMANENT_POST_CODE').value;
    $1('MAILING_ROAD').value=$1('PERMANENT_ROAD').value;
    $1('MAILING_HOUSEHOLD').value=$1('PERMANENT_HOUSEHOLD').value;
    
    
   }
   
   else
   {
    var t=getDropDown('MAILING_DIV');
    t.selectedIndex=0
    
    //$1('MAILING_DIV').value="--Select Division--";
    $1('MAILING_DIST').innerHTML="";
    $1('MAILING_UPAZILLA_OR_THANA').innerHTML="";
    $1('MAILING_UNION_OR_WARD').innerHTML="";
    $1('MAILING_MAUZA_OR_MOHOLLA').innerHTML="";
    $1('MAILING_VILLAGE').innerHTML="";
    
    $1('MAILING_POST_OFFICE').value="";
    $1('MAILING_POST_CODE').value="";
    $1('MAILING_ROAD').value="";
    $1('MAILING_HOUSEHOLD').value="";
   }
   
  }
  
  
  function areaSelect(fieldValue,fieldId)
  {
   if(fieldValue=="Others")
    document.getElementById(fieldId).style.display="block";
   else
    document.getElementById(fieldId).style.display="none";
    
  }
  


	function getDropDown(listid)
	{
	var dps =  document.getElementsByTagName("select");
	var dpsno;
	
	for(i=0;i<dps.length;i++)
	 {
	   if(dps[i].id==listid)
	   {
	    dpsno = dps[i];
	    break;
	   }
	 }
	return dpsno; 
	} 