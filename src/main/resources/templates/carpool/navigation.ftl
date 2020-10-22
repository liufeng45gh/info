<!-- 全局顶部导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="width-limit">
        <!-- 左上方 Logo -->
        <a class="logo" ></a>

        <!-- 右上角 -->
        <!-- 登录显示写文章 -->
        <a class="btn write-btn" target="_blank" href="https://www.jianshu.com/writer#/">
            写文章
        </a>
        <!-- 如果用户登录，显示下拉菜单 -->
        <div class="user">
            <div data-hover="dropdown" class="nickname">
                    昵称
            </div>
            <ul class="dropdown-menu">
                <li>
                    <a href="https://www.jianshu.com/u/574e1db44e2e">
                        <i class="iconfont ic-icon_mine"></i><span>我的主页</span>
                    </a>          </li>
                <li>
                    <!-- TODO bookmarks_path -->
                    <a href="https://www.jianshu.com/bookmarks">
                        <i class="iconfont ic-icon_collection"></i><span>我的收藏</span>
                    </a>          </li>
                <li>
                    <a href="https://www.jianshu.com/settings">
                        <i class="iconfont ic-icon_setting"></i><span>设置</span>
                    </a>          </li>

                <li>
                    <a rel="nofollow" data-method="delete" href="https://www.jianshu.com/sign_out">
                        <i class="iconfont ic-icon_logout"></i><span>退出</span>
                    </a>          </li>
            </ul>
        </div>

        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="menu">
                <ul class="nav navbar-nav">
                    <li class="tab active">
                        <a href="https://www.jianshu.com/">
                            <span class="menu-text">发现</span><i class="iconfont ic-navigation-discover menu-icon"></i>
                        </a>            </li>

                    <li class="tab notification">
                        <a data-hover="dropdown" href="https://www.jianshu.com/notifications" class="notification-btn"><span class="menu-text">消息</span>
                            <i class="iconfont ic-navigation-notification menu-icon"></i> <!---->
                            <span class="badge">1</span>
                        </a>

                    </li>
                    <li class="search">
                        <form target="_blank" action="https://www.jianshu.com/search" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="✓">
                            <input type="text" name="q" id="q" value="" autocomplete="off" placeholder="搜索" class="search-input">
                            <a class="search-btn" href="javascript:void(null)"><i class="iconfont ic-search"></i></a>
                        </form>          </li>
                </ul>
            </div>
        </div>
    </div>
</nav>