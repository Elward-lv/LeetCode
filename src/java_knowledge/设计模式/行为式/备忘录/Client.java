package java_knowledge.设计模式.行为式.备忘录;

/**
 * 备忘录的实现
 * 计算类有个顶层接口,计算类有个方法生成备忘录，即根据计算的两个数字生成备忘录；另外一个回滚方法，通过把备忘录之中的数字拷贝出来实现回滚
 * PreviousCalculationToOriginator 为上次运算数据，即备忘录实现
 * PreviousCalculationToCareTaker 为保存备忘录的Caretaker
 * PreviousCalculationImp 同时实现以上两个接口
 */
public class Client {
    public static void main(String[] args) {
        // program starts
        Calculator calculator = new CalculatorImpl();

        // assume user enters two numbers
        calculator.setFirstNum(10);
        calculator.setSecondNum(100);

        // find result
        System.out.println(calculator.getCalculationResult());

        // Store result of this calculation in case of error
        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();

        // user enters a number
        calculator.setFirstNum(17);

        // user enters a wrong second number and calculates result
        calculator.setSecondNum(-290);

        // calculate result
        System.out.println(calculator.getCalculationResult());

        // user hits CTRL + Z to undo last operation and see last result
        calculator.restorePreviousCalculation(memento);

        // result restored
        System.out.println(calculator.getCalculationResult());
    }
}
