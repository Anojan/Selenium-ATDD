package gmail.Gmail_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailInboxPage extends GmailLoginPage {
	
	WebElement mailBody;
	WebElement mailTo;
	WebElement Subject;
	WebElement closeButton;
	WebElement draftsLink;
	WebElement draft;
	
	public GmailInboxPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isMailBox(){
		return webdriver.findElement(By.xpath("//div[3]/div/a")).isDisplayed()?true:false;
	}
	
	public void clickCompose(){
		webdriver.findElement(By.xpath("//div[@id=':4u']/div/div")).click();
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/div[2]")));
	}
	
	public void composeMail(String mailID, String subject, String Text){
		mailTo = webdriver.findElement(By.xpath("//textarea"));
		mailBody = webdriver.findElement(By.xpath("//td[2]/div[2]/div"));
		Subject = webdriver.findElement(By.xpath("//div[3]/input"));
		
		mailTo.click();
		mailTo.sendKeys(mailID);
		Subject.click();
		Subject.sendKeys(subject);
		mailBody.sendKeys(Text);
		webdriver.switchTo().defaultContent(); 
	}
	
	public void closeMail(){
		closeButton = webdriver.findElement(By.xpath("//img[@alt='Close']"));
		if(closeButton.isDisplayed()){
			closeButton.click();
		}
	}
	
	public void navigateToDrafts(){
		draftsLink = webdriver.findElement(By.xpath("//div[4]/div/div/div/span/a"));
		draftsLink.click();
		
	}
	
	public boolean isMailSavedAsDraft() throws Exception{
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'This is a')]")));
		draft = webdriver.findElement(By.xpath("//span[contains(text(),'This is a')]"));
		return draft.isDisplayed()?true:false;
	}
}
