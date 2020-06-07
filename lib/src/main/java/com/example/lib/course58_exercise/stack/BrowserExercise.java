package com.example.lib.course58_exercise.stack;

/**
 * ���ģ��ʵ��һ���������ǰ�������˹���
 */
public class BrowserExercise<T> {

    LinkStackExercise<String> backStack; // �洢��ǰ�Ѵ򿪵���������
    LinkStackExercise<String> closeStack; // �����ѹرյ�����
    private String mCurrentPage;

    public BrowserExercise() {
        backStack = new LinkStackExercise<>();
        closeStack = new LinkStackExercise<>();
    }

    /**
     * �ر������
     */
    public void closeBrower() {
        mCurrentPage = null;
        backStack.clear();
        closeStack.clear();
    }

    /**
     * ����ҳ���൱������
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
     * ǰ�������򿪸ո���������رյ���ҳ
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
     * ����
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
