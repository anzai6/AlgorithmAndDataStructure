package com.example.lib.course8_stack.my;

/**
 * Created by qinshunan on 2019/2/27.
 */

public class MySampleBrowser {

    private String mCurrentPage; // 当前浏览的网页
    private MyStackBasedLinkedList mBackStack; // 回退栈
    private MyStackBasedLinkedList mForwardStack; // 前进栈

    public MySampleBrowser() {
        mBackStack = new MyStackBasedLinkedList();
        mForwardStack = new MyStackBasedLinkedList();
    }

    /**
     * 关闭浏览器
     */
    public void closeBrower() {
        mCurrentPage = null;
        mBackStack.clear();
        mForwardStack.clear();
    }

    /**
     * 打开链接
     *
     * @param url
     */
    public void open(String url) {
        if (!isStringEmpty(mCurrentPage)) { // 第一次打开网页链接不入回退栈
            mBackStack.push(mCurrentPage);
            mForwardStack.clear();
        }
        loadUrl(url, "open");
    }

    /**
     * 后退
     *
     * @return
     */
    public String goBack() {
        if (canGoBack()) {
            String url = mBackStack.pop();
            mForwardStack.push(mCurrentPage);
            loadUrl(url, "goBack");
            return url;
        }
        System.out.println("No Back Page");
        return "";
    }

    /**
     * 前进
     *
     * @return
     */
    public String goForward() {
        if (canGoForward()) {
            String url = mForwardStack.pop();
            mBackStack.push(mCurrentPage);
            loadUrl(url, "goForward");
            return url;
        }
        System.out.println("No Forward Page");
        return "";
    }

    /**
     * 有链接回退
     *
     * @return
     */
    public boolean canGoBack() {
        return mBackStack.getSize() > 0;
    }

    /**
     * 有链接前进
     *
     * @return
     */
    public boolean canGoForward() {
        return mForwardStack.getSize() > 0;
    }

    public void loadUrl(String url, String action) {
        mCurrentPage = url;
        System.out.println("LoadUrl ---- :" + url + " Action:" + action);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.mCurrentPage);
    }

    public static boolean isStringEmpty(String data) {
        return data == null || "".equals(data);
    }

    public static void main(String[] args) {
        MySampleBrowser browser = new MySampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }
}
