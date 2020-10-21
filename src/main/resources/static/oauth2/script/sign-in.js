$(function (){

    $("#sign-in-btn").click(function () {

        var data_send = {};
        data_send.email = $("#email").val();
        if (isEmpty(data_send.email)) {
            layer.msg("email 不能为空");
            return;
        }

        var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        if(!reg.test(data_send.email)){
            //alert("邮箱格式正确");
            layer.msg("邮箱格式正确");
            return;
        }


        data_send.password = $("#password").val();

        if (isEmpty(data_send.password)) {
            layer.msg("密码 不能为空");
            return;
        }

        if (data_send.password.length<6) {
            layer.msg("密码长度不能小于6");
            return;
        }


        //data_send.password = $("#password_input").val();
        //data_send.random = Math.random();


        var request =$.ajax({
            type: 'post',
            url: '/oauth2/sign-in',
            contentType: 'application/json',
            data: JSON.stringify(data_send),
            dataType: 'json',
        });

        request.fail(function( jqXHR, textStatus ) {
            layer.msg("系统错误!",{icon: 5});
        });

        request.done(function(data) {
            if(data.ok){
                layer.msg("登录成功!",{icon: 6});
                setTimeout(function () {
                    window.location.href="/"
                },1000);
            }else if(data.code == "USER_NOT_EXIST"){
                layer.msg("email不存在!");
            }else if(data.code == "EMAIL_OR_PASSWORD_WRONG"){
                layer.msg("email或密码错误!",{icon: 5});
            }else {
                layer.msg("系统错误!",{icon: 5});
            }
        });
    });
});

