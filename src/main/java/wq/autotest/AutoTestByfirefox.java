package wq.autotest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//public protected private
public class AutoTestByfirefox {

	public static void main(String[] args) {
		//打开浏览器
		WebDriver driver = new FirefoxDriver();
//		//最大化窗口
		driver.manage().window().maximize();
//		WebDriver driver = new InternetExplorerDriver();
//		等待
//		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		//打开京东首页
		driver.get("http://www.jd.com");
		//等待
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//进入登陆页面
		WebElement loginBtn = driver.findElement(By.className("link-login"));
		loginBtn.click();
        //输入用户名
        WebElement loginNameInput = driver.findElement(By.id("loginname"));
        loginNameInput.sendKeys("wq8987");
        //输入密码
        WebElement loginPwdInput = driver.findElement(By.id("nloginpwd"));
        loginPwdInput.sendKeys("Wq89871684");
        //自动登陆框
        WebElement autoLoginBox = driver.findElement(By.id("autoLogin"));
        //不自动登陆
        if(autoLoginBox.isSelected()){
        	autoLoginBox.click();
        }
        //提交登陆
        WebElement loginSubmitBtn = driver.findElement(By.id("loginsubmit"));
        loginSubmitBtn.click();
        //等待3秒
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //查找商品-小米note
        WebElement searchKeyInput = driver.findElement(By.id("key"));
        searchKeyInput.click();
        searchKeyInput .sendKeys("小米note");
       //跳转到结果页面
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/button")).click();
      //等待3秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //切换对象到新页面
      driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[7]/ul/li/div/div/a")).click();
        //这路跳转会导致登陆状态丢失
        //driver.get("http://item.jd.com/1514801.html");
      //等待3秒
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      //切换窗口
      Set<String> windows =driver.getWindowHandles();
      for (Iterator iterator = windows.iterator(); iterator.hasNext();) {
		String windowItem = (String) iterator.next();
		System.out.println(driver.getWindowHandle() + ":" + windowItem);
		if(!driver.getWindowHandle().equals(windowItem)){
			driver = driver.switchTo().window(windowItem);
		}
	}
		//下单
		WebElement orderBtn = driver.findElement(By.id("btn-easybuy-submit"));
		orderBtn.click();
		 System.out.println(driver.getTitle());
		//等待3秒
	      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//提交订单
		WebElement submitOrderBtn = driver.findElement(By.id("order-submit"));
		submitOrderBtn.click();
		 System.out.println(driver.getTitle());
		WebElement result = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/h3"));
		if(result.getText().trim().contains("订单提交成功")){
			System.out.println("订单提交成功");
		}else{
			System.err.println("订单提交失败");
		}
		//退出登陆
	driver.findElement(By.className("link-logout")).click();;
	 driver.quit();	
	}
}