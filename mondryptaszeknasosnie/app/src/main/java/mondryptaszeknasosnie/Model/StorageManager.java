package Model;

public interface StorageManager<TYPE, PRIMARY_KEY> {

	/**
	 * 
	 * @param element
	 */
	abstract boolean insert(TYPE element);

	/**
	 * 
	 * @param key
	 */
	abstract boolean delete(PRIMARY_KEY key);

	/**
	 * 
	 * @param key
	 * @param obj
	 */
	abstract boolean update(PRIMARY_KEY key, TYPE obj);

}