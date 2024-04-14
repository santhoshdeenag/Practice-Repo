window.onload = function exampleFunction() { 
    console.log('The Script will load now.');
    $.ajax({
    type : "GET",
        url : "/content/aemgeeks/us/en/lab-test-hyundai/jcr:content",
    success: function(res) {
        var resdata = res;
     	//alert(resdata['pageTitle']);
        var print=resdata['pageTitle'].toString();
        console.log(print);
        document.getElementById("pageTitle").innerHTML = print;
    }
	});
} 