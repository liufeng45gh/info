<div class="container">

    <div class="collapse navbar-collapse" id="menu">
        <ul class="nav navbar-nav">

            <li class="tab active">
                <a href="/">
                    <span class="menu-text">首页</span>
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

            </li>

        </ul>
    </div>

    <template id="search-item-template" style="display: none;">
        <li >
            <div class="content">
                <a class="title" target="_blank" href="/carpool/detail/--id--"><span>--from--</span><span>到</span><span>--to--</span></a>
                <p class="abstract">
                    <span>途径 :</span> <span>--pass1--</span> <span>;</span> <span>--pass2--</span> <span>;</span> <span>--pass3--</span>
                </p>
                <p class="abstract">
                    <span>出发时间 :</span> <span>--departureTime--</span>
                </p>
                <div class="meta">
                    <span >联系人: </span>
                    <span>--linkman--</span>
                    <span >剩余座位: </span>
                    <span>--site--</span>
                </div>
            </div>
        </li>
    </template>
    <template id="search-result-template" style="display: none;">
        <ul class="note-list" infinite-scroll-url="/" id="search-result">

            <!---->

        </ul>
    </template>
</div>

