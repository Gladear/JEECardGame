$(document).ready(function () {
  $.ajax({
    url: "/api/user/current",
    method: "GET",
    headers: {
      Authenticate: localStorage.getItem("userId"),
    },
    success: function (result) {
      document.getElementById("username").innerHTML = result.name;
      document.getElementById("money").innerHTML = result.money;
      $.ajax({
        url: "/api/sale/",
        method: "GET",
        success: function (sales) {
          for (let i = 0; i < sales.length; i++) {
            const sale = sales[i];
            $.ajax({
              url: "/api/card/" + sale.cardId,
              success(data) {
                $.ajax({
                  url: "/api/user/" + data.ownerId,
                  success(owner) {
                    if (i == 0) {
                      fillCurrentCard(
                        sale.id,
                        data.template.imgUrlFamily,
                        data.template.family,
                        data.template.imgUrl,
                        data.template.name,
                        data.template.description,
                        data.template.hp,
                        data.template.energy,
                        data.template.attack,
                        data.template.defense,
                        owner.name,
                        sale.price
                      );
                    }

                    addCardToList(
                      sale.id,
                      data.template.imgUrlFamily,
                      data.template.family,
                      data.template.imgUrl,
                      data.template.name,
                      data.template.description,
                      data.template.hp,
                      data.template.energy,
                      data.template.attack,
                      data.template.defense,
                      owner.name,
                      sale.price
                    );
                  },
                });
              },
            });
          }
        },
      });
    },
    error: function (result) {
      window.location.replace("/formSample.html");
    },
  });
});

function fillCurrentCard(
  id,
  imgUrlFamily,
  familyName,
  imgUrl,
  name,
  description,
  hp,
  energy,
  attack,
  defence,
  owner,
  price
) {
  //FILL THE CURRENT CARD
  $("#cardFamilyImgId")[0].src = imgUrlFamily;
  $("#cardFamilyNameId")[0].innerText = familyName;
  $("#cardImgId")[0].src = imgUrl;
  $("#cardNameId")[0].innerText = name;
  $("#cardDescriptionId")[0].innerText = description;
  $("#cardHPId")[0].innerText = hp + " HP";
  $("#cardEnergyId")[0].innerText = energy + " Energy";
  $("#cardAttackId")[0].innerText = attack + " Attack";
  $("#cardDefenceId")[0].innerText = defence + " Defence";
  $("#cardPriceId")[0].innerText = price + " $";
  $("#buttonBuyCard").off();
  $("#buttonBuyCard").on("click", function () {
    buyCard(id);
  });
}

function addCardToList(
  id,
  imgUrlFamily,
  familyName,
  imgUrl,
  name,
  description,
  hp,
  energy,
  attack,
  defence,
  owner,
  price
) {
  content =
    "\
    <td> \
    <img  class='ui avatar image' src='" +
    imgUrl +
    "'> <span>" +
    name +
    " </span> \
   </td> \
    <td>" +
    description +
    "</td> \
    <td>" +
    familyName +
    "</td> \
    <td>" +
    hp +
    "</td> \
    <td>" +
    energy +
    "</td> \
    <td>" +
    attack +
    "</td> \
    <td>" +
    defence +
    "</td> \
    <td>" +
    owner +
    "</td>\
    <td>" +
    price +
    "$</td>\
    <td>\
        <div class='ui vertical animated button' tabindex='0' onClick=\"buyCard(" +
    id +
    ")\">\
            <div class='hidden content'>Buy</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";

  $("#cardListId tr:last").after(
    `<tr onClick="fillCurrentCard(${id},'${imgUrlFamily}','${familyName}','${(
      imgUrl || ""
    ).replace(
      /\//g,
      "/"
    )}','${name}','${description}',${hp},${energy},${attack},${defence},'${owner}',${price})">${content}</tr>`
  );
}

function buyCard(id) {
  console.log("sale/buy?saleId=" + id);
  $.ajax("/api/sale/buy?saleId=" + id, {
    method: "POST",
    headers: {
      Authenticate: localStorage.getItem("userId"),
    },
    success: function (user) {
      alert("Carte achetée!");
      window.location.reload();
    },
    error: function (a) {
      console.log("error", a);
      alert("carte pas achetée");
    },
  });
}
