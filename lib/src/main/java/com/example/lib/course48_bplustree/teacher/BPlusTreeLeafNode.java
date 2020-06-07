package com.example.lib.course48_bplustree.teacher;

/**
 * ���� B+ ����Ҷ�ӽڵ�Ķ��塣
 * <p>
 * B+ ���е�Ҷ�ӽڵ���ڲ�����ǲ�һ����,
 * Ҷ�ӽڵ�洢����ֵ���������䡣
 * ��������ÿ��Ҷ�ӽڵ�洢 3 �������еļ�ֵ����ַ��Ϣ��
 * <p>
 * k ֵ�����ȼ���õ��ģ��������������������Ϣ�Ĵ�С���õ���ҳ�Ĵ�С��int-4���ֽڣ�long-8���ֽ�
 * PAGE_SIZE = k*4[keyw.. ��С]+k*8[dataAd.. ��С]+8[prev ��С]+8[next ��С]
 */
public class BPlusTreeLeafNode {
    public static int k = 3;
    public int[] keywords = new int[k]; // ���ݵļ�ֵ
    public long[] dataAddress = new long[k]; // ���ݵ�ַ

    public BPlusTreeLeafNode prev; // �������������е�ǰ�����
    public BPlusTreeLeafNode next; // �������������еĺ�̽��
}
