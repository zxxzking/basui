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
            url:"http://localhost:9093/userInfo/checkUserName",
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


    $('#sub').click(function(){
        var username = $('.username').val();
        var password = $('.password').val();
        var password2 = $('.password2').val();
        if(username == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '15px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '48px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        if(password2 == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '84px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.password2').focus();
            });
            return false;
        }
        if(password != password2){
            $('.tip').fadeOut('fast', function(){
                $(this).css('display', 'inline');
            });
            $('.tip').fadeIn('fast', function(){
                $(this).parent().find('.password2').focus();
            });
            return false;
        }
        $('.tip').css('display','none');
        $('.tip2').css('display','none');
        $('.error').css('display','none');
        $.ajax({
            type:"post",
            url:"/userInfo/register",
            async:true,
            data:{
                username:username,
                password:password
            },
            success:function(res){
                alert(res)
                res = JSON.parse(res);
                console.log(res)
                if(res.code == "0000"){
                    window.location.href = "/"
                }else{
                    alert(res.msg);
                }
            }
        });
    });






})