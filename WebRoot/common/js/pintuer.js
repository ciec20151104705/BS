
$(function () {
	$("input[id=checkall]").click(function () {
		var e = $(this);
		var name = e.attr("name");
		var checkfor = e.attr("checkfor");
		var type;
		if (checkfor != "" && checkfor != null && checkfor != undefined) {
			type = e.closest("form").find("input[name='" + checkfor + "']");
		} else {
			type = e.closest("form").find("input[type='checkbox']");
		}
		if (name == "checkall") {
			$(type).each(function (index, element) {
				element.checked = true;
			});
			e.attr("name", "ok");
		} else {
			$(type).each(function (index, element) {
				element.checked = false;
			});
			e.attr("name", "checkall");
		}
	});
});

