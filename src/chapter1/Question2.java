package chapter1;

/**
 * 实现 Singleton 模式
 */
public class Question2 {

    /**
     * 饿汉模式：在类加载的时候，就将对象初始化了，可以避免多线程问题。
     */
    private static Question2 mInstance1 = new Question2();
    public static Question2 getInstance1() {
        return mInstance1;
    }

    /**
     * 懒汉模式：在第一使用的时候，进行对象初始化。
     * 此方法存在多线程问题，需要避免在多线程环境中使用
     */
    private static Question2 mInstance2;
    public static Question2 getInstance2() {
        if(mInstance2 == null) {
            mInstance2 = new Question2();
        }

        return mInstance2;
    }

    /**
     * 线程安全的懒汉模式
     * double-check，使用 volatile 关键字 & 使用 synchronized 锁住当前的 class
     * 当然，也可以直接在 getInstance3  方法前面加上 synchronized 来达到线程安全的目的，但是效率会稍微掉一点
     * 使用 volatile 关键字的目的是防止指令重排
     * 在初始化对象时的基本顺序是：
     *  1. 分配内存空间
     *  2. 初始化对象
     *  3. 将对象指向刚分配的内存空间
     * 但是有些编译器为了性能的原因，可能会将第二步和第三步进行重排序，会导致在多线程的环境下生成不一样的对象。
     */
    private static volatile Question2 mInstance3;
    public static Question2 getInstance3() {
        if(mInstance3 == null) {
            synchronized (Question2.class) {
                if(mInstance3 == null) {
                    mInstance3 = new Question2();
                }
            }
        }
        return mInstance3;
    }

    /**
     * 线程模式的懒汉模式
     * 利用累加载的特征，实现线程安全的单利
     */
    private static class InnerClass {
        private final static Question2 INSTANCE_4 = new Question2();
    }
    public static Question2 getINstance4() {
        return InnerClass.INSTANCE_4;
    }


}
