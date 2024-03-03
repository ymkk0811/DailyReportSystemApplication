package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.constants.ErrorKinds;
import com.techacademy.constants.ErrorMessage;
import com.techacademy.entity.Employee;
import com.techacademy.entity.Report;
import com.techacademy.service.EmployeeService;
import com.techacademy.service.ReportService;
import com.techacademy.service.UserDetail;

@Controller
@RequestMapping("reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // ■日報一覧画面
    @GetMapping
    public String list(Model model) {

        model.addAttribute("listSize", reportService.findAll().size());
        model.addAttribute("reportList", reportService.findAll());

        return "reports/list";
    }

    // 日報詳細画面
    /*@GetMapping(value = "/{id}/")
    public String detail(@PathVariable int id, Model model) {

        model.addAttribute("report", reportService.findById(id));
        return "reports/detail";
    }*/

    // 日報新規登録画面
    @GetMapping(value = "/add")
    public String create(@ModelAttribute Report report,@AuthenticationPrincipal UserDetail userDetail) {
        //　■ログイン中の従業員情報を取得して、従業員氏名を渡す
        
        return "reports/new";
    }

    // 日報新規登録処理
    /*@PostMapping(value = "/add")
    public String add(@Validated Report report, BindingResult res, Model model) {

        /*　■ログイン中の従業員code＆日付の重複チェックはおそらくサービスで実装するのでできたらここは削除
         * パスワード空白チェック
         */
        /*
         * エンティティ側の入力チェックでも実装は行えるが、更新の方でパスワードが空白でもチェックエラーを出さずに
         * 更新出来る仕様となっているため上記を考慮した場合に別でエラーメッセージを出す方法が簡単だと判断

        if ("".equals(report.getPassword())) {
            // パスワードが空白だった場合
            model.addAttribute(ErrorMessage.getErrorName(ErrorKinds.BLANK_ERROR),
                    ErrorMessage.getErrorValue(ErrorKinds.BLANK_ERROR));

            return create(report);

        }
         */

        // 入力チェック
        /*if (res.hasErrors()) {
            return create(report);
        }

        // 論理削除を行った従業員番号を指定すると例外となるためtry~catchで対応
        // (findByIdでは削除フラグがTRUEのデータが取得出来ないため)
        try {
            ErrorKinds result = reportService.save(report);

            if (ErrorMessage.contains(result)) {
                model.addAttribute(ErrorMessage.getErrorName(result), ErrorMessage.getErrorValue(result));
                return create(report);
            }

        } catch (DataIntegrityViolationException e) {
            model.addAttribute(ErrorMessage.getErrorName(ErrorKinds.DUPLICATE_EXCEPTION_ERROR),
                    ErrorMessage.getErrorValue(ErrorKinds.DUPLICATE_EXCEPTION_ERROR));
            return create(report);
        }

        return "redirect:/reports";
    }*/

    // 日報更新画面
    /*@GetMapping(value = "/{code}/update")
    public String edit(@PathVariable String code, Model model) {

        model.addAttribute("report", reportService.findByCode(code));
        return "reports/update";
    }

    //　エラー時更新画面再表示用
    public String edit(@PathVariable ("code")String code,Report report, BindingResult res, Model model1) {
        model1.addAttribute("report", employee);
        return "reports/update";
    }

    // 日報更新処理
    @PostMapping(value = "/{code}/update")
    public String update(@PathVariable String code, Model model,@Validated Report report2, BindingResult res, Model model1) {
        // !!　voidをStringに直すこと
        //System.out.println(code);//codeが画面から渡されているか確認用（クラスをvoidにすること）

        // 入力チェック
        if (res.hasErrors()) {

            model1.addAttribute("employee", reportService.findByCode(code));
            return edit(code,report2, res, model1);
            //System.out.println("入力チェック時");//エラー内容確認用（クラスをvoidにすること）
        }

        // パスワード空白チェック
        //　パスワードが空白の場合
        if ("".equals(employee.getPassword())) {
            Employee dbemployee=employeeService.findByCode(code);
            String dbpassword=dbemployee.getPassword();
            employee.setPassword(dbpassword);
        }


        // 論理削除を行った従業員番号を指定すると例外となるためtry~catchで対応
        // (findByIdでは削除フラグがTRUEのデータが取得出来ないため)
        try {
            ErrorKinds result = reportService.save(code,report2);

            if (ErrorMessage.contains(result)) {
                model1.addAttribute(ErrorMessage.getErrorName(result), ErrorMessage.getErrorValue(result));
                return edit(code,report2, res, model1);
                //System.out.println("サービスからの戻り値がエラー"+res);//エラー内容確認用（クラスをvoidにすること）
            }

        } catch (DataIntegrityViolationException e) {
            model1.addAttribute(ErrorMessage.getErrorName(ErrorKinds.DUPLICATE_EXCEPTION_ERROR),
                    ErrorMessage.getErrorValue(ErrorKinds.DUPLICATE_EXCEPTION_ERROR));
            return edit(code,report2, res, model1);
            //System.out.println("削除フラグの例外発生");//エラー内容確認用（クラスをvoidにすること）
        }



        return "redirect:/reports";
        //System.out.println("success");
    }


    // 日報削除処理
    @PostMapping(value = "/{code}/delete")
    public String delete(@PathVariable String code, @AuthenticationPrincipal UserDetail userDetail, Model model) {

        ErrorKinds result = reportService.delete(code, userDetail);

        if (ErrorMessage.contains(result)) {
            model.addAttribute(ErrorMessage.getErrorName(result), ErrorMessage.getErrorValue(result));
            model.addAttribute("report", reportService.findByCode(code));
            return detail(code, model);
        }

        return "redirect:/reports";
    }*/

}

