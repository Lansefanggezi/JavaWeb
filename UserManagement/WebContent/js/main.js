/*
 * 登陆账号密码的非空验证
 * */
function check() {
	if (document.getElementById("name").value == "") {
		alert("请输入登录账号!");
		return false;
	}
	if (document.getElementById("password").value == "") {
		alert("请输入登录密码!");
		return false;
	}
	return true;
}

/*
 * 添加用户
 */
function addUser() {
	document.manager.action = "user/addUserPage";
	document.manager.submit();
}

/*
 * 导出Excel
 */
function toExecl() {
	document.manager.action = "user/exportExcel";
	document.manager.submit();
}

/*
 * 删除用户
 * */
function deleteUser(object){
	
	//获取所在行
	var tr = object.parentNode.parentNode;
	
	//获取ID
	var id = tr.cells[0].innerText;
	document.getElementById("row").value= id;

	document.manager.action = "user/deleteUser";
	document.manager.submit();
}
