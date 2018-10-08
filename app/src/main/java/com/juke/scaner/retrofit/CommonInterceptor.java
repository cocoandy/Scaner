package com.juke.scaner.retrofit;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Http 拦截器
 * 用于追加参数等操作，相关可以看官方
 * 注意的是 post和get的追加写法不一样
 * Created by Gavin on 2018/8/2.
 */

public class CommonInterceptor implements Interceptor {

    public CommonInterceptor() {
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        if (request.method().equals("POST")) {
//
//            return chain.proceed(addPostParams(request));
//        } else {
//
//            return chain.proceed(addGetParams(request));
//        }
        return chain.proceed(request);
    }


    /**
     * 追加参数
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
//    private Request addPostParams(Request request) throws UnsupportedEncodingException {
//
//        LogUtil.e("Request", "----->" + request.body().getClass());
//        FormBody.Builder bodyBuilder = new FormBody.Builder();
//        FormBody formBody = null;
//
//        //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
//        if (request.body() instanceof FormBody) {
//            formBody = (FormBody) request.body();
//            for (int i = 0; i < formBody.size(); i++) {
//                bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
//            }
//        }
//
//
//        bodyBuilder.addEncoded(Network.GROUP_ID, Network.GROUPID);
//        if (isLogin(mSpUtils)) {
//            bodyBuilder.addEncoded(Network.TOKEN, mSpUtils.getUser().token);
//        }
//        if (HttpConnect.cinema_id != null && !"".equals(HttpConnect.cinema_id)) {
//            bodyBuilder.addEncoded(Network.CINEMA_ID, HttpConnect.cinema_id);
//        } else {
//            //没有影院ID时 传坐标
//            if (App.location == null) {
//                bodyBuilder.addEncoded(Network.LNG, 0 + "");
//                bodyBuilder.addEncoded(Network.LAT, 0 + "");
//            } else {
//                bodyBuilder.addEncoded(Network.LNG, App.location.getLongitude() + "");
//                bodyBuilder.addEncoded(Network.LAT, App.location.getLatitude() + "");
//            }
//        }
//
//        formBody = bodyBuilder.build();
//        LogUtil.e("TAG_URL", "URL:" + request.url());
//
//        return request.newBuilder().post(formBody).build();
//    }
//
//    private Request addGetParams(Request original) throws UnsupportedEncodingException {
//        HttpUrl.Builder builder = original.url().newBuilder();
//        builder.addQueryParameter(Network.GROUP_ID, Network.GROUPID);
//        if (isLogin(mSpUtils)) {
//            builder.addQueryParameter(Network.TOKEN, mSpUtils.getUser().token);
//        }
//        if (HttpConnect.cinema_id != null && !"".equals(HttpConnect.cinema_id)) {
//            builder.addQueryParameter(Network.CINEMA_ID, HttpConnect.cinema_id);
//        } else {
//            //没有影院ID时 传坐标
//            if (App.location == null) {
//                builder.addQueryParameter(Network.LNG, 0 + "");
//                builder.addQueryParameter(Network.LAT, 0 + "");
//            } else {
//                builder.addQueryParameter(Network.LNG, App.location.getLongitude() + "");
//                builder.addQueryParameter(Network.LAT, App.location.getLatitude() + "");
//            }
//        }
//        HttpUrl url = builder.build();
//
//        //添加请求头
//        Request newRequest = original.newBuilder()
//                .method(original.method(), original.body())
//                .url(url)
//                .build();
//        return newRequest;
//    }

    /**
     * 是否登录
     *
     * @return
     */
//    public static boolean isLogin(SPUtils mSpUtils) {
//        if (mSpUtils == null) return false;
//        return mSpUtils.getBoolean(Constants.IS_LOGIN, false);
//    }
}
