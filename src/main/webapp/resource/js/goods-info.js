var info = {
	URL : {
		update : function(id) {
			return "/mall/admin/goods/" + id;
		},
		add : function() {
			return "/mall/admin/goods";
		}
	},
	init : function(goodsId) {
		// init fileupload-tools
		$('#goods-img').fileinput({
			language : 'zh',
			enctype : 'multipart/form-data',
			uploadUrl : '../upload/img',
			allowedFileExtensions : [ 'jpg', 'gif', 'jpeg', 'png' ],
			initialCaption : '请选择商品图片',
			maxFileCount : 10
		});
		$('#goods-img').on('fileuploaded',
				function(event, data, previewId, index) {
					$("input[name='img']").val(data.response.info);
				});
		info.submit(goodsId);
	},
	submit : function(goodsId) {
		// init submit click
		$('#btn-submit').on('click', function() {
			var data = $('#goods-form').serialize();
			if ($('input[name="name"]').val()) {
				$.ajax({
					url : info.URL.update(goodsId),
					type : 'PUT',
					data : data,
					success : function(result) {
						if (result.successs) {
							layer.msg('修改成功', {
								time : 2000
							});
							window.location.reload();
						} else {
							layer.msg(result.info, {
								time : 2000
							});
						}
					}
				});
			} else {
				$.ajax({
					url : info.URL.add(),
					type : 'POST',
					data : data,
					success : function(result) {
						if (result.successs) {
							layer.msg('新增成功', {
								time : 1500
							});
							window.location.href = "/mall/admin/goods/list";
						} else {
							layer.msg(result.info, {
								time : 2000
							});
						}
					}
				});
			}
		});
	}

};