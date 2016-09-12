package Alibaba.Arbergo.Maven;

import java.util.*;

/**
 * Created by zhensheng on 2016/9/9.
 */
public class Dependency {
    static Set<Dependency> dependencySet= new HashSet<>();

    public Dependency buildRoot(Dependency ...args){
        Dependency root = new Dependency();
        for(Dependency arg:args){
            root.denpendons.add(arg);
        }
        return root;

    }
    /**
     * 该文件依赖的文件
     */
    List<Dependency> denpendons;
    /**
     * 路径最先原则， 则深度最小的被依赖，则按广度有限进行搜索
     * @param root
     */
    public void build(Dependency root){
        Queue<Dependency> queue= new LinkedList<>();
        queue.add(root);
        dependencySet.add(root);
        while(!queue.isEmpty()){
            Dependency peek = queue.poll();
            for(Dependency dependency :peek.denpendons){
                dependencySet.add(dependency);
                queue.add(dependency);
            }
        }

    }

    public void buildByDepth(Dependency root){
        dependencySet.add(root);
        for(Dependency dependency : root.denpendons){
            buildByDepth(dependency);
        }
    }
}
