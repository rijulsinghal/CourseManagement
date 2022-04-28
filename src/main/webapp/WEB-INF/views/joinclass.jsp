<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0">
    <title>Join-Class</title>
    </head>
    <style>
        * {
            margin: 0;
             padding: 0;
             user-select: none;
             box-sizing: border-box;
        }

        body {
            background-color: white;
            justify-content: center;
            align-items: center;
            display: flex;
            min-height: 100vh;
        }

        .box{
            background-color: rgba(0,0,0,0.5);
            padding-top: 30px;
            padding: 30px;

        }
        .box h2{
            
            margin-bottom: 40px;
            text-align: center;
            font-size: 26px;
            color: #FFC312;
            font-family: sans-serif;
        }
        input {
            padding: 20px;
            user-select: none;
            height: 50px;
            width: 400px;
            border-radius: 6px;
            border: none;
            border: 2px solid #FFC312;
            outline: none;
            font-size: 22px;
        }

        input::placeholder{
            font-size: 23px;
        } 
        #button {
            font-family: sans-serif;
            font-size: 15px;
            margin-top: 40px;
            border: 2px solid #FFC312;
            width: 155px;
            height: 50px;
            text-align: center;
            background-color: #FFC312;
            display: flex;
            color: rgb(255, 255, 255);
            justify-content: center;
            cursor: pointer;
            border-radius: 5px;  
        }

        .btn2{
            margin-left: 110px
        }

        #button:hover {
            color: white;
            background-color: black;
        }
    </style>
    <body>
        <div class="box">
            <form action="<%= request.getContextPath() %>/joinclass" method="post">
                <h2>Join-Class</h2>
                <div class="input-group form-group">
                    <input type="text" class="form-control" name = "ClassCode" placeholder="Class-Code">
                </div>
                <table>
                    <th><input type="submit" id="button" class="btn2">
                </table>
             </form>
        </div>
   </body>
</html>