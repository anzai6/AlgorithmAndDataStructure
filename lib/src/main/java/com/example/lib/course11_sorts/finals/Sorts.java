package com.example.lib.course11_sorts.finals;

/**
 * ð�����򡢲�������ѡ������
 */
public class Sorts {

    /**
     * ð�����򣬲��ϵĸ����ڵ�itemȥ�Ƚϣ�Ȼ�󽻻�
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     * ��������ð�ݣ���������ð�ݣ�����0��ʼ�������ϱȽϣ�С���򽻻���0��λ�ã�һ������0�������С�ģ��Դ����ơ�
     * <p>
     * �ȶ�������ʱ�临�Ӷȣ���� O(n^2)���O(n^2)��ƽ��O(n^2)
     *
     * @param data
     * @return
     */
    public int[] bubblingSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        for (int i = len - 1; i > 0; i--) {
            boolean isSwap = false;
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) { // �����򽻻�
                    swapData(data, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) { // û�н�����֤���Ѿ����������
                return data;
            }
        }
        return data;
    }

    /**
     * �����������������õģ�����������ɢ���磺0��1��������ˣ���2���0��1�Ƚϣ�������ʵ�λ�ã�
     * Ȼ��0��1��2������ˣ���3���0��1��2�Ƚϣ�������ʵ�λ�ã��Դ����ƺ�����
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     * <p>
     * �ȶ�������ʱ�临�Ӷȣ���� O(n)���O(n^2)��ƽ��O(n^2)
     *
     * @param data
     * @return
     */
    public int[] insertionSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        for (int i = 1; i < len; i++) {
            int item = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // ����Ҫ�����itemʱ����ǰ�ƶ�
                if (data[j] > item) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = item;
        }
        return data;
    }

    /**
     * ѡ������ȡn-1��ϸ���Ŀ�Ƚϣ�����n-1���򽻻�������n-1��������ֵ��Ȼ��n-2��n-3....�Դ�����
     * (���ȶ�������,��Ϊ���ڽ���λ��)
     * ���ȶ�������ʱ�临�Ӷȣ���� O(n^2)���O(n^2)��ƽ��O(n^2)
     *
     * @param data
     * @return
     */
    public int[] selectionSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        for (int i = 0; i < len - 1; i++) {
            int maxItem = data[i];
            int maxIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (data[j] < maxItem) {
                    maxItem = data[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                swapData(data, i, maxIndex);
            }
        }
        return data;
    }

    /**
     * �����������������С���߻����������������Ч�ʺܸߣ������������������������Ч�ʽϵͣ�ϣ��������Ǿݴ˸Ľ��ģ�
     * �ֽ�������м���ֳ�һ�����飬��ʱһ�����ݺ�С���ǲ�������ͺܸ�Ч��Ȼ��������С�����ÿ����Сһ��������ÿ�������������࣬
     * ������ǰ����̵棬��������Ƚϸߣ����Դ�ʱ���������Ч��Ҳ���ɺܸߣ��ȵ������С��1���������
     * ��չ��
     * ϣ������https://blog.csdn.net/qq_39207948/article/details/80006224
     * (���ȶ�������)
     *
     * @param data
     * @return
     */
    public int[] shellSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        // �� len/2 �����ʼ��ÿ������һ��������������Сһ��
        for (int gap = len / 2; gap >= 1; gap = gap / 2) {
            // �Լ�����ڵĸ���������в�������
            for (int i = gap; i < len; i++) {
                // ��arr[i]���뵽���ڷ������ȷλ��
                insertI(data, gap, i);
            }
        }
        return data;
    }

    /**
     * ��arr[i]���뵽���ڷ������ȷλ��
     *
     * @param arr
     * @param interval
     * @param i
     */
    private void insertI(int[] arr, int interval, int i) {
        int insertValue = arr[i];
        int j;
        for (j = i - interval; j >= 0; j -= interval) {
            if (arr[j] > insertValue) {
                arr[j + interval] = arr[j];
            } else {
                break;
            }
        }
        arr[j + interval] = insertValue;
    }

    public void swapData(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sorts mySorts = new Sorts();
        int n = 10;
        int[] data1 = getRandomArray(n);
        int[] data2 = getRandomArray(n);
        int[] data3 = getRandomArray(n);
//        System.out.println("����ǰ");
//        mySorts.printArray(data1);
//        System.out.println("ð������");
//        mySorts.bubblingSort(data1);
//        mySorts.printArray(data1);

//        System.out.println("����ǰ");
//        mySorts.printArray(data2);
//        System.out.println("��������");
//        mySorts.insertionSort(data2);
//        mySorts.printArray(data2);

//        System.out.println("����ǰ");
//        mySorts.printArray(data3);
//        System.out.println("ѡ������");
//        mySorts.selectionSort(data3);
//        mySorts.printArray(data3);

        System.out.println("����ǰ");
        mySorts.printArray(data3);
        System.out.println("ϣ������");
        mySorts.shellSort(data3);
        mySorts.printArray(data3);


        // �Ƚ�ð�ݺͲ�������ĺ�ʱ�����a��a���ȵ�����������
        /*int a = 5000;

        int[][] data4 = new int[a][a];
        for (int i = 0; i < a; i++) {
            data4[i] = getRandomArray(a);
        }
        int[][] data5 = new int[a][a];
        for (int i = 0; i < a; i++) {
            data5[i] = getRandomArray(a);
        }

        // ð������
        long buTime = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            mySorts.bubblingSort(data4[i]);
        }
        buTime = System.currentTimeMillis() - buTime;
        System.out.println("ð������" + buTime);

        // ��������
        long insertTime = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            mySorts.insertionSort(data5[i]);
        }
        insertTime = System.currentTimeMillis() - insertTime;
        System.out.println("��������" + insertTime);*/
    }

    /**
     * ��ȡһ���������
     *
     * @param n ����
     * @return
     */
    public static int[] getRandomArray(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * n);
        }
        return data;
    }

}
