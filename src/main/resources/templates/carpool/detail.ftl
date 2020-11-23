<!DOCTYPE html>

<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">

    <meta name="description"  content="拼车网">
    <meta name="keywords"  content="拼车, ${(entity.from)!}  到 ${(entity.to)!} 途径 ${(entity.pass1)!};${(entity.pass2)!};${(entity.pass3)!}">
    <title>拼车详情 ${(entity.from)!}  到 ${(entity.to)!} </title>

    <link rel="stylesheet" media="all" href="/oauth2/css/common.css">
    <link rel="stylesheet" media="all" href="/carpool/css/index.css">
    <link rel="stylesheet" media="all" href="/carpool/css/iconfont.css">
    <link rel="stylesheet" media="all" href="/carpool/css/entry-d6c0cd47a055b4f3ef28.css">


    <link href="/oauth2/icon/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <script type="text/javascript" charset="UTF-8" src="/oauth2/script/jquery-1.9.1.min.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <script  type="text/javascript" src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/carpool/script/nav.js"></script>
    <script type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
</head>

<body lang="zh-CN" class="reader-black-font">

<#if Request.MEMBER_LOGIN?exists>
    <#include "nav-logined.ftl"/>
<#else>
    <#include "nav-not-login.ftl"/>
</#if>

<div class="container index">
    <div class="row">
        <div class="col-xs-16 main">
            <div class="split-line"></div>
            <div id="list-container">
                    <#include "detail-content.ftl"/>
            </div>
        </div>
        <#include "right.ftl"/>
    </div>

</div>
<#include "footer.ftl"/>

</html>