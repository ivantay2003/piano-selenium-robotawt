package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import control.Common;
import control.basepage;

public class Page extends Common{
	
	 public WebDriver driver;
	    public Wait<WebDriver> wait;
	 
	    //Constructor
	    public Page(WebDriver driver, Wait<WebDriver> wait){
	        this.driver = driver;
	        this.wait = wait;
	        
	        setInstance(driver);
	    }
	 
	    //JAVA Generics to Create and return a New Page
	    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
	        try {
	            return pageClass.getDeclaredConstructor(WebDriver.class, Wait.class).newInstance(this.driver, this.wait);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
