$(function(){


    $('#sub').click(function(){
        var username = $('.username').val();
        var password = $('.password').val();
        if(username == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '9%');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '42%');
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
                if(res.code == "0000"){
                    sessionStorage.setItem("token",res.data);
                    window.location.href = "/welcome"
                }else{
                    alert(res.msg);
                }
            }
        });


    })

})