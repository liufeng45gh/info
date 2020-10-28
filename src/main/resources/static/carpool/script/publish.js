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
$(function () {
    $("#btn-add-pass").click(function () {
        addPass();
    });
});

