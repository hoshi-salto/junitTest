package jp.co.test.service.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 認証入力モデル
 */
@Getter
@Setter
public class LoginInputModel {

    /**
     * ユーザID
     */
    private String userId;

    /**
     * パスワード
     */
    private String password;

}
