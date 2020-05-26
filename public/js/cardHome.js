


var userConnect = ""

$(document ).ready(function(){
    
//    var xml =new XMLHttpRequest();
//    xml.onLoad=function(response){
//    	console.log("load");
//    	console.log(response.reponspeText);
//    }
//    xml.open("GET","user");
//    xml.send();
    $.ajax("user",{success:function(user){
    	userConnect = user.name;
        $("#userNameId").html(user.name);
        $("#money span").html("42");

    },error:function(a){
        console.log("error",a);
        $("#userNameId").html(`<a href="formSample.html">Login</a>`);
        $("#money").hide();
    }})



    $("#playButtonId").click(function(){
        alert("Play button clicked ");
        
    });    
    $("#buyButtonId").click(function(){
    	if(userConnect){
    		window.location.href="searchCard.html";    		
    	}else{
    		window.location.href="formSample.html";
    	}
    });    
    $("#sellButtonId").click(function(){
    	if(userConnect){
	    	window.location.href="cardList.html";
	    }else{
			window.location.href="formSample.html";
		}
    });    
});

