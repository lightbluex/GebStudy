/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.ie.InternetExplorerDriver

driver = "chrome"
//driver = "firefox"

System.setProperty("webdriver.chrome.driver", "D:/test/Geb_tests/GebStudy/travel_homepage_check/exe/chromedriver.exe")

System.setProperty("webdriver.ie.driver", "exe/IEDriverServer.exe")


//driver = { new FirefoxDriver() }
//driver = { new ChromeDriver() }
//driver = { new InternetExplorerDriver() }




//baseUrl = "http://travel.rakuten.co.jp"
