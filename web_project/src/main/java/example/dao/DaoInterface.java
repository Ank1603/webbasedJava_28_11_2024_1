package example.dao;

import java.util.Collection;

public interface DaoInterface <T,K>
//T =type and K=Key
{
//A method to retrieve all records
	Collection <T> retrieveAll();
	
	//A method to retrieve a single record
	
	T retrieveOne(K key);
	
	
	//A method to insert a new record
	//we used generic representation bec here our object is restaurant but when object changed 
	void create(T t);
	
	
	//A method to update an existing record
	void update(T t);
	
	//A method to delete an existing record
	void delete(K key);
}
