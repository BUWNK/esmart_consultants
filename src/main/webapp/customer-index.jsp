<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Texas Lawers</title>

        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
        <link href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
        <link href="resources/css/owl.carousel.css" rel="stylesheet">
        <link href="resources/css/owl.carousel.theme.min.css" rel="stylesheet">
        <link href="resources/css/main.css" rel="stylesheet">

        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body data-spy="scroll" data-target="#main-navbar">

        <!-- NavigationBar Section -->
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-navbar" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="main-navbar">
                  <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="#header">Home <span class="sr-only">(current)</span></a></li>
               
                    <li><a href="#contact">Contact</a></li>
                  </ul>
                </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
                </nav>

        <!-- Header Section -->
            <header id="header" class="header overlay-dark">
                <div class="container">
                    <div class="row">
					<div class="col-sm-6 col-sm-offset-3">
					    <div class="intro-box c-table">
					        <div class="intro ct-cell">
					            <h1>eSmart Consultant Service</h1>
					        </div>
					    </div>
					    <a class="btn btn-primary btn-lg btn-header" href="make-appointment.jsp">Make an Appointment</a>
					</div>
                    </div>
                </div>
            </header>

        <!-- Fun Facts -->
            <section id="fun" class="fun">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="title-box">
                                <p class="section-subtitle">We are known by</p>
                                <h2 class="section-title">Who we are</h2>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="fun-box">
                                <p class="fun-number">2000+</p>
                                <p class="fun-title">Cases were faught</p>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="fun-box">
                                <p class="fun-number">96.5%</p>
                                <p class="fun-title">Cases have been won</p>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="fun-box">
                                <p class="fun-number">$25k</p>
                                <p class="fun-title">Money Recovered</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>


       
        

     
               <!-- Contact -->
            <section id="contact" class="contact">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="title-box">
                                <p class="section-subtitle">You may want to</p>
                                <h2 class="section-title">Contact us</h2>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                          
                            <p>
                                This is Texas Lawyers, an awesome template for Lawyers. It provides everything and more for a lower. Search no more, Download this now.This is Texas Lawyers, an awesome template for Lawyers.
                            </p>
                            <ul>
                                <li><span class="ion-location"></span>322, Adress, Lorem Ipsum Avenue, London, Earth</li>
                                <li><span class="ion-android-call"></span>(888) 123-456-7890</li>
                                <li><span class="ion-paper-airplane"></span>thisisfakeemail@noreply.com</li>
                            </ul>
                        </div>
                        <div class="col-sm-6">
                            <form id="contactForm" action="php/contact_form.php" method="post">
                                <div class="input-group">      
                                    <span class="input-group-addon">
                                        <i class="ion-person"></i>
                                    </span> 
                                    <input class="form-control" type="text" placeholder="Name" name="name" required>
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="ion-email"></i>
                                    </span>
                                    <input class="form-control" name="email" type="email" placeholder="Email address" required>
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon custom-addon">
                                        <i class="ion-chatbubbles"></i>
                                    </span>
                                    <textarea class="form-control" rows="8" placeholder="Write Message" name="message"></textarea>
                                </div>
                                <button id="cfsubmit" type="submit" class="btn btn-default btn-block">Send your Message <span class="ion-paper-airplane"></span></button>
                            </form>

                            <div id="contactFormResponse"></div>
                        </div>
                    </div>
                </div>
            </section>
       <!-- Footer -->
            <footer class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>

                            </p>
                        </div>
                        <div class="col-sm-6">
                            <div class="footer-social">
                                <a href="#"><i class="ion-social-facebook"></i></a>
                                <a href="#"><i class="ion-social-linkedin-outline"></i></a>
                                <a href="#"><i class="ion-social-skype-outline"></i></a>
                                <a href="#"><i class="ion-social-twitter"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        
        <!-- Scripts -->
        <script src="resources/js/jquery-1.12.3.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
        <script src="resources/js/owl.carousel.min.js"></script>
        <script src="resources/js/script.js"></script>
    </body>
</html>

 