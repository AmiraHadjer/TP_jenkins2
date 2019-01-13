import java.io.Serializable;

public abstract class Observer implements Serializable{
	protected Subject subject;
	public abstract void update();

}
