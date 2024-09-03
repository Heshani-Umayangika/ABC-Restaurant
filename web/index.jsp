<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ABC Family Restaurant</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: whitesmoke;
                padding-top: 90px; 
            }

            .navbar {
                min-height: 90px; 
            }

            .navbar-brand {
                font-size: 1.5rem; 
            }

            .navbar-nav .nav-link {
                padding-top: 20px; 
                padding-bottom: 20px;
            }

            .custom-navbar {
                background-color: #000000;
            }
            .jumbotron {
                background-image: url('./images/Restaurant_food.jpg');
                background-size: cover;
                color: #000000;
                text-align: center;
                padding: 120px 20px;
                margin-bottom: 0;
            }

            .section {
                padding: 50px 20px;
            }

            .section-header {
                text-align: center;
                margin-bottom: 40px;
            }

            .card {
                margin-bottom: 20px;
            }

            .btn-custom{
                background-color: black;
                color: white; 
            }

            .btn-custom:hover {
                background-color: dimgrey; 
                color:#fff;
            }
            
            .bg-custom{
                background-color: whitesmoke;
            }
            .bg-card-custom
            {
                 background-color: lightgrey;
            }
        </style>
    </head>
    <body>
        <!-- Navigation bar -->
        <nav class="navbar navbar-expand-lg navbar-dark custom-navbar fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">ABC Restaurant</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#introduction">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#menu">Menu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#offers">Offers</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#facilities">Facilities</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#gallery">Gallery</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contact">Contact</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Login?page=signin">Sign In</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Main content -->
        <div class="jumbotron">
            <h1 class="display-4">ABC Family Restaurant</h1>
            <p class="lead">Providing delightful dining experiences for over a decade.</p>
            <a class="btn btn-custom" href="#menu">Explore Our Menu</a>
        </div>

        <!-- Sections -->

        <div id="introduction" class="section">
            <div class="container">
                <h2 class="section-header">Welcome to ABC Restaurant</h2>
                <p> At ABC Restaurant, we are dedicated to offering high-quality dining experiences to our guests. With a focus on exceptional service, delicious food, and a warm atmosphere, we strive to be your preferred dining destination.</p>

                <h2 class="section-header">Our Vision</h2>
                <p> To be the leading restaurant in our area, known for our culinary excellence, innovation, and customer-centric approach. </p>

                <h2 class="section-header">Our Mission</h2>
                <p>Our mission is to provide outstanding food and service in a welcoming environment, ensuring every guest leaves with a memorable experience. We aim to continually improve our offerings and maintain the highest standards of quality and hospitality.</p>

            </div>
        </div>

        <div id="about" class="section">
            <div class="container">
                <h2 class="section-header">About Us</h2>
                <p>Our restaurant has been serving delicious meals since 2003. With a focus on quality ingredients and innovative recipes, we offer a diverse menu that caters to various tastes and preferences. Our commitment to excellence and customer satisfaction sets us apart in the dining industry.</p>
                <p>Located in the heart of Ibbagamuwa, we offer a cozy and inviting atmosphere perfect for family gatherings, special occasions, and casual dining. Our dedicated team works hard to ensure every visit is enjoyable and memorable.</p>
            </div>
        </div>

        <div id="menu" class="section">
            <div class="container">
                <h2 class="section-header">Our Menu</h2>
                <div class="card bg-card-custom">
                    <div class="card-body">
                        <h3 class="card-title">Explore Our Delicious Offerings</h3>
                        <p class="card-text ">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item bg-custom">Starters</li>
                            <li class="list-group-item">Main Courses</li>
                            <li class="list-group-item bg-custom">Desserts</li>
                            <li class="list-group-item">Beverages</li>
                            <!-- Add more menu items here -->
                        </ul>
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <div id="offers" class="section">
            <div class="container">
                <h2 class="section-header">Special Offers</h2>
                <div class="row">
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Happy Hour</h3>
                                <p class="card-text">Enjoy 50% off on selected appetizers and drinks from 5 PM to 7 PM daily.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Weekend Brunch Special</h3>
                                <p class="card-text">Get a free dessert with every brunch order on Saturdays and Sundays.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Family Feast</h3>
                                <p class="card-text">A special family meal deal that includes a variety of dishes at a discounted price. Available for groups of four or more.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Exclusive Invitations</h3>
                                <p class="card-text">Join our special events and enjoy exclusive dining experiences, complimentary tastings, and meet-and-greets with our chefs.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="facilities" class="section">
            <div class="container">
                <h2 class="section-header">Our Facilities</h2>
                <div class="row">
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Family-Friendly Environment</h3>
                                <p class="card-text">Our restaurant is designed to be welcoming for guests of all ages, with a special menu for children and high chairs available.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Event Hosting</h3>
                                <p class="card-text">Host your next event with us! We offer facilities for birthdays, anniversaries, and other celebrations.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Outdoor Seating</h3>
                                <p class="card-text">Enjoy your meal in our beautiful outdoor seating area with a relaxing atmosphere.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card mb-4 bg-card-custom">
                            <div class="card-body">
                                <h3 class="card-title">Free Wi-Fi</h3>
                                <p class="card-text">Stay connected while you dine with our complimentary high-speed internet access.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="gallery" class="section">
            <div class="container">
                <h2 class="section-header">Gallery</h2>
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <img src="./images/Restaurant_customers.png" class="card-img-top" alt="Gallery Image 1">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <img src="./images/Restaurant_customers.png" class="card-img-top" alt="Gallery Image 2">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <img src="./images/Restaurant_customers.png" class="card-img-top" alt="Gallery Image 3">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="contact" class="section">
            <div class="container">
                <h2 class="section-header">Contact Us</h2>

                <div class="row">
                    <div class="col-md-6">
                        <div class="card mb-3">
                            <div class="card-body">
                                <h3 class="card-title">Visit Us</h3>
                                <p>Kurunegala Road,<br>Ibbagamuwa, 61150</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="card mb-3">
                            <div class="card-body">
                                <h3 class="card-title">Contact Information</h3>
                                <p>Email: info.abc.restaurant@gmail.com<br>Phone: 123-456-7890</p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title">Send Us a Message</h3>
                        <form method="post">
                            <div class="mb-3">
                                <label for="subject" class="form-label">Subject</label>
                                <input type="text" class="form-control" id="subject" required>
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" required>
                            </div>
                            <div class="mb-3">
                                <label for="message" class="form-label">Message</label>
                                <textarea class="form-control" id="message" rows="3" required></textarea>
                            </div>
                            <div class="text-end">
                                <button type="submit" class="btn btn-custom">Send Message</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Scripts -->
        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>

