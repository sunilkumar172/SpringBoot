<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url('background-image.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            color: #fff;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
        }

        h2 {
            color: #007bff;
            margin-bottom: 30px;
        }

        p {
            margin-bottom: 20px;
            color: #333;
        }

        .contact-info {
            font-weight: bold;
            color: #333;
        }

        .chat-button {
            padding: 15px 20px;
            background-color: #25d366;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .chat-button:hover {
            background-color: #128c7e;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>About Us</h2>

        <p>Welcome to SDFC Bank, where your financial needs are our priority. We strive to provide excellent banking services to our valued customers.</p>

        <p>For any inquiries, please feel free to reach out to us:</p>

        <p class="contact-info">Email: <a href="mailto:info@sdfcbank.com">info@sdfcbank.com</a></p>

        <p class="contact-info">Phone: + (91) 703-6012-486</p>

        <!-- WhatsApp chat button -->
        <a href="https://wa.me/917036012486" class="chat-button" target="_blank">Chat on WhatsApp</a>
    </div>

</body>
</html>