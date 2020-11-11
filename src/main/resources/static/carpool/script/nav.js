
var searchParam = {};
searchParam.offset = 0;

$(function () {
    var optMouseover = false;
    $("#user-opt").mouseover(function () {
        //console.log("$(\"#user-opt\").mouseover has been called");
        $(this).addClass("open");
        optMouseover = true;
    });

    $("#user-opt").mouseout(function () {
        //console.log("$(\"#user-opt\").mouseover has been called");
        optMouseover = false;
        setTimeout(function () {
            if(!optMouseover){
                $("#user-opt").removeClass("open");
            }
        },1000);
    });

    $("#search-btn").click(function () {
        if ($("#search-result").length == 0) {
            layer.msg("本页面不支持搜索");
            return;
        }
        searchParam.from = $("#search-from").val();
        if (isEmpty(searchParam.from)) {
            layer.msg("起始位置不能为空");
            return;
        }
        searchParam.to = $("#search-to").val();
        if (isEmpty(searchParam.to)) {
            layer.msg("终点位置不能为空");
            return;
        }
        searchParam.date = $("#search-date").val();
        if (isEmpty(searchParam.date)) {
            layer.msg("日期不能为空");
            return;
        }
        searchParam.offset = 0;
        searchParam.limit = 20;
        $("#search-result").empty();

        var request =$.ajax({
            type: 'post',
            url: '/carpool/search',
            data: searchParam,
            dataType: 'json',
        });

        request.fail(function( jqXHR, textStatus ) {
            layer.msg("系统错误!",{icon: 5});
        });

        request.done(function(data) {
            if(data.ok){
                //layer.msg("返回成功!",{icon: 6});
                randerBackResult(data);

            }else {
                layer.msg("系统错误!",{icon: 5});
            }
        });
    });

    $("#load-more-btn").click(function () {
        if (searchParam.offset == 0) {
            layer.msg("不能直接点击此按钮");
            return;
        }

        var request =$.ajax({
            type: 'post',
            url: '/carpool/search',
            data: searchParam,
            dataType: 'json',
        });

        request.fail(function( jqXHR, textStatus ) {
            layer.msg("系统错误!",{icon: 5});
        });

        request.done(function(data) {
            if(data.ok){
                //layer.msg("返回成功!",{icon: 6});
                randerBackResult(data);

            }else {
                layer.msg("系统错误!",{icon: 5});
            }
        });
    });
    
    
});

function randerBackResult(data) {
    for (var i = 0; i< data.data.length; i++) {
        var carpool = data.data[i];
        var template = $("#item-template").html();
        //var title = data.data.from
        template = template.replaceAll("--from--",carpool.from);
        template = template.replaceAll("--to--",carpool.to);
        if (null == carpool.pass1) {
            carpool.pass1 = "";
        }
        template = template.replaceAll("--pass1--",carpool.pass1);
        if (null == carpool.pass2) {
            carpool.pass2 = "";
        }
        template = template.replaceAll("--pass2--",carpool.pass2);
        if (null == carpool.pass3) {
            carpool.pass3 = "";
        }
        template = template.replaceAll("--pass3--",carpool.pass3);
        template = template.replaceAll("--departureTime--",carpool.departureTime);
        template = template.replaceAll("--linkman--",carpool.linkman);
        template = template.replaceAll("--site--",carpool.site);
        $("#search-result").append(template);
    }
    if (data.data.length>0) {
        $("#load-more-btn").show();
        searchParam.offset = searchParam.offset + data.data.length;
    }else {
        layer.msg("无数据返回");
    }

}

