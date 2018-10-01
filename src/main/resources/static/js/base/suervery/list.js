/**
 * js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-54});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../base/survery/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			                params.id = vm.id;
			                params.an_item_least_num = vm.an_item_least_num;
			                params.answer_num = vm.answer_num;
			                params.create_date = vm.create_date;
			                params.dir_type = vm.dir_type;
			                params.excerpt_num = vm.excerpt_num;
			                params.html_path = vm.html_path;
			                params.is_share = vm.is_share;
			                params.parent_id = vm.parent_id;
			                params.sid = vm.sid;
			                params.survey_detail_id = vm.survey_detail_id;
			                params.survey_model = vm.survey_model;
			                params.survey_name = vm.survey_name;
			                params.survey_qu_num = vm.survey_qu_num;
			                params.survey_state = vm.survey_state;
			                params.survey_tag = vm.survey_tag;
			                params.user_id = vm.user_id;
			                params.view_answer = vm.view_answer;
			                params.visibility = vm.visibility;
						return params;
		},
		columns: [
			{checkbox: true},
			{field : "id", title : "", width : "100px"}, 
			{field : "anItemLeastNum", title : "", width : "100px"}, 
			{field : "answerNum", title : "", width : "100px"}, 
			{field : "createDate", title : "", width : "100px"}, 
			{field : "dirType", title : "", width : "100px"}, 
			{field : "excerptNum", title : "", width : "100px"}, 
			{field : "htmlPath", title : "", width : "100px"}, 
			{field : "isShare", title : "", width : "100px"}, 
			{field : "parentId", title : "", width : "100px"}, 
			{field : "sid", title : "", width : "100px"}, 
			{field : "surveyDetailId", title : "", width : "100px"}, 
			{field : "surveyModel", title : "", width : "100px"}, 
			{field : "surveyName", title : "", width : "100px"}, 
			{field : "surveyQuNum", title : "", width : "100px"}, 
			{field : "surveyState", title : "", width : "100px"}, 
			{field : "surveyTag", title : "", width : "100px"}, 
			{field : "userId", title : "", width : "100px"}, 
			{field : "viewAnswer", title : "", width : "100px"}, 
			{field : "visibility", title : "", width : "100px"}
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
					id : null,
					an_item_least_num : null,
					answer_num : null,
					create_date : null,
					dir_type : null,
					excerpt_num : null,
					html_path : null,
					is_share : null,
					parent_id : null,
					sid : null,
					survey_detail_id : null,
					survey_model : null,
					survey_name : null,
					survey_qu_num : null,
					survey_state : null,
					survey_tag : null,
					user_id : null,
					view_answer : null,
					visibility : null,
			},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增',
				url: 'base/survery/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑',
					url: 'base/survery/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.bzSurveyDirectory.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '../../base/survery/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})