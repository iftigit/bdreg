<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">          
          <a class="" href="#"><span class="navbar-brand">BMET Comprehensive DB</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> 
                    <s:property value="%{#session.loggedInUser.fullName}"/>
                    <i class="fa fa-caret-down"></i>
                </a>

              <ul class="dropdown-menu">
                <li><a href="userAccount.action">My Account</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Admin Panel</li>
                <li><a href="./">-</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="logout.action">Logout</a></li>
              </ul>
            </li>
          </ul>

        </div>
      </div>