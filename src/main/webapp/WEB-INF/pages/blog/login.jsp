<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<title>Login</title>
<style type="text/css">
.sign-box{
  width: 50%;
  margin: 50px auto 30px;
  background-color: #F9F9F9;
  border-radius: 3px;
  box-shadow: 0 1px 3px rgba(34, 25, 25, 0.5);
  -moz-box-shadow: 0 1px 3px rgba(34,25,25,0.5);
  -webkit-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.5);
  padding: 45px 35px 45px;
  
}
.login-form {
  padding-right: 39px;
  border-right: 1px solid gainsboro;
}
.other-login{
  padding-left: 39px;
}
.other-login h4{
  border-bottom: 1px solid gainsboro;
}
</style>
</head>
<body>
  <jsp:include page="/WEB-INF/pages/include/home-head.jsp" />
  <div class="container">
    <div class="sign-box c-fix">
      <div class="login-form f-left">
        <form >
          <legend>Sign in</legend>
          <div>
            <input type="text" class="span3" placeholder="Username">
          </div>
          <div>
            <input type="password" class="span3" placeholder="Password">
          </div>
          <div class="c-fix">
            <div class="f-left">
              <label class="checkbox">
                <input type="checkbox">Remember me
              </label>
            </div>
            <div class="f-right">
              <a href="#" class="btn btn-link padding-zero">
                <span class="icon-question-sign"></span>忘记密码
              </a>
            </div>
          </div>
          <div>
            <input type="submit" class="btn btn-primary" value="Sign in">
          </div>
        </form>
      </div>
      <div class="other-login f-left">
        <div>
          <h4 style="padding-bottom:7px;">sign in with other platform</h4>
          <div>
            <p>
              <button class="btn btn-small">
                <li class="icon-info-sign"></li> sign in with twitter
              </button>
            </p>
            <p>
              <button class="btn btn-small btn-info">
                <li class="icon-info-sign"></li> sign in with facebook
              </button>
            </p>
            <p>
              <button class="btn btn-small btn-danger">
                <li class="icon-info-sign"></li> sign in with linkedin
              </button>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
</body>
</html>