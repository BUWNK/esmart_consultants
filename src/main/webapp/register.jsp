<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet"/>

    <link rel="stylesheet" href="./assets/css/main.css">
    <script>
        function validateForm() {
            const username = document.getElementById("username").value;
            const name = document.getElementById("name").value;
            const password = document.getElementById("password").value;
            const rePassword = document.getElementById("re-password").value;

            const errorDiv = document.getElementById("error-message");
            errorDiv.innerHTML = ""; // Clear previous error messages

            const emailError = document.getElementById("emailError");
            const passwordError = document.getElementById("passwordError");
            emailError.textContent = ""; // Clear previous error messages
            passwordError.textContent = ""; // Clear previous error messages

            let isValid = true;

            if (username === "" || name === "" || password === "" || rePassword === "") {
                errorDiv.innerHTML = "All fields are required.";
                isValid = false;
            }

            if (password !== rePassword) {
                errorDiv.innerHTML = "Passwords do not match.";
                isValid = false;
            }

            if (username === "") {
                emailError.textContent = "Email is required.";
                isValid = false;
            }

            if (password === "") {
                passwordError.textContent = "Password is required.";
                isValid = false;
            }

            return isValid;
        }
    </script>
</head>
<body>

    <section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
	            <div class="col-md-6 col-lg-4 col-xl-4">
	                <img src="http://178.128.92.244/lg/resources/img/graphic.svg"
	                     class="img-fluid" alt="Sample image">
	            </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                    <form onsubmit="return validateForm()">
                        <div class="text-center d-flex flex-row align-items-center justify-content-center">
                            <h2 class="fw-normal mb-4 me-3">eSmart Consultant Service</h2>
                        </div>

                        <h5 class="fw-normal mb-4 me-3">Sign Up</h5>

                        <!-- Email input -->
                        <div class="form-group">
                            <input type="text" name="username" id="username" class="form-control border form-control-lg" placeholder="Email">
                            <div id="emailError" class="text-danger mt-2"></div>
                        </div>
                        <br/>
                        <div class="form-group">
                            <input type="text" name="name" id="name" class="form-control border form-control-lg" placeholder="Full Name">
                        </div>
                        <br/>
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control border form-control-lg" placeholder="Password">
                            <div id="passwordError" class="text-danger mt-2"></div>
                        </div>
                        <br>
                        <div class="form-group">
                            <input type="password" name="re-password" id="re-password" class="form-control border form-control-lg" placeholder="Re-enter Password">
                        </div>
                        <div id="error-message" class="text-danger mt-2"></div>
                        <div class="text-center text-lg-start mt-4 pt-2">
                            <button type="submit" class="btn btn-primary btn-lg w-100"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

</body>
</html>