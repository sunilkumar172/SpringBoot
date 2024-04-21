<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Check Balance Result</title>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
            color: #333;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #007bff;
            margin-bottom: 20px;
            font-size: 24px;
        }

        p {
            margin-bottom: 20px;
            font-size: 16px;
        }

        .error-message {
            color: #dc3545;
            font-weight: bold;
            font-size: 18px;
        }

        .back-link {
            color: #007bff;
            text-decoration: none;
            font-size: 16px;
            display: inline-block;
            margin-top: 20px;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Check Balance Result</h2>

        <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
        <% } else { %>
            <p><strong>Name:</strong> <%= request.getAttribute("name") %></p>
            <p><strong>Account Number:</strong> <%= request.getAttribute("accountNumber") %></p>
            <p><strong>Balance:</strong> $<%= request.getAttribute("balance") %></p>
        <% } %>

        <a href="/" class="back-link">Back to Home Page</a>
    </div>

</body>
</html>