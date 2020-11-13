<div class="note-list content">
    <table>
        <thead>
        <tr>
            <th style="width: 80px;"></th>
            <th></th>
        </tr>
        </thead>
        <tbody class="information">
        <tr>
            <td class="top-line setting-title setting-verticle"><p class="abstract"> 起始地 </p></td>
            <td class="top-line">
                <p class="abstract">
                    <span>${fromArray[0]}</span>
                    <span>省</span>
                    <span>${fromArray[1]}</span>
                    <span>市</span>
                    <span>${fromArray[2]}</span>
                    <span>区</span>
                </p>

            </td>
        </tr>
        <tr>
            <td class="top-line setting-title setting-verticle"> <p class="abstract">目的地 </p></td>
            <td class="top-line">
                <p class="abstract">
                    <span>${toArray[0]}</span><span>省</span>
                    <span>${toArray[1]}</span><span>市</span>
                    <span>${toArray[2]}</span><span>区</span>
                </p>

            </td>
        </tr>
                <#list passBodyArray as passArray>
                    <tr class="pass-place" >
                        <td class="top-line setting-title setting-verticle"> <p class="abstract">途径地点</p> </td>
                        <td class="top-line">
                            <p class="abstract">
                                <span>${passArray[0]}</span><span>省</span>
                                <span>${passArray[1]}</span> <span>市</span>
                                <span>${passArray[2]}</span> <span>区</span>
                            </p>
                        </td>
                    </tr>
                </#list>

        <tr>
            <td class="top-line setting-title setting-verticle"> <p class="abstract">出发时间 </p></td>
            <td class="top-line">
                <p class="abstract">
                    <span>${day}</span> <span>日</span>

                    <span>${hh}</span>
                    <span>时</span>
                    <span>${mm}</span>
                    <span>分</span>
                </p>

            </td>
        </tr>
        <tr>
            <td class="setting-title pull-left"><p class="abstract">补充说明</p></td>
            <td>
                <p class="abstract">
                ${entity.comment}
                </p>
            </td>
        </tr>
        <tr>
            <td class="setting-title pull-left setting-input"><p class="abstract">剩余座位</p></td>
            <td>
                <p class="abstract">
               ${entity.site}
                </p>
            </td>
        </tr>
        <tr>
            <td class="setting-title pull-left setting-input"><p class="abstract">联系人</p></td>
            <td>
                <p class="abstract">
                    ${entity.linkman}
                </p>
            </td>
        </tr>
        <tr>
            <td class="setting-title pull-left setting-input"><p class="abstract">联系电话</p></td>
            <td>
                    <p  class="abstract">${entity.phone}</p>
            </td>
        </tr>


        </tbody>

    </table>
</div>

