package com.example.aldo.robotiumtest;


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

}
