/**
 * 新增-InnoDB free: 7168 kBjs
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wxUser: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			var $province = $('#province').val();
			var $city = $('#city').val();
			var $district = $('#district').val();
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/vip/save?_' + $.now()+'&province='+$province+'&city='+$city+'&district='+$district,
		    	param: vm.wxUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	},
				error:function(){alert('sb了,,,');}
		    });
		}
	}
})
