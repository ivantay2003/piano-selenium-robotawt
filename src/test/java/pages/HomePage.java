package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import control.basepage;

public class HomePage extends BasePage {
	
	String url = "https://www.onlinepianist.com/virtual-piano";
	String searchText_css = ".gLFyf.gsfi";
	//WebDriver driver;
	
	 //*********Constructor*********
//    public HomePage (WebDriver driver) {
//        super(driver);
//    }
 
	public HomePage (WebDriver driver, Wait<WebDriver> wait){
		
		//this.driver = driver;
		super(driver, wait);
	}
	
	public void readMusic (String filename){
		
		//driver.findElement(By.cssSelector(searchText_css)).sendKeys(text);
		play (filename);
		
	}
	
	public void goHomePage (){
		System.out.println ("driver " + driver);
		driver.get(this.url);
	}
}
