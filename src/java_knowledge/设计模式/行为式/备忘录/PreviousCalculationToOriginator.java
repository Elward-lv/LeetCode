package java_knowledge.设计模式.行为式.备忘录;
/**
 * Memento Interface to Originator
 *
 * This interface allows the originator to restore its state
 */
public interface PreviousCalculationToOriginator {
    int getFirstNumber();

    int getSecondNumber();
}
