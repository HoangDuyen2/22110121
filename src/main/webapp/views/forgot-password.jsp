<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/9/2024
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!doctype html>
<html class="no-js" lang="en">

<!-- Mirrored from new.axilthemes.com/demo/template/etrade/sign-up.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 14 Oct 2024 00:33:30 GMT -->
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>eTrade || Sign In</title>
  <meta name="robots" content="noindex, follow" />
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="admin/assets/images/favicon.png">

  <!-- CSS
  ============================================ -->

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="admin/assets/css/vendor/bootstrap.min.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/font-awesome.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/flaticon/flaticon.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/slick.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/slick-theme.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/jquery-ui.min.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/sal.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/magnific-popup.css">
  <link rel="stylesheet" href="admin/assets/css/vendor/base.css">
  <link rel="stylesheet" href="admin/assets/css/style.min.css">

</head>


<body>
<div class="axil-signin-area">

  <!-- Start Header -->
  <div class="signin-header">
    <div class="row align-items-center">
      <div class="col-xl-4 col-sm-6">
        <a href="" class="site-logo"><img src="admin/assets/images/logo/logo.png" alt="logo"></a>
      </div>
      <div class="col-md-2 d-lg-block d-none">
        <a href="${pageContext.request.contextPath}/login" class="back-btn"><i class="far fa-angle-left"></i></a>
      </div>
      <div class="col-xl-6 col-lg-4 col-sm-6">
        <div class="singin-header-btn">
          <p>Already a member?</p>
          <a href="${pageContext.request.contextPath}/login" class="sign-up-btn axil-btn btn-bg-secondary">Sign In</a>
        </div>
      </div>
    </div>
  </div>
  <!-- End Header -->

  <div class="row">
    <div class="col-xl-4 col-lg-6">
      <div class="axil-signin-banner bg_image bg_image--10">
        <h3 class="title">We Offer the Best Products</h3>
      </div>
    </div>
    <div class="col-lg-6 offset-xl-2">
      <div class="axil-signin-form-wrap">
        <div class="axil-signin-form">
          <h3 class="title">Forgot Password?</h3>
          <p class="b2 mb--55">Enter the email address you used when you joined and we’ll send you instructions to reset your password.</p>
          <form class="singin-form" action="${pageContext.request.contextPath}/forgot-password" method="post">
            <div class="form-group">
              <label>Email</label>
              <input type="email" class="form-control" name="email" value="annie@example.com">
            </div>
            <div class="form-group">
              <label>New password</label>
              <input type="password" class="form-control" name="password" value="123456789">
            </div>
            <div class="form-group">
              <label>Confirm password</label>
              <input type="password" class="form-control" name="re-password" value="123456789">
            </div>
            <div class="form-group">
              <button type="submit" class="axil-btn btn-bg-primary submit-btn">Reset password</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- JS
============================================ -->
<!-- Modernizer JS -->
<script src="admin/assets/js/vendor/modernizr.min.js"></script>
<!-- jQuery JS -->
<script src="admin/assets/js/vendor/jquery.js"></script>
<!-- Bootstrap JS -->
<script src="admin/assets/js/vendor/popper.min.js"></script>
<script src="admin/assets/js/vendor/bootstrap.min.js"></script>
<script src="admin/assets/js/vendor/slick.min.js"></script>
<script src="admin/assets/js/vendor/js.cookie.js"></script>
<!-- <script src="assets/js/vendor/jquery.style.switcher.js"></script> -->
<script src="admin/assets/js/vendor/jquery-ui.min.js"></script>
<script src="admin/assets/js/vendor/jquery.ui.touch-punch.min.js"></script>
<script src="admin/assets/js/vendor/jquery.countdown.min.js"></script>
<script src="admin/assets/js/vendor/sal.js"></script>
<script src="admin/assets/js/vendor/jquery.magnific-popup.min.js"></script>
<script src="admin/assets/js/vendor/imagesloaded.pkgd.min.js"></script>
<script src="admin/assets/js/vendor/isotope.pkgd.min.js"></script>
<script src="admin/assets/js/vendor/counterup.js"></script>
<script src="admin/assets/js/vendor/waypoints.min.js"></script>

<!-- Main JS -->
<script src="admin/assets/js/main.js"></script>

</body>


<!-- Mirrored from new.axilthemes.com/demo/template/etrade/forgot-password.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 14 Oct 2024 00:33:30 GMT -->
</html>