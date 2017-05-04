var handler = {
	URL : {
		single : function(id) {
			return "/mall/admin/goods/" + id;
		}
	},
	init : function() {
		$('a.btn.btn-danger').on('click', function() {
			var gid = $(this).data('value');
			$.ajax({
				url : handler.URL.single(gid),
				type : 'DELETE',
				success : function(data) {
					if (data.success) {
						layer.msg('删除成功', {
							time : 2000
						});
						window.location.reload();
					} else {
						layer.msg(data.info, {
							time : 2000
						});
					}
				}
			});
		});
	},

};