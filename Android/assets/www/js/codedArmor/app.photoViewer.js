/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.photoViewer={
    
    urlPhotosList:[],
    currentPhoto:0,
    viewToRender:"",
    
    init:function(){
        
        this.viewToRender=$(Photoviewer);
        this.setListener();
        this.currentPhoto=cobalt.storage.getItem("currentPhoto","int");
        this.renderCurrentPhoto();
      
    },
    
    setListener:function(){
        
        $('#left').on('tap click',function(){
          console.log(app.photoViewer.currentPhoto);
            if(app.photoViewer.currentPhoto>0){
                app.photoViewer.currentPhoto--;   
            }
            else{               
                app.photoViewer.currentPhoto=app.photoViewer.urlPhotosList.length;              
            }
            app.photoViewer.renderCurrentPhoto();
            cobalt.log(app.photoViewer.currentPhoto);
            return false;
        });
        
        $('#right').on('tap click',function(){
            console.log(app.photoViewer.currentPhoto);
            if(app.photoViewer.currentPhoto<app.photoViewer.urlPhotosList.length){                
                app.photoViewer.currentPhoto++;                
            }           
            else{                
                app.photoViewer.currentPhoto=0;                
            }
            
            app.photoViewer.renderCurrentPhoto();
            cobalt.log(app.photoViewer.currentPhoto);
            return false;
            
        });
        
    },
    getFullSizePhoto:function(){
        
            
        },
    renderCurrentPhoto:function(){
        
       this.viewToRender.css("background-image","url("+this.urlPhotosList[this.currentPhoto].url_o+")");   
        
        
    }    
        
        
    
    
}
