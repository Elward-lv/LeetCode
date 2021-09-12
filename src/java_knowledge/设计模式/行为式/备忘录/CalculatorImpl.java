package java_knowledge.设计模式.行为式.备忘录;

public class CalculatorImpl implements Calculator {
    private int firstNum ;
    private int secondNum ;

    @Override
    public PreviousCalculationToCareTaker backupLastCalculation() {
        return new PreviousCalculationImp(firstNum, secondNum);
    }

    @Override
    public void restorePreviousCalculation(PreviousCalculationToCareTaker memento) {
        firstNum = ((PreviousCalculationToOriginator) memento).getFirstNumber();
        secondNum = ((PreviousCalculationToOriginator) memento).getSecondNumber();
    }

    @Override
    public int getCalculationResult() {
        return firstNum + secondNum;
    }

    @Override
    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    @Override
    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }
}
