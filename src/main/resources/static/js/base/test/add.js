/**
 * 新增-代码生成测试js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		test: {
			rowId: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/test/save?_' + $.now(),
		    	param: vm.test,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
