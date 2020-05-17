package com.example.lib.course58_exercise.stack;

/**
 * 编程模拟实现一个浏览器的前进、后退功能
 */
public class BrowserExercise<T> {

    LinkStackExercise<String> backStack; // 存储当前已打开的所有链接
    LinkStackExercise<String> closeStack; // 存在已关闭的链接
    private String mCurrentPage;

    public BrowserExercise() {
        backStack = new LinkStackExercise<>();
        closeStack = new LinkStackExercise<>();
    }

    /**
     * 关闭浏览器
     */
    public void closeBrower() {
        mCurrentPage = null;
        backStack.clear();
        closeStack.clear();
    }

    /**
     * 打开网页，相当于新增
     *
     * @param url
     * @return
     */
    public void open(String url) {
        if (url == null)
            return;
        if (mCurrentPage != null) {
            backStack.push(mCurrentPage);
            closeStack.clear();
        }
        loadUrl(url, "open");
    }

    /**
     * 前进：即打开刚刚浏览过并关闭的网页
     *
     * @return
     */
    public boolean goForward() {
        if (closeStack.isEmpty()) {
            System.out.println("No Forward Page");
            return false;
        }
        String url = closeStack.pop();
        backStack.push(mCurrentPage);
        loadUrl(url, "goForward");
        return true;
    }

    /**
     * 后退
     *
     * @return
     */
    public boolean goBack() {
        if (backStack.isEmpty()) {
            System.out.println("No Back Page");
            return false;
        }

        closeStack.push(mCurrentPage);
        String url = backStack.pop();
        loadUrl(url, "goBack");
        return true;
    }

    public void loadUrl(String url, String action) {
        mCurrentPage = url;
        System.out.println("LoadUrl ---- :" + url + " Action:" + action);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.mCurrentPage);
    }


    public static void main(String[] args) {
        BrowserExercise browser = new BrowserExercise();
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
