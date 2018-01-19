package lijingqian.bawei.com.login_2018117.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * author:黄章鹏
 * date:2018/1/15 14:07
 * introduction:
 */

public interface ApiService {
    /**
     * GET请求
     * @param url
     * @param map
     * @return
     */
    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, String> map);

    /**
     * POST请求
     * @param url
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST
    Observable<String> post(@Url String url, @FieldMap Map<String, String> map);

}
