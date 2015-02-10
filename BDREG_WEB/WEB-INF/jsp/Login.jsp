<!doctype html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>BMET-Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Ifta Khirul">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/BDREG_WEB/resources/lib/font-awesome/css/font-awesome.css">
    <script src="/BDREG_WEB/resources/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="/BDREG_WEB/resources/stylesheets/premium.css">
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body class=" theme-blue">

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="" href="login.action"><span class="navbar-brand">BMET Comprehensive DB</span></a></div>
    </div>

    <div class="dialog">
    	<div class="panel panel-default">
        	<p class="panel-heading no-collapse">Sign In</p>
        <div class="panel-body">
         
        <form action="checkValidity.action" method="post" id="loginForm"  name="loginForm">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" class="form-control span12" name="userId">
                </div>
                <div class="form-group">
                <label>Password</label>
                    <input type="password" class="form-control span12 form-control" name="password">
                </div>
                <a href="#" class="btn btn-primary pull-right" onclick="submitForm()">Login</a>
                <div class="clearfix"></div>
                <s:if test="hasActionMessages()">
				   <div class="welcome">
				      <s:actionmessage/>
				   </div>
				</s:if>
            </form>
        </div>
    </div>
</div>
<script src="/BDREG_WEB/resources/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
function submitForm()
{ document.loginForm.submit(); }
</script>      
</body>
</html>
