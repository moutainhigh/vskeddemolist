
$(function(){
	$('#spId').combobox({
	    url:basePath+'permissionListDataAll',
	    valueField:'SPID',
	    textField:'SPNICK'
	});
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#sfValue').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var sfValue=$('#sfValue').val();
	var spId=$('#spId').val();
	var sfType=$('input:radio[name="sfType"]:checked').val();
	var myBasePath=$('#fm').attr("action");
	$.post(myBasePath,
			{
		sfValue: sfValue,
		spId:spId,
		sfType:sfType
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('functionAddProc:post','addBt');
}