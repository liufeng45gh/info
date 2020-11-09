

function save(){

    var data_send = {};

    data_send.nickname =  $("#nickname").val() ;
    console.log("data_send.nickname: "+data_send.nickname)
    if (isEmpty(data_send.nickname)) {
        layer.msg("昵称必须填写");
        return;
    }

    data_send.phone =  $("#phone").val() ;
    console.log("data_send.phone: "+data_send.phone)
    var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!reg.test(data_send.phone)) {
        layer.msg("手机号码不正确");
        return;
    }

    var request =$.ajax({
        type: 'post',
        url: '/carpool/setting',
        contentType: 'application/json',
        data: JSON.stringify(data_send),
        dataType: 'json',
    });

    request.fail(function( jqXHR, textStatus ) {
        layer.msg("系统错误!",{icon: 5});
    });

    request.done(function(data) {
        if(data.ok){
            layer.msg("修改成功!",{icon: 6});
        }else {
            layer.msg("系统错误!",{icon: 5});
        }
    });

}


$(function () {
    $("#btn-submit").click(function () {
        save();
    });

});

