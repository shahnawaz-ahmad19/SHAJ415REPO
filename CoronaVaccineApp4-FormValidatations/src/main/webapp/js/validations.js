
//empty the form validation error messages
    document.getElementById("pnameErr").innerHTML="";
    document.getElementById("paddrsErr").innerHTML="";
    document.getElementById("pageErr").innerHTML="";
    
    function validate(frm){
    	//read form data
    	let name=frm.pname.value;
    	let addrs=frm.paddrs.value;
    	let age=frm.page.value;
    	//client side form validation
    	let flag=true;
    	if(name==""){//required rule on person name
    		document.getElementById("pnameErr").innerHTML="Person name is required";
    		frm.pname.focus();
    		flag=false;
    	}
    	if(addrs==""){ //required rule on address
    		document.getElementById("paddrsErr").innerHTML="Person address is required";
			frm.paddrs.focus();
			flag=false;
    	}  
    	else if(addrs.length<10){ // min lenth rule on person address
    		document.getElementById("paddrsErr").innerHTML="Person address must have munimum of 10 chars";
			frm.paddrs.focus(); // makes text box gaining the focus(cursor goes there)
			flag=false;
    	}
    	if(age==""){ // required rule on person age
    		document.getElementById("pageErr").innerHTML=" person age is required";
			frm.page.focus();
			flag=false;
    	}
    	else if(isNaN(age)){ //must be numeric value rule on person age
    		document.getElementById("pageErr").innerHTML=" person age must be numeric value";
			frm.page.focus();
			flag=false;
    	}
    	else if(age<=0 || age>125){ //range rule on person age
    		document.getElementById("pageErr").innerHTML=" person age must be there between 1 through 125";
			frm.page.focus();
			flag=false;
    	}
    	////change hidden box value(vflag) to "yes" indicating client side form validations are done 
    	frm.vflag.value="yes";
    	return flag;
    	
    }//function