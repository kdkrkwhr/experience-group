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
					<c:if test="${empty sessionAdmin }">
						<p><a href="#" data-toggle="modal" data-target="#modalLoginForm">관리자 로그인</a></p>
					</c:if>
					<c:if test="${not empty sessionAdmin }">
						<p><a href="#" id="logOut">로그아웃</a></p>					
					</c:if>
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
          <label data-error="wrong" data-success="right" for="defaultForm-email">E-Mail</label>
          <input type="text" id="adminEmail" name="adminEmail" class="form-control validate">
        </div>

        <div class="md-form mb-4">
          <label data-error="wrong" data-success="right" for="defaultForm-pass">Password</label>
          <input type="password"  id="adminPassword" name="adminPassword" class="form-control validate">
        </div>

      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="btn btn-default" id="loginBtn" name="loginBtn"><strong>로그인</strong></button>
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