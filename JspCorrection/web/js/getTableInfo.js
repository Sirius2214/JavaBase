
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
