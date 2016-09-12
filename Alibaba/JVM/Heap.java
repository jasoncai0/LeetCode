package Alibaba.JVM;

import java.util.List;

/**
 * Created by zhensheng on 2016/9/9.
 */
public class Heap {
    static int MAX_AGE= 16;
    private static List<JVMObject> eden;
    private static List<JVMObject> fromSurvivor;
    private static List<JVMObject> toSurvivor;
    private static List<JVMObject> metaSpace;
    static class JVMObject{
        String Mark;
        int age;
        public JVMObject(){
            age =0 ;
            eden.add(this);
        }

        public void finalize() {

        }

        public void ageIncrement(){
            age++;
            if(age>=MAX_AGE){
                //this.finalize();
                moveToMetaSpace(this);
            }
        }

    }
    private static  void moveToMetaSpace(JVMObject jvmObject) {
        removeformSurvivor(jvmObject);
        metaSpace.add(jvmObject);

    }

    private static void removeformSurvivor(JVMObject jvmObject) {
    }

    public static void moveToSurvior(JVMObject jvmObject){
        eden.remove(jvmObject);
        fromSurvivor.add(jvmObject);
    }

    public void gc(){
        for(JVMObject object : eden){
            object.ageIncrement();

            /**
             * 实际要采用可达性检测，这里简化
             */
            if(object == null ){
                object.finalize();
                moveToSurvior(object);
            }
        }
    }

    public static void main(String[] args) {
        JVMObject j1 = new JVMObject();
        JVMObject j2 = new JVMObject();
        //j1.null;
    }







}
