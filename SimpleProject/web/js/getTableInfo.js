/**
 * 进行表格数据的刷新
 * @param data
 */
function pushTable(data) {
    // var data = getAjax('/tableInfo', 'Post', null)
    //由获取的数据,进行便签的拼接,返回拼接后的结果
    var tableInfo = getTableInfo(data);
    //清空该标签下的所有数据
    $('[id="message"]').empty();
    for (var i in tableInfo){
        //进行标签的插入
        $('[id="message"]').append(tableInfo[i]);
    }
}

/**
 * 进行用户部门的下拉框的生成
 */
function  pushDepartSelect(){
    //请求用户部门数据
    var departTree = getAjax('/getDepartTree', 'POST', null)
    //将数据转化为标签集合
    var select = setDepartSelect(departTree);
    //清空当前标签
    $('[id="depart"]').empty();
    //进行标签追加
    $('[id="depart"]').append("<option selected disabled style=\"display: none;\" value=\"\" name=\"depart\">---请选择部门---\n" +
        "                            </option>")
    for (var i in select){
        console.log(select[i])
        //进行标签追加
        $('[id="depart"]').append(select[i]);
    }
}

/**
 * 将数据转化为表格标签数据
 * @param data
 * @returns {[]}
 */
function getTableInfo(data) {
    // console.log(data)
    var tableInfo=[];
    //遍历数据
    for (var obj in data) {
        // 将数据进行标签化
        var s = "<tr style=\"background-color:#edf2ff ;\"><td>" + data[obj].sort +
            "</td><td>" + data[obj].userName +
            "</td><td>" + data[obj].account +
            "</td><td>" + data[obj].department +
            "</td><td>" + data[obj].sex +
            "</td><td>" + "<input type='button' onclick=\"detailMessage('"+data[obj].account+"')\"value='查看'></input> " +
            "</td><td>" + "<input type='button' onclick=\"deleteUser('"+data[obj].account+"')\"value='删除'></input> " +
            "</td><td>" + "<input type='button' onclick=\"updateUser('"+data[obj].account+"')\"value='修改'></input> " +
            "</td></tr>"
        //标签的字符串加入到集合
        tableInfo.push(s)
    }
    //返回标签集合
    return tableInfo;
}

/**
 * 返回下拉框标签集合
 * @param data
 * @returns {[]}
 */
function setDepartSelect(data){

    var departSelect=[];
    // 遍历数据,并将数据标签化,存入到集合中
    for (var i=0;i<data.length;i++) {
        var s="<option value=\""+data[i]+"\" name=\"depart\">"+data[i]+"</option>"
        departSelect.push(s)
    }
    // console.log(departSelect)
    //返回下拉框标签集合
    return departSelect;

}
