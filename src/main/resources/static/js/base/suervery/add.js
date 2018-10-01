/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		bzSurveyDirectory: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../base/survery/save?_' + $.now(),
		    	param: vm.bzSurveyDirectory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
