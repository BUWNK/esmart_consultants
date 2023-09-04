<!-- 

<  %@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

 -->
 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Make Appointment</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.16/css/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.5/umd/popper.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.16/js/dataTables.bootstrap4.js"></script>
	<script src="./assets/js/script.js"></script>
</head>
<body>
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="customer-index.jsp">Dashboard</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
customer-index.jsp
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Appointment</a>
        </li>
        <li class="breadcrumb-item active">Make Appointment</li>
      </ol>


      <div class="row justify-content-center">
        <div class="col-md-8">
             <form action="appointment?type=add" method="post">

				<div class="card mb-4">
				    <div class="card-header">
				        <h5 class="card-title">Personal Information</h5>
				    </div>
				    <div class="card-body">
				        <div class="form-group">
				            <input type="text" name="full_name" id="full_name" class="form-control" placeholder="Full Name">
				        </div>
				
				        <div class="row">
				            <div class="col-md-6">
				                <div class="form-group">
				                    <div class="input-group date" id="datetimepicker" data-target-input="nearest">
				                        <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker" name="dob" id="dob" placeholder="Date of Birth"/>
				                        <div class="input-group-append" data-target="#datetimepicker" data-toggle="datetimepicker">
				                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
				                        </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-6">
				                <div class="form-group">
				                    <label class="col-form-label">Gender</label>
				                    <div class="btn-group" data-toggle="buttons">
				                        <label class="btn btn-light active">
				                            <input type="radio" name="gender" id="genderMale" value="Male"> Male
				                        </label>
				                        <label class="btn btn-light">
				                            <input type="radio" name="gender" id="genderFemale" value="Female"> Female
				                        </label>
				                    </div>
				                </div>
				            </div>
				        </div>
				
				        <div class="row">
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="nationality" id="nationality" class="form-control" placeholder="Nationality">
				                </div>
				            </div>
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="passport_no" id="passport_no" class="form-control" placeholder="Passport Number (if available)">
				                </div>
				            </div>
				        </div>
				    </div>
				</div>

              
              <!-- Contact Info -->
              
   				<div class="card mb-4">
				    <div class="card-header">
				        <h5 class="card-title">Contact Information</h5>
				    </div>
				    <div class="card-body">
				        <div class="form-group">
				            <input type="text" name="address" id="address" class="form-control" placeholder="Address">
				        </div>
				
				        <div class="row">
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="phone_no" id="phone_no" class="form-control" placeholder="Phone No">
				                </div>
				            </div>
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="email" id="email" class="form-control" placeholder="Email">
				                </div>
				            </div>
				        </div>
				    </div>
				</div>

              <!-- Education and Qualifications: Info -->				
   				<div class="card mb-4">
				    <div class="card-header">
				        <h5 class="card-title">Education and Professional Qualifications</h5>
				    </div>
				    <div class="card-body">		
				        <div class="row">
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="education" id="education" class="form-control" placeholder="Highest Level of Education">
				                </div>
				            </div>
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="uni_name" id="uni_name" class="form-control" placeholder="University/Institution Name">
				                </div>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="job_title" id="job_title" class="form-control" placeholder="Current Job Title">
				                </div>
				            </div>
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="experience" id="experience" class="form-control" placeholder="Work Experience (Years)">
				                </div>
				            </div>
				        </div>
						<div class="input-group">
						  <div class="custom-file">
						    <input type="file" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04">
						    <label class="custom-file-label" for="inputGroupFile04">Resume/CV Upload</label>
						  </div>
						  <div class="input-group-append">
						    <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">Upload</button>
						  </div>
						</div>			        
				    </div>
				</div>

              <!-- Intended Destination: -->	
   				<div class="card mb-4">
				    <div class="card-header">
				        <h5 class="card-title">Intended Destination</h5>
				    </div>
				    <div class="card-body">		
				        <div class="row">
							<div class="form-group col-md-6">
				            <select name="selectedDestination" id="inputCountry" class="form-control">
				                <option selected>Choose the Intended Destination...</option>
				                <option value="USA">USA</option>
				                <option value="Australia">Australia</option>
				                <option value="New Zealand">New Zealand</option>
				            </select>
							</div>
							
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="preferred_city" id="preferred_city" class="form-control" placeholder="Preferred City or Region">
				                </div>
				            </div>
				        </div>		        
				    </div>
				</div>              

              <!-- Desired Job/Role: -->	
   				<div class="card mb-4">
				    <div class="card-header">
				        <h5 class="card-title">Desired Job/Role</h5>
				    </div>
				    <div class="card-body">		
				        <div class="row">
							<div class="form-group col-md-6">
							  <select name="jobcategory" id="jobcategory" class="form-control">
							  	<option selected>Job Category</option>
							    <option value="IT">IT</option>
							    <option value="Healthcare">Healthcare</option>
							    <option value="Engineering">Engineering</option>
							  </select>
							</div>
							
				            <div class="col-md-6">
				                <div class="form-group">
				                    <input type="text" name="job_role" id="job_role" class="form-control" placeholder="Job Role">
				                </div>
				            </div>
				        </div>		        
				    </div>
				</div> 
				
				 				
				<div class="card mb-4">
				    <div class="card-header">
				        <h5 class="card-title">Schedule Appointment</h5>
				    </div>
				    <div class="card-body">
			
				        <div class="row">
				            <div class="col-md-6">
				                <div class="form-group">
				                    <div class="input-group date" id="datetimepicker" data-target-input="nearest">
				                        <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker" name="appointmnet_date" id="appointmnet_date" placeholder="Date"/>
				                        <div class="input-group-append" data-target="#datetimepicker" data-toggle="datetimepicker">
				                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
				                        </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-6">
					            <div class="col-md-6">
					                <div class="form-group">
					                    <input type="text" name="appointmnet_time" id="appointmnet_time" class="form-control" placeholder="Time">
					                </div>
					            </div>
				            </div>
				        </div>
				    </div>
				</div>
				
              <!-- Other: -->	
   				<div class="card mb-4">
				    <div class="card-header">
				        <h5 class="card-title">Questions or Concernse</h5>
				    </div>
				    <div class="card-body">		
						  <div class="form-group">
						    <label for="exampleFormControlTextarea1">Any additional information not covered in the form</label>
						    <textarea class="form-control" id="exampleFormControlTextarea1" rows="2"></textarea>
						  </div>
						   <div class="form-group form-check">
						    <input type="checkbox" class="form-check-input" id="exampleCheck1">
						    <label class="form-check-label" for="exampleCheck1">Consent for sharing information with migration consultants</label>
						  </div>	        
				    </div>
				</div> 
				<div class="alert alert-success" role="alert" style="display: none;" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for contacting us, we will get back to you shortly.</div>
				
                <div class="row justify-content-center">
                       <button type="submit" class="btn btn-primary">Make Appointment</button>
                </div>
                </br>
            </form>
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
    
<script>
$(document).ready(function () {
    $('#datetimepicker').datetimepicker({
        format: 'YYYY-MM-DD HH:mm',  // Choose the desired date-time format
    });
});

</script>



</body>
</html>