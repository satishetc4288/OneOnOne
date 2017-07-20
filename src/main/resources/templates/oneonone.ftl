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

            <div class="login-error" ng-show="errorMessageShow">Username or passwrod is incorrect.</div>

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
               {{loginUser.name}}
               </span>
        </div>
        <!-- Scheduling Form -->
        <form ng-submit="scheduleMeeting(meeting)">
           <section class="schedule-form">
                <div class="s-form">
                    One-on-one meeting with
                    <input type="text" id="tags" class="select-associate" ng-model="meeting.receiver">
                    On <input type="text" id="datepicker" class="date-picker" ng-model="meeting.meetingDate">
                    From <input id="basicExample" type="text" class="time" ng-model="meeting.meetingFromTime"/>
                    :
                    To <input id="basicExample2" type="text" class="time" ng-model="meeting.meetingToTime"/>
                    In
                    <input type="text" id="tags2" ng-model="meeting.meetingRoom">
                    Room.
                </div>
                <input type="submit" value="Schedule" class="btn-primary">
            </section>
        </form>
        <div class="meetings-list">
            <br><br>
            <hr>
            <h3>Meetings List</h3>
            <hr>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Room</th>
                    <th>Status</th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat= "item in allMeetings">
                    <td>{{item.receiver}}</td>
                    <td>{{item.meetingDate}}</td>
                    <td>{{item.meetingFromTime}}</td>
                    <td>{{item.meetingRoom}}</td>
                    <td><i class="fa fa-check" aria-hidden="true"></i> Scheduled</td>
                    <td><a href="" data-toggle="modal" data-target="#myModal" ng-click="updateDefault(item)">Feedback</a> </td>
                    <td><a href="" data-toggle="modal" data-target="#myModal2" ng-click="getUserAllFeedback(item)">History</a> </td>
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
                    <h3  class="modal-title" id="exampleModalLabel">Feedback for <span>{{defaultMeeting.receiver}}</span></h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form ng-submit="submitFeedback(feedback)">
	                <div class="modal-body">
	                    <div class="feedback-area">
	                        <textarea name="" id="" rows="5" placeholder="Your feedback here" ng-model="feedback.feedbacks"></textarea>
	                    </div>
	                    <h3>Performance Metrics</h3>
	                    <div class="perf-fields">
	                        <input type="text" class="kpi" placeholder="kpi" ng-model="feedback.perf1"> <input type="text" class="kpi-review" placeholder="review" ng-model="feedback.reveiw1">
	                    </div>
	                    <div class="perf-fields">
	                        <input type="text" class="kpi" placeholder="kpi" ng-model="feedback.perf2"> <input type="text" class="kpi-review" placeholder="review" ng-model="feedback.reveiw2">
	                    </div>
	                    <div class="plus-sign">
                          <i class="fa fa-plus-circle" aria-hidden="true" title="Add KPI"></i>
                      </div>
	                </div>
	                <div class="modal-footer">
	                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	                    <button type="submit" class="btn btn-primary">Submit</button>
	                </div>
                </form>
            </div>
        </div>
     </div>

     <!-- History Modal -->
      <div class="modal fade bd-example-modal-lg" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
              <div class="modal-content">
                  <div class="modal-header">
                      <h3  class="modal-title" id="exampleModalLabel">Feedback history of <span>Sneha Varne</span></h3>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                      </button>
                  </div>
                  <div class="modal-body" ng-repeat="feedback in usersAllFeedbacks">
                      <div id="accordion">
                          <div>
                              <p><b>Feedback: </b>{{feedback.feedbacks}}</p>
                              <table class="table table-striped">
                                  <tr ng-repeat="performances in feedback.performanceMatrices">
                                      <td scope="row" width="70%">{{performances | split:':':0}}</td>
                                      <td>{{performances | split:':':1}}</td>
                                  </tr>
                              </table>
                          </div>
                      </div>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  </div>
              </div>
          </div>
      </div>
</div>