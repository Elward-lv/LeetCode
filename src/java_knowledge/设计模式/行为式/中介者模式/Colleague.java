package java_knowledge.设计模式.行为式.中介者模式;

/**
 * 同事--用来指具有一定关系得事物
 */
public abstract class Colleague {
    public abstract void onEvent(Mediator mediator);
}
