package java_knowledge.设计模式.行为式.备忘录;
/**
 * Memento Object Implementation
 * <p>
 * Note that this object implements both interfaces to Originator and CareTaker
 */
public class PreviousCalculationImp implements PreviousCalculationToCareTaker ,PreviousCalculationToOriginator{

    private int firstNumber;
    private int secondNumber;

    public PreviousCalculationImp(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getFirstNumber() {
        return this.firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return this.secondNumber;
    }
}
