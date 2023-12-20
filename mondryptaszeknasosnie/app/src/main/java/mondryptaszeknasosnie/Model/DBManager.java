package Model;

public abstract class DBManager<TYPE, PRIMARY_KEY> implements StorageManager {

	protected String login;
	protected String password;
	protected String db;
	protected String server;

	/**
	 * 
	 * @param key
	 */
	public abstract boolean delete(PRIMARY_KEY key);

	/**
	 * 
	 * @param element
	 */
	public abstract boolean insert(TYPE element);

	/**
	 * 
	 * @param key
	 * @param obj
	 */
	public abstract boolean update(PRIMARY_KEY key, TYPE obj);

	public abstract List<TYPE> select();

}