package com.techacademy.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.constants.ErrorKinds;
import com.techacademy.entity.Employee;
import com.techacademy.entity.Report;
import com.techacademy.repository.ReportRepository;

@Service
    public class ReportService {

        private final ReportRepository reportRepository;
        //private final PasswordEncoder passwordEncoder;

        @Autowired
        public ReportService(ReportRepository reportRepository) {
            this.reportRepository = reportRepository;
        }

        /*// ログイン中の従業員氏名取得
        public String getEmployeeName(UserDetail userDetail){

            String employeeName = null;
            return employeeName;
        }*/


        // ■日報保存
//        @Transactional
//        public ErrorKinds save(Report report) {
//
//            // パスワードチェック
//            ErrorKinds result = reportPasswordCheck(report);
//            if (ErrorKinds.CHECK_OK != result) {
//                return result;
//            }
//
//            // 社員番号＆日付重複チェック
//            if (findById(report.getEmployeeCode(),report.getReportDate()) != null) {
//                return ErrorKinds.DUPLICATE_ERROR;
//            }
//
//
//            report.setDeleteFlg(false);
//
//            LocalDateTime now = LocalDateTime.now();
//            report.setCreatedAt(now);
//            report.setUpdatedAt(now);
//
//            reportRepository.save(report);
//            return ErrorKinds.SUCCESS;
//        }

        // ■従業員更新
        /*@Transactional
        public ErrorKinds save(String code,Report report2) {

            // パスワードチェック
            ErrorKinds result = reportPasswordCheck2(code,report2);
            if (ErrorKinds.CHECK_OK != result) {
                return result;
            }

            report2.setDeleteFlg(false);

            Report dbreport=findByCode(code);
            LocalDateTime dbcreate_at=dbreport.getCreatedAt();

            report2.setCreatedAt(dbcreate_at);
            LocalDateTime now = LocalDateTime.now();
            report2.setUpdatedAt(now);

            reportRepository.save(report2);
            return ErrorKinds.SUCCESS;
        }


        // 従業員削除
        @Transactional
        public ErrorKinds delete(String code, UserDetail userDetail) {

            // 自分を削除しようとした場合はエラーメッセージを表示
            if (code.equals(userDetail.getEmployee().getCode())) {
                return ErrorKinds.LOGINCHECK_ERROR;
            }
            Report report = findByCode(code);
            LocalDateTime now = LocalDateTime.now();
            report.setUpdatedAt(now);
            report.setDeleteFlg(true);

            return ErrorKinds.SUCCESS;
        }*/

        // 日報一覧表示処理
        public List<Report> findAll() {
            return reportRepository.findAll();
        }

        /*public String getLogInUserCode() {

            String result;
            return result=userDetail.getEmployee().getCode();
        }

        // 1件を検索
        /*public Report findByCode(String code) {
            // findByIdで検索
            Optional<Report> option = reportRepository.findById(code);
            // 取得できなかった場合はnullを返す
            Report report = option.orElse(null);
            return report;
        }*/

        // ■社員番号＆日付の組み合わせで1件検索　レポジトリにメソッド追加
        public boolean existsByEmployeeAndReportDate(Employee employee,LocalDate reportDate ){
            // findByIdで検索


            return reportRepository.existsByEmployeeAndReportDate(employee, reportDate);
        }

        // 従業員パスワードチェック新規用
        /*private ErrorKinds reportPasswordCheck(Report report) {

            // 従業員パスワードの半角英数字チェック処理
            if (isHalfSizeCheckError(report)) {

                return ErrorKinds.HALFSIZE_ERROR;
            }

            // 従業員パスワードの8文字～16文字チェック処理
            if (isOutOfRangePassword(report)) {

                return ErrorKinds.RANGECHECK_ERROR;
            }

            report.setPassword(passwordEncoder.encode(report.getPassword()));

            return ErrorKinds.CHECK_OK;
        }

        // ■従業員パスワードチェック更新用
        private ErrorKinds reportPasswordCheck2(String code,Report report2) {

            // ■パスワードが空欄の場合チェックせずにCHECK_OKを返す
            if ("".equals(report2.getPassword())) {
                Report dbreport=findByCode(code);
                String dbpassword=dbreport.getPassword();
                report2.setPassword(dbpassword);
                return ErrorKinds.CHECK_OK;
            }else {


            // 従業員パスワードの半角英数字チェック処理
            if (isHalfSizeCheckError(report2)) {

                return ErrorKinds.HALFSIZE_ERROR;
            }

            // 従業員パスワードの8文字～16文字チェック処理
            if (isOutOfRangePassword(report2)) {

                return ErrorKinds.RANGECHECK_ERROR;
            }

            report2.setPassword(passwordEncoder.encode(employee2.getPassword()));

            return ErrorKinds.CHECK_OK;
        }
        }


        // 従業員パスワードの半角英数字チェック処理
        private boolean isHalfSizeCheckError(Employee employee) {

            // 半角英数字チェック
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
            Matcher matcher = pattern.matcher(employee.getPassword());
            return !matcher.matches();
        }

        // 従業員パスワードの8文字～16文字チェック処理
        public boolean isOutOfRangePassword(Report report) {

            // 桁数チェック
            int passwordLength = report.getPassword().length();
            return passwordLength < 8 || 16 < passwordLength;
        }

    }*/






}
