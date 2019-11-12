<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="footer-area">
	<!-- Top Footer Area -->
	<div class="top-footer-area">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Footer Logo -->
					<div class="footer-logo">
					</div>
					<!-- Copywrite -->
					<p><a href="#" data-toggle="modal" data-target="#modalLoginForm">관리자 로그인</a></p>
					<p>
						<a href="#"> <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with 
							<i class="fa fa-heart-o" aria-hidden="true"></i> by Colorlib
					</p>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- ##### All Javascript Script ##### -->

<!-- Modal Admin Login Form -->
<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">로그인</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mx-2" style="background:#73C6B6;">
        <div class="md-form mb-5">
          <label data-error="wrong" data-success="right" for="defaultForm-email">ID</label>
          <input type="email" id="defaultForm-email" class="form-control validate">
        </div>

        <div class="md-form mb-4">
          <label data-error="wrong" data-success="right" for="defaultForm-pass">Password</label>
          <input type="password" id="defaultForm-pass" class="form-control validate">
        </div>

      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="btn btn-default">Login</button>
      </div>
    </div>
  </div>
</div>
<!-- All Plugins js -->
<script src="/resources/js/plugins/plugins.js"></script>
<!-- Active js -->
<script src="/resources/js/active.js"></script>
</body>
</html>