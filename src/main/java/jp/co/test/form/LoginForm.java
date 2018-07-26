package jp.co.test.form;

import lombok.Getter;
import lombok.Setter;

/**
 * ログイン
 */
@Getter
@Setter
public class LoginForm {

    /**
     * ユーザID
     */
    private String userId;

    /**
     * パスワード
     */
    private String password;

    /**
     * トークン
     */
    private String token;


}
