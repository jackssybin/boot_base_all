/**
 * 新增-系统用户测试js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sysTest: {
			userId: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/test/save?_' + $.now(),
		    	param: vm.sysTest,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
