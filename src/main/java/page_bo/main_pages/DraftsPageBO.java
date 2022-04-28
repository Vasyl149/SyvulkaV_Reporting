package page_bo.main_pages;

import io.qameta.allure.Step;
import logging.LogLevels;
import org.testng.Assert;
import page.main.DraftsPage;
import page_bo.main_pages.commonBO.MainMenuBO;

public class DraftsPageBO extends MainMenuBO {
    DraftsPage draftsPage = new DraftsPage();

    @Step("Verify is user can send draft")
    public DraftsPageBO verifySendDraft() throws InterruptedException {
        logger.log(LogLevels.INFO,"Select first draft");
        draftsPage.firstDraft();
        logger.log(LogLevels.INFO,"click send button");
        draftsPage.sendButton();
        logger.log(LogLevels.INFO,"close alert");
        draftsPage.closeAlert();
        logger.log(LogLevels.INFO,"fill in email field");
        draftsPage.fillEmailField();
        Thread.sleep(1000);
        logger.log(LogLevels.INFO,"click send button");
        draftsPage.sendButton();
        Thread.sleep(4000);
        Assert.assertTrue(draftsPage.confirmMessage().isDisplayed());
        logger.log("Everything passed");
        //Assert.assertTrue(false);
        return this;
    }
}
