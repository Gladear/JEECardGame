
function reqListener () {
  console.log(this.responseText);
  var data = JSON.parse(this.responseText);
  if(data){
	  $('#cardFamilyImgId')[0].src=data.imgUrl
	  $('#cardFamilyNameId')[0].innerText=data.family;
	  $('#cardImgId')[0].src=data.imgUrl
	  $('#cardNameId')[0].innerText=data.name
	  $('#cardDescriptionId')[0].innerText=data.description
	  $('#cardHPId')[0].innerText=`${data.hp} HP`;
	  $('#cardEnergyId')[0].innerText=`${data.energy} Energy`;
	  $('#cardAttackId')[0].innerText=`${data.attack} Attack`;
	  $('#cardDefenceId')[0].innerText=`${data.defence} Defence`;
	  
  }else{
	  $('#notif')[0].innerText = "Hero inconnu"
  }
 
}


var querySearch =  window.location.search.replace("?","").split(",").map(query=>{return query.split("=")}).find(n=>n[0]=="search")
console.log(querySearch)
if(querySearch){
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", reqListener);
	oReq.open("GET", "rest/servicescard/find?name="+querySearch[1]);
	oReq.send();
}else{
	$('#notif')[0].innerText = "Choissisez un hero"
}





