package java_knowledge.设计模式.创建式.单例模式.枚举;

/**
 * 枚举实现单例模式
 */
public enum Singleton {
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        singleton1.setObjName("s1");
        System.out.println(singleton1.getObjName());

        Singleton singleton2 = Singleton.INSTANCE;
        singleton2.setObjName("s2");
        System.out.println(singleton1.getObjName());
        System.out.println(singleton2.getObjName());

        // 反射获取实例测试
        try {
            Singleton[] enumConstants = Singleton.class.getEnumConstants();
            for (Singleton enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
