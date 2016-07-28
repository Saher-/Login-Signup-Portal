<!DOCTYPE HTML>
<!--
	Identity by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Identity by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-loading">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="login">
						<form method="POST" action="login">
							<!-- <header> -->
								<span class="avatar"><img src="images/user.jpg" alt="" hight="100" width="100" /></span>
								<input type="text" name="name" id="name" placeholder="Name" required/> <br/>
								<input type="password" name="password" id="password" placeholder="Pin Code" required/> 
								<br/>
								<h6> ${error} </h6>
								<input type="submit" value="Login"/>
							<!-- </header> -->
							<hr />

							<footer>
								<ul style="list-style-type:none">
									<li><a href="#">forgot the pin code, again!</a></li>
									<li><a href="register">Sign me up</a></li>
								</ul>
							</footer>
						</form>
					</div>

				<!-- Footer -->
					<footer id="footer">
						<ul class="copyright">
							<li>&copy; Saher Yakoub</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</footer>
			</div>
	</body>
	<!-- Scripts -->
			<!--[if lte IE 8]><script src="assets/js/respond.min.js"></script><![endif]-->
			<script>
				if ('addEventListener' in window) {
					window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
					document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
				}
			</script>
			<!--script type="text/javascript">
				function register(){
					document.getElementById('login').style.display="none";
					document.getElementById('register').style.display="";
				}
			</script>
			<script type="text/javascript">
				function enroll(){
					document.getElementById('login').style.display="";
					document.getElementById('register').style.display="none";
				}
			</script-->
</html>