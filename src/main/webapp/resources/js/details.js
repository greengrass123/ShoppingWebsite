/**
 * Created by yuanchuang on 2018-3-19.
 */
$(function () {
    $("#detailButton").click(function () {
        var price = $("#price").html();
        var id = $("#commodityID").val();
        var amount = $("#amount").html();

        if (amount <= 0) {
            alert("购买数量要大于0");
            return;
        }
        $.ajax({
            type: "post",
            url: ctx+"/purchase/addShoppingCart",
            data: {
                "price": price, "id": id, "amount": amount,
            },
            success: function (data) {
                alert(data);
            },
            error: function (data) {
                alert("添加失败");
            },
        });
    });

    $("#plusNum").click(function () {
        var amount = $("#amount").html();
        if (isNaN(amount) || parseInt(amount) != amount || parseInt(amount) < 1) {
            amount = 1;
            return;
        }
        $("#amount").html(amount - 1);
    });
    $("#addNum").click(function () {
        var amount = $("#amount").html();
        $("#amount").html(parseInt(amount) + 1);
    })
});