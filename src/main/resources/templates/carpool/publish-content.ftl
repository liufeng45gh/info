<div class="container setting">
    <div class="row">
        <div class="aside">
            <ul>
                <li class=""><a href="/settings/basic">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-basic"></i>
                    </div> <span>基础设置</span>
                    <!----></a></li>
                <li class=""><a href="/settings/profile">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-profile"></i>
                    </div> <span>个人资料</span>
                    <!----></a></li>
                <li class="router-link-exact-active active"><a href="/settings/profile">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-publish"></i>
                    </div> <span>我的发布</span>
                    <!----></a></li>
                <li class="">
                    <a href="/settings/blacklist">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-block"></i>
                    </div> <span>黑名单</span>
                    <!----></a></li>
                <li class=""><a href="/settings/reward-setting">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-money"></i>
                    </div> <span>赞赏设置</span>
                    <!----></a></li>
                <li class=""><a href="/settings/misc">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-account"></i>
                    </div> <span>帐号管理</span>
                    <!----></a></li>
            </ul>
            <!---->
        </div>
        <div class="col-xs-17 col-xs-offset-7 main">
            <table>
                <thead>
                <tr>
                    <th class="setting-head"></th>
                    <th></th>
                </tr>
                </thead>
                <tbody class="information">
                <tr>
                    <td class="top-line setting-title setting-verticle"> 起始地 </td>
                    <td class="top-line">
                        <input type="text" id="from-province" class="place" /> <span>省</span>
                        <input  type="text" id="from-city" class="place" /> <span>市</span>
                        <input type="text" id="from-district" class="place"/> <span>区</span>
                    </td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle"> 目的地 </td>
                    <td class="top-line">
                        <input type="text" id="to-province" class="place" /> <span>省</span>
                        <input  type="text" id="to-city" class="place" /> <span>市</span>
                        <input type="text" id="to-district" class="place"/> <span>区</span>
                    </td>
                </tr>
                <tr id="pass-point">
                    <td class="setting-title">途径地点</td>
                    <td class="weixin-qrcode">
                        <a class="btn btn-hollow" id="btn-add-pass" onclick="addPass()">添加 </a>
                        <p class="pull-right">最多添加三个途径地点</p></td>
                </tr>
                <tr>
                    <td class="top-line setting-title setting-verticle"> 出发时间 </td>
                    <td class="top-line">
                        <input type="text" id="departure-day" class="place" readonly="readonly"  onClick="WdatePicker()"/> <span>日</span>
                        <select   id="departure-hour" class="place" >
                        </select>
                        <span>时</span>
                        <select type="text" id="departure-minute" class="place">
                        </select>
                        <span>分</span>
                    </td>
                </tr>
                <tr>
                    <td class="setting-title pull-left">补充说明</td>
                    <td>
                        <form>
                            <textarea placeholder="填写补充说明" id="comment"></textarea>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td class="setting-title pull-left setting-input">剩余座位</td>
                    <td>
                        <form>
                            <input type="text" id="site" class="short-text" placeholder="剩余座位" />
                            <p class="pull-right">必填</p>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td class="setting-title pull-left setting-input">联系人</td>
                    <td>
                        <form>
                            <input type="text" id="linkman" class="short-text" placeholder="联系人" />
                            <p class="pull-right">必填</p>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td class="setting-title pull-left setting-input">联系电话</td>
                    <td>
                        <form>
                            <input type="text" id="phone" class="short-text" placeholder="联系电话" />
                            <p class="pull-right">必填</p>
                        </form>
                    </td>
                </tr>


                </tbody>

            </table>
            <input type="submit" class="btn btn-success setting-save"id="btn-submit" value="保存" />
            <template style="display: none;" id="pass-template">
                <tr class="pass-place" >
                    <td class="top-line setting-title setting-verticle"> 途径地点 </td>
                    <td class="top-line">
                        <input type="text"  class="place" /> <span>省</span>
                        <input  type="text"  class="place" /> <span>市</span>
                        <input type="text"  class="place"/> <span>区</span>
                        <p class="pull-right" style="cursor: pointer;" onclick="removePass(this)" >删除</p>
                    </td>
                </tr>
            </template>
            <!---->
            <!---->
            <!---->

        </div>
    </div>
</div>