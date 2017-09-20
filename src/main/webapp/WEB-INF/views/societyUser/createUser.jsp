<div class="page-header">
	<h1>
		New User <small> <i class="ace-icon fa fa-angle-double-right"></i>
			Detail of society user
		</small>
	</h1>
</div>
<!-- /.page-header -->

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<form class="form-horizontal" role="form" method="post"
			action="createUser">
			
			<input type="hidden" value="${ sessionScope.SOCIETYID }" name="societyId" />
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">User
					Name<i class="fa fa-asterisk" style="color: red;"></i>
				</label>
				<div class="col-sm-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input id="userNameId" name="userName" placeholder="User Name"
							class=" col-xs-10 col-sm-4" type="text">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">Password
					<i class="fa fa-asterisk" style="color: red;"></i>
				</label>
				<div class="col-sm-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-key"></i></span> <input
							id="userPasswordId" name="userPassword" placeholder="Password"
							class=" col-xs-10 col-sm-4" type="text">
					</div>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">First
					Name <i class="fa fa-asterisk" style="color: red;"></i>
				</label>
				<div class="col-sm-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input name="firstName" placeholder="First Name" id="firstNameId"
							class=" col-xs-10 col-sm-4" type="text">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">Middle
					Name</label>
				<div class="col-sm-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input name="middleName" placeholder="Middle Name"
							class=" col-xs-10 col-sm-4" type="text">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">Last
					Name <i class="fa fa-asterisk" style="color: red;"></i>
				</label>
				<div class="col-sm-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input name="lastName" placeholder="Last Name" id="lastNameId"
							class=" col-xs-10 col-sm-4" type="text">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">Mobile
					Number <i class="fa fa-asterisk" style="color: red;"></i>
				</label>
				<div class="col-sm-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-mobile"></i></span>
						<input name="contactNumber" placeholder="(845)555-1212"
							id="contactNumberId" class=" col-xs-10 col-sm-4 numeric"
							type="text">
					</div>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">Email
					Id <i class="fa fa-asterisk" style="color: red;"></i>
				</label>
				<div class="col-sm-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						<input name="emailId" placeholder="Email Address" id="emailIdId"
							class=" col-xs-10 col-sm-4" type="text">
					</div>
				</div>
			</div>

			<div class="widget-box widget-color-blue2">
				<div class="widget-header">
					<h4 class="widget-title lighter smaller">User Rights</h4>
				</div>

				<div class="widget-body">
					<div class="widget-main padding-8">
						<ul id="tree1">
						</ul>
					</div>
				</div>
			</div>


			<div class="clearfix form-actions">
				<div class="col-sm-offset-3">
					<button id="societyUserSubmitBtn" type="submit" class="btn btn-success">
						<i class="ace-icon fa fa-check bigger-110"></i>Submit
					</button>
					&nbsp; &nbsp; &nbsp;
					<button class="btn" type="reset">
						<i class="ace-icon fa fa-undo bigger-110"></i> Reset
					</button>
				</div>
			</div>

		</form>
	</div>
</div>
