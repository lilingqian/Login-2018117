package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.DetailsBean;
import lijingqian.bawei.com.login_2018117.model.DetailsModel;
import lijingqian.bawei.com.login_2018117.model.DetailsModelCallback;
import lijingqian.bawei.com.login_2018117.view.DetailsView;

/**
 * date:2018/1/16 13:36
 * introduction:
 */

public class DetailsPresenter {
    private DetailsView view;
    private DetailsModel model;

    public DetailsPresenter(DetailsView view) {
        this.view = view;
        model = new DetailsModel();
    }


    public void getDetails(String pid) {
        model.getDetailsData(pid, new DetailsModelCallback() {
            @Override
            public void success(DetailsBean bean) {
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
