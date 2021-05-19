/**
 * 通用的Ajaxq请求方法,返回请求完成的结果
 * @param url
 * @param type
 * @param data
 * @returns {null}
 */
function getAjax(url,type,data) {
    var result=null;
        $.ajax({
            url: url,
            type: type,
            data: data,
            async:false, // 异步请求
            cache:false, // 设置为 false 将不缓存此页面
            dataType: 'json', // 返回对象
            success: function(data) {
                // console.log(data)
                // if (data.code == 100) {
                //     alert(data.resultMessage)
                // }
                // alert("2");
                result=data;
            },
            error: function(data) {
                // 请求失败函数
                // alert(data)
                result=data;


            }
        })
        // alert(data.code)
        return result;
    }

/**
 * 根据cookieName获取cookie值
 * @param cookieName
 * @returns {string}
 */
function getCookie(cookieName) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(cookieName+"=")
        if (c_start != -1) {
            c_start = c_start + cookieName.length + 1

            // 从 c_start 位置开始找第一个分号的索引值，也就是 cookie 名称对应值的结束索引值
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1) {
                c_end = document.cookie.length
            }
            //unescape () 函数可对通过 escape () 编码的字符串进行解码
            // 获取 cookie 名称对应的值，并返回
            console.log(unescape(document.cookie.substring(c_start, c_end)))
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }


    // console.log(c_start)
}
// function encodeStr(val) {
//     return encodeURIComponent((trim(val)));
// }
