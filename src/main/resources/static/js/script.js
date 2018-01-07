// JavaScript Document

$(function() {

    //alert($.cookie('menustatus'));
    if ($.cookie('menustatus') == null) {
        $.cookie('menustatus', '0', { expires: 1 });
    }

    if ($.cookie('menustatus') == '0') {
        $('.menu').css('display', 'none');
    } else if ($.cookie('menustatus') == '1') {
        $('.menu').css('display', 'block');
    }

});



$(function() {
    var nav = $("#nav");
    var menu = $("#menu");
    nav.click(function() {
        nav.find(".nav_anniu").toggleClass("nav_anniu_hover")
        menu.toggle();
        if (menu.css('display') == "block") {
            $.cookie('menustatus', '1');
        } else if (menu.css('display') == "none") {
            $.cookie('menustatus', '0');
        }
    });

});



$(function() {
    var pinlun_anniu = $(".pinlun_anniu");
    var pinlun_con = $(".pinlun_con");
    var icon = $(".pinlun_anniu_icon");
    pinlun_anniu.click(function() {
        pinlun_con.toggle();
        icon.toggleClass("pinlun_anniu_icon_hover")
    });

});




$(function() {

    $("#btnSearch").click(function(event) {
        event.preventDefault();
        if ($("#txtSearch").val() == "undefined" || $.trim($("#txtSearch").val()) == "") {
            alert("搜索内容不能为空!");
        } else {
            window.location.href = "mSearch.aspx@keyword=" + $("#txtSearch").val();
        }



    });

    $("#txtSearch").keypress(function(event) {
        var key = event.which;
        if (key == 13) {
            $("#btnSearch").click();
        }
    });

});

