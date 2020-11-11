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
                <a href="/">
                    <span class="menu-text">首页</span>
                    <i class="iconfont ic-navigation-discover menu-icon"></i>
                </a>
            </li>
            <!--
               <li class="tab notification">
                   <a data-hover="dropdown" href="https://www.jianshu.com/notifications" class="notification-btn"><span class="menu-text">消息</span>
                       <i class="iconfont ic-navigation-notification menu-icon"></i>
                    <span class="badge">1</span>
                </a>

            </li>
            -->
            <li class="search">
                <span><input type="text"  placeholder="起始地点" class="search-input" id="search-from"></span>
                <span class="search-span">到</span>
                <span><input type="text"  placeholder="目标地点" class="search-input" id="search-to"></span>

                <span class="search-span">出发时间</span>
                <span><input type="text" placeholder="日期" class="search-input-date" id="search-date" readonly="readonly"  onClick="WdatePicker()"></span>
            </li>


            <li class="search" id="search-btn">
                    <div class="search-btn" >
                        <i class="iconfont ic-search"></i>
                    </div>
            </li>
        </ul>
    </div>
</div>