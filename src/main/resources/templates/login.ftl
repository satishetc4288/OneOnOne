<div class="container login-form">
   <div class="logo tb-space text-center">
      <img src="img/Logo.png" height="30" alt="Logo">
   </div>
   <br></br>
   <!--Form-->
   <div class="form-container">
      <form ng-submit="loginUser(formAdata)">
         <div class="input-group login-userinput">
            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
            <input id="txtUser" type="text" class="form-control" name="username" placeholder="Username" ng-model="formAdata.username">
         </div>
         <div class="input-group">
            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
            <input  id="txtPassword" type="password" class="form-control" name="password" placeholder="Password" ng-model="formAdata.password">
            <span id="showPassword" class="input-group-btn">
            <button class="btn btn-default reveal" type="button"><i class="glyphicon glyphicon-eye-open"></i></button>
            </span>
         </div>
         <div class="login-error" ng-show="errorMessageShow">Username or passwrod is incorrect.</div>
         <button class="btn btn-primary btn-block login-button" type="submit">Login</button>
         <div class="checkbox login-options">
            <label><input type="checkbox"/> Remember Me</label>
            <a href="#" class="login-forgot">Forgot Username/Password?</a>
         </div>
      </form>
   </div>
</div>