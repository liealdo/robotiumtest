package com.example.aldo.robotiumtest;


import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
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
        intent.putExtra("location","123456");
        setActivityIntent(intent);
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    @UiThreadTest
    public void testIntent() {

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
        solo.enterTextInWebElement(By.cssSelector("html>body>input[type='text']"), "aldo");
        WebElement webElement = solo.getWebElement(By.id("click"), 0);
        assertTrue(webElement != null);
        solo.clickOnWebElement(By.cssSelector("#click"));
    }


/*
//       solo.pinchToZoom(new PointF(0.2f, 0.2f), new PointF(0.3f, 0.3f), new PointF(0.1f, 0.1f),
//               new PointF(0.4f, 0.4f));
//*/
//        //solo.goBack();
//       /* solo.illustrate(
//                solo.createIllustrationBuilder()
//                        .addPoint(20f, 100f, 1f)
//                        .addPoint(10f, 10f, 1f)
//                        .addPoint(101f, 101f, 1f)
//                        .addPoint(120f, 120f, 1f)
//                        .addPoint(50f, 50f, 1f)
//                        .addPoint(60f, 60f, 1f)
//                        .build());*/
//        solo.clickOnActionBarHomeButton();
//        solo.sleep(3000);
//    }

}
