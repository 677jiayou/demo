$().ready(function () {
    $("#btn_login").click(function () {
        //获取用户输入的用户名
        var username=$("#login_username").val();
        //获取用户输入的密码
        var password=$("#login_password").val();
        if(username==""&&password!=""){
            $("#np-warning").html("请输入用户名！");
        }else if (password==""&&username!=""){
            $("#np-warning").html("请输入密码！");
        }else if (username==""&&password==""){
            $("#np-warning").html("请输入用户名和密码！");
        }else {
            $.ajax({
                url: "actionLogin.do" ,//url
                type: "POST",//方法类型
                data: {"loginUserName":username,"loginPassword":password},
                dataType: "Json",//预期服务器返回的数据类型
                success: function (response) {
                    //response为布尔值，true时表示用户名密码输入正确，我们返回首页，false表示输入错误
                    if(response!=null){
                        if (response.position.level=="人事部主任") {
                            location.href="index1.do"
                        }else
                        if (response.position.level=="人事部员工") {
                            location.href="index2.do"
                        }
                        else
                        if (response.position.level=="部门主任") {
                            location.href="index3.do"
                        }else {
                            location.href="index4.do"
                        }
                    }else{
                        $("#np-warning").html("*用户名或者密码错误！请重新输入");
                        // alert("用户名或者密码错误！")
                    }

                },
                error : function() {
                    $("#np-warning").html("*用户名或者密码错误！请重新输入");
                }
            });

        }
    });
    $("#login_form").validate({
        // 当标签获得焦点时暂时清除表单验证
        focusCleanup:true,
        //当标签失去焦点时进行表单验证
        onfocusout: function (element) {
            $(element).valid();
        },
        rules: {
            //name为login_username的验证规则
            employeeNumber: {
                //是否必须填写
                required: true
            },
            //name为password的验证规则
            password: {
                //是否必须填写
                required: true
            },

            //不符合验证规则时的提示信息
            messages: {
                //name为mployeeNumber的标签中内容不符合验证规则时的提示信息
                employeeNumber: {
                    //未填写时的提示信息
                    required: "请输入用户名"
                },
                //name为password的标签中内容不符合验证规则时的提示信息
                password: {
                    //未填写时的提示信息
                    required: "请输入密码"

                }
            }
        }
    });

    //光标移入错误提示移除
    $("#login_username,#login_password").focus(function () {
        $("#np-warning").html("");
    });

});//ready