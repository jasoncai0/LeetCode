package Huawei.zuigaofen;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by zhensheng on 2016/8/16.
 */
public class Main {
    static class Student{
        int id;
        int grade;

        public Student(int grade, int id) {
            this.grade = grade;
            this.id = id;
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int grades  [] = new int[N];

            for (int i = 0; i < N ; i++) {
                int grade= in.nextInt();
                Student s = new Student(grade,i);
;
                grades[i] = grade;

            }
            for (int i = 0; i < M ; i++) {
                String job = in.next();
                int A = in.nextInt();
                int B = in.nextInt();
                if("Q".equals(job)){
                    if(A>B){
                        int temp = A;
                        A= B;
                        B= temp;
                    }
                    int max= 0;
                    for (int j = A; j <=B ; j++) {
                        if(max< grades[j-1]){
                            max= grades[j-1];
                        }
                    }
                    System.out.println(max);
                }
                else if("U".equals(job)){
                    grades[A-1]= B;
                }
            }

        }
    }
}
