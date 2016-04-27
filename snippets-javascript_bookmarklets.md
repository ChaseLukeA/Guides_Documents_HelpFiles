##http://www.grymoire.com bookmarklet

javascript:(function(){
	var content = document.getElementById("centerDoc");
	
	var body = document.getElementsByTagName("body")[0];
	body.innerHTML = "";
	
	var wrapper = document.createElement("div");
	wrapper.setAttribute("id", "wrapper");
	wrapper.setAttribute("style", "width: 90%;margin: 0 auto;");
	wrapper.innerHTML = content.innerHTML;
	body.appendChild(wrapper);
	
	var ads = document.querySelectorAll("ins.adsbygoogle");
	Array.prototype.forEach.call(ads, function( node ) {
	    node.parentNode.removeChild( node );
	});
	
	var header = document.getElementsByTagName("head")[0];
	var css = "h1, h2, h3, h4, h5, h6, p { width: 100% }";
	var style = document.createElement("style");
	style.type = "text/css";
	style.appendChild(document.createTextNode(css));
	header.appendChild(style);
	
	window.print();
})()