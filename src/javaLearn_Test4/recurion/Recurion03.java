//package recurion;
//
//import java.util.ArrayList;
//
///**
// * @author 风之诗
// * 递归求解迷宫问题
// */
//public class Recurion03 {
// /**
// * 老鼠找路问题解法：
// *      1、假设 0为未找过可通过的路，1为未找过的障碍物，2为找过的可通过的路，3为找过的不可通过的路
// *      2、小鼠不能原路返回
// *      3、找路策略为先找下，再找右，再找上，再找左
// *
// *      穷举法寻找最短路径：
// *          1、创建一个集合来记录每一次到终点所经历的步数的位置，然后用一个集合的集合用来保存每一个集合的位置，最终就能得到每一个到达终点的步数
// *          2、寻找路径，（注意路径的回溯）
// *          3、筛选最短路径
// * @param map
// * @param i
// * @param j
// * @return
// */
//    //疑问1：寻找到终点后如何返回来继续寻找新的路径
//    //疑问2：上一步的路径如何记录，并且如何记录步数
//    //疑问3：如何清除该路上已经走过的路径:我们事先并不知道能够通过的路径有多少条，所以走完之后存在 回溯 的过程，也就是把之前之前走过的路还原为 0 且 之前的结果 remove()；
//
//    static void findway(int[][]map,int i,int j,int num,ArrayList<Integer> max){
//        ArrayList<Integer> step = new ArrayList<>();//记录上一步的位置
////判断是否找到了路
//        //判断该路是否为死路
//        if(map[i][j]==1||map[i][j]==2){
//            return;
//        }
//        if(map[6][5]==2){
//            //递归结束调节，迷宫终点为找过的可通过的路
//            //添加终点坐标
//            step.add(i);
//            step.add(j);
//
//            max.add(num);
//            return ;
//        }
//        else{
//            //判断路是否能走通：1、先假设该路能走通，再利用判断和递归寻找
//            //添加当前坐标
//            step.add(i);
//            step.add(j);
//            if(map[i][j]==0) {
//                map[i][j]=2;
//                //利用策略找上下左右
//                findway(map, i + 1, j,max);
//                findway(map, i , j+1,max);
//                findway(map, i-1, j,max);
//                findway(map, i , j-1,max);
//                map[i][j]=3;
//                //回溯
//                map[i][j]=0;
//                step.remove(step.size()-1);
//                step.remove(step.size()-1);
//            }
//            }
//        }
//    public static void main(String[] args) {
//        //迷宫的创建:使用二维数组；其中一表示障碍物，二表示空地
//        //初始化地图
//        int[][] map = new int[8][7];
//            for(int j=0;j<7;j++){
//                map[0][j]=1;
//                map[7][j]=1;
//            }
//        for (int i = 0; i < 8; i++) {
//            map[i][0]=1;
//            map[i][6]=1;
//        }
//        map[3][1]=1;
//        map[3][2]=1;
//        map[2][2]=1;//测试回溯
//        System.out.println("====地图====");
//            for(int i=0;i<8;i++){
//                System.out.println();
//                for (int j = 0; j < 7; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//        }
//        System.out.println();
//        /**
//         * 穷举法寻找最短路径：
//         *          1、创建一个集合来记录步数
//         *          2、寻找路径，（注意路径的回溯）
//         *          3、筛选最短路径
//         */
//        //1、设置一个集合，其中保存着每一条路线的步数
//        ArrayList<Integer> steps=new ArrayList<>();
//        //2、从1，位置开始寻找道路
//        Recurion03.findway(map, 5, 4,0,steps);
//        System.out.println("====地图寻找====：");
//        for(int i=0;i<8;i++){
//            System.out.println();
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//        }
//        System.out.println(steps);
//        //3、筛选最短路径
//        int size = Integer.MAX_VALUE;//首先设置一个无穷大的数
//        int index=0;
//
//
//    }
//}
