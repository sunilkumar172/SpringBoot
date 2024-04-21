<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transfer Error</title>

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
        }

        h2 {
            color: #dc3545;
            margin-bottom: 30px;
        }

        p {
            margin-bottom: 20px;
        }

        .error-message {
            color: #dc3545;
            font-weight: bold;
        }

        .info-message {
            color: #007bff;
        }
    </style>
</head>
<body>

   <div class="container">
        <h2>Transfer Error</h2>

        <% if ("InvalidCredentials".equals(request.getAttribute("errorType"))) { %>
            <p class="error-message">${errorMessage}</p>
            <!-- Display additional information for invalid credentials -->
            <p>Please check your credentials and try again.</p>
        <% } else if ("InsufficientFunds".equals(request.getAttribute("errorType"))) { %>
            <p class="error-message">${errorMessage}</p>
            <!-- Display additional information for insufficient funds -->
            <p>Your account does not have sufficient funds for this transfer.</p>
        <% } else if ("InvalidTransferAmount".equals(request.getAttribute("errorType"))) { %>
            <p class="error-message">${errorMessage}</p>
            <!-- Display additional information for an invalid transfer amount -->
            <p>Please enter a valid transfer amount.</p>
        <% } else if ("UnexpectedError".equals(request.getAttribute("errorType"))) { %>
            <p class="error-message">${errorMessage}</p>
            <!-- Display additional information for unexpected errors -->
            <p>An unexpected error occurred. Please try again later.</p>
        <% } else { %>
            <!-- Handle other error types if needed -->
        <% } %>
    </div>

</body>
</html>