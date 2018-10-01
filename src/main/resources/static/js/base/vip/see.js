/**
 * 查看会员详情
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
	}
})