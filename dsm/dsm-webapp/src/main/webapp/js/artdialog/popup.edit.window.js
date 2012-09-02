/*
 * 弹出编辑页面窗口
 * author xmfang
 */
document.write('<script src="/dsm/js/artdialog/jquery.artDialog.basic.js"></script>'); 	

(function (config) {
	config['lock'] = true;
	config['yesText'] = 'yes';
	config['noText'] = 'no';
})(art.dialog.defaults);

function popupWin(winTitle, winContent) {
	$.dialog({
		id:'edit',
		padding: 0,
		opacity: 0.1,
		title: winTitle,
		content: winContent
	});
}

function closeEditPage(prompt) {
	alert(prompt);
	$.dialog({id:'edit'}).close();
	location.reload();
}
