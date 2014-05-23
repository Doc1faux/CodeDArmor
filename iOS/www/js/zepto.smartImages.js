(function($){
	$.extend($.fn, {
    smartImage: function(){
      // `this` refers to the current Zepto collection.
      // When possible, return the Zepto collection to allow chaining.
	    $(this).find('.smartImageFakeImage').each(function(){
		        var image=$(this);
			    var url=image.attr('data-src');
			    if (url && url!="" && url!="(null)" && !image.attr('background-image')){
			        //if data-src is defined, load it and fade it in.
			        var _img = new Image();
				    _img.src=url;
				    _img.onload=function(){
					    image.css({
						   'background-image' : 'url('+url+')',
						    opacity : 1
					    });
					    image.parent().parent().find('.imageLoader').hide();
			        };
		        }else{
				    image.parent().addClass('no_url');
			    }

	    });



	    return this;
    }
  });
})(Zepto);
