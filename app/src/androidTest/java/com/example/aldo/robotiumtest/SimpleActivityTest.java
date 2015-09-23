package com.example.aldo.robotiumtest;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.robotium.solo.Solo;

/**
 * Created by aldo on 9/10/2015.
 */
public class SimpleActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public SimpleActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo=new Solo(getInstrumentation(),getActivity());
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

       solo.sendKey(Solo.MENU);

       solo.clickOnText("Settings");

       solo.clickOnButton(1);

       solo.assertCurrentActivity("Wrong Activity", DetailActivity.class);

       solo.clickOnActionBarHomeButton();

       solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

       Button button= (Button) solo.getView(R.id.button2);

       solo.clickOnView(button);

       solo.assertCurrentActivity("Wrong Activity", DetailActivity.class);

       solo.clickOnActionBarHomeButton();

       solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

   }

}
