function addPass() {
    var passArray = $(".information").find(".pass-place");
    console.log(passArray);
    if (passArray.length >=3) {
        return;
    }
    var content = $("#pass-template").html();
    console.log(content);
    $("#pass-point").before(content);
}
function removePass(btn){
    console.log("removePass called")
    $(btn).parent().parent().remove();
}
function save(){
    var placeArray = $(".information").find(".place");
    $.each(placeArray,function () {
        var value = $(this).val();
        if (isEmpty(value)) {
            layer.msg("必须字段填写不完整");
            return;
        }
    });
    var shortTextArray = $(".information").find(".short-text");
    $.each(shortTextArray,function () {
        var value = $(this).val();
        if (isEmpty(value)) {
            layer.msg("必须字段填写不完整");
            return;
        }
    });

    var data_send = {};
    data_send.from = $("#from-province").val() + "," + $("#from-city").val() + "," + $("#from-district").val();
    console.log("data_send.from: "+data_send.from)
    data_send.to = $("#to-province").val() + "," + $("#to-city").val() + "," + $("#to-district").val();
    console.log("data_send.to: "+data_send.to)
    var $passArray = $(".information").find(".pass-place");
    if ($passArray.length >0) {
        $inputs1= $passArray.eq(0).find("input");
        console.log("$inputs1.length: "+$inputs1.length)
        data_send.pass1 = $inputs1.eq(0).val() + "," + $inputs1.eq(1).val() + "," + $inputs1.eq(2).val();
        console.log("data_send.pass1: "+data_send.pass1)
    }

    if ($passArray.length >1) {
        $inputs2= $passArray.eq(1).find("input");
        console.log("$inputs2.length: "+$inputs2.length)
        data_send.pass2 = $inputs2.eq(0).val() + "," + $inputs2.eq(1).val() + "," + $inputs2.eq(2).val();
        console.log("data_send.pass2: "+data_send.pass2)
    }
    if ($passArray.length >2) {
        $inputs3= $passArray.eq(2).find("input");
        console.log("$inputs3.length: "+$inputs3.length)
        data_send.pass3 = $inputs3.eq(0).val() + "," + $inputs3.eq(1).val() + "," + $inputs3.eq(2).val();
        console.log("data_send.pass3: "+data_send.pass3)
    }
    data_send.departureTime =  $("#departure-day ").val() + " " + $("#departure-hour").val() + ":" + $("#departure-minute").val();
    console.log("data_send.departureTime: "+data_send.departureTime)

    data_send.comment =  $("#comment ").val() ;
    console.log("data_send.comment: "+data_send.comment)

    data_send.site =  $("#site").val() ;
    console.log("data_send.site: "+data_send.site)
    if (isNaN(data_send.site)) {
        layer.msg("座位必须为数字");
        return;
    }

    data_send.linkman =  $("#linkman").val() ;
    console.log("data_send.linkman: "+data_send.linkman)

    data_send.phone =  $("#phone").val() ;
    console.log("data_send.phone: "+data_send.phone)
    var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!reg.test(data_send.phone)) {
        layer.msg("手机号码不正确");
        return;
    }

    layer.load(2);
    var request =$.ajax({
        type: 'post',
        url: '/carpool/publish',
        contentType: 'application/json',
        data: JSON.stringify(data_send),
        dataType: 'json',
    });

    request.fail(function( jqXHR, textStatus ) {
        layer.msg("系统错误!",{icon: 5});
    });

    request.done(function(data) {
        if(data.ok){
            layer.msg("发布成功!",{icon: 6});
            setTimeout(function () {
            window.location.href="/carpool/my";
            },1000);
        }else {
            layer.msg("系统错误!",{icon: 5});
        }
    });

}

function initSelect(){
    for (var i = 0;i<24 ;i++ ) {
        var text = i;
        if (i<10) {
            text = "0" + i;
        }
        var value = text;
        $("#departure-hour").append("<option value='"+value+"'>"+text+"</option>");
    }

    for (var i = 0;i<60 ;i=i+5 ) {
        var text = i;
        if (i<10) {
            text = "0" + i;
        }
        var value = text;
        $("#departure-minute").append("<option value='"+value+"'>"+text+"</option>");
    }

}
$(function () {
    initSelect();
    $("#btn-submit").click(function () {
        save();
    });

});

