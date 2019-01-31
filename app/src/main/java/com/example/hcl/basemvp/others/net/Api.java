package com.example.hcl.basemvp.others.net;
import com.example.hcl.basemvp.domains.NewsDomain;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    //http://v.juhe.cn/toutiao/index?type=top&key=APPKEY
    @GET("/toutiao/index")
    Observable<NewsDomain> getNews (@Query("type")String type, @Query("key")String apiKey);
}
