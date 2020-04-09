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

/**
 * 验证是否满足正则表达式
 * @param regxPatt 正则表达式
 * @param testFiled 要测试的field
 * @returns  true 符合正则表达式 ;false 不符合正则表达式
 */
function checkRegexMatch(regxPatt, testFiled){
	return regxPatt.test(testFiled)
		
}