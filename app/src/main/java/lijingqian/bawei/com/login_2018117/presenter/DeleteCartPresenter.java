package lijingqian.bawei.com.login_2018117.presenter;

import lijingqian.bawei.com.login_2018117.bean.DeleteBean;
import lijingqian.bawei.com.login_2018117.model.DelModel;
import lijingqian.bawei.com.login_2018117.model.DelModelCallback;
import lijingqian.bawei.com.login_2018117.view.DeleteCartView;

/**
 * date:2018/1/17 13:55
 * introduction:
 */

public class DeleteCartPresenter {
    private DeleteCartView view;
    private DelModel model;

    public DeleteCartPresenter(DeleteCartView view) {
        this.view = view;
        model=new DelModel();
    }


    public void deleteCart(String pid){
        model.deletCart(pid, new DelModelCallback() {
            @Override
            public void success(DeleteBean bean) {
                view.success(bean);
            }

            @Override
            public void failure(int code) {
                view.failure(code);
            }
        });
    }

    /**
     * 解除绑定
     */
    public void dettach(){
        this.view=null;
    }


}
