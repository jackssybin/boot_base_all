/**
 * 新增-用户管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		roleList:{},
		user:{
			orgId: 0,
			orgName: null,
			status: 1,
			roleIdList:[]
		}
	},
	methods : {
		getRoleList: function(){
			$.get('../../sys/role/select?_' + $.now(), function(r){
				vm.roleList = r.rows;
			});
		},
		orgTree: function() {
			dialogOpen({
				id: 'layerOrgTree',
				title: '选择机构',
		        url: 'base/user/org.html?_' + $.now(),
		        scroll : true,
		        width: "300px",
		        height: "450px",
		        yes : function(iframeId) {
		        	top.frames[iframeId].vm.acceptClick();
				}
		    })
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/user/save?_' + $.now(),
		    	param: vm.user,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	},
	created : function() {
		this.getRoleList();
	}
})
