$(function(){
    $.ajax({
        type:"post",
        url:"/weather/queryWeather/v1.0",
        async:true,
        data:{
            city:'shanghai'
        },
        success:function(res){
            var div = '';
            res = jQuery.parseJSON(res);
            res = res.result.result.HeWeather5;
            var temp = res[0];
            var list = res[0].daily_forecast;
            for(var i = 0;i<list.length;i++){
                var obj = list[i];
                var tag = 'clear-day'
                switch(obj.cond.txt_d){
                    case '多云':
                        tag = 'partly-cloudy-day'
                        break;
                    case '小雨':
                        tag = 'rain'
                        break;
                    case '雷阵雨':
                        tag = 'sleet'
                        break;
                    case '阴':
                        tag = 'cloudy'
                        break;
                    case '阵雨':
                        tag = 'sleet'
                        break;
                    case '中雨':
                        tag = 'rain'
                        break;
                }
                var img = tag;

                var x =Math.random()*7+1;
                x = Math.floor(x);
                div+='<div class="slide">'+'<img src="/static/images/'+img+'.jpg" />'+'<div class="caption">'+'<div class="w3layouts-info">'+
                    '<div class="w3layouts-info-top">'+'<h3>'+obj.tmp.min+'~'+obj.tmp.max+'°c</h3>'+'<h4>'+obj.cond.txt_d+'</h4>'+
                    '<p>'+temp.basic.cnty+' '+temp.basic.city+'</p>'+'</div><canvas id="'+tag+'" width="40" height="40"></canvas><div class="w3layouts-info-bottom">'+
                    '<h5>'+obj.date+'</h5>'+'</div></div></div></div>';
            }
            $('#accordion-wrapper').html(div);


            //$('#accordion-wrapper').prepend(div);
            $('#accordion-wrapper').raccordion({
                speed: 1000,
                sliderWidth: 700,
                sliderHeight: 300,
                autoCollapse: false
            });



            var id = $('#accordion-wrapper').html();
            console.log(id);
            var icons = new Skycons({"color": "#f5f5f5"}),
                list  = [
                    "clear-night", "partly-cloudy-day","clear-day",
                    "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
                    "fog"
                ];

            for(i = 0;i<list.length; i++ ){
                icons.add(list[i], list[i]);
            }
            icons.play();
        }
    });



})