
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <!-- Start of Baidu Transcode -->
    <meta name="description"  content="信息网">
    <title>Oauth2.0-授权登录</title>
    <link rel="stylesheet" media="all" href="/oauth2/css/common.css" />
    <link rel="stylesheet" media="all" href="/oauth2/css/sign-in.css" />
    <!--
    <link rel="stylesheet" media="all" href="/oauth2/css/web-09ed578c92dce670ddb2.css" />
    -->
    <link rel="stylesheet" media="all" href="/oauth2/css/entry-f3121f603b4ede1d27bc.css" />

    <script type="text/javascript" charset="UTF-8" src="/oauth2/script/jquery-1.9.1.min.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <script  type="text/javascript" src="/web/js/common.js"></script>
    <script type="text/javascript" charset="UTF-8" src="/oauth2/script/sign-in.js"></script>
    <link href="/oauth2/icon/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <!-- End of 访问统计 -->
</head>

<body class="no-padding reader-black-font" lang="zh-CN">
<div class="sign">
    <div class="logo"><a href="/"><img src="/oauth2/svg/panda-index.svg" alt="Logo" /></a></div>
    <div class="main">


        <h4 class="title">
            <div class="normal-title">
                <a class="active" href="/oauth2/sign-in">登录</a>
                <b>·</b>
                <a id="js-sign-up-btn" class="" href="/oauth2/sign-up">注册</a>
            </div>
        </h4>
        <div class="js-sign-in-container">
            <form id="new_session" action="#" accept-charset="UTF-8" method="post">

                <!-- 正常登录登录名输入框 -->
                <div class="input-prepend restyle js-normal">
                    <input placeholder="邮箱" type="text"  id="email" style="margin-top: 10px;"/>
                    <i class="iconfont ic-email"></i>
                </div>

                <!-- 海外登录登录名输入框 -->

                <div class="input-prepend">
                    <input placeholder="密码" type="password" id="password" />
                    <i class="iconfont ic-password"></i>
                </div>

                <div class="remember-btn">
                    <input type="checkbox" value="true" checked="checked" id="remember_me" readonly="readonly" /><span>记住我</span>
                </div>
                <div class="forget-btn">
                    <a class="" data-toggle="dropdown" href="/oauth2/email-reset">重置密码?</a>

                </div>
                <button class="sign-in-button" id="sign-in-btn" type="button">
                    <span id="sign-in-loading"></span>
                    登录
                </button>
            </form>
            <!-- 更多登录方式 -->

        </div>

    </div>
</div>


</body>
</html>
