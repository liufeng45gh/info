<ul class="note-list" infinite-scroll-url="/" id="search-result">

    <#list topList as item>
     <li >
         <div class="content">
             <a class="title" target="_blank" href="/carpool/detail/${item.id}"><span>${item.from!}</span><span>到</span><span>${item.to!}</span></a>
             <p class="abstract">
                 <span>途径 :</span> <span>${item.pass1!}</span>  <span>;</span><span>${item.pass2!}</span><span>;</span> <span>${item.pass3!}</span>
             </p>
             <p class="abstract">
                 <span>出发时间 :</span> <span>${item.departureTime!?string("yyyy-MM-dd HH:mm")}</span>
             </p>
             <div class="meta">
                 <span >联系人: </span>
                 <span>${item.linkman!}</span>
                 <span >剩余座位: </span>
                 <span>${item.site!}</span>
             </div>
         </div>
     </li>
    </#list>
    <!---->

</ul>