package org.v8jisu.api;

import io.reactivex.Single;
import org.v8jisu.entity.request.MapiRequest;
import org.v8jisu.entity.response.MapiResponse;
import org.v8jisu.entity.response.AppInfoResponse;
import org.v8jisu.entity.response.OrderInfoResponse;
import org.v8jisu.entity.response.SettlementRecordResponse;
import retrofit2.http.*;

/**
 * 支付 api 接口
 *
 * @author WuHao
 * @since 2023/10/20 17:10
 */
public interface Api {

    /**
     * API接口支付
     * 此接口可用于服务器后端发起支付请求，会返回支付二维码链接或支付跳转url。
     * <p>
     * URL地址：https://pay.v8jisu.cn/mapi.php
     * <p>
     * 请求方式：POST
     *
     * @param request
     * @return
     */
    @POST("/mapi.php")
    Single<MapiResponse> mapi(@Body MapiRequest request);

    /**
     * [API]查询商户信息
     * <p>URL地址：https://pay.v8jisu.cn/api.php?act=query&pid={商户ID}&key={商户密钥}</p>
     *
     * @param act
     * @param pid
     * @param key
     * @return
     */
    @GET("/api.php")
    Single<AppInfoResponse> queryAppInfo(@Query("act") String act, @Query("pid") String pid, @Query("key") String key);

    /**
     * [API]查询结算记录
     * <p>URL地址：https://pay.v8jisu.cn/api.php?act=settle&pid={商户ID}&key={商户密钥}</p>
     *
     * @param act
     * @param pid
     * @param key
     * @return
     */
    @GET("/api.php")
    Single<SettlementRecordResponse> querySettlementRecord(@Query("act") String act, @Query("pid") String pid, @Query("key") String key);

    /**
     * [API]查询单个订单
     * <p>URL地址：https://pay.v8jisu.cn/api.php?act=order&pid={商户ID}&key={商户密钥}&out_trade_no={商户订单号}</p>
     *
     * @param act
     * @param pid
     * @param key
     * @param trade_no
     * @param out_trade_no
     * @return
     */
    @GET("/api.php")
    Single<OrderInfoResponse> queryOrderInfo(@Query("act") String act, @Query("pid") String pid, @Query("key") String key, @Query("trade_no") String trade_no, @Query("out_trade_no") String out_trade_no);

    /**
     * [API]批量查询订单
     * URL地址：https://pay.v8jisu.cn/api.php?act=orders&pid={商户ID}&key={商户密钥}
     *
     * @param act
     * @param pid
     * @param key
     * @param limit
     * @param page
     * @return
     */
    @GET("/api.php")
    Single<OrderInfoResponse> queryOrdersBatch(@Query("act") String act, @Query("pid") String pid, @Query("key") String key, @Query("limit") int limit, @Query("page") int page);

}
