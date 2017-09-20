var sampleData = initiateDemoData();// see below

$('#tree1')
		.ace_tree(
				{
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

function initiateDemoData() {
	var tree_data = {
		'society' : {
			text : 'Society',
			type : 'folder'
		},
		'reminder' : {
			id   : 1,
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
				id   : 2,
				text : 'Create User',
				type : 'item'
			}
		}
	}
	tree_data['report']['additionalParameters'] = {
		'children' : {
			'balanceSheet' : {
				id   : 3,
				text : 'Balance Sheet',
				type : 'item'
			},
			'incomeAndExpense' : {
				id   : 4,
				text : 'Income & Expense',
				type : 'item'
			},
			'maintenence' : {
				id   : 5,
				text : 'Maintenence',
				type : 'item'
			}
		}
	}
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

	return {
		'dataSource1' : dataSource1
	}
}

$("#tree1").on("click", ".tree-item", function(){
	if($(this).hasClass("tree-selected")) {
		$(this).find("input[type=checkbox]").attr("checked", true);
		
	}	
	else {
		$(this).find("input[type=checkbox]").attr("checked", false);
	}
		
});
