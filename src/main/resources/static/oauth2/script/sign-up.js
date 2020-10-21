$(function (){
    $('#email').on/*bind*/("input propertychange", function () {
        //alert("文本框的值："+$(this).val());
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
        var data_send = {};
        data_send.email = $("#email").val();
        //data_send.password = $("#password_input").val();
        //data_send.random = Math.random();


        var request =$.ajax({
            type: 'post',
            url: '/oauth2/sign-up/send-code',
            data: data_send,
            dataType: 'json'
        });

        request.fail(function( jqXHR, textStatus ) {
            layer.msg("系统错误!",{icon: 5});
        });

        request.done(function(data) {
            //check_result = true;
            if(data.ok){
                //check_result = true;
                layer.msg("验证码已发送",{icon: 6});
            }else{
                //check_result = false;
                layer.msg("email已经注册 请登录!");
            }
        });
    });

    $("#sign_up_btn").click(function () {

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

        data_send.nickName = $("#nick_name").val();

        if (isEmpty(data_send.nickName)) {
            layer.msg("昵称 不能为空");
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

        data_send.code = $("#sms_code").val();

        if (isEmpty(data_send.code)) {
            layer.msg("邮箱验证码 不能为空");
            return;
        }
        //data_send.password = $("#password_input").val();
        //data_send.random = Math.random();


        var request =$.ajax({
            type: 'post',
            url: '/oauth2/sign-up',
            contentType: 'application/json',
            data: JSON.stringify(data_send),
            dataType: 'json',
        });

        request.fail(function( jqXHR, textStatus ) {
            layer.msg("系统错误!",{icon: 5});
        });

        request.done(function(data) {
            if(data.ok){
                layer.msg("注册成功!",{icon: 6});
                setTimeout(function () {
                    window.location.href="/"
                },1000);
            }else if(data.code == "USER_EXIST"){
                layer.msg("email 已经存在请直接登录!");
            }else if(data.code == "CODE_NOT_EQUALS"){
                layer.msg("验证码不正确!",{icon: 5});
            }else {
                layer.msg("系统错误!",{icon: 5});
            }
        });
    });
});

