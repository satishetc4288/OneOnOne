<div class="container login-form">
    <div class="logo tb-space">
        <img src="img/Logo.png" height="30" alt="Logo">
    </div>
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
            <button class="btn btn-primary btn-block login-button" type="submit">Login</button>
            <div class="checkbox login-options">
                <label><input type="checkbox"/> Remember Me</label>
                <a href="#" class="login-forgot">Forgot Username/Password?</a>
            </div>
        </form>
    </div>
</div>
<!-- Inner page -->
<div class="landing hide">
    <div class="user-profile-bg"></div>
    <div class="container sche-meeting">
        <div class="header clearfix">
            <span class="one-logo"> <img src="img/One-On-One_Logo.png" alt="One on one"></span>
            <span class="logo-inner pull-right"> <img src="img/CDK-Logo.png" alt="CDK Global"> </span>
        </div>
        <div class="user-profile-cont">
            <span class="pull-left section-title">Schedule a meeting</span>
            <span class="fa fa-bell-o"></span>
            <span class="u-name">
               <i class="fa fa-user-circle-o"></i>
               User
               </span>
        </div>
        <!-- Scheduling Form -->
        <section class="schedule-form">
            <!--
               https://twitter.github.io/typeahead.js/examples/
               http://blog.teamtreehouse.com/creating-autocomplete-dropdowns-datalist-element

               -->
            <div class="s-form">
                <label>One-on-one meeting with</label>
                <input type="text" ng-model="user">
                <li ng-repeat="item in (users | filter:search)" ng-bind="user"></li>
                On <input type="text" id="datepicker" class="date-picker">
                From <input id="basicExample" type="text" class="time" />
                :
                To <input id="basicExample2" type="text" class="time" />
                In
                <input type="text" id="tags2">
                Room.
            </div>
            <input type="submit" value="Schedule" class="btn-primary">
        </section>
        <div class="meetings-list">
            <br><br>
            <hr>
            <h3>Meetings List</h3>
            <hr>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Associate ID</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Room</th>
                    <th>Status</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">502601</th>
                    <td>Sneha Varne</td>
                    <td>Monday, 16th July</td>
                    <td>11:00am - 11:30am</td>
                    <td>Samiti</td>
                    <td><i class="fa fa-check" aria-hidden="true"></i> Accepted</td>
                    <td><a href="" data-toggle="modal" data-target="#exampleModal" class="feedback-link">Feedback</a> </td>
                </tr>
                <tr>
                    <th scope="row">502601</th>
                    <td>Sneha Varne</td>
                    <td>Monday, 16th July</td>
                    <td>11:00am - 11:30am</td>
                    <td>Samiti</td>
                    <td><i class="fa fa-info" aria-hidden="true"></i> Scheduled</td>
                    <td>&nbsp;</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade bd-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3  class="modal-title" id="exampleModalLabel">Feedback for <span>Sneha Varne</span></h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="feedback-area">
                        <textarea name="" id="" rows="5" placeholder="Your feedback here"></textarea>
                    </div>
                    <h3>Performance Metrics</h3>
                    <div class="perf-fields">
                        <input type="text" class="kpi" placeholder="kpi"> <input type="text" class="kpi-review" placeholder="review">
                    </div>
                    <div class="perf-fields">
                        <input type="text" class="kpi" placeholder="kpi"> <input type="text" class="kpi-review" placeholder="review">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </div>
    </div>
</div>