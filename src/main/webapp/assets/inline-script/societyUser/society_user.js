//function initiateDemoData() {
//	var tree_data = {
//		'society' : {
//			text : 'Society',
//			type : 'folder'
//		},
//		'reminder' : {
//			id : 2,
//			text : 'Reminder',
//			type : 'item'
//		},
//		'report' : {
//			text : 'Report',
//			type : 'folder'
//		}
//	}
//	tree_data['society']['additionalParameters'] = {
//		'children' : {
//			'createUser' : {
//				id   : 1,
//				text : 'Create User',
//				type : 'item'
//			},
//			'userList' : {
//				id : 6,
//				text : 'User List',
//				type : 'item'
//			}
//		}
//	}
//	tree_data['report']['additionalParameters'] = {
//		'children' : {
//			'balanceSheet' : {
//				id : 3,
//				text : 'Balance Sheet',
//				type : 'item'
//			},
//			'incomeAndExpense' : {
//				id : 4,
//				text : 'Income & Expense',
//				type : 'item'
//			},
//			'maintenence' : {
//				id : 5,
//				text : 'Maintenence',
//				type : 'item'
//			}
//		}
//	}
//	
//	var dataSource1 = function(options, callback) {
//		
//		var $data = null
//		if (!("text" in options) && !("type" in options)) {
//			$data = tree_data;// the root tree
//			callback({
//				data : $data
//			});
//			return;
//		} else if ("type" in options && options.type == "folder") {
//			if ("additionalParameters" in options
//					&& "children" in options.additionalParameters)
//				$data = options.additionalParameters.children || {};
//			else
//				$data = {}// no data
//		}
//
//		if ($data != null)// this setTimeout is only for mimicking some
//			// random delay
//			setTimeout(function() {
//				callback({
//					data : $data
//				});
//			}, parseInt(Math.random() * 500) + 200);
//	}
//
//	return {
//		'dataSource1' : dataSource1
//	}
//}

function selectMenuItem(menuIdArr, tree_data) {
	
	$.each(tree_data, function (index, value){
		if (value.type === 'item') {
			var menuId = value.id.toString();
			if($.inArray(menuId, menuIdArr) !== -1) {
				//alert(menuId);
				value.additionalParameters = {
						'item-selected' : true
				}
			}
		}
		else {
			selectMenuItem(menuIdArr, value.additionalParameters.children);
		}
	});
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
			},
			'item-selected' : true
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
	
	
	var menuIdArr = "1,2,6".split(",");
	selectMenuItem(menuIdArr, tree_data);
	
//	$.each(tree_data, function (index, value){
//		if (value.type === 'item') {
//			var menuId = value.id.toString();
//			if($.inArray(menuId, menuIdArr) !== -1) {
//				alert(menuId);
//				value.additionalParameters = {
//						'item-selected' : true
//				}
//			}
//		}
//		else {
//			
//			
//		}
//	});
	
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
	
	
//	var menuIdArr = "1,2,6".split(",");
//	var sampleData = initiateDemoData();
//	
//	var tree_data = sampleData['dataSource1'];
//	
//	$.each(tree_data, function (index, value){
//		
//		alert(value.type);
//		
//		if (value.type === 'item') {
//			var menuId = value.id;
//			if($.inArray(menuId, menuIdArr) !== -1) {
//				var selectItem = {	
//						'additionalParameters' : {
//							'item-selected' : true
//						}
//				}
//				value.push(selectItem);
//			}
//		}	
//	});

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
	
	$("#tree1").on("click", ".tree-item", function() {
		if ($(this).hasClass("tree-selected")) {
			$(this).find("input[type=checkbox]").attr("checked", true);
		} else {
			$(this).find("input[type=checkbox]").attr("checked", false);
		}
	});
	
//	var menuIdArr = $("#rights").val().split(",");
//	$.each(menuIdArr, function(index, menuId) {
//		
//		alert(menuId);
//		
//		var checkInputType = $("#tree1").find("input[value='" + menuId + "']").val();
//		
//		alert(checkInputType);
//	});
	
	

});
