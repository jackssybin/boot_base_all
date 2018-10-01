/**
 * InnoDB free: 7168 kBjs
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
		url: '../../sys/vip/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.account = vm.account;
			params.nick = vm.nick;
			params.referee = vm.referee;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "account", title : "账户", width : "80px"},
			{field : "portrait", title : "头像", width : "60px",formatter : function(value, row, index) {
					return '<image style="width: 50px;height: 50px;border-radius: 100%;" src='+value+' />';}
			},
			{field : "nick", title : "昵称", width : "160px"},
			{field : "sex", title : "性别", width : "30px",formatter : function(value, row, index) {
				if (value == '0') {
					return '<span class="label label-danger">男</span>';
				} else if (value == '1') {
					return '<span class="label label-success">女</span>';
				}
			}},
			{field : "ins", title : "行业", width : "100px"}, 
			{field : "grade", title : "会员等级", width : "100px",formatter : function(value, row, index) {
				if (value == '1') {
					return '<span class="label label-info">青铜</span>';
				} else if (value == '2') {
					return '<span class="label label-info">白银</span>';
				} else if (value == '3') {
					return '<span class="label label-info">黄金</span>';
				} else if (value == '4') {
					return '<span class="label label-info">铂金</span>';
				} else if (value == '5') {
					return '<span class="label label-info">钻石</span>';
				} else if (value == '6') {
					return '<span class="label label-info">黑卡</span>';
				}
			}},
			{field : "online", title : "在线方式", align:'center',width : "100px",formatter : function(value, row, index) {
				if (value == '0') {
					return '<b style="color: #2D93CA;font-size: 20px;"><i class="fa glyphicon fa-tripadvisor"></i></b>';
				} if (value == '1') {
					return '<b style="color: #2D93CA;font-size: 30px;"><i class="fa glyphicon fa-mobile"></i></b>';
				} else if (value == '2') {
					return '<b style="color: #2b542c;font-size: 20px;"><i class="fa glyphicon fa-tv"></i></b>';
				}
			}},
			{field : "inTime", title : "注册时间", width : "200px"},
			{field : "jwd", title : "经纬度", width : "200px"},
			{field : "referee", title : "推荐人", width : "100px"}, 
			{field : "refereeId", title : "推荐人id", width : "100px"},
			{field : "state", title : "状态", width : "100px",formatter : function(value, row, index) {
				if (value == '0') {
					return '<span class="label label-default">注销</span>';
				} if (value == '1') {
					return '<span class="label label-success">正常</span>';
				} else if (value == '2') {
					return '<span class="label label-danger">黑名单(屏蔽电话)</span>';
				} else if (value == '3') {
					return '<span class="label label-warning">禁用(不允许进入)</span>';
				} else if (value == '4') {
					return '<span class="label label-info">只发布文字</span>';
				} else if (value == '5') {
					return '<span class="label label-primary">只能浏览</span>';
				}
			}},
			{field : "referral", title : "推荐码", width : "100px"},
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		account: null,
		nick: null,
		referee: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增会员信息',
				url: 'base/vip/add.html?_' + $.now(),
				width: '420px',
				height: '520px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑会员信息',
					url: 'base/vip/edit.html?_' + $.now(),
					width: '420px',
					height: '520px',
					success: function(iframeId){
						top.frames[iframeId].vm.wxUser.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		see: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '查看会员信息',
					url: 'base/vip/see.html?_' + $.now(),
					width: '720px',
					height: '520px',
					success: function(iframeId){
						top.frames[iframeId].vm.wxUser.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '../../sys/vip/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})