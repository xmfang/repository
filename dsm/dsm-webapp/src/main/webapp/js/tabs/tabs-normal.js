/*
 * author xmfang
 * 2011-08-30
 */

$(document).ready(function() {
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content
	
	newTabContent = $(".tab_content:first").clone();
	//On Click Event
	$("ul.tabs li").click(function() {
		return clickLi(this);
	});
});

function clickLi(theLi) {
	$("ul.tabs li").removeClass("active"); //Remove any "active" class
	$(theLi).addClass("active"); //Add "active" class to selected tab
	$(".tab_content").hide(); //Hide all tab content

	var activeTab = $(theLi).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
	$(activeTab).fadeIn(); //Fade in the active ID content
	return false;
}

var newTabContent;
var tabIndex = 2;
function addTab(tabTitle) {
	$("ul.tabs li").removeClass("active"); //Remove any "active" class

	var newLi = "<li onclick='return clickLi(this)' class='active'><a href='#tab" + tabIndex + "'>" + tabTitle + "</a></li>";
	$("ul.tabs").append(newLi);
	
	//"<div id='tab" + tabIndex + "' class='tab_content'></div>";
	var tabContent = $(newTabContent).clone();
	$(tabContent).attr("id", "tab" + tabIndex).hide();
	$(".tab_container").append($(tabContent));
	
	$(".tab_content").hide(); //Hide all tab content
	var activeTab = $(newLi).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
	$(activeTab).fadeIn(); //Fade in the active ID content
	tabIndex ++;
}

function removeTab(tabDiv) {
	var tabId = $(tabDiv).attr("id");
	$(tabDiv).remove();
	$("a[href='#" + tabId + "']").parent().remove();
	$("ul.tabs li:first").click();
}

function reNameTab(tabDiv, newName) {
	var tabId = $(tabDiv).attr("id");
	$("a[href='#" + tabId + "']").text(newName);
}

