<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultant</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.16/css/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Dashboard</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Appointments">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#Appointments" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-check-square-o"></i>
            <span class="nav-link-text">Appointments</span>
          </a>
          <ul class="sidenav-second-level collapse" id="Appointments">
            <li>
              <a href="">View Scheduled Appointments</a>
            </li>
          </ul>
        </li>


      </ul>
      <ul class="navbar-nav ml-auto">
      
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-success o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-money"></i>
              </div>
              <div class="mr-5">Accepted Appointments 5</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-danger o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-support"></i>
              </div>
              <div class="mr-5">Rejected Appointments 2</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
      </div>

      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Consultant Availability

     <div class="float-right d-flex">

         <div class="form-group">
           <input type="date" name="" id=""  class="form-control">
            </div>  


         <div class="form-group">
            <select name="" id="" class="form-control">
              <option value="" disabled="" selected="">Country</option>
              <option value="">usa</option>
              <option value="">aus</option>
              <option value="">nz</option>
            </select>
            </div>  

            <div class="form-group">
            <select name="" id="" class="form-control">
              <option value="" disabled="" selected="">Category</option>
              <option value="">IT</option>
              <option value="">Healthcare</option>
              <option value="">Engineering</option>
            </select>
            </div>
     </div>


      </div>

        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
   				  <thead>
				    <tr>
				      <th scope="col">Appointment ID</th>
				      <th scope="col">Job Seeker Name</th>
				      <th scope="col">Job Seeker Address</th>
				      <th scope="col">Job Seeker Phone No</th>
				      <th scope="col">Selected Destination</th>
				      <th scope="col">Job Category</th>
				      <th scope="col">Education</th>
				      <th scope="col">Appointment Date</th>
				      <th scope="col">Appointment Time</th>	
				      <th scope="col">Status</th>					      					      				      				      				      				      
				    </tr>
				  </thead>
				  <tbody>
				  	<tag:forEach var="appointmnet" items="${appointmentRequesttList}">
					    <tr>
					      <td>${appointmnet.appointment_id}</td>
					      <td>${appointmnet.full_name}</td>
					      <td>${appointmnet.address}</td>
					      <td>${appointmnet.phone_no}</td>
					      <td>${appointmnet.selectedDestination}</td>
					      <td>${appointmnet.jobcategory}</td>
					      <td>${appointmnet.education}</td>
					      <td>${appointmnet.appointment_date}</td>
					      <td>${appointmnet.appointment_time}</td>
						  <td>${appointmnet.status}</td>     
					    </tr>
				    </tag:forEach>
				  </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>eSmart Consultants Web Application</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
    

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.5/umd/popper.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.16/js/dataTables.bootstrap4.js"></script>
<script src="./assets/js/script.js"></script>
</body>
</html>