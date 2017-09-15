/** ************ */
$('#memberTable').on(
		'click',
		'.show-details-btn',
		function(e) {
			e.preventDefault();
			$(this).closest('tr').next().toggleClass('open');
			$(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down')
					.toggleClass('fa-angle-double-up');
		});
/** ************ */

$("#addMemberAnchor").click(function() {
	$('#updateMemberBtn').addClass("hide");
	$("#saveMemberBtn").removeClass("hide");
	
	clearTextForPersonModel();
});

$('#memberTable').on('click', '#editMemberAnchor', function(e) {

	$('#updateMemberBtn').removeClass("hide");
	$("#saveMemberBtn").addClass("hide");
	
	clearTextForPersonModel();
	
	var editTr = $(this).parents('tr');
	var firstName = editTr.find("td:eq(1)").text();
	var middleName = editTr.find("td:eq(2)").text();
	var lastName = editTr.find("td:eq(3)").text();
	var mobileNumber = editTr.find("td:eq(4)").text();
	var emailId = editTr.find("td:eq(5)").text();
	
	$("#memberFirstName").val(firstName);
	$("#memberMidleName").val(middleName);
	$("#memberLastName").val(lastName);
	$("#memberMobileNumber").val(mobileNumber);
	$("#memberEmailId").val(emailId);
	
	var rowIndex = editTr.index();
	$("#rowIndex").val(rowIndex);
});

$("#saveMemberBtn").click(function() {

	var firstName = $("#memberFirstName").val();
	var middleName = $("#memberMidleName").val();
	var lastName = $("#memberLastName").val();
	var mobileNumber = $("#memberMobileNumber").val();
	var emailId = $("#memberEmailId").val();

	if (firstName === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter first name");
		$(this).removeAttr('data-dismiss');
		return;
	}

	if (lastName === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter last name");
		$(this).removeAttr('data-dismiss');
		return;
	}

	if (mobileNumber === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter mobile number");
		$(this).removeAttr('data-dismiss');
		return;
	}

	if (emailId === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter email id");
		$(this).removeAttr('data-dismiss');
		return;
	}

	var memberObj = {
		'firstName' : firstName,
		'middleName' : middleName,
		'lastName' : lastName,
		'contactNumber' : mobileNumber,
		'emailId' : emailId
	}

	var memberObjJson = JSON.stringify(memberObj);

	$.ajax({
		url : 'getMemberRow',
		contentType : "application/json",
		type : 'POST',
		data : memberObjJson,
		success : function(response) {
			$('#memberTable tbody').append(response);
			$('#memberTable').removeClass("hide");
		}
	});
	$(this).attr('data-dismiss', 'modal');	
});

$("#updateMemberBtn").click(function() {

	var firstName = $("#memberFirstName").val();
	var middleName = $("#memberMidleName").val();
	var lastName = $("#memberLastName").val();
	var mobileNumber = $("#memberMobileNumber").val();
	var emailId = $("#memberEmailId").val();
	
	if (firstName === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter first name");
		$(this).removeAttr('data-dismiss');
		return;
	}

	if (lastName === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter last name");
		$(this).removeAttr('data-dismiss');
		return;
	}

	if (mobileNumber === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter mobile number");
		$(this).removeAttr('data-dismiss');
		return;
	}

	if (emailId === "") {
		$("#modelMsgDiv").removeClass("hide");
		$("#modelMsg").html("Please enter email id");
		$(this).removeAttr('data-dismiss');
		return;
	}
	
	var rowIndex = $("#rowIndex").val();
	var $editRow = $("#memberTable tbody").find("tr:eq("+ rowIndex +")");
	
	$editRow.find("td:eq(1)").html(firstName);
	$editRow.find("td:eq(2)").html(middleName);
	$editRow.find("td:eq(3)").html(lastName);
	$editRow.find("td:eq(4)").html(mobileNumber);
	$editRow.find("td:eq(5)").html(emailId);
	
	var $detailRow = $editRow.next("tr");
	var $profileInfoRow = $detailRow.find(".profile-user-info").find(".profile-info-row");
	var profileInfoRowArr = $.makeArray($profileInfoRow);
	
	$(profileInfoRowArr[0]).find("span").html(firstName);
	$(profileInfoRowArr[0]).find("input").val(firstName);
	
	$(profileInfoRowArr[1]).find("span").html(middleName);
	$(profileInfoRowArr[1]).find("input").val(middleName);
	
	$(profileInfoRowArr[2]).find("span").html(lastName);
	$(profileInfoRowArr[2]).find("input").val(lastName);
	
	$(profileInfoRowArr[3]).find("span").html(mobileNumber);
	$(profileInfoRowArr[3]).find("input").val(mobileNumber);
	
	$(profileInfoRowArr[4]).find("span").html(emailId);
	$(profileInfoRowArr[4]).find("input").val(emailId);
});

function clearTextForPersonModel() {
	
	$("#memberFirstName").val("");
	$("#memberMidleName").val("");
	$("#memberLastName").val("");
	$("#memberMobileNumber").val("");
	$("#memberEmailId").val("");
	
	$("#modelMsgDiv").addClass("hide");
}


$("#societySubmitBtn").click(function(){
	
	var unique_id = $.gritter.add({
		title: 'This is a sticky notice!',
		text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="red">magnis dis parturient</a> montes, nascetur ridiculus mus.',
		image: './assets/avatars/avatar.png',
		sticky: true,
		time: '',
		class_name: 'gritter-info gritter-light'
	});
	
	return false;
});