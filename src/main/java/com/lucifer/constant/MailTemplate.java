package com.lucifer.constant;

public class MailTemplate {

    public static final String registerCodeSubject = "[注册验证码] 15分钟内有效";

    public static final String registerCodeContentTemplate = "{code} 是您的注册验证码 请在15分钟内使用";

    public static String generateRegisterCodeContent(String code){
        return registerCodeContentTemplate.replace("{code}", code);
    }

    public static final String resetCodeSubject = "[修改密码验证码] 15分钟内有效";

    public static final String resetCodeContentTemplate = "{code} 是您的修改密码验证码 请在15分钟内使用";

    public static String generateResetCodeContent(String code){
        return resetCodeContentTemplate.replace("{code}", code);
    }
}
