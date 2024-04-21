<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transfer Successful</title>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            text-align: center;
            color: #343a40;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            opacity: 0; /* Initial opacity set to 0 for animation */
            animation: fadeIn 1s forwards; /* Animation properties */
        }

        .loaded .container {
            opacity: 1; /* Set opacity to 1 when the page is loaded */
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        h2 {
            color: #28a745;
            margin-bottom: 30px;
        }

        p {
            margin-bottom: 20px;
        }

        .success-message {
            color: #28a745;
            font-weight: bold;
        }

        .info-message {
            color: #007bff;
        }

        .home-link {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body class="loaded"> <!-- Add loaded class to body -->
    <div class="container">
        <h2>Transfer Successful</h2>

        <p class="success-message">${message}</p>

        <!-- Display additional information if needed -->
        <p>${details}</p>

        <!-- Display a thank you message -->
        <p class="info-message">Thanks for choosing the SDFC Bank service.</p>

        <!-- Home link -->
        <p><a class="home-link" href="/">Home</a></p>
    </div>
</body>
</html>