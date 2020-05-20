<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div class="column"></div>
            <div class="column"></div>
            <div class="column">
                <form class="ui form" method="POST">
                    <h3 class="ui dividing header">Add Card Form</h3>
                    <div class="field">
                        <label>Name</label>
                        <input type="text" name="name" placeholder="First Name">
                    </div>
                    <div class="field">
                        <label>Description</label>
                        <textarea name="description"></textarea>
                    </div>
                    <div class="field">
                        <label>Image URL</label>
                        <input type="url" name="image-url" placeholder="First Name">
                    </div>
                    <div class="field">
                    	<label>Family</label>
                    	<select name="family">
                    		<option value="DC">DC</option>
                    		<option value="Marvel">Marvel</option>
                    	</select>
                    </div>
                    <div class="field">
                    	<label>HP</label>
                    	<input name="hp" type="range" min="0" max="100" />
                    </div>
                    <div class="field">
                    	<label>Energy</label>
                    	<input name="energy" type="range" min="0" max="20" />
                    </div>
                    <div class="field">
                    	<label>Attack</label>
                    	<input name="attack" type="range" min="0" max="10" />
                    </div>
                    <div class="field">
                    	<label>Defense</label>
                    	<input name="defense" type="range" min="0" max="10" />
                    </div>
                    <button class="ui button" type="submit">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>