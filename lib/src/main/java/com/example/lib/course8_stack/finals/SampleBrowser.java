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
        backStack = new LinkedListBasedStack();
        forwardStack = new LinkedListBasedStack();
    }

    public void open(String url) {
        showUrl(url, "Open");
        forwardStack.clear();
        if (currentPage != null && !"".equals(currentPage)) {
            backStack.push(currentPage);
        }
        currentPage = url;
    }

    public boolean canGoBack() {
        return this.backStack.size() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }

    public String goBack() {
        if (!canGoBack()) {
            System.out.println("* Cannot go back, no pages behind.");
            return "";
        }
        if (currentPage != null && !"".equals(currentPage)) {
            forwardStack.push(currentPage);
        }
        currentPage = backStack.pop();
        showUrl(currentPage, "goBack");
        return currentPage;
    }

    public String goForward() {
        if (!canGoForward()) {
            System.out.println("* Cannot go goForward, no pages behind.");
            return "";
        }
        if (currentPage != null && !"".equals(currentPage)) {
            backStack.push(currentPage);
        }
        currentPage = forwardStack.pop();
        showUrl(currentPage, "goForward");
        return currentPage;
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
            top = null;
            size = 0;
        }

        public void push(String data) {
            Node newNode = new Node(data, null);
            if (top != null) {
                newNode.next = top;
            }
            top = newNode;
            ++size;
        }

        public String pop() {
            if (top == null)
                return "";
            String value = top.data;
            top = top.next;
            --size;
            return value;
        }

        public String getTopData() {
            return top == null ? "" : top.data;
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
