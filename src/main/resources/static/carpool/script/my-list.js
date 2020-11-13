function deleteCarpool(id) {
    if(!confirm("确定删除?")){
        return;
    }
    var request =$.ajax({
        type: 'delete',
        url: '/carpool/'+id,
        contentType: 'application/json',
        data: {},
        dataType: 'json',
    });

    request.fail(function( jqXHR, textStatus ) {
        layer.msg("系统错误!",{icon: 5});
    });

    request.done(function(data) {
        if(data.ok){
            layer.msg("删除成功!",{icon: 6});
            setTimeout(function () {
                window.location.href="/carpool/my";
            },1000);
        }else {
            layer.msg("系统错误!",{icon: 5});
        }
    });
}

function pushToBaidu(id) {
    var pushUrl = '/carpool/push-baidu/'+ id;
    var request =$.ajax({
        type: 'post',
        url: pushUrl,
        crossDomain: true,
        data: {},
        dataType: 'json',
    });

    request.fail(function( jqXHR, textStatus ) {
        layer.msg("系统错误!",{icon: 5});
    });

    request.done(function(data) {
        if(data.ok){
            layer.msg("收录请求已提交!",{icon: 6});
        }else {
            layer.msg("系统错误!",{icon: 5});
        }
    });
}