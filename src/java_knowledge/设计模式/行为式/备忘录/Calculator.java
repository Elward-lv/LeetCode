package java_knowledge.设计模式.行为式.备忘录;

/**
 * Originator Interface
 */
public interface Calculator {

    PreviousCalculationToCareTaker backupLastCalculation();

    // setMemento
    void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

    public abstract int getCalculationResult();

    public abstract void setFirstNum(int firstNum);

    public abstract void setSecondNum(int secondNum);
}
