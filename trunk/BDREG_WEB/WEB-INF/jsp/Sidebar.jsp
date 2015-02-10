<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="sidebar-nav">
        <li><a id='n_home' href="home.action" class="nav-header"><i class="fa fa-fw fa-home"></i>User Home</a></li>
        <li><a id='n_reg_stat' href="regStatHome.action" class="nav-header"><i class="fa fa-fw fa-search"></i>Search Data</a></li>
        <li><a id='n_homeMaid' href="homeMaidHome.action" class="nav-header"><i class="fa fa-fw fa-h-square"></i>Home Maid</a></li>
        <li><a id='n_home' href="logout.action" class="nav-header"><i class="fa fa-fw fa-sign-out"></i>Logout</a></li>
</div>

<s:if test="#context['struts.actionMapping'].name=='home'">
   <script type="text/javascript">$("#n_home").css("background","white");$("#n_home").css("font-weight","bold");</script>
</s:if>
<s:if test="#context['struts.actionMapping'].name=='regStatHome'">
   <script type="text/javascript">$("#n_reg_stat").css("background","white");$("#n_reg_stat").css("font-weight","bold");</script>
</s:if>
