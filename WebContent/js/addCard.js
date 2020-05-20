
function reqListener () {
  console.log(this.responseText);
  
 
}


var data={
		name : "Ironman",
		description : "le hero sans pouvoir",
		family : "DC",
		hp : 75,
		energy : 25,
		defence : 35,
		attack : 54,
		imgUrl : "https://thumbs.gfycat.com/CompleteQuarrelsomeFreshwatereel-size_restricted.gif",	
}


var oReq = new XMLHttpRequest();
oReq.addEventListener("load", reqListener);
oReq.open("POST", "rest/servicescard/add");
oReq.send(JSON.stringify(data));