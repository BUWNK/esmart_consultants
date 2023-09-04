<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet"/>

    <link rel="stylesheet" href="./assets/css/main.css">
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
                <form onsubmit="return validateForm()" action="login?type=login" method="post">
                    <div class="text-center d-flex flex-row align-items-center justify-content-center">
                        <h2 class="fw-normal mb-4 me-3">eSmart Consultant Service</h2>
                    </div>

                    <h5 class="fw-normal mb-4 me-3">Sign In</h5>

                    <!-- Email input -->
                    <div class="form-group">
                        <input type="text" name="email" id="email" class="form-control border form-control-lg"  placeholder="Email">
                        <span id="emailError" class="text-danger"></span> <!-- Validation message -->
                    </div>
                    <br/>

                    <!-- Password input -->
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control border form-control-lg"  placeholder="Password">
                        <span id="passwordError" class="text-danger"></span> <!-- Validation message -->
                    </div>

                    <div class="d-flex justify-content-between align-items-center">
                        <!-- Checkbox -->
                        <div class="form-check mb-0">
                            <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                            <label class="form-check-label" for="form2Example3">
                                Remember me
                            </label>
                        </div>
                        <a href="#!" class="text-body">Forgot password?</a>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg w-100"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="register.jsp"
                                                                                            class="link-danger">Register</a></p>
                    </div>

                </form>
            </div>
        </div>
    </div>
</section>

<script>
    function validateForm() {
        var emailField = document.getElementById('email');
        var passwordField = document.getElementById('password');
        var emailError = document.getElementById('emailError');
        var passwordError = document.getElementById('passwordError');
        var isValid = true;

        // Reset previous error messages
        emailError.textContent = '';
        passwordError.textContent = '';

        if (emailField.value === '') {
            emailError.textContent = 'Email is required.';
            isValid = false;
        }

        if (passwordField.value === '') {
            passwordError.textContent = 'Password is required.';
            isValid = false;
        }

        return isValid;
    }
</script>
</body>
</html>
