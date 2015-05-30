package studio9;
public interface List<Integer> {
	public void addFirst(Integer x);

	public void addLast(Integer x);

	public boolean remove(Integer x);

	public Integer get(Integer i) throws IndexOutOfBoundsException;

	public Integer size();

	public boolean isEmpty();
}
