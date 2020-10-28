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

