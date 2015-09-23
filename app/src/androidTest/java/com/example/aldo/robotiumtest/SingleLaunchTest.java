package com.example.aldo.robotiumtest;

import android.test.SingleLaunchActivityTestCase;
import android.view.KeyEvent;

import com.robotium.solo.By;
import com.robotium.solo.Solo;

/**
 * Created by aldo on 9/17/2015.
 */
public class SingleLaunchTest extends SingleLaunchActivityTestCase {

    private Solo solo;

    public SingleLaunchTest() {
        super("com.example.aldo.robotiumtest", MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo=new Solo(getInstrumentation(),getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
         super.tearDown();
    }

    public void testA(){
        solo.clickOnButton(2);
        this.sendKeys(KeyEvent.KEYCODE_C);
        this.sendKeys(KeyEvent.ACTION_DOWN);
    }

    public void testB(){
        solo.waitForActivity(DetailActivity.class, 2000);
        solo.sleep(4000);
        solo.enterTextInWebElement(By.id("aldo"), "Aldo");
        assertTrue(solo.getWebElement(By.id("aldo"), 0).getText().equals("Aldo"));


    }

}
