/**
 * Created by yuanchuang on 2018-3-18.
 */
$(function () {

    $(".del").bind("click", function (event) {

        var id = $(event.target).attr("data-del");
        event.stopPropagation();//防止冒泡
        event.preventDefault();//阻止a标签跳转
        $.ajax({
            type: "post",
            url: ctx + "/commodity/deleteNoSellCommodity",
            data: {
                "id": id
            },
            success: function (data) {
                $(event.target).hide();

            },
            error: function (data) {
                alert(data);
            },
        });


    });
});