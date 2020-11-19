<div class="container setting">
    <div class="row">
        <#include "my-menu.ftl">
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
                    <td class="top-line setting-title">昵称</td>
                    <td  class="top-line">
                            <input type="text" id="nickname" class="short-text" value="${(Request.MEMBER_LOGIN.nickname)!}" placeholder="昵称" />
                            <p class="pull-right">必填</p>
                    </td>
                </tr>
                <tr>
                    <td class="top-line setting-title">联系电话</td>
                    <td>
                            <input type="text" id="phone" class="short-text" placeholder="联系电话" />
                            <p class="pull-right">必填</p>
                    </td>
                </tr>


                </tbody>

            </table>

            <input type="submit" class="btn btn-success setting-save"id="btn-submit" value="保存" />
        </div>
    </div>
</div>