
jQuery(document).ready(function() {

    $('#sub').click(function(){
        var username = $('.username').val();
        var password = $('.password').val();
        var password2 = $('.password2').val();
        if(username == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        if(password2 == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '165px');
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

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
