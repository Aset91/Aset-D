
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static sun.plugin.javascript.navig.JSType.Element;

public class TaskTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "webDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        String baseURL = "https://www.rgs.ru/";
        driver.get(baseURL);
    }

    @Test
    public void test() {
        //Выбрать Меню
        String menuButton = "//a[@data-toggle= 'dropdown' and @class='hidden-xs']";
        WebElement menuButtonList = driver.findElement(By.xpath(menuButton));

            menuButtonList.click();

            //Компаниям > Здоровье > Добровольное медицинское страхование
            String forCompanies = "//a[contains(text(),'Компаниям')]";
            WebElement forCompaniesButton = driver.findElement(By.xpath(forCompanies));
            forCompaniesButton.click();

            String health = "//a[contains(text(),'Здоровье')]";
            WebElement healthButton = driver.findElement(By.xpath(health));
            healthButton.click();

            String insurance = "//a[contains(text(), 'медицинское страхование')]";
            WebElement insuranceButton = driver.findElement(By.xpath(insurance));
            insuranceButton.click();

            // Проверить наличие заголовка - Добровольное медицинское страхование
            Assert.assertEquals("Заголовок неверный", "Добровольное медицинское страхование", driver.getTitle());


            //Нажать на кнопку - Отправить заявку
            String application = "//a[contains(text(),'Отправить заявку')]";
            WebElement pushApplicationButton = driver.findElement(By.xpath(application));
            pushApplicationButton.click();

            // Проверить, что открылась страница , на которой присутствует текст - Заявка на добровольное медицинское страхование
            String applicationFormTitle = "//b[text()= 'Заявка на добровольное медицинское страхование']";
            waitUntilElementToBeVisible(By.xpath(applicationFormTitle));
            WebElement appTitle = driver.findElement(By.xpath(applicationFormTitle));
            Assert.assertEquals("Страница не содержит искомого текста", "Заявка на добровольное медицинское страхование", appTitle.getText());

            //.Заполнить поля
            //	Имя, Фамилия, Отчество, Регион, Телефон,
            //	Эл. почта - qwertyqwerty,
            //	Комментарии, Я согласен на обработку
            String inputField = "//input[@name = %s]";
            fillInputField(driver.findElement(By.xpath(String.format(inputField, "LastName"))), "Иванов");
            fillInputField(driver.findElement(By.xpath(String.format(inputField, "FistName"))), "Василий");
            fillInputField(driver.findElement(By.xpath(String.format(inputField, "MiddleName"))), "Иванович");
            fillInputField(driver.findElement(By.xpath(String.format(inputField, "Region"))), "Москва");
            String phonePath = "//input[contains(@data-bind, 'Phone')]";
            fillInputField(driver.findElement(By.xpath(phonePath)), "89268769078");
            fillInputField(driver.findElement(By.xpath(String.format(inputField, "Email"))), "qwertyqwerty");
            fillInputField(driver.findElement(By.xpath(String.format(inputField, "ContactDate"))), "11052021");
            fillInputField(driver.findElement(By.xpath(String.format(inputField, "Comment"))), "...");

            String checkBoxPath = "//input[@class=\"checkbox\"]";
            WebElement pressCheckBox = driver.findElement(By.xpath(checkBoxPath));
            pressCheckBox.click();

            //Нажать Отправить
            String submit = "//button[contains(@data-bind, 'SubmitForm')]";
            WebElement submitButton = driver.findElement(By.xpath(submit));
            submitButton.click();

            //Проверить, что у Поля - Эл. почта присутствует сообщение об ошибке - Введите корректный email
            checkErrorMessageAtField(driver.findElement(By.xpath(String.format(inputField, "Email"))), "Некорректное значение");
        }



    @After
    public void after() {
        driver.quit();
    }

    private void scrollToElementJs(WebElement element) {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }
        private void waitUntilElementToBeClickable(WebElement element) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        private void waitUntilElementToBeVisible(By locator) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
        }
        private void waitUntilElementToBeVisible(WebElement element) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        private void fillInputField(WebElement element, String value) {
        scrollToElementJs(element);
        waitUntilElementToBeClickable(element);
        element.click();
        element.sendKeys(value);
        Assert.assertEquals("Поле было заполнено некоректно",
            value, element.getAttribute("value"));

        }
        private void checkErrorMessageAtField(WebElement element, String errorMessage) {
            element = element.findElement(By.xpath("/./..//span"));
            Assert.assertEquals("Проверка ошибки у поля не пройдена",
            errorMessage, element.getText());
        }

    }

