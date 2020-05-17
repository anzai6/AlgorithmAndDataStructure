package com.leetcode.anzai.subject_61_80;

import java.util.Stack;

/**
 * ��·��
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class Subject71 {

    /**
     *
     �� Unix ������һ���ļ��ľ���·��������Ҫ���������߻��仰˵������ת��Ϊ�淶·����

     �� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..��  ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�
     ������Ϣ����ģ�Linux / Unix�еľ���·�� vs ���·��(https://blog.csdn.net/u011327334/article/details/50355600)

     ��ע�⣬���صĹ淶·������ʼ����б�� / ��ͷ����������Ŀ¼��֮�����ֻ��һ��б�� /�����һ��Ŀ¼����������ڣ������� / ��β�����⣬�淶·�������Ǳ�ʾ����·��������ַ�����



     ʾ�� 1��

     ���룺"/home/"
     �����"/home"
     ���ͣ�ע�⣬���һ��Ŀ¼������û��б�ܡ�
     ʾ�� 2��

     ���룺"/../"
     �����"/"
     ���ͣ��Ӹ�Ŀ¼����һ���ǲ����еģ���Ϊ��������Ե������߼���
     ʾ�� 3��

     ���룺"/home//foo/"
     �����"/home/foo"
     ���ͣ��ڹ淶·���У��������б����Ҫ��һ��б���滻��
     ʾ�� 4��

     ���룺"/a/./b/../../c/"
     �����"/c"
     ʾ�� 5��

     ���룺"/a/../../b/../c//.//"
     �����"/c"
     ʾ�� 6��

     ���룺"/a//b////c/d//././/.."
     �����"/a/b/c"
     *
     */


    /**
     * �����뷨����pathͨ��"/"���飬����ջ����������飬�����װ
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        if (path == null || "".equals(path) || !path.contains("/")) {
            return "/";
        }
        String[] list = path.split("/");
        Stack stack = new Stack();
        for (int i = 0; i < list.length; i++) {
            String item = list[i];
            if ("".equals(item) || "/".equals(item) || ".".equals(item)) { // ��ЧĿ¼
                continue;
            }

            if ("..".equals(item)) { // ��ջ
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else { // ��ջ
                stack.push(item);
            }
        }

        if (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append("/" + stack.remove(0));
            }
            return sb.toString();
        }

        return "/";
    }

    public static void main(String[] args) {
        String path = "/home/";
//        path = "/../";
//        path = "/home//foo/";
//        path = "/a/./b/../../c/";
//        path = "/a/../../b/../c//.//";
//        path = "/a//b////c/d//././/..";
        Subject71 subject = new Subject71();
        System.out.println(subject.simplifyPath(path));
    }

}
