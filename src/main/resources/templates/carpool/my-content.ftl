<div class="container setting">
    <div class="row">
        <#include "my-menu.ftl">
        <div class="col-xs-17 col-xs-offset-7 main">
            <ul class="add-follow-list">
                <#list myList as item>
                    <li>
                        <div class="info">
                            <p><span>联系人</span><span>${item.linkman}</span>&nbsp;<span>${item.from}</span><span>到</span>  <span>${item.to}</span></p>
                            <p ><span>途经: </span> <span>${item.pass1!}</span>  <span>${item.pass2!}</span>  <span>${item.pass3!}</span></p>
                            <p><span>${item.departureTime!?string("yyyy-MM-dd HH:mm")}</span>&nbsp;
                                <span>座位: </span><span>${item.site}</span> &nbsp;
                            </p>
                            <p>
                                <span> <a class="btn " onclick="deleteCarpool(${item.id})">删除</a></span>
                                <span> <a class="btn " href="/carpool/modify/${item.id}">修改</a></span>
                                <span> <a class="btn " onclick="pushToBaidu(${item.id})">推送到百度</a></span>
                                <span> <a class="btn " href="/carpool/detail/${item.id}">详情</a></span>
                            </p>
                        </div>
                    </li>
                </#list>
            </ul>
            <!---->
            <!---->

        </div>
    </div>
</div>