function submitForm() {                
  	window.open("TestJsp.jsp");}

function selected(dis){
	 var radio = dis.value;
  	if(radio=='Sample Annotation List'){
  		document.getElementById("triple").style.display="block";
  	}
  	else{
  		document.getElementById("triple").style.display="none";
      	}
	   }

function selectedCustom(dis){
	 var radio = dis.value;
 	if(radio=='Annotation List'){
 		document.getElementById("triple").style.display="none";
 	}
 	else{
 		document.getElementById("triple").style.display="none";
     	}
	   }   