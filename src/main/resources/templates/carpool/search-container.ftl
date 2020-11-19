<nav>
    <div class="container sear-container">
        <span><input type="text"  placeholder="起始地点" class="search-input" id="search-from"></span>
        <span class="search-span">到</span>
        <span><input type="text"  placeholder="目标地点" class="search-input" id="search-to"></span>
        <span class="position-tag"></span>
        <span class="search-span">出发时间</span>
        <span><input type="text" placeholder="日期" class="search-input-date" id="search-date" readonly="readonly"  onClick="WdatePicker()"></span>
        <span class="search-btn" id="search-btn"> <i class="iconfont ic-search"></i></span>
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
</nav>