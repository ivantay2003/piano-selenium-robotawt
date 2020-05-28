package TestScenario;

import org.testng.annotations.Test;

import control.basepage;
import pages.HomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Music_HappyBirthday extends basepage{

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @Test
  public void test() {
	  
	  page.GetInstance(HomePage.class).goHomePage();
	  page.GetInstance(HomePage.class).play("birthday.txt");
  }
}
