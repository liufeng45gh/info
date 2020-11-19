<div class="container setting">
    <div class="row">
        <#include "my-menu.ftl">
        <div class="col-xs-17 col-xs-offset-7 main">
            <table>
                <thead>
                <tr>
                    <th class="setting-head"></th>
                    <th><input type="hidden" id="carpool-id" value="${entity.id}"></th>
                </tr>
                </thead>
                <tbody class="information">
                <tr>
                    <td class="top-line setting-title setting-verticle"> 起始地 </td>
                    <td class="top-line">
                        <span><input type="text" id="from-province" class="place" value="${fromArray[0]}" />  </span><span>省</span>
                        <span class="break-tag"></span>
                        <span><input  type="text" id="from-city" class="place" value="${fromArray[1]}"  /> </span><span>市</span>
                        <span class="break-tag"></span>
                        <span><input type="text" id="from-district" class="place" value="${fromArray[2]}"/></span> <span>区</span>
                    </td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle"> 目的地 </td>
                    <td class="top-line">
                        <span><input type="text" id="to-province" class="place"  value="${toArray[0]}"/></span>  <span>省</span>
                        <span class="break-tag"></span>
                        <span><input  type="text" id="to-city" class="place" value="${toArray[1]}"/></span>  <span>市</span>
                        <span class="break-tag"></span>
                        <span><input type="text" id="to-district" class="place" value="${toArray[2]}"/></span>  <span>区</span>
                    </td>
                </tr>
                <#list passBodyArray as passArray>
                    <tr class="pass-place" >
                        <td class="top-line setting-title setting-verticle"> 途径地点 </td>
                        <td class="top-line">
                            <span><input type="text"  class="place" value="${passArray[0]}" /></span>  <span>省</span>
                            <span class="break-tag"></span>
                            <span><input  type="text"  class="place" value="${passArray[1]}" /></span>  <span>市</span>
                            <span class="break-tag"></span>
                            <span><input type="text"  class="place" value="${passArray[2]}" /></span>  <span>区</span>
                            <span>
                                <p class="inline-left" style="cursor: pointer;" onclick="removePass(this)" >删除</p class="pull-right">
                            </span>
                        </td>
                    </tr>
                </#list>
                <tr id="pass-point">
                    <td class="top-line setting-title setting-verticle">途径地点</td>
                    <td class="weixin-qrcode">
                        <a class="btn btn-hollow" id="btn-add-pass" onclick="addPass()">添加 </a>
                        <p class="inline-left">最多添加三个途径地点</p></td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle"> 出发时间 </td>
                    <td class="top-line">
                        <span><input type="text" id="departure-day" class="place" readonly="readonly"  onClick="WdatePicker()" value="${day}"/></span>  <span>日</span>
                        <span class="break-tag"></span>
                        <span><select   id="departure-hour" class="place" data-value="${hh}"></select></span>
                        <span>时</span>
                        <span class="break-tag"></span>
                        <span><select type="text" id="departure-minute" class="place" data-value="${mm}"></select></span>
                        <span>分</span>
                    </td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle">补充说明</td>
                    <td class="top-line">
                        <textarea placeholder="填写补充说明" id="comment">${entity.comment}</textarea>
                    </td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle">剩余座位</td>
                    <td class="top-line">
                            <input type="text" id="site" class="short-text" placeholder="剩余座位" value="${entity.site}"/>
                            <p class="inline-left">必填</p>
                    </td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle">联系人</td>
                    <td class="top-line">
                            <input type="text" id="linkman" class="short-text" placeholder="联系人" value="${entity.linkman}"/>
                            <p class="inline-left">必填</p>
                    </td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle">联系电话</td>
                    <td class="top-line">
                        <input type="text" id="phone" class="short-text" placeholder="联系电话" value="${entity.phone}" />
                        <p class="inline-left">必填</p>
                    </td>
                </tr>


                </tbody>

            </table>
            <input type="submit" class="btn btn-success setting-save"id="btn-submit" value="保存" />
            <template style="display: none;" id="pass-template">
                <tr class="pass-place" >
                    <td class="top-line setting-title setting-verticle"> 途径地点 </td>
                    <td class="top-line">
                        <span><input type="text"  class="place" /> </span><span>省</span>
                        <span class="break-tag"></span>
                        <span><input  type="text"  class="place" /> </span><span>市</span>
                        <span class="break-tag"></span>
                        <span><input type="text"  class="place"/> </span><span>区</span>
                        <span>
                            <p class="inline-left" style="cursor: pointer;" onclick="removePass(this)" >删除</p class="pull-right">
                        </span>

                    </td>
                </tr>
            </template>
            <!---->
            <!---->
            <!---->

        </div>
    </div>
</div>