$(function () {
    
})

function init(){
    $.ajax({
        type:"get",
        url:"/needLogin/userInfo",
        async:true,
        data:{
            token:sessionStorage.getItem("token")
        },
        success:function(res){
            var code = res.code;
            if(code != '0000'){
                window.location.href= "/static/pages/login.html"
            }
            else{
                console.log($("#username"))
                $("#username").html(res.data.name)
            }
        }

    });
}