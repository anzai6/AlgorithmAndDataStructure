package com.example.lib.course8_stack.my;

/**
 * Created by qinshunan on 2019/2/27.
 */

public class MySampleBrowser {

    private String mCurrentPage; // ��ǰ�������ҳ
    private MyStackBasedLinkedList mBackStack; // ����ջ
    private MyStackBasedLinkedList mForwardStack; // ǰ��ջ

    public MySampleBrowser() {
        mBackStack = new MyStackBasedLinkedList();
        mForwardStack = new MyStackBasedLinkedList();
    }

    /**
     * �ر������
     */
    public void closeBrower() {
        mCurrentPage = null;
        mBackStack.clear();
        mForwardStack.clear();
    }

    /**
     * ������
     *
     * @param url
     */
    public void open(String url) {
        if (!isStringEmpty(mCurrentPage)) { // ��һ�δ���ҳ���Ӳ������ջ
            mBackStack.push(mCurrentPage);
            mForwardStack.clear();
        }
        loadUrl(url, "open");
    }

    /**
     * ����
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
     * ǰ��
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
     * �����ӻ���
     *
     * @return
     */
    public boolean canGoBack() {
        return mBackStack.getSize() > 0;
    }

    /**
     * ������ǰ��
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
