/**
 * 系统用户测试js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-54});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../sys/test/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			                params.user_id = vm.user_id;
			                params.username = vm.username;
			                params.password = vm.password;
			                params.email = vm.email;
			                params.mobile = vm.mobile;
			                params.status = vm.status;
			                params.remark = vm.remark;
			                params.user_id_create = vm.user_id_create;
			                params.gmt_create = vm.gmt_create;
			                params.gmt_modified = vm.gmt_modified;
						return params;
		},
		columns: [
			{checkbox: true},
			{field : "username", title : "用户名", width : "100px"}, 
			{field : "password", title : "密码", width : "100px"}, 
			{field : "email", title : "邮箱", width : "100px"}, 
			{field : "mobile", title : "手机号", width : "100px"}, 
			{field : "status", title : "状态 0:禁用，1:正常", width : "100px"}, 
			{field : "remark", title : "备注", width : "100px"}, 
			{field : "userIdCreate", title : "创建用户id", width : "100px"}, 
			{field : "gmtCreate", title : "创建时间", width : "100px"}, 
			{field : "gmtModified", title : "修改时间", width : "100px"}
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
					user_id : null,
					username : null,
					password : null,
					email : null,
					mobile : null,
					status : null,
					remark : null,
					user_id_create : null,
					gmt_create : null,
					gmt_modified : null,
			},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增系统用户测试',
				url: 'test/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑系统用户测试',
					url: 'test/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.sysTest.userId = ck[0].userId;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.userId;
				});
				$.RemoveForm({
					url: '../../sys/test/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})