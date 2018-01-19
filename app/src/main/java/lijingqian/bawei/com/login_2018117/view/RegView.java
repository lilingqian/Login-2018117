package lijingqian.bawei.com.login_2018117.view;


import lijingqian.bawei.com.login_2018117.bean.RegBean;

/**
 * date:2018/1/15 20:29
 * introduction:
 */

public interface RegView {
    String getMobile();
    String getPwd();
    void success(RegBean bean);
    void failure(String s);
}
