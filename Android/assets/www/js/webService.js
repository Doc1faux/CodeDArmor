var config = {
    'name'          : "Code d'Armor",
    'id'            : "105840950870167242716",
    'google_api'    : "AIzaSyBj2tvS2t-T6ZTGhDoGWsNC-N5RNVm5L2Y",
    'pwa_id'        : "", //Picasa web album id
    
    'cover_photo'   : true, //Make sure you have 940x180 image
    'cover_color'   : '#ffffff',
    'custom_albums' : {
        events : {
            
            
        }
    }
}

var photoConfig ={
    'api_key': '84d459948b86bb12867e416ae7b42077',
    photoset_id: '72157632762645410'
}   

var infoGplus ={
    'aboutMe':null,
    'coverUrl':null,
    'avatarUrl':null
}
var events =[
    
]
function processInfoGplus(data){
    infoGplus.aboutMe=data.aboutMe;
    infoGplus.coverUrl=data.cover.coverPhoto.url;
    infoGplus.avatarUrl=data.image.url;
    
}


function getInfoGplus(){
    
    var settings={
        url:"https://www.googleapis.com/plus/v1/people/"+config.id+"?fields=aboutMe%2Ccover%2CdisplayName%2Cimage%2CplusOneCount&key="+config.google_api,
        type : 'GET',
        dataType:"json",
        success:function(data){
            processInfoGplus(data);
            
            
        },
        error:function(){
            console.log("Fail to contact server at adress : "+url);
        }
        
        
        
    }
    
    $.ajax(settings);
    
}

function getEvents(callback){
    
    var settings={
        url:"http://gdgfresno.com/gdgfeed.php?id="+config.id,
        type : 'GET',
        dataType:"json",
        success:function(data){
            events=data;
            callback();
            console.log(events);
        },
        error:function(data){
            console.log("Fail to contact server at adress : "+url);
        }
        
        
        
    }
    
    
    
    $.ajax(settings);
    
}

function jsonFlickrApi(data){
    console.log(data);
}

function getPhotos(setId){
    
    var settings={
        url:"http://api.flickr.com/services/rest/?&method=flickr.photosets.getPhotos&api_key=" + photoConfig.api_key + "&photoset_id=" + setId+ "&format=json&media=photos&extras=url_o",
        type : 'GET',
        dataType:'jsonp',
        success:function(data){
            events=data;
            console.log(data);
        },
        error:function(data){
            
                alert("wrong structure : ");
                console.log(data);
            
        }
        
       
        
    }
    
    
    
    $.ajax(settings);
    
}
function jsonFlickrApi(data){
    console.log(data);
}

function getVideos(){
    
    var settings={
        url:"http://gdata.youtube.com/feeds/users/UC3MIXkWlQAvzQLa3ALbSqhg/uploads?alt=json-in-script",
        type : 'GET',
        dataType:'jsonp',
        success:function(data){
            console.log(data);
        },
        error:function(data){
                
                console.log("fail : "+data);
            
        }
        
       
        
    }
    
    
    
    $.ajax(settings);
    
}
