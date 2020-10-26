<div class="container setting">
    <div class="row">
        <div class="aside">
            <ul>
                <li class=""><a href="/settings/basic">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-basic"></i>
                    </div> <span>基础设置</span>
                    <!----></a></li>
                <li class="router-link-exact-active active"><a href="/settings/profile">
                    <div class="setting-icon">
                        <i class="iconfont ic-settings-profile"></i>
                    </div> <span>个人资料</span>
                    <!----></a></li>
                <li class=""><a href="/settings/blacklist">
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
        <div class="col-xs-16 col-xs-offset-8 main">
            <table>
                <thead>
                <tr>
                    <th class="setting-head"></th>
                    <th></th>
                </tr>
                </thead>
                <tbody class="information">
                <tr>
                    <td class="top-line setting-title setting-verticle"> 性别 </td>
                    <td class="top-line"><input type="radio" value="1" /> <span>男</span> <input type="radio" value="2" /> <span>女</span> <input type="radio" value="3" /> <span>保密</span></td>
                </tr>
                <tr>
                    <td class="setting-title pull-left">个人简介</td>
                    <td>
                        <form>
                            <textarea placeholder="填写你的个人简介"></textarea>
                        </form></td>
                </tr>
                <tr>
                    <td class="setting-title pull-left setting-input">个人网站</td>
                    <td>
                        <form>
                            <input type="text" name="website" placeholder="http://你的网址" />
                            <p class="pull-right">填写后会在个人主页显示图标</p>
                        </form></td>
                </tr>
                <tr>
                    <td class="setting-title">微信二维码</td>
                    <td class="weixin-qrcode"><input type="file" class="hide" /> <a class="btn btn-hollow"><input type="file" class="hide" /> 更换图片 </a> <p class="pull-right">上传后会在个人主页显示图标</p></td>
                </tr>
                <tr>
                    <td class="setting-title setting-input pull-left">社交帐号</td>
                    <td class="social-bind"><p>你可以通过绑定的社交帐号登录简书。出于安全因素, 你最初用来创建账户的社交帐号不能移除。</p> <p>如果帐号被占用，你可以在<a href="/p/eea64a29cf9d">简书帐号绑定解绑相关问题汇总</a>中获得相关帮助。</p>
                        <ul class="social-bind-list">
                            <li>
                                <div class="bind-name">
                                    <i class="iconfont ic-weibo"></i>
                                    <a href="/users/auth/weibo?can_transfer=true">绑定微博<i class="iconfont ic-arrow"></i></a>
                                </div></li>
                            <li>
                                <div class="bind-name">
                                    <i class="iconfont ic-wechat"></i>
                                    <a href="/users/auth/wechat?can_transfer=true">绑定微信<i class="iconfont ic-arrow"></i></a>
                                </div></li>
                            <li>
                                <div class="bind-name">
                                    <i class="iconfont ic-qq_connect"></i>
                                    <a href="/users/auth/qq_connect?can_transfer=true">绑定 QQ<i class="iconfont ic-arrow"></i></a>
                                </div></li>
                        </ul></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" class="btn btn-success setting-save" value="保存" />
            <!---->
            <!---->
            <!---->

        </div>
    </div>
</div>