package com.theherakles.keyacademy.pom.components;

import com.theherakles.keyacademy.exception.AutomationException;
import com.theherakles.keyacademy.utils.DriverUtil;
import java.util.Locale;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class NavHeaderComponent {
  private WebDriver driver;

  protected NavHeaderComponent(){
    driver = DriverUtil.getDriver();
    PageFactory.initElements(driver, this);
  }

  private final String desktopMenuRootSelector = "//li[@class='w3-hide-small']";

  @FindBy(xpath = "//a[@href='#courses']" )
  private WebElement navMenuCourses;

  @FindBy(xpath = "//button[.='CREATE AN ACCOUNT']")
  private WebElement signUpButton;

  @FindBy(xpath = "//button[.='SIGN IN']")
  private WebElement signInButton;

  public WebElement getNavMenuByName(String menuName){
    return driver.findElement(By.xpath(desktopMenuRootSelector + "//a[@href='#" + menuName.toLowerCase(Locale.ROOT).replace(" ", "") + "']"));
  }

  public WebElement getNavButtonByName(String buttonName){
    if (buttonName.equals("CREATE AN ACCOUNT"))
      return signUpButton;
    else if (buttonName.equals("SIGN IN"))
      return signInButton;
    else
      throw new AutomationException("Button name is not a predefined one");
  }
}
