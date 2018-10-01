/**
 * 编辑-InnoDB free: 7168 kBjs
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wxUser: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/vip/info?_' + $.now(),
		    	param: vm.wxUser.id,
		    	success: function(data) {
		    		vm.wxUser = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/vip/update?_' + $.now(),
		    	param: vm.wxUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})