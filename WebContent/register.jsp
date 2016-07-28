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
		<link rel="stylesheet" href="assets/css/signup_progress_style.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-loading">
		<!-- Wrapper -->
			<div id="wrapper">
				<div id="register">
					<progress value="75" max="100"></progress>
					<span class="done" id="check" style="display:none;">&#10004;</span>
					<form method="post" action="#" id="signUp1">
						<span class="avatar"><img src="images/user.jpg" alt="" hight="50" width="50" /></span>
						<h2>Sign Up - General Info</h2>
						<div class="field">
							<input type="text" name="name" id="name" placeholder="Name" required/>
						</div>
						<div class="field">
							<input type="password" name="password" id="password" placeholder="Pin Code" required/>
						</div>
						<div class="field">
							<input type="password" name="password" id="passwordC" placeholder="Confirm Pin Code" required/>
						</div>
						<!-- <a href="#" class="button" onclick="next()">Next</a> -->
						<input type="button" value="Next &#8611;" onclick="customSubmit()"/>
					</form>

					<form method="post" action="#" id="signUp2" style="display:none;">
						<span class="avatar"><img src="images/user.jpg" alt="" hight="50" width="50" /></span>
						<h2>Sign Up - Security Info</h2>
						<div class="field">
							<input type="email" name="email" id="email" placeholder="Email" required/>
						</div>
						<div class="field">
							<input type="tel" name="phone" id="phone" placeholder="Phone Number" required/>
						</div>
						<!-- <div class="field datefield"> -->
							<label>Date Of Birth</label>
							<div class="datefield">
								<input id="day"  type="db" maxlength="2" placeholder="DD"/> /
    							<input id="month" type="db" maxlength="2" placeholder="MM"/>/
    							<input id="year" type="db" maxlength="4" placeholder="YYYY"/>
							</div>
						<!-- </div>  -->
						<br/>
						<input type="button" value="&#8612; Previous" onclick="prev()"/>
						<input type="button" value="Next &#8611;" onclick="customSubmit()"/>
					</form>

					<form method="post" action="#" id="signUp3" style="display:none;">
						<span class="avatar"><img src="images/user.jpg" alt="" hight="50" width="50" /></span>
						<h2>Sign Up - Preference Info</h2>
						<label>Reading Preferences:</label>
						<table id="preferences">
							<tr>
								<td>
									<input type="checkbox" name="book_cat[]" id="Literature" />
									<label for="Literature">Literature</label>
								</td>
								<td>
									<input type="checkbox" name="book_cat[]" id="Poetry" />
									<label for="Poetry">Poetry</label>
								</td>
							</tr>
								<td>
									<input type="checkbox" name="book_cat[]" id="Bibles &#38; Christianity" />
									<label for="Bibles &#38; Christianity">Bibles &#38; Christianity</label>
								</td>
								<td>
									<input type="checkbox" name="book_cat[]" id="Science" />
									<label for="Science">Science</label>
								</td>
							<tr>
							</tr>
							<tr>
								<td>
									<input type="checkbox" name="book_cat[]" id="History" />
									<label for="History">History</label>
								</td>
								<td>
									<input type="checkbox" name="book_cat[]" id="Biography" />
									<label for="Biography">Biography</label>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" name="book_cat[]" id="Technology &#38; Computers" />
									<label for="Technology &#38; Computers">Technology &#38; Computers</label>
								</td>
								<td>
									<input type="checkbox" name="book_cat[]" id="Education" />
									<label for="Education">Education</label>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" name="book_cat[]" id="Foreign Languages" />
									<label for="Foreign Languages">Foreign Languages</label>
								</td>
								<td>
									<input type="checkbox" name="book_cat[]" id="Religion" />
									<label for="Religion">Religion</label>
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" name="book_cat[]" id="NY Times&#174; Bestsellers" />
									<label for="NY Times&#174; Bestsellers">NY Times&#174; Bestsellers</label>
								</td>
								<td>
									<input type="checkbox" name="book_cat[]" id="Travel" />
									<label for="Travel">Travel</label>
								</td>
							</tr>
						</table>
						<div class="field"></div>
						<div class="field"></div>
						<label>Language Preferences:</label>
						<table id="language">
							<tr>
								<td>
									<input type="checkbox" name="lang[]" id="English" />
									<label for="English">English</label>
								</td>
								<td>
									<input type="checkbox" name="lang[]" id="Arabic" />
									<label for="Arabic">Arabic</label>
								</td>
								<td>
									<input type="checkbox" name="lang[]" id="español" />
									<label for="español">español</label>
								</td>
							</tr>
						</table>

						<input type="button" value="&#8612; Previous" onclick="prev()"/>
						<input type="button" value="Next &#8611;" onclick="customSubmit()"/>
					</form>

					<form method="post" action="#" id="signUp4" style="display:none;">
						<span class="avatar"><img src="images/user.jpg" alt="" hight="50" width="50" /></span>
						<h2>Saving Your Info</h2>
						<div class="loader"></div>
						<br/>
						<p>Preparing your profile.</p>
					</form>
					<form method="POST" action="register" name="final" style="display:none;">
						<input type="hidden" id="f_name" name="f_name"/>
						<input type="hidden" id="f_pin" name="f_pin"/>
						<input type="hidden" id="f_email" name="f_email"/>
						<input type="hidden" id="f_phone" name="f_phone"/>
						<input type="hidden" id="f_dob" name="f_dob"/>
						<input type="hidden" id="f_pref" name="f_pref"/>
						<input type="hidden" id="f_lang" name="f_lang"/>
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

			<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
			<script src="assets/js/submit_progress.js"></script>

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