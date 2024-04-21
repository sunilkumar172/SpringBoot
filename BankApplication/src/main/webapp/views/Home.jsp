<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SDFC Bank</title>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
            color: #333;
        }

        h2 {
            color: #007bff;
            margin-top: 20px;
            font-size: 28px;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 20px 0;
            display: flex;
            justify-content: center;
            background-color: #007bff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        li {
            margin: 0;
        }

        li a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            padding: 15px 20px;
            display: inline-block;
            transition: background-color 0.3s;
        }

        li a:hover {
            background-color: #0056b3;
        }

        hr {
            border: none;
            border-top: 1px solid #ddd;
            margin: 20px 0;
        }

        .welcome-message {
            font-size: 18px;
            color: #666;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

    <h2>Welcome to SDFC Bank</h2>

    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="newAccount">New Account</a></li>
        <li><a href="balance">Check Balance</a></li>
        <li><a href="deposit">Deposit</a></li>
        <li><a href="withdraw">Withdraw</a></li>
        <li><a href="transfer">Transfer</a></li>
        <li><a href="closeAccount">Close Account</a></li>
        <li><a href="about">About</a></li>
    </ul>

    <hr>

    <div class="welcome-message">
        <p>Welcome to SDFC Bank. Manage your accounts with ease.</p>
    </div>
    
    
    
    
</body>
</html>