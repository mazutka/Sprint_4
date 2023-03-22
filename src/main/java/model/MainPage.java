package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {
    
    //Шаблон вопрос
    public final static String QUESTION = "//div[@class=\"accordion__button\" and text()=\"%s\"]";
    //Шаблон ответ
    public final static String ANSWER = "//div[@class=\"accordion__panel\" and @aria-labelledby=\"%s\"]";
    //Кнопка "Заказать" вверху страницы
    public final static By ORDER_BUTTON_UP = By.xpath("//button[@class=\"Button_Button__ra12g\"]");
    //Кнопка "Заказать" внизу страницы
    public final static By ORDER_BUTTON_DOWN = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    public WebElement findQuestionElement(String question) {
        return driver.findElement(By.xpath(String.format(QUESTION, question)));
    }
    
    public WebElement findAnswerElement(WebElement questionElement) {
        String id = questionElement.getAttribute("id");
        return driver.findElement(By.xpath(String.format(ANSWER, id)));
    }

}
