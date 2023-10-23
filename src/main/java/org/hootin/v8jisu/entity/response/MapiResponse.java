package org.hootin.v8jisu.entity.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hootin.v8jisu.entity.V8CommonResponse;

/**
 * API接口支付 响应实体
 * @author WuHao
 * @since 2023/10/20 17:26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MapiResponse extends V8CommonResponse {

    /**
     * 订单号
     */
    private String trade_no;
    /**
     * 支付跳转url
     */
    private String payurl;
    /**
     * 二维码链接
     */
    private String qrcode;
    /**
     * 小程序跳转url
     */
    private String urlscheme;

}
