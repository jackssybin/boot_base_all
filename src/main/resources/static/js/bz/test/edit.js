/**
 * 编辑-系统用户测试js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sysTest: {
			userId: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../bz/test/info?_' + $.now(),
		    	param: vm.sysTest.userId,
		    	success: function(data) {
		    		vm.sysTest = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../bz/test/update?_' + $.now(),
		    	param: vm.sysTest,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})