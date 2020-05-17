package com.example.lib.course11_sorts.my;

/**
 * ð�����򣬲�������ѡ������
 * Created by qinshunan on 2019/2/27.
 */
public class MySorts {

    /**
     * ð�����򣬲��ϵĸ����ڵ�itemȥ�Ƚϣ�Ȼ�󽻻�
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     * ��������ð�ݣ���������ð�ݣ�����0��ʼ�������ϱȽϣ�С���򽻻���0��λ�ã�һ������0�������С�ģ��Դ����ơ�
     *
     * @param data
     * @return
     */
    public int[] bubblingSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            boolean noTransFlag = false; // �ж���һ���Ƿ��н���
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {// �����򽻻�
                    int value = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = value;
                    noTransFlag = true;
                }
            }
            // ���û�з�������֤���Ѿ�������ˣ����涼������ѭ����
            if (!noTransFlag)
                break;
        }
        return data;
    }

    /**
     * �����������������õģ�����������ɢ���磺0��1��������ˣ���2���0��1�Ƚϣ�������ʵ�λ�ã�
     * Ȼ��0��1��2������ˣ���3���0��1��2�Ƚϣ�������ʵ�λ�ã��Դ����ƺ�����
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     *
     * @param data
     * @return
     */
    public int[] insertionSort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) { // ��1��ʼ����Ϊ0���Ҫ�Ƚ�
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) { // j���ڵ�������õ�ѡ��
                if (data[j] > value) { // ����value�������ƶ�һλ
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
        return data;
    }

    /**
     * ѡ������ȡn-1��ϸ���Ŀ�Ƚϣ�����n-1���򽻻�������n-1��������ֵ��Ȼ��n-2��n-3....�Դ�����
     * (���ȶ�������,��Ϊ���ڽ���λ��)
     *
     * @param data
     * @return
     */
    public int[] selectionSort(int[] data) {
        int n = data.length;
        for (int i = n - 1; i > 0; i--) { // 0���Ҫ�Ƚ�
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[i]) {// �����򽻻�
                    int value = data[i];
                    data[i] = data[j];
                    data[j] = value;
                }
            }
        }
        return data;
    }

    /**
     * ��չ��
     * �۰��������0~i-1����������õģ�Ȼ�������۰�������Ѱ��i��Ĳ���λ�á�Ȼ���Ӧ�����������ƶ�
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     *
     * @param data
     * @return
     */
    public int[] halfInsertionSort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) { // ��1��ʼ����Ϊ0���Ҫ�Ƚ�

            // ���ҳ���λ�����±�m
            int value = data[i];
            int low = 0; // �Ƚ�����ĵ�һ��Ԫ������λ��
            int high = i - 1; // �Ƚ���������һ��Ԫ������λ��
            int m = 0; // ��λ��
            while (low <= high) {
                m = (low + high) / 2;
                if (data[m] > value) { // ����������
                    high = m - 1;
                } else { // ����
                    low = m + 1;
                }
            }

            // �����ƶ�����,��������low=hign��ʱ���hign�����ƿ�֪����Ҫ�ƶ�����high+1��i-1�����ֵ���úÿ���
            for (int j = i - 1; j > high; j--) {
                data[j + 1] = data[j];
            }
            data[high + 1] = value;

        }
        return data;
    }


    /**
     * ��չ��
     * ϣ������https://blog.csdn.net/qq_39207948/article/details/80006224
     * (���ȶ�������)
     *
     * @param data
     * @return
     */
    public int[] shellSort(int[] data) {
        int n = data.length;
        int interval = n / 2; // �������ʼ����Ϊ���鳤�ȵ�һ�룬Ȼ���𽥵ݼ�
        for (; interval > 0; interval /= 2) { // ���������
            // �Լ�����ڵĸ���������в�������
            for (int i = interval; i < n; i++) {
                // ��arr[i]���뵽���ڷ������ȷλ��
                insertI(data, interval, i);
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

    public void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySorts mySorts = new MySorts();
        int n = 10;
        int[] data1 = getRandomArray(n);
        int[] data2 = getRandomArray(n);
        int[] data3 = getRandomArray(n);
//        System.out.println("����ǰ");
//        mySorts.printArray(data1);
//        System.out.println("ð������");
//        mySorts.bubblingSort(data1);
//        mySorts.printArray(data1);
//
//        System.out.println("����ǰ");
//        mySorts.printArray(data2);
//        System.out.println("��������");
//        mySorts.insertionSort(data2);
//        mySorts.printArray(data2);
//
//        System.out.println("����ǰ");
//        mySorts.printArray(data3);
//        System.out.println("ѡ������");
//        mySorts.selectionSort(data3);
//        mySorts.printArray(data3);
//
//        System.out.println("����ǰ");
//        mySorts.printArray(data3);
//        System.out.println("�۰��������");
//        mySorts.halfInsertionSort(data3);
//        mySorts.printArray(data3);
//
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
