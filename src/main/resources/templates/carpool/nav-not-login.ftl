<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="width-limit">

        <!-- 右上角 -->
        <!-- 未登录显示登录/注册/写文章 -->
        <a class="btn write-btn" target="_blank" href="/carpool/publish">
            新建发布
        </a>
        <a class="btn sign-up" id="sign_up" href="/oauth2/sign-up">注册</a>
        <a class="btn log-in" id="sign_in" href="/oauth2/sign-in">登录</a>

        <!-- 如果用户登录，显示下拉菜单 -->


          <#include "nav-container.ftl"/>
    </div>
</nav>