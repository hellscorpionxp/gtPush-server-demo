/**
 * Copyright(c) 2004-2018 by qyer.com All rights reserved.
 */
package com.example;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.exceptions.PushAppException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.style.Style0;

/**
 * @author Tony
 * @date 2018-03-05
 * @version 1.0
 */
public class Push {

    private static final IGtPush PUSH = new IGtPush(
        "http://sdk.open.api.igexin.com/apiex.htm", Constants.APP_KEY,
        Constants.MASTER_SECRET);

    public static IPushResult push4Android(String title, String text,
        String url) throws PushAppException, ParseException {
        return PUSH.pushMessageToApp(getMessage(title, text, url, null));
    }

    public static IPushResult push4AndroidByTime(String title, String text,
        String url, String time) throws PushAppException, ParseException {
        return PUSH.pushMessageToApp(getMessage(title, text, url, time));
    }

    private static AppMessage getMessage(String title, String text, String url,
        String time) throws ParseException {
        Style0 style = new Style0();
        style.setTitle(title);
        style.setText(text);

        LinkTemplate template = new LinkTemplate();
        template.setAppId(Constants.APP_ID);
        template.setAppkey(Constants.APP_KEY);
        template.setStyle(style);
        template.setUrl(url);

        List<String> appIds = new ArrayList<>();
        appIds.add(Constants.APP_ID);

        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);
        if (time != null) {
            message.setPushTime(time);
        }
        return message;
    }

}
