package jp.co.test.service;

import jp.co.test.service.model.LoginInputModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean login(LoginInputModel model) {

        // 入力チェック
        if(!loginValidate(model)) {
            return false;
        }

        // ID、パスワードの確認
        // a固定
        if(!"a".equals(model.getUserId())) {
            return false;
        }

        // a固定
        if(!"a".equals(model.getPassword())) {
            return false;
        }

        return true;
    }

    /**
     * ログインボタン押下時入力チェック
     *
     * @return true：チェックOK
     */
    public boolean loginValidate(LoginInputModel model) {

        // 必須チェック
        if(!this.chkRequire(model.getUserId())) {
            return false;
        }
        if(!this.chkRequire(model.getPassword())) {
            return false;
        }

        // 半角英数チェック
        if(!this.chkHalfAlNum(model.getUserId())) {
            return false;
        }
        if(!this.chkHalfAlNum(model.getPassword())) {
            return false;
        }

        return true;
    }

    /**
     * 必須チェック
     *
     * @param target チェック対象
     * @param name 変数名
     * @param errMsgList エラーメッセージリスト
     */
    public boolean chkRequire(String target) {
        if (StringUtils.isBlank(target)) {
            return false;
        }
        return true;
    }

    /**
     * 半角英数チェック
     *
     * @param target チェック対象
     * @param name 変数名
     * @param errMsgList エラーメッセージリスト
     */
    public boolean chkHalfAlNum(String target) {
        if (!target.matches("[0-9a-zA-Z]+")) {
            return false;
        }
        return true;
    }
}
