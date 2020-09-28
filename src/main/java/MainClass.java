import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\_projects\\testSelenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension( 900, 500));

        driver.get("https://www.wikipedia.org/wiki");
        driver.findElement(By.xpath("//a[contains(@title,'to log in')]")).click();

        WebElement username = driver.findElement(By.id("wpName1"));
        username.sendKeys("MyNametatiana");
        WebElement password = driver.findElement(By.id("wpPassword1"));
        password.sendKeys("Pass123456789");

        WebElement button = driver.findElement(By.name("wploginattempt"));
        button.submit();

        WebElement link = driver.findElement(By.xpath("//a[@title='Wikipedia']"));
        link.click();
        WebElement link1 = driver.findElement(By.id("pt-logout"));
        link1.click();
        WebElement link2 = driver.findElement(By.xpath("//a[contains(@title,'log in')]"));
        link2.click();

        WebElement link3 = driver.findElement(By.xpath("//a[contains(@title,'to log in')]"));
        link3.click();
        WebElement username1 = driver.findElement(By.id("wpName1"));;
        username1.clear();

        WebElement button1 = driver.findElement(By.name("wploginattempt"));
        button1.submit();

        WebElement WebelementError = driver.findElement(By.className("errorbox"));
        if (WebelementError.getText().equals("There are problems with some of your input.")){
            System.out.println("Pass");
        }
        else  System.out.println("Fail");

        WebElement username2 = driver.findElement(By.id("wpName1"));
        username2.sendKeys("MyName");
        System.out.println("Username is " + username2.getAttribute("value"));
        WebElement password2 = driver.findElement(By.id("wpPassword1"));
        password2.sendKeys("111");

        WebElement button2 = driver.findElement(By.name("wploginattempt"));
        button2.submit();

        WebElement WebelementError1 = driver.findElement(By.className("errorbox"));
        if (WebelementError1.getText().equals("There are problems with some of your input.")) {
            System.out.println("Pass");
        }
        else  System.out.println("Fail");

        driver.quit();
    }
}

/*
        String Error = new String(WebelementError1.getText());
        boolean result = Error.contains("There are problems with some of your input.");
        System.out.println(result);
WebElement link = driver.findElement(By.linkText("Log in"));  // находит по названию линки
    WebElement link2 = driver.findElement(By.partialLinkText("Contact")); // находит по части названия текста
    WebElement searchField = driver.findElement(By.name("search"));
    WebElement searchButton = driver.findElement(By.ByClassName("searchButton")).click();
    WebElement webElement = driver.findElement(By.xpath("//a[@class='mw-wiki-logo']"));

        driver.manage().window().setSize(new Dimension( 900, 500)); // указываем размер окна
        driver.get("https://www.wikipedia.org/");
        driver.navigate().to("https://www.google.com");
        driver.navigate().back(); // возвращает предидущую страницу. на страницу назад
        driver.navigate().forward(); // возвращает на страницу вперед
        driver.navigate().refresh(); // перезагружает страничку
        System.out.println(driver.getTitle()); // получим тайтл нашей страницы и выведем на экран
        System.out.println(driver.getCurrentUrl());// получение URL странички и выведем на экран
        driver.quit(); // завершает работу браузера

    https://en.wikipedia.org/wiki/Main_Page
    div[@class ='lang-list-container']//li[3]/a[@title ='English']

              оси xPath
             ancestor-or-self::
              following-sibling::
              preceding-sibling::
                /parent::
     //input[@id='searchInput']/ancestor-or-self::form   возвращает предка и себя
     //input[@id='searchInput']/ancestor::form          возвращает предка данного узла
     //input[@id='searchInput']/following-sibling::*      позволяет вернуть соседей, которые находяться ниже нашего элемента
     //input[@id="searchButton"]/preceding-sibling::input[@id="searchInput"]   возвращает соседей, которые находяться на том же уровне, но выше нашего элемента
     //input[@id="searchButton"]/parent::*  возвращает родителя

           функции xPath
      //nav[@id='p-navigation']/div[@class='body vector-menu-content']/ul[@class='vector-menu-content-list']/li[last()]
      [last()] находит последний среди li
      //a[text()='Wikipedia']     -   [text()] находит по тексту
      //div[contains(@class, 'nourlexpansion')]   -   находим по контексту
      //input[starts-with(@title, "Search Wikipedia for")]    -  находит начало по контексту тайтлу или др
*/