/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



Handlebars.registerHelper('slice', slice);


function slice(text){
			//escape html stuff
                        
                        var width=$('body').width();
                        console.log('taille' +width);
			if(width>400){
                            
                            limit=4000;
                            
                        }
                        else{
                            limit=5000;
                        }
			if (limit && limit >0 && (text+"").length > limit ){
				text=(text+"").slice(0,limit)+"..."
			}
			return new Handlebars.SafeString(text);

		}
