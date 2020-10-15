;!function (win) {
	"use strict";
	
	var Pro = function(){
		this.name = "请求对象";
	};
	
	/**
	调用服务接口  service-服务名（springBean名）  method-调用的方法名   params-参数对象   , func 回调函数
	*/
	Pro.prototype.callServer= function(service ,method , params ,func){
		axios({
			    method: 'post',
			    url: '/serviceCtl',
			    data:{
			    	serviceName : service,
			    	methodName : method,
			    	params : params
			    }
		    }
		).then(function(res){
			func(res)
		});
	}
	
	
	
	
	win.pro = new Pro();
	
	win.loadCss = function(url) {
			var link = document.createElement('link');
			link.rel = "stylesheet";
			link.type = "text/css";
			link.href = url;
			var head = document.getElementsByTagName("head")[0];
			head.appendChild(link);
	};
}(window);


