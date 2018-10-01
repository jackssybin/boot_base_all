/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		bzSurveyDirectory: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../base/survery/info?_' + $.now(),
		    	param: vm.bzSurveyDirectory.id,
		    	success: function(data) {
		    		vm.bzSurveyDirectory = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../base/survery/update?_' + $.now(),
		    	param: vm.bzSurveyDirectory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})