package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static WebElement element = null;

    /*
     * JUST FOR REFERENCE 
     */
//	private static By message = By.xpath("//a[@href=\"/messages/\"]");
//	private static By logout = By.xpath("//*[@id=\"page-contents\"]/div[1]/aside/div/ul/li[6]/a");
//	private static By friendLink = By.xpath("//*[@id=\"page-contents\"]/div[1]/aside/div/ul/li[3]/a");
//	private static By addFriendBtn = By.className("add-friend");
//	private static By friend = By.xpath("//*[@id=\"page-contents\"]/div[1]/aside/div/ul/li[4]/a");
//	private static By likeBtn =By.xpath("//*[@id=\"page-contents\"]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/ul/li[2]/span/ins");
//	private static By dislikeBtn =By.xpath("//*[@id=\"page-contents\"]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/ul/li[3]/span/ins");
//	private static By notification = By.xpath("//*[@id=\"page-contents\"]/div[1]/aside/div/ul/li[5]/a");
//	private static By whoIsFollowingFindFriend = By.xpath("//*[@id=\"page-contents\"]/div[3]/aside/div[1]/ul/li[1]/div/a");
//	private static By hamBurger = By.className("main-menu");
//	private static By userName = By.xpath("//*[@id=\"page-contents\"]/div[2]/div[2]/div/div/div[1]/div[1]/ins/a");
//	private static By profilePage = By.className("fileContainer");
//	private static By searchBox = By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/form/input");
//	private static By searchBtn = By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/form/button");
//
//	public static WebElement userMessage(WebDriver driver) {
//		element =  driver.findElement(message);
//		return element;
//	}
//
//	public static WebElement userLogOut(WebDriver driver) {
//		element =  driver.findElement(logout);
//		return element;
//	}
//
//	public static WebElement getFindFriendLink(WebDriver driver) {
//		element =  driver.findElement(friendLink);
//		return element;
//	}
//
//	public static WebElement getAddFriendBtn(WebDriver driver) {
//		element =   driver.findElement(addFriendBtn);
//		return element;
//	}
//
//	public static String getActualBtnName(WebDriver driver) {
//		String name = driver.findElement(addFriendBtn).getText();
//		return name;
//	}
//
//	public static WebElement getFrienLinkNew(WebDriver driver) {
//		element =  driver.findElement(friend);
//		return element;
//	}
//
//	public static String getPageTitle(WebDriver driver) {
//		return driver.getTitle();
//	}
//
//	public static WebElement getLikeBtn(WebDriver driver) {
//		element =   driver.findElement(likeBtn);
//		return element;
//	}
//
//	public static WebElement getDislikeBtn(WebDriver driver) {
//		element = driver.findElement(dislikeBtn);
//		return element;
//	}
//
//	public static WebElement getNotificationLink(WebDriver driver) {
//		element =   driver.findElement(notification);
//		return element;
//	}
//
//	public static WebElement getFindFriendWhoIsFollowing(WebDriver driver) {
//		element =   driver.findElement(whoIsFollowingFindFriend);
//		return element;
//	}
//
//	public static WebElement getHamBurgermenu(WebDriver driver) {
//		element =   driver.findElement(hamBurger);
//		return element;
//	}
//
//	public static WebElement getUserName(WebDriver driver) {
//		element =   driver.findElement(userName);
//		return element;
//	}
//
//	public static String verifyProfilePage(WebDriver driver) {
//		String name = driver.findElement(profilePage).getText();
//		return name;
//	}
//
//	public static WebElement getSearchBox(WebDriver driver) {
//		element =   driver.findElement(searchBox);
//		return element;
//	}
//
//	public static WebElement getSearchBtn(WebDriver driver) {
//		element =   driver.findElement(searchBtn);
//		return element;
//	}
}