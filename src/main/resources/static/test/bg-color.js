$(function(){
    var i = 0;
    var bgColors = ["#ffff00","#ffcc00","#ff9900","#ff6600","#ff3300","#ff0000","#ccff00","#cccc00","#cc9900","#cc6600"]
     $('#tag-input').on/*bind*/("input propertychange", function () {
            //alert("文本框的值："+$(this).val());
            //这里写你的处理代码
//            var email = $(this).val();
//            var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
//            if(reg.test(email)){
//                //alert("邮箱格式正确");
//                $("#btn_send_code").removeClass("disable");
//            }else{
//                //alert("邮箱格式不正确");
//                $("#btn_send_code").addClass("disable");
//            }
        i ++;
        var _select= i % 10;
        $("body").css("background-color",bgColors[_select]);


       });

});