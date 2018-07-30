package jp.co.test.controller;

import jp.co.test.common.constant.ScreenConst;
import jp.co.test.form.LoginForm;
import jp.co.test.service.LoginService;
import jp.co.test.service.model.LoginInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * ログイン
 */
@Controller
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class LoginController{

	private final LoginService loginService;

    /**
     * ログイン画面表示
     *
     * @return なし
     * @throws Exception 例外
     */
	@GetMapping(value = "/login")
    public String index(@ModelAttribute LoginForm loginForm) throws Exception {
        return ScreenConst.LOGIN;
    }

    /**
     * ログインイベント
     *
     * @return 画面パス
     * @throws Exception 例外
     */
	@PostMapping(value = "/login")
    public String login(@ModelAttribute LoginForm loginForm, HttpServletRequest request) throws Exception {

        // ログイン処理呼出し
        boolean output = loginService.login(this.getInputModel(loginForm));

        // 出力項目設定
        if (!output) {
            // ログインエラーの場合
            return ScreenConst.LOGIN;
        }

        return ScreenConst.SUCCESS;
    }

    /**
     * 入力モデル作成
     *
     * @return 入力モデル
     */
    public LoginInputModel getInputModel(LoginForm loginForm) {
    	LoginInputModel input = new LoginInputModel();
        input.setUserId(loginForm.getUserId());
        input.setPassword(loginForm.getPassword());
        return input;
    }
}
