function selectMenuItem(menuIdArr, tree_data) {
	
	var isMenuPresent = false;
	$.each(tree_data, function (index, value){
		if (value.type === 'item') {
			var menuId = value.id.toString();
			if($.inArray(menuId, menuIdArr) !== -1) {
				//alert(menuId);
				value.additionalParameters = {
						'item-selected' : true
				}
				isMenuPresent = true;
			}
		}
		else {
			var flag = selectMenuItem(menuIdArr, value.additionalParameters.children);
			if(flag) {
				value.additionalParameters['item-selected'] = true;
			}
		}
	});
	return isMenuPresent;
}


$(document).ready(function() {
	
	var tree_data = {
			'society' : {
				text : 'Society',
				type : 'folder'
			},
			'reminder' : {
				id : 2,
				text : 'Reminder',
				type : 'item'
			},
			'report' : {
				text : 'Report',
				type : 'folder'
			}
		}
		tree_data['society']['additionalParameters'] = {
			'children' : {
				'createUser' : {
					id   : 1,
					text : 'Create User',
					type : 'item'
				},
				'userList' : {
					id : 6,
					text : 'User List',
					type : 'item'
				}
			}
		}
		tree_data['report']['additionalParameters'] = {
			'children' : {
				'balanceSheet' : {
					id : 3,
					text : 'Balance Sheet',
					type : 'item'
				},
				'incomeAndExpense' : {
					id : 4,
					text : 'Income & Expense',
					type : 'item'
				},
				'maintenence' : {
					id : 5,
					text : 'Maintenence',
					type : 'item'
				}
			}
		}
	
	
	var menuIdArr = $("#rights").val().split(",");
	selectMenuItem(menuIdArr, tree_data);
	
	var dataSource1 = function(options, callback) {
		
		var $data = null
		if (!("text" in options) && !("type" in options)) {
			$data = tree_data;// the root tree
			callback({
				data : $data
			});
			return;
		} else if ("type" in options && options.type == "folder") {
			if ("additionalParameters" in options
					&& "children" in options.additionalParameters)
				$data = options.additionalParameters.children || {};
			else
				$data = {}// no data
		}

		if ($data != null)// this setTimeout is only for mimicking some
			// random delay
			setTimeout(function() {
				callback({
					data : $data
				});
			}, parseInt(Math.random() * 500) + 200);
	}

	var sampleData =  {
		'dataSource1' : dataSource1
	}

	$('#tree1').ace_tree({
		dataSource : sampleData['dataSource1'],
		multiSelect : true,
		cacheItems : true,
		'open-icon' : 'ace-icon tree-minus',
		'close-icon' : 'ace-icon tree-plus',
		'itemSelect' : true,
		'folderSelect' : false,
		'selected-icon' : 'ace-icon fa fa-check',
		'unselected-icon' : 'ace-icon fa fa-times',
		loadingHTML : '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>'
	});
	
//	$("#tree1").on("click", ".tree-item", function() {
//		if ($(this).hasClass("tree-selected")) {
//			$(this).find("input[type=checkbox]").attr("checked", true);
//		} else {
//			$(this).find("input[type=checkbox]").attr("checked", false);
//		}
//	});
	
	$("#societyUserSubmitBtn").click(function() {
		
		var isValid = true;
		
		var userName = $("#userName").val();
		if(userName == "") {
			showValidationMsg("User Name","Please enter value for user name.");
			isValid = false;
		}
			
		
		var userPassword = $("#userPassword").val();
		if(userPassword == "") {
			showValidationMsg("Password","Please enter value for password.");
			isValid = false;
		}
			
		
		var firstName = $("#firstName").val();
		if(firstName == ""){
			showValidationMsg("First Name","Please enter value for First Name.");
			isValid = false;
		}
			
		
		var lastName = $("#lastName").val();
		if(lastName == "") {
			showValidationMsg("Last Name","Please enter value for Last Name.");
			isValid = false;
		}
			
		
		var contactNumber = $("#contactNumber").val();
		if(contactNumber == ""){
			showValidationMsg("Contact Number","Please enter value for Conatct Number.");
			isValid = false;
		}
			
		
		var emailId = $("#emailId").val();
		if(emailId == "") {
			showValidationMsg("Email Id","Please enter value for email Id.");
			isValid = false;
		}
		
		if(isValid) {
			$("#tree1").find(".tree-selected").map(function() {
				$(this).find("input[type=checkbox]").attr("checked", true);
			});
			$("#rights").remove();
		}
		
		return isValid;
	});
});
