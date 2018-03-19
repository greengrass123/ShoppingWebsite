/**
 * Created by yuanchuang on 2018-3-19.
 */
function loginFunc() {
    var userName = $("#userName").val();
    var beforePassword = $("#beforePassword").val();
    if (!isNull(userName) && !isNull(beforePassword)) {
        var MD5Password = $.md5(beforePassword);

        $.ajax({
            type:"post",
            url : ctx+"/user/loginJump",
            data: {
                "userName":userName,"password":MD5Password,
            },
            success:function (data) {

                if(data==2001){
                    alert("无此用户");
                }else if(data==2002) {
                    alert("密码错误");
                }else {
                    window.location.href=ctx+"/";
                }

            },
            error:function (data) {
                alert("添加失败");
            },
        });

    } else {
        alert("请重新输入");

    }
    return false;
}
function isNull(str) {
    if (str == "") return true;
    var regu = "^[ ]+$";
    var re = new RegExp(regu);
    return re.test(str);
}