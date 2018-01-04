$(function(){
    //异步校验用户名是否被占用
    $("#username").blur(function(){
        var userName = $(this).val();
        var that = $(this);
        if(userName == null||userName == ''){
            return;
        }
        $.ajax({
            type:"post",
            url:"/userInfo/checkUserName",
            async:true,
            data:{
                userName:userName
            },
            success:function(res){
                var result = jQuery.parseJSON(res);
                var flag = result.result.flag;
                if(!flag){
                    $(".tip2").css("display","inline")
                }else{
                    $(".tip2").css("display","none")
                }
            }
        });
    })
})