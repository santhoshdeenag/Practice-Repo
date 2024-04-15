window.onload = function exampleFunction() { 
    var pagePath = $("#path").data("page-path").toString();
    $.ajax({
    type : "GET",
        url : pagePath+"/jcr:content",
    success: function(res) {
        var resdata = res;
        var print=resdata['pageTitle'].toString();
        document.getElementById("pageTitle").innerHTML = print;
    }
	});
} 