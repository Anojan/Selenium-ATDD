package gmail.Gmail_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GmailLoginPage{
	protected WebDriver webdriver = (WebDriver) new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(webdriver,30);
	WebElement username;
	WebElement password;
	WebElement SignInButton;
	WebElement SignOutButton;
	
	public GmailLoginPage() {
		// TODO Auto-generated constructor stub
	}

	public void launchApp(String url){
    	webdriver.get(url);		
    }
	
	public void enterUserName(String userName){
       	
		username = webdriver.findElement(By.cssSelector("#Email"));
		
		if(username.isDisplayed()){
			username.click();
			username.sendKeys(userName);
		}
    }
	
	public void enterPassWord(String passWord){
       	
		password = webdriver.findElement(By.cssSelector("#Passwd"));
		
		if(password.isDisplayed()){
			password.click();
			password.sendKeys(passWord);
		}
    }
	
	public void clickSignIn(){
       	
		SignInButton = webdriver.findElement(By.cssSelector("#signIn"));
		
		if(SignInButton.isDisplayed()){
			SignInButton.click();
		}
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div/a")));
    }
	
	public void clickSignOut(){
		SignOutButton = webdriver.findElement(By.xpath("//a[@id='gb_71']"));
		if(webdriver.findElement(By.xpath("//div[3]/div/a")).isDisplayed()){
			webdriver.findElement(By.xpath("//div[3]/div/a")).click();
			SignOutButton.click();
		}
		
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signIn")));
	}
	
	public void Login(String UserName, String PassWord){
		webdriver.manage().window().maximize();
		username = webdriver.findElement(By.cssSelector("#Email"));
		password = webdriver.findElement(By.cssSelector("#Passwd"));
		SignInButton = webdriver.findElement(By.cssSelector("#signIn"));
		
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Email")));
		username.click();
		username.sendKeys(UserName);
		password.click();
		password.sendKeys(PassWord);
		SignInButton.click();
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div/a")));
		
	}
	
	public boolean isLoginPage(){
		return webdriver.findElement(By.cssSelector("#signIn")).isDisplayed()?true:false;
	}
	
	public void clearSession(){
		webdriver.close();
	}
	
}
