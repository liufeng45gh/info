
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <meta name="description"  content="注册">
    <title>Oauth2.0-注册 </title>
    <link rel="stylesheet" media="all" href="/oauth2/css/web-09ed578c92dce670ddb2.css" />
    <link rel="stylesheet" media="all" href="/oauth2/css/entry-f3121f603b4ede1d27bc.css" />
    <link href="/oauth2/icon/favicon.ico" rel="shortcut icon" type="image/x-icon">

    <script type="text/javascript" charset="UTF-8" src="/oauth2/script/jquery-1.9.1.min.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <script  type="text/javascript" src="/web/js/common.js"></script>
    <script type="text/javascript" charset="UTF-8" src="/oauth2/script/sign-up.js"></script>
    <!-- End of 访问统计 -->
</head>

<body class="no-padding reader-black-font" lang="zh-CN">
<div class="sign">
    <div class="logo"><a href="/"><img src="/oauth2/svg/panda-index.svg" alt="Logo" /></a></div>
    <div class="main">


        <h4 class="title" style="margin-bottom: 0px">
            <div class="normal-title" >
                <a class="" href="/oauth2/sign-in">登录</a>
                <b>·</b>
                <a id="js-sign-up-btn" class="active" href="/oauth2/sign-up">注册</a>
            </div>
        </h4>

        <div class="js-sign-up-container">
            <form class="new_user" accept-charset="UTF-8" method="post">

                <p class="sign-up-msg">若收不到邮件, 请留意下邮件垃圾箱</p>
                <div class="input-prepend restyle">
                    <input placeholder="昵称" type="text" id="nick_name" />
                    <i class="iconfont ic-user"></i>
                </div>

                <div class="input-prepend restyle no-radius js-normal">
                    <input placeholder="邮箱" type="tel"  id="email" />
                    <i class="iconfont ic-email"></i>
                </div>
                <div class="input-prepend restyle no-radius security-up-code js-security-number">
                    <input type="text"  id="sms_code" placeholder="邮箱验证码" />
                    <i class="iconfont ic-verify"></i>
                    <a tabindex="-1" class="btn-up-resend js-send-code-button disable"  id="btn_send_code">发送验证码</a>
                    <div class="js-geetest-captcha"></div>
                </div>
                <div class="input-prepend">
                    <input placeholder="设置密码" type="password"  id="password" />
                    <i class="iconfont ic-password"></i>
                </div>
                <input type="button" name="commit" value="注册" class="sign-up-button" id="sign_up_btn" data-disable-with="注册" />
                <p class="sign-up-msg">点击 “注册” 即表示您同意并愿意遵守简书<br> <a target="_blank" href="#" onclick="return false">用户协议</a> 和 <a target="_blank" href="#" onclick="return false">隐私政策</a> 。</p>
            </form>
            <!-- 更多注册方式 -->

        </div>

    </div>
</div>

<
</body>
</html>
