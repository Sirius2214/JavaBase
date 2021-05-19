package tdh.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务代码模拟
 * 用于测试
 * @author hanzc
 * @date 2021/4/22
 */
public class TestUtils {

    //模拟查询用户信息
    public static List<TUser> queryUserList() {
        List<TUser> users = new ArrayList<TUser>();
        for (int i = 0; i < 5; i++) {
            TUser user = new TUser();
            user.setYhdm("320100" + "000" + i);
            user.setYhid("000" + i);
            user.setYhxm("" + i);
            user.setYhbm("32010001");
            users.add(user);
        }
        return users;
    }

    //模拟翻译部门
    public static TDepart getDepart(String bmdm) {
        TDepart depart = new TDepart();
        depart.setBmdm(bmdm);
        depart.setBmmc(bmdm + "部门");
        return depart;
    }

}
