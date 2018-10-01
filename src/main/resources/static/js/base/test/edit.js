/**
 * 编辑-代码生成测试js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		test: {
			rowId: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/test/info?_' + $.now(),
		    	param: vm.test.rowId,
		    	success: function(data) {
		    		vm.test = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/test/update?_' + $.now(),
		    	param: vm.test,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})