# 彩虹易支付 Java SDK

**免责声明：仅供学术研究使用。对于违反相关法律、造成危害的滥用行为，开发者不负任何责任。**

**Disclaimer: For academic research purposes only. Developers are not responsible for any abuse that violates relevant laws and causes harm.**


> 官网地址：https://pay.v8jisu.cn/

## 背景

想在个人网站中接入支付功能，赚点服务器费用，但是官方渠道都要一些资质跟资料，太麻烦了。后来找到了这个第三方平台，可以个人收款不需要资质、营业执照。了解信息可前往官网查看

官方文档只有PHP示例的SDK，没有JAVA版的，api文档比较简单，因此自己封装了这个Api，与SpringBoot集成只需要引入Maven依赖、配置商户信息即可实现api调用。

## 使用方法

### 1. maven 引入

```xml

<repositories>
    <repository>
        <id>v8jisu-api</id>
        <url>https://toushang6015.github.io/v8jisu-payment-api/maven-repo/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>org.hootin</groupId>
        <artifactId>v8jisu-payment-api</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>

```

### 2. yml配置商户信息
```yml

# 彩虹易支付配置
v8jisu:
  account:
    # 商户ID
    appId: xxx
    # 商户秘钥
    appKey: xxxxxxxxxxxxxxxxx

```

### 3. 支付服务Service注入到Spring容器

```java
// 在配置类或启动类中加入以下代码

/**
 * 彩虹易支付服务
 */
@Bean
public V8ApiService v8ApiService() {
    return V8PayClient.createService();
}

```

### 4. 使用
在Spring所管理的类当中通过@Autowireh或@Resource自动注入Bean

```java
public class TestController {

    @Autowired
    private V8ApiService v8ApiService;

    public void test() {
        v8ApiService.queryAppInfo();
        v8ApiService.querySettlementRecord();
        // .......
    }

}
```

> 如果项目对你有帮助或觉得不戳，可以帮我点一下小⭐⭐，这将作为我继续开发的动力，感谢你的支持