<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<asset:javascript src="jquery-2.2.1.min.js"/>
		<asset:stylesheet src="bootstrap.min.css"/>
		<asset:stylesheet src="bootstrap-theme.min.css"/>
		<asset:stylesheet src="font-awesome.min.css"/>
		<asset:javascript src="bootstrap.min.js"/>



	<style>

	a{
		text-decoration:underline;
	}

	#search-panel{
		border:solid black;
		border-radius:8px;
	}

	a{
		text-decoration:underline;
	}
	#search-panel{
		border:solid black;
		border-radius:8px;
	}
	.btn:focus {
		outline: none;
	}

	</style>


		<g:layoutHead/>
	</head>
	<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-default">
					<div class="panel-body" style="border:3px solid black;border-radius:8px">
						<div class="col-xs-4">
							<a href="#" style="font-size:28px">Link Sharing</a>
						</div>
						<div class="col-xs-3">
							<div class="panel" id="search-panel">
								<div class="glyphicon glyphicon-search"></div>
								<div class="badge pull-right">
									<div class="glyphicon glyphicon-remove"></div>
								</div>
								<input type="text" placeholder="search"    style="border:none">
							</div>
						</div>
						<div class="col-xs-5">
							<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal4" 					style="border:none;background:none;color:black">
								<div class="glyphicon glyphicon-comment"></div></button>
							<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" 					style="border:none;background:none;color:black"><div class="glyphicon glyphicon-envelope"></div></button>
							<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal2" 					style="border:none;background:none;color:black"><div class="glyphicon glyphicon-paperclip"></div></button>
							<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal3" 					style="border:none;background:none;color:black"><div class="glyphicon glyphicon-edit"></div></button>

							<div class=" pull-right"><div class="dropdown">
								<button class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="border:none"><div class="glyphicon glyphicon-user"></div>
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li><a href="#">Profiles</a></li>
									<li><a href="#">Users</a></li>
									<li><a href="#">Topic</a></li>
									<li><a href="#">Post</a></li>
									<li><a href="/LinkSharing/login/logout">Logout</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
		<g:render template="/topic/create"/>
		<g:render template="/topic/email"/>
		<g:render template="/resource/documentResourceCreate"/>
		<g:layoutBody/>
	</body>
</html>
