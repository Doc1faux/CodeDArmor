/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.photoViewer={
    
    urlPhotosList:[],
    currentPhoto:0,
    $viewToRender:"",
    
    init:function(){
        
        $viewToRender=$(Photoviewer);
        
        
      
    },
    
    setListener:function(){
        
        $('#left').on('tap click',function(){
          
            if(app.photoViewer.currentPhoto>0){
                app.photoViewer.currentPhoto--;   
            }
            else{               
                app.photoViewer.currentPhoto=app.photoViewer.urlPhotosList.length;              
            }
            app.photoViewer.renderCurrentPhoto();    
        });
        
        $('#right').on('tap click',function(){
            
            if(app.photoViewer.currentPhoto<app.photoViewer.urlPhotosList.length){                
                app.photoViewer.currentPhoto++;                
            }           
            else{                
                app.photoViewer.currentPhoto=0;                
            }
            
            app.photoViewer.renderCurrentPhoto(); 
            
        });
        
    },
    getFullSizePhoto:function(){
        
            
        },
    renderCurrentPhoto:function(){
        
        
    }    
        
        
    
    
}

