package com.example.aldo.robotiumtest;


import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;


import com.robotium.solo.*;

public class RobotiumTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public RobotiumTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent =new Intent();
        intent.putExtra("testing","123456");
        setActivityIntent(intent);
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testRun() throws Exception{

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        assertTrue(solo.searchText("Hello"));

        solo.clickOnButton(0);

        assertTrue("Signed Validation FAIlURE", solo.searchText(solo.getString(R.string
                .error_message_signed_numeric)));

        solo.enterText(0, "123456");

        solo.clickOnText("Submit");

        assertTrue("Letter Validation FAILURE", solo.searchText(solo.getString(R.string
                .error_message_signed_alphabet)));

        solo.enterText(1, "asd123");

        solo.clickOnText("Submit");

        assertTrue("Letter Validation FAILURE", solo.searchText(solo.getString(R.string
                .error_message_signed_alphabet)));

        solo.clearEditText(1);

        solo.enterText(1, "asd");

        solo.clickOnButton(0);

        assertTrue("FAILURE", solo.searchText(getActivity().getString(R.string
                .success_message)));


    }

    public void testGetButtonAndClick() {

        solo.getView(R.id.button);

        solo.getButton(0);

        View view = solo.getButton("Submit");

        solo.clickOnView(view);
    }


    public void testChangeActivity() {

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        solo.clickOnButton(1);//Click Button to move to another Detail Activity

        solo.waitForActivity(DetailActivity.class, 2000);// Wait DetailActivity to show with
        // timeout 2000;

        solo.assertCurrentActivity("Wrong Activity", DetailActivity.class);
    }


    public void testInteractWithWebElement() {

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        solo.clickOnButton(1);//Click Button to move to another Detail Activity

        solo.waitForActivity(DetailActivity.class, 2000);// Wait DetailActivity to show with
        // timeout 2000;

        solo.assertCurrentActivity("Wrong Activity", DetailActivity.class);

        solo.sleep(5000); //Wait 5 seconds to load web

        solo.enterTextInWebElement(By.cssSelector("html>body>input[type='text']"), "testing");

        WebElement webElement = solo.getWebElement(By.id("click"), 0);

        assertTrue(webElement != null);

        solo.clickOnWebElement(By.cssSelector("#click"));

    }

}
