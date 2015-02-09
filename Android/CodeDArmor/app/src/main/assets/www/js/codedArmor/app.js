/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app={
    
    init:function(){
       
    },
    
    touch:function(selector,touchHandler, allowDefault){
		var preventDefault = allowDefault ? false : true;
		var elem=$(selector);
		var touchup=function(){
			elem.removeClass('touched');
		};
		var touching=function(e){
			if (!elem.hasClass('touched')){
				elem.addClass('touched');
				clearTimeout(app.touchTimer);
				app.touchTimer = setTimeout(touchup,1000);
				touchHandler.apply(this,e);
			}
			if (preventDefault)
				return false;
		};
		elem.unbind('tap').on('tap',touching);
		elem.unbind('click').on('click',touching);
	}
   
}
