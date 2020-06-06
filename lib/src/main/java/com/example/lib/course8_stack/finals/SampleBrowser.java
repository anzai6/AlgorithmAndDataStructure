package com.example.lib.course8_stack.finals;

/**
 * 使用前后栈实现浏览器的前进后退。
 *
 * @author chinalwb
 */
public class SampleBrowser {

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
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

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
    }

    public void open(String url) {
        showUrl(url, "Open");
    }

    public boolean canGoBack() {
        return this.backStack.size() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }

    public String goBack() {

        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public String goForward() {

        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }

    public void showUrl(String url, String prefix) {
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    /**
     * A LinkedListExercise1Single based Stack implementation.
     */
    public static class LinkedListBasedStack {

        private int size;
        private Node top;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
        }

        public void push(String data) {
        }

        public String pop() {
            return "";
        }

        public String getTopData() {
            return "";
        }

        public int size() {
            return this.size;
        }

        public void print() {
            System.out.println("Print stack:");
            Node currentNode = this.top;
            while (currentNode != null) {
                String data = currentNode.getData();
                System.out.print(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

        public static class Node {

            private String data;
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getData() {
                return this.data;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }
        }

    }
}
