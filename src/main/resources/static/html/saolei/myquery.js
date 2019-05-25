/*

author : 大钢牙
created  in :2019.05.25


 */

function Mq(){
	this.type = 'Mq';
}

 

var MQ = (selector) =>{
	
	var obj = new Mq();

	obj.MQ = [];

	if(selector instanceof HTMLElement){
			// console.log(selector)
		
		obj.MQ.push(selector);
	
		
	}else{
		obj.MQ =document.querySelectorAll(selector);
	}

	obj.get = (index)=>{
		return obj.MQ[index];
	}
	

	obj.find = (selector) =>{
		var res = [];
		// obj.MQ = res; = [];
		for(var i = 0;i < obj.MQ.length;i++){
			var res1 = obj.MQ[i].querySelectorAll(selector);
			for(var j = 0; j < res1.length;j++){
				res.push(res1[j]);
			}
			
		}
		obj.MQ = res;
		return obj;
	}

	obj.css = (styleprop,val) =>{
		var defaultSuffix = 'px';
		var val_;
		if(val == undefined){
			return obj.MQ.style[styleprop];
		}

		if(typeof(val) == 'number'){
			val_ =  val + defaultSuffix;
		}else if(typeof(val) == 'string'){
			val_ =  val;
		}
		for(var i = 0;i < obj.MQ.length;i++){

			obj.MQ[i].style[styleprop] = val_;
		}

		return obj;
	}

	obj.append = (o) =>{
		if(o.type == obj.type){

		}else if(typeof(o) == 'string'){
			
			for(var i = 0;i < obj.MQ.length;i++){
				 // console.log(obj.MQ[i].innerHTML);
				obj.MQ[i].innerHTML =  obj.MQ[i].innerHTML+o;
			}
		}
	}

	obj.click = (func) =>{
		for(var i = 0;i < obj.MQ.length;i++){
				// console.log(obj.MQ[i].innerHTML);
				
				var that = obj.MQ[i]
				// console.log(that);
				
				that.onclick = function(event){
					event.stopPropagation(); 
					if(func != null && func != undefined){
						
						func(this,obj);
					}
				}				
		}
	}

	obj.text = () => {
		var text = '';
		for(var i = 0;i < obj.MQ.length;i++){
				text += obj.MQ[i].innerHTML;
		}
		return text;
	}

	obj.attr = (atr, val ) =>{
		if(val == undefined || val == null){
			
			if(obj.MQ.length == 1){
				  // console.log(obj.MQ)
				  //  console.log(obj.MQ[0].getAttribute(atr))
				// alert(obj.MQ[0].getAttribute(atr))
				return obj.MQ[0].getAttribute(atr);

			}
			return null;
		}

		for(var i = 0;i < obj.MQ.length;i++){
				obj.MQ[i].setAttribute(atr , val);
		}

		return obj;
	}

	// console.log(obj)

	return obj;
}
		
function getById(id){

	return document.getElementById(id);
}

function attr(dom,attr){
	return dom.getAttribute(attr);
}

function css(id,style,val){
	getById(id)[style] = val;
}

// function rnd( seed ){
//     seed = ( seed * 9301 + 49297 ) % 233280; //为何使用这三个数?
//     return seed / ( 233280.0 );
// };

function rand(number){

	var ran = Math.random(number);
	var res = Math.round (ran *100)
	
	while(res >= number){
		res = res - number;
	}

	// console.log(number + ' '  +res );
	
  return res
};

