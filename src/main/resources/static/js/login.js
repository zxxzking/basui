$(function(){


    $('#sub').click(function(){
        var username = $('.username').val();
        var password = $('.password').val();
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
        $('.tip').css('display','none');
        $('.tip2').css('display','none');
        $('.error').css('display','none');


        $.ajax({
            type:"post",
            url:"/userInfo/login",
            async:true,
            data:{
                username:username,
                password:password
            },
            success:function(res){
                res = JSON.parse(res);
                console.log(res)
                if(res.code == "0000"){
                    window.location.href = "/welcome"
                }else{
                    alert(res.msg);
                }
            }
        });


    })






})