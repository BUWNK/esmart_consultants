<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Assign Consultants</title>
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
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="index.html">
            <i class="fa fa-fw fa-tachometer"></i>
            <span class="nav-link-text">Customer 360</span>
          </a>
        </li>
 
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
        <li class="breadcrumb-item active">Assign Appointment</li>
      </ol>  				
      <div class="row justify-content-center"> 
        <div class="col-md-8">
   			<div class="container">
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Appointmnet ID" aria-label="Recipient's username" aria-describedby="basic-addon2">
				  <div class="input-group-append">
				    <button class="btn btn-outline-secondary" type="button">Search</button>
				  </div>
				</div>
   			 </div>
		</div>
        <div class="row justify-content-center">       
   			<div class="container">
				<table class="table table-bordered table-hover">
				  <thead class="thead-info">
				    <tr class="table-info">
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
				      <th scope="col">Approve/Reject</th>
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
						  <td>
					      	<form action="approval?type=approve" method="post">					      		
									<div class="mb-3">
									  <select class="form-select" name="approve" id="approve">
									    <option value="accept">Accept</option>
									    <option value="reject">Reject</option>
									  </select>
									</div>
					      		<input type="hidden" name="appointment_id" id="appointment_id" value="${appointmnet.appointment_id}">
								<button type="submit" class="btn btn-success">Confirm</button>
					      	</form>
						  </td>	
					    </tr>
				    </tag:forEach>
				  </tbody>
				</table>
			</div>	
        </div>
      </div>

    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Smart-Consultants Web Application 2023</small>
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
              <span aria-hidden="true">�</span>
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
    
<script>
  function updateCategory(selectedCategory) {
    var brand = document.getElementById("brand");
    brand.innerHTML = ""; // Clear previous options
    
    if (selectedCategory === "electronic") {
      brand.innerHTML += '<option value="samsung">Samsung</option>';
      brand.innerHTML += '<option value="xiaomi">Xiaomi</option>';
    } else if (selectedCategory === "fashion") {
      brand.innerHTML += '<option value="polo">polo</option>';
      brand.innerHTML += '<option value="embark">Embark</option>';
  }
}
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.5/umd/popper.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.16/js/dataTables.bootstrap4.js"></script>
<script src="./assets/js/script.js"></script>


</body>
</html>