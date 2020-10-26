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
});