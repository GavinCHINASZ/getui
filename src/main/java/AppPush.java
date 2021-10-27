import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.gexin.rp.sdk.template.style.Style0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AppPush {
    // STEP1：获取应用基本信息
    private static String appId = "Lz99d9bsim57izLwSTHFW6";
    private static String appKey = "XY5rn6IwX89iWEvpvSCOH1";
    private static String masterSecret = "azsQbQA4d28pCS88ucF4j3";

    private static String appId2 = "VxHF6idnsf6CmxXwbn0nu5";

    // 如果需要使用HTTPS，直接修改url即可
    //private static String url = "https://api.getui.com/apiex.htm";
    private static String url = "http://api.getui.com/apiex.htm";

    public static void main(String[] args) throws IOException {
        IGtPush push = new IGtPush(url, appKey, masterSecret);

        // 通知
        NotificationTemplate template = getNotificationTemplate();
        // 透传
        //TransmissionTemplate template = transmissionTemplateDemo();

        // STEP5：定义"AppMessage"类型消息对象,设置推送消息有效期等推送参数
        List<String> appIds = new ArrayList<>(2);
        appIds.add(appId);

        //添加要推送的终端
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId("79c30bfafe7e75ce6c84924abebfe3f8");

        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        // 时间单位为毫秒
        message.setOfflineExpireTime(1000 * 600);

        // STEP6：执行推送
        IPushResult ret = push.pushMessageToApp(message, String.valueOf(target));
        System.out.println(ret.getResponse().toString());
    }

    /**
     * 通知模板
     *
     * @return NotificationTemplate
     */
    private static NotificationTemplate getNotificationTemplate() {
        Style0 style = new Style0();
        // STEP2：设置推送标题、推送内容
        style.setTitle("请输入通知栏标题1");
        style.setText("请输入通知栏内容1");
        // 设置推送图标
        style.setLogo("push.png");
        // STEP3：设置响铃、震动等推送效果
        // 设置响铃
        style.setRing(true);
        // 设置震动
        style.setVibrate(true);

        // STEP4：选择通知模板
        NotificationTemplate template = new NotificationTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setStyle(style);
        return template;
    }

    /**
     * 透传模板
     *
     * @return TransmissionTemplate
     */
    public static TransmissionTemplate transmissionTemplateDemo() {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        //搭配transmissionContent使用，可选值为1、2；
        //1：立即启动APP（不推荐使用，影响客户体验）
        //2：客户端收到消息后需要自行处理
        template.setTransmissionType(2);
        template.setTransmissionContent("请输入需要透传的内容");
        // 详见本页iOS通知样式设置
        //template.setAPNInfo(getAPNPayload());
        return template;
    }

}
