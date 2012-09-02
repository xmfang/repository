/*
 * author xmfang
 * 2011-08-30
 */

$(document).ready(function() {
	var firstLi = $("ul.tabs li:first");
	firstLi.addClass("active");//Activate first tab
	var iframe = $("#tab").find("iframe");
	iframe.attr("src", firstLi.find("a").attr("href")); //Find the href attribute value to identify the active tab + content
	
	//On Click Event
	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab

		iframe.attr("src", $(this).find("a").attr("href")); //Find the href attribute value to identify the active tab + content
		return false;
	});
});

function setIframeHeight(thisFrame) {
	var frameHeight = 0;
	var defaultHeight = 550;
	if (thisFrame.contentDocument && thisFrame.contentDocument.body.offsetHeight){
		frameHeight = thisFrame.contentDocument.body.offsetHeight;
		if (defaultHeight > frameHeight) {
			thisFrame.height = defaultHeight;
			return;
		}
		thisFrame.height = frameHeight;
	}else if(thisFrame.Document && thisFrame.Document.body.scrollHeight){
		frameHeight = thisFrame.Document.body.scrollHeight;
		if (defaultHeight > frameHeight) {
			thisFrame.height = defaultHeight;
			return;
		}
		thisFrame.height = frameHeight;
	}
}
