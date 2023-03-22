import io.github.bonigarcia.wdm.WebDriverManager;
import model.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static model.MainPage.ORDER_BUTTON_DOWN;
import static model.MainPage.ORDER_BUTTON_UP;
import static model.OrderPage.BUTTON_NEXT;
import static model.OrderPage.BUTTON_ORDER;
import static model.OrderPage.BUTTON_YES;
import static model.OrderPage.COLOR_SCOOTER_TEMPLATE;
import static model.OrderPage.FIELD_ADDRESS_ORDER;
import static model.OrderPage.FIELD_COMMENT;
import static model.OrderPage.FIELD_FIRSTNAME;
import static model.OrderPage.FIELD_LASTNAME;
import static model.OrderPage.FIELD_ORDER_DATE;
import static model.OrderPage.FIELD_ORDER_TIME;
import static model.OrderPage.FIELD_PHONE;
import static model.OrderPage.FIELD_STATION;
import static model.OrderPage.HEADER_ABOUT_ORDER;
import static model.OrderPage.HEADER_SUCCESSFUL_ORDER;
import static model.OrderPage.METRO_TEMPLATE;
import static model.OrderPage.TIME_TEMPLATE;

@RunWith(Parameterized.class)
public class OrderTest {
    
    private WebDriver driver;
    private By buttonLocator;
    private String firstname;
    private String lastname;
    private String addressOrder;
    private String phone;
    private String station;
    private String orderDate;
    private String orderTime;
    private String colorScooter;
    private String comment;
    
    //конструктор класса
    public OrderTest(By buttonLocator, String firstname, String lastname, String addressOrder, String phone, String station, String orderDate, String orderTime, String colorScooter, String comment) {
        this.buttonLocator = buttonLocator;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressOrder = addressOrder;
        this.phone = phone;
        this.station = station;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }
    
    //параметры теста
    @Parameterized.Parameters
    public static Object[][] orderData() {
        return new Object[][] {
            {ORDER_BUTTON_UP,"Александр","Вертипухайнов","ул. Декабристов д. 56","89064328546","Черкизовская","11.06.2023","двое суток","black","Комментарий для курьера"},
            {ORDER_BUTTON_DOWN,"Аня","Ли","ул. Декабристов д. 156, корпус 1, кв. 143","+15068597744","Сокольники","20.03.2023","семеро суток","grey",""}
        };
    }
    
    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
    }
    
    @Test
    public void checkScooterOrder() throws InterruptedException {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openPage();
        orderPage.scrollAndClickElement(orderPage.findElement(buttonLocator));
        orderPage.findElementAndInputData(FIELD_FIRSTNAME, firstname);
        orderPage.findElementAndInputData(FIELD_LASTNAME, lastname);
        orderPage.findElementAndInputData(FIELD_ADDRESS_ORDER, addressOrder);
        orderPage.findElementAndInputData(FIELD_PHONE, phone);
        orderPage.findElementAndInputData(FIELD_STATION, station);
        orderPage.selectElementFromList(METRO_TEMPLATE, station);
        orderPage.findAndClickElement(BUTTON_NEXT);
        orderPage.findElementAndInputData(FIELD_ORDER_DATE, orderDate);
        orderPage.findAndClickElement(HEADER_ABOUT_ORDER);
        orderPage.findAndClickElement(FIELD_ORDER_TIME);
        orderPage.selectElementFromList(TIME_TEMPLATE, orderTime);
        orderPage.selectElementFromList(COLOR_SCOOTER_TEMPLATE, colorScooter);
        orderPage.findElementAndInputData(FIELD_COMMENT, comment);
        orderPage.findAndClickElement(BUTTON_ORDER);
        orderPage.findAndClickElement(BUTTON_YES);
        Assert.assertTrue(orderPage.isElementDisplayed(orderPage.findElement(HEADER_SUCCESSFUL_ORDER)));
    }
    
    @After
    public void afterTest(){
        driver.quit();
    }
}
