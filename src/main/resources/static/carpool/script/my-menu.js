$(function () {
    var activeId = $("#my-menu-active").val();
    if (isEmpty(activeId)) {
        $("#my-publish").addClass("active");
    }else{
        $("#"+activeId).addClass("active");
    }
});