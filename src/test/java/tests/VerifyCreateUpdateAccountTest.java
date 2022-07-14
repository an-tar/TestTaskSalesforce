package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountDetailsPage;
import pages.account.AccountsPage;
import pages.account.EditAccountDialog;
import pages.account.NewAccountDialog;
import utils.Messages;
import utils.PropertyProvider;
import utils.RandomUtils;

public class VerifyCreateUpdateAccountTest extends BaseTest {

    private final String accountName = RandomUtils.getAccountRandomName();
    private final String accountNameUpd = RandomUtils.getAccountRandomName();

    @Test
    public void verifyCreateUpdateAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AccountsPage accountsPage = new AccountsPage(driver);
        NewAccountDialog newAccountDialog = new NewAccountDialog(driver);
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
        EditAccountDialog editAccountDialog = new EditAccountDialog(driver);

        loginPage.login(PropertyProvider.getConfigData("username"), PropertyProvider.getConfigData("password"));
        homePage.openAccountsPage();
        accountsPage.openNewAccountDialog();
        newAccountDialog.createAccount(accountName);

        Assert.assertEquals(accountDetailsPage.getPopupMessageText(), String.format(Messages.ACCOUNT_CREATED.getMessage(), accountName),
                "Verify message after Account creation");
        Assert.assertEquals(accountDetailsPage.getAccountLabelText(), accountName, "Verify Account name after creation");

        accountDetailsPage.waitForPopupMessageDisappear();
        accountDetailsPage.openEditAccountDialog();
        editAccountDialog.updateAccount(accountNameUpd);

        Assert.assertEquals(accountDetailsPage.getPopupMessageText(), String.format(Messages.ACCOUNT_UPDATED.getMessage(), accountNameUpd),
                "Verify message after Account update");
        Assert.assertEquals(accountDetailsPage.getAccountLabelText(), accountNameUpd, "Verify Account name after update");
    }
}
