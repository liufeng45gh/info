$(function (){
    $('#email').on/*bind*/("input propertychange", function () {
        alert("文本框的值："+$(this).val());
        //这里写你的处理代码
        var email = $(this).val();
        var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        if(reg.test(email)){
            //alert("邮箱格式正确");
            $("#btn_send_code").removeClass("disable");
        }else{
            //alert("邮箱格式不正确");
            $("#btn_send_code").addClass("disable");
        }
        
    });

    $("#btn_send_code").click(function () {
        if ($(this).hasClass("disable")) {
            return;
        }

    });
});

