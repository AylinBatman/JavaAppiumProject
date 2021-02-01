package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Methods {
    public static MobileElement mobileElement;
    public WebDriverWait wait;
    public  AppiumDriver driver;
    String emptySepetText = "There is no result";

    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5 API 30");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("appPackage", "com.getir.casestudy.dev");
        caps.setCapability("appActivity", "com.getir.casestudy.modules.splash.ui.SplashActivity");
        caps.setCapability("skipServerInstallation", "false");
        caps.setCapability("automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
    public void loginAccount(String u, String p) throws InterruptedException, MalformedURLException {
        System.out.println("-------------SENARYO BAŞLIYOR---------------");
        waitForPresence((AndroidDriver) driver,10000, "com.getir.casestudy.dev:id/usernameEditText" );
        WebElement loginEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.getir.casestudy.dev:id/usernameEditText")));
        loginEmail.sendKeys(u);

        WebElement loginPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.getir.casestudy.dev:id/passwordEditText")));
        loginPassword.sendKeys(p);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.getir.casestudy.dev:id/loginButton")));
        loginButton.click();

        System.out.println("BAŞARILI LOGIN OLDUN");
    }

    public void sepeteGit() {
        WebElement sepetGit = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton")));
        sepetGit.click();
        System.out.println("SEPETTESİN");
    }

    public void sepeteEmptyControl() {

        WebElement sepeteEmpty = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.getir.casestudy.dev:id/tvTitle")));
        String sepetText = sepeteEmpty.getText();

        if (sepetText.equals(emptySepetText)) {
            System.out.println("-------------SEPET BOŞ KONYTOLÜ : SEPET BOŞ---------------");
        } else {
            System.out.println("------------SEPET DOLU HATA!----------------");
       }
    }
    public void BackGit() {
        WebElement Back = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView")));
        Back.click();
    }

    public void KategoriGit(Integer s) {
        WebElement categoryAt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+s+"]/android.widget.FrameLayout/android.widget.TextView")));
        categoryAt.click();
        System.out.println("KATEGORİYE GİDİLDİ");
    }

    public void urunEkle(Integer s) {
        WebElement addProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+s+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView")));
        addProduct.click();
        System.out.println("ÜRÜN EKLEME BAŞARILI");
    }

    public void urunEkleCoklu(Integer s, Integer ss) {
        WebElement addProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+s+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView["+ss+"]")));
        addProduct.click();
        System.out.println("BİRDEN FAZLA ÜRÜN İÇİN BİRDEN FAZLA EKLEME BAŞARILI");
    }
    public void scroll() {

        TouchAction action =new TouchAction(driver);
        Dimension size	=driver.manage().window().getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height*.7);
        int endYCoordinate= (int)(height*.2);

        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();

    }

    public void sepetArtıControl() {
        WebElement SepetProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("\t/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")));
        String productSayı = SepetProduct.getText();
        urunEkleCoklu(1,2);
        String productSayıSon = SepetProduct.getText();

        if (productSayı.equals(productSayıSon)){
            System.out.println("-------------SEPETTE ÜRÜN EKLENMEMİŞ---------------");
        }
        else {
            System.out.println("-------------SEPETTE ÜRÜN EKLENMİŞ---------------");
        }
    }
    public void urunSil() {

        scroll();
        WebElement parentElement = driver.findElement(By.id("productrecyclerView"));
        List<WebElement> childElements = parentElement.findElements(By.className("android.view.ViewGroup"));

        for(int x=3; x>= 1 ; x--){
            System.out.println("x1" + childElements.size() /2);
            WebElement elementUrun = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+x+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"));
            WebElement elementUrunClick = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+x+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[1]"));
            String deger = elementUrun.getText();
            int y1 = Integer.valueOf(deger);
            System.out.println("deger" + deger);
            System.out.println("y1" + y1);
            for(int y = y1; y>=1; y--){
                elementUrunClick.click();
            }
        }

    }

    public void categorySayısı() {
        WebElement parentElement = driver.findElement(By.id("mainRecyclerView"));
        List<WebElement> childElements = parentElement.findElements(By.className("android.view.ViewGroup"));
        childElements.size();
        System.out.println("Kategori Sayısı : " + childElements.size());

    }

    public void SepetiBosalt() {
        WebElement parentElement = driver.findElement(By.id("productrecyclerView"));
        List<WebElement> childElements = parentElement.findElements(By.className("android.view.ViewGroup"));
        childElements.size();

        System.out.println("Sepetteki Ürün Sayısı : " + childElements.size()/2);
        System.out.println("Sepetteki Ürün Sayısı 2  : " + parentElement.getSize());

        for(int x=4; x>= 1 ; x--){
            System.out.println("x1" + childElements.size() /2);
            WebElement elementUrun = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+x+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"));
            WebElement elementUrunClick = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+x+"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[1]"));
            String deger = elementUrun.getText();
            int y1 = Integer.valueOf(deger);
            System.out.println("deger" + deger);
            System.out.println("y1" + y1);
            for(int y = y1; y>=1; y--){
                elementUrunClick.click();
              }
        }

        sepeteEmptyControl();
    }
    public void logout() {
        WebElement profil = driver.findElement(By.id("com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView"));
        profil.click();
        WebElement logoutButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.TextView"));
        logoutButton.click();
        WebElement submitButton = driver.findElement(By.id("com.getir.casestudy.dev:id/loginButton"));
        submitButton.getText();
        String submit = "Submit";

        if(submitButton.getText().equals(submit)){
            System.out.println("BAŞARILI LOGOUT");
        }
        else {
            System.out.println("BAŞARISIZ LOGOUT");
        }

    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, String targetResourceId){
        boolean isElementPresent;
        try{
            mobileElement =  (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+targetResourceId+"\")");
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        }catch(Exception e){
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        } }
}
