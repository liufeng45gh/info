<!-- 全局顶部导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">

    <div class="width-limit">
        <!-- 右上角 -->
        <!-- 登录显示写文章 -->
        <div class="nav-right">
            <a class="btn write-btn" target="_blank" href="/carpool/publish">
                新建发布
            </a>
            <!--
            <div class="btn nickname" id="nickname" > 昵称</div>
            -->
            <!-- 如果用户登录，显示下拉菜单 -->
            <div class="user " id="user-opt">

                <div class="nickname" >
                ${(Request.MEMBER_LOGIN.nickname)!}
                </div>

                <ul class="dropdown-menu">
                    <li>
                        <a href="/carpool/my">
                            <i class="iconfont ic-icon_mine"></i><span>我的发布</span>
                        </a>
                    </li>
                    <!--
                    <li>
                        <a href="/">
                            <i class="iconfont ic-icon_collection"></i><span>我的收藏</span>
                        </a>          </li>
                        -->
                    <li>
                        <a href="/carpool/setting">
                            <i class="iconfont ic-icon_setting"></i>
                            <span>设置</span>
                        </a>
                    </li>

                    <li>
                        <a rel="nofollow"  href="/oauth2/logout">
                            <i class="iconfont ic-icon_logout"></i><span>退出</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>


        <#include "nav-container.ftl"/>
    </div>
</nav>
