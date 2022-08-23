package dataobjects;

import common.constant.Constant;
import common.helper.Helper;

public class AccountInformation {
    Helper helper = new Helper();

    public String email;
    public String password;
    public String confirmPassword;
    public String passport;
    public String newPassword;

    public AccountInformation() {
        this.email = helper.randomAlphabetGenerator(8) + Constant.TEST_DOMAIN;
        this.password = helper.randomNumericGenerator(8);
        this.confirmPassword = password;
        this.passport = helper.randomNumericGenerator(10);
        this.newPassword = helper.randomNumericGenerator(10);
    }


    public AccountInformation(String email, String password, String confirmPassword, String passport) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.passport = passport;
    }

    public AccountInformation(String email, String password, String confirmPassword
            , String passport, String newPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.passport = passport;
        this.newPassword = newPassword;
    }

    public AccountInformation(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
