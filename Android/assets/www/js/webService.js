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
};

var photoConfig ={
    'api_key': '84d459948b86bb12867e416ae7b42077',
    photoset_id: '72157632762645410'
}   ;

var infoGplus ={
    'aboutMe':null,
    'coverUrl':null,
    'avatarUrl':null
};

var events =[
    
];
var videos=[
    
];
var photos=[
    
];
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
            console.log("Fail to contact server at adress : "+settings.url);
        }
        
        
        
    };
    
    $.ajax(settings);
    
}

function getVideos(callback){
    
    var settings={
        url:"http://gdata.youtube.com/feeds/users/UC3MIXkWlQAvzQLa3ALbSqhg/uploads?alt=json-in-script",
        type : 'GET',
        dataType:'jsonp',
        success:function(data){
            var entry=[];
            entry =data.feed.entry;
            var i;
          for(i=0; i<entry.length; ++i){ 
                
                videos.push(video={
                    id:i,
                    title: entry[i].title.$t,
                    thumbnail: entry[i].media$group.media$thumbnail[0].url,
                    link:entry[i].link[0].href
                });
            
          }
          console.log(videos);
          callback();
        },      
        error:function(data){
                
            nativeBridge.log("fail : "+data);
            
        }
    };
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
        },
        error:function(data){
            console.log("Fail to contact server at adress : "+settings.url);
        }
        
        
        
    };
    
    
    
    $.ajax(settings);
    
}




function buildEventBriteUrl(){
    
    
}


