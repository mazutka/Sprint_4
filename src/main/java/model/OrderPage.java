package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends Page {
    
    //Поле "Имя"
    public final static By FIELD_FIRSTNAME = By.xpath("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\" and @placeholder=\"* Имя\"]");
    //Поле "Фамилия"
    public final static By FIELD_LASTNAME = By.xpath("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\" and @placeholder=\"* Фамилия\"]");
    //Поле "Адрес"
    public final static By FIELD_ADDRESS_ORDER = By.xpath("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\" and @placeholder=\"* Адрес: куда привезти заказ\"]");
    //Поле "Станция метро"
    public final static By FIELD_STATION = By.xpath("//input[@class=\"select-search__input\" and @placeholder=\"* Станция метро\"]");
    //Шаблон конкретной станции
    public final static String METRO_TEMPLATE = ".//div[@class='select-search__select']//*[text()='%s']";
    //Поле "Телефон"
    public final static By FIELD_PHONE = By.xpath("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\" and @placeholder=\"* Телефон: на него позвонит курьер\"]");
    //Кнопка "Далее"
    public final static By BUTTON_NEXT = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" and text()=\"Далее\"]");
    //Поле "Когда привезти"
    public final static By FIELD_ORDER_DATE = By.xpath("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\" and @placeholder=\"* Когда привезти самокат\"]");
    //Заголовок "Про аренду"
    public final static By HEADER_ABOUT_ORDER = By.xpath("//div[@class=\"Order_Header__BZXOb\" and text()=\"Про аренду\"]");
    //Поле "Срок аренды"
    public final static By FIELD_ORDER_TIME = By.xpath("//div[@class=\"Dropdown-placeholder\" and text()=\"* Срок аренды\"]");
    //Шаблон времени аренды
    public final static String TIME_TEMPLATE = "//div[@class=\"Dropdown-option\" and text()=\"%s\"]";
    //Поле "Цвет самоката"
    public final static String COLOR_SCOOTER_TEMPLATE = "//input[@class=\"Checkbox_Input__14A2w\" and @id=\"%s\"]";
    //Поле "Комментарий"
    public final static By FIELD_COMMENT = By.xpath("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\" and @placeholder=\"Комментарий для курьера\"]");
    //Кнопка "Заказать"
    public final static By BUTTON_ORDER = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" and text()=\"Заказать\"]");
    //Кнопка "Да"
    public final static By BUTTON_YES = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" and text()=\"Да\"]");
    //Заголовок "Заказ оформлен"
    public final static By HEADER_SUCCESSFUL_ORDER = By.xpath("//div[@class=\"Order_ModalHeader__3FDaJ\" and text()=\"Заказ оформлен\"]");
    
 
    public OrderPage(WebDriver driver) {
        super(driver);
    }
    
}
