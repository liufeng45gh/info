
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <!-- Apple -->
    <meta name="apple-mobile-web-app-title" content="重置密码">
    <title>Oauth2.0-用邮箱重置密码 </title>
    <link rel="stylesheet" media="all" href="/oauth2/css/web-09ed578c92dce670ddb2.css" />

    <link rel="stylesheet" media="all" href="/oauth2/css/entry-f3121f603b4ede1d27bc.css" />

    <script type="text/javascript" charset="UTF-8" src="/oauth2/script/jquery-1.9.1.min.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <script  type="text/javascript" src="/web/js/common.js"></script>
    <script type="text/javascript" charset="UTF-8" src="/oauth2/script/email-reset.js"></script>

    <link href="/oauth2/icon/favicon.ico" rel="shortcut icon" type="image/x-icon">


</head>

<body class="no-padding reader-black-font" lang="zh-CN">
<div class="sign">
    <div class="logo"><a href="/"><img src="/oauth2/svg/panda-index.svg" alt="Logo" /></a></div>
    <div class="main">


        <!-- <h4 class="reset-title">用邮箱重置密码</h4> -->
        <h4 class="reset-title" style="margin-bottom: 0px">用邮箱重置密码</h4>
        <!-- 用邮箱重置密码 -->
        <form action="#" accept-charset="UTF-8" method="post">
            <p class="sign-up-msg">若收不到邮件, 请留意下邮件垃圾箱</p>
            <div class="input-prepend restyle no-radius">
                <input type="text" name="email" id="email" placeholder="请输入注册或绑定的邮箱" />
                <i class="iconfont ic-email"></i>
            </div>
            <div class="input-prepend restyle no-radius security-up-code js-security-number">
                <input type="text" name="email_code" id="email_code" placeholder="邮箱验证码" />
                <i class="iconfont ic-verify"></i>
                <a class="btn-in-resend js-send-code-button disable" id="btn_send_code">发送验证码</a>
            </div>
            <div class="input-prepend restyle no-radius">
                <input type="password"  id="password" placeholder="请输入新密码" />
                <i class="iconfont ic-password"></i>
            </div>
            <div class="input-prepend">
                <input type="password"  id="password_confirmation" placeholder="请再输入一遍新密码" />
                <i class="iconfont ic-password"></i>
            </div>
            <input type="button"  value="重置密码" class="sign-in-button" data-disable-with="重置密码" id="reset-btn" />
        </form><a class="return" href="/oauth2/sign_in"><i class="iconfont ic-back"></i> 返回登录注册</a>

    </div>
</div>


</body>
</html>
