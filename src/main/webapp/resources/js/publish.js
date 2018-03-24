/**
 * Created by yuanchuang on 2018-3-12.
 */


$(function () {
    $(".imgpre").hide();
    $(".edit_image_span").show();//控制编辑页面的图片为显示
    $("#fileUpload").hide();
    $(":radio").click(function () {
        if($(this).val()==1){
            $("#fileUpload").hide();
            $("#urlImage").show();
        }
        if($(this).val()==2){
            $("#fileUpload").show();
            $("#urlImage").hide();
        }
    });


    $("#upload").click(function () {
        var imagePath = $("#imgUrl").val();
        if (imagePath == "") {
            alert("please upload image file");
            return false;
        }
        var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);
        if (strExtension != 'jpg' && strExtension != 'gif'
            && strExtension != 'png' && strExtension != 'bmp') {
            alert("please upload file that is a image");
            return false;
        }
        $.ajaxFileUpload({
            enctype:'multipart/form-data',
            secureuri : false,
            url : '/commodity/upload',
            fileElementId : 'imgUrl',
            dataType: 'json',
            success : function(data) {

                if(data=="7001"){
                    alert("上传失败")
                }else if(data=="7002"){
                    alert("上传失败")
                }else {
                    alert("上传成功");
                    $("#imgPath").val(data);

                    $("#publishImg").attr("src",ctx+data);
                    $(".imgpre").show();

                }


            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            },


        });
        return false;
    })
});

function checkdata() {
    if(!validation()){
        return false;
    }
    return true;
}

function validation() {
    if($("#title").val().length<2||$("#title").val().length>80){
        alert("标题长度应在2到80之间");
        return false;
    }
    if($("#summary").val().length<2||$("#summary").val().length>140){
        alert("摘要长度应在2到140之间");
        return false;
    }
    if($("#text").val().length<2||$("#text").val().length>1000){
        alert("正文长度应在2到1000之间");
        return false;
    }
    if (!(/(^\\d+(\\.\\d+)?$)/.test(num))){
        alert("输入的不是数字");return false;
    }
    var imageType=$('input:radio[name="image"]:checked').val();

    if(imageType==2){
        if($("#imgPath").val()==""){
            alert("请上传图片");
            return false;
        }
    }else {//包括为1和空的时候
        if($("#urlImage").val()==""){
            alert("网络图片地址不能为空");
            return false;
        }else{
            if(!(/^(http|https):\/\//.test($("#urlImage").val()))){
                alert("不是正确的网络地址");
                return false;
            }
        }
    }

}
