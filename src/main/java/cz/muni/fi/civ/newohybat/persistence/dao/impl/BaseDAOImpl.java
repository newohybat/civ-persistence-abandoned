package cz.muni.fi.civ.newohybat.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.BaseDAO;

public abstract class BaseDAOImpl<T> implements BaseDAO<T>
{   
	@PersistenceContext(unitName = "CivBackend")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager entityManager) {
        em = entityManager;
    }
          
    private Class<T> persistentClass = figureOutPersistentClass();
    
    private Class<T> figureOutPersistentClass() 
    {
        Class<T> result = (Class<T>)((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        return result;
    }
    
    private void persistObject(T object)
    {
        em.persist(object);
    }
    
    private void removeObject(T object)
    {
        em.remove(em.merge(object));
    }
    
    private void mergeObject(T object)
    {
        em.merge(object);
    }
    private boolean containsObject(T object)
    {
    	return em.contains(object);
    }
    
    protected void persist(T object)
    {
        persistObject(object);
    }
    
    protected void remove(T object)
    {
        removeObject(object);
    }
    
    protected void merge(T object)
    {
        mergeObject(object);
    }
    protected boolean contains(T object)
    {
    	return containsObject(object);
    }
    
    /**
     * Abstract method isValid checks whether given object is valid i.e. includes
     * all required attributes.
     * @param object instance of T to be validated
     * @return true if  is valid, false otherwise
     */
    abstract protected boolean isValid(T object);
    
    public void create(T object) 
    {
    	if(isValid(object)) {
            persist(object);
            
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void update(T object) 
    {
        if(isValid(object) && contains(object)) {
            merge(object);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void delete(T object) 
    {
        if(contains(object)) {
            remove(object);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public T getById(Long id) 
    {
        return em.find(persistentClass, id);
    }

    public List<T> getAll() 
    {
        Query q = em.createQuery("SELECT o FROM " + 
                persistentClass.getSimpleName() + " o");
//        System.out.println(q.getResultList());
        return (List<T>) q.getResultList();
    }
    
    
}