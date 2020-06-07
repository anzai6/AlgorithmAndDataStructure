package com.example.lib.course48_bplustree.teacher;

/**
 * ���� B+ ����Ҷ�ӽڵ�Ķ��塣
 * <p>
 * ���� keywords=[3, 5, 8, 10]
 * 4 ����ֵ�����ݷ�Ϊ 5 �����䣺(-INF,3), [3,5), [5,8), [8,10), [10,INF)
 * 5 ������ֱ��Ӧ��children[0]...children[4]
 * <p>
 * m ֵ�����ȼ���õ��ģ��������������������Ϣ�Ĵ�С���õ���ҳ�Ĵ�С��int-4���ֽڣ�long-8���ֽ�
 * PAGE_SIZE = (m-1)*4[keywordss ��С]+m*8[children ��С]
 */
public class BPlusTreeNode {
    public static int m = 5; // 5 ����
    public int[] keywords = new int[m - 1]; // ��ֵ������������������
    public BPlusTreeNode[] children = new BPlusTreeNode[m];// �����ӽڵ�ָ��
}
