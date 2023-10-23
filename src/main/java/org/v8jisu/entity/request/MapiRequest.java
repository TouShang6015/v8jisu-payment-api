package org.v8jisu.entity.request;

import lombok.Data;

/**
 * API接口支付 请求实体
 * <p>此接口可用于服务器后端发起支付请求，会返回支付二维码链接或支付跳转url。</p>
 * <p>URL地址：https://pay.v8jisu.cn/mapi.php</p>
 * <p>请求方式：POST</p>
 *
 * @author WuHao
 * @since 2023/10/20 17:18
 */
@Data
public class MapiRequest {

    /**
     * 商户ID
     */
    private Integer pid;
    /**
     * 支付方式
     */
    private String type;
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 异步通知地址
     */
    private String notify_url;
    /**
     * 跳转通知地址
     */
    private String return_url;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品金额
     */
    private String money;
    /**
     * 用户IP地址
     */
    private String clientip;
    /**
     * 设备类型
     */
    private String device;
    /**
     * 业务扩展参数
     */
    private String param;
    /**
     * 签名字符串
     */
    private String sign;
    /**
     * 签名类型
     */
    private String sign_type;

}
