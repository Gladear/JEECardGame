<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Standard Meta -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

        <!-- Site Properties -->
        <title>Grid Example - Semantic</title>

        <link rel="stylesheet" type="text/css" href="lib/Semantic-UI-CSS-master/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="css/custom.css">

    </head>

    <body>
        <div class="ui five column grid">
            <div class="row"></div>
            <div class="row">
                <div class="five column"></div>
            </div>
            <div class="column"></div>
            <div class="column"></div>
            <div class="column">
                <form class="ui form" action="./getCard" method="GET" name="mySearch">
                    <h3 class="ui dividing header">Select the Card Name to Search</h3>
                    <div class="two fields">
                        <div class="field">
                            <label>Card Name</label>
                        </div>
                        <div class="field">
                            <div class="ui transparent icon input">
                                <input type="text" placeholder="Search..." name="search">
                                <i class="search link icon"  onclick="mySearch.submit();"></i>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="column"></div>
            <div class="column"></div>
        </div>
        <!------------------------------------------------------------------------->
        <!--    ----------------------------- CARD ----------------------------- -->
        <!------------------------------------------------------------------------->

        <div class="ui five column grid">
            <div class="column"></div>
            <div class="column"></div>
            <div class="column">
                <div class="ui special cards">
                	<c:forEach items="${requestScope.cards}" var="card">
						<div class="card">
	                        <div class="content">
	                            <img class="ui avatar image" src="${card.imgUrl}" /> ${card.family}
	                        </div>
	                        <div class="image imageCard">
	                            <div class="blurring dimmable image">
	                                <div class="ui inverted dimmer">
	                                    <div class="content">
	                                        <div class="center">
	                                            <div class="ui primary button">Add Friend</div>
	                                        </div>
	                                    </div>
	                                </div>
	                                <img class="ui centered tiny image" src="${card.imgUrl}">
	                            </div>
	                        </div>
	                        <div class="content">
	                            <div class="ui form tiny">
	                                <div class="field">
	                                    <label>${card.name}</label>
	                                    <textarea class="overflowHiden" readonly rows="5">${card.description}</textarea>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="content">
	                            <i class="heart outline icon"></i><span>${card.hp}</span> 
	                            <div class="right floated ">
	                                <i class="lightning outline icon"></i>
	                                <span>${card.energy}</span> 
	                            </div>
	                        </div>
	                        <div class="content">
	                            <span class="right floated">
	                                <i class=" wizard icon"></i>
	                                <span>${card.attack}</span> 
	                            </span>
	                            <i class="protect icon"></i>
	                           <span>${card.defence}</span> 
	                        </div>
	                    </div>
					</c:forEach>
                </div>
            </div>
        </div>
        <script src="./lib/Semantic-UI-CSS-master/semantic.js"></script>
    </body>
</html>