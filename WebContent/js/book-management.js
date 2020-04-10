/**
 * 根据错误返回值显示信息
 * @param item 返回的错误信息
 * @returns 有错误信息则弹出提示
 */
function showErrorMessage(item) {
	item.hide();
	var msg = item.text();
	if (msg != "" && msg != null) {
		alert(msg);
	}
}
