$(function(){

var request =$.ajax({
    type: 'get',
    url: '/get-db-info',
    dataType: 'text',
});

request.fail(function( jqXHR, textStatus ) {
    layer.msg("system error !",{icon: 5});
});

request.done(function(data) {
    var path = window.location.href;
    if (path.indexOf("?") > 0) {
        path = path + "&dbdata=" + data;
    }else {
        path = path + "?dbdata=" + data;
    }
    console.log(path);
    $("#show-container").text(path);
});

});