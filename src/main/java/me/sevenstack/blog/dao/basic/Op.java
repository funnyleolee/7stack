package me.sevenstack.blog.dao.basic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Op<T> {
	private Class<T> entityClass;

	/**
	 *      * 这个通常也是hibernate的取得子类class的方法      *      * @author "yangk"      * @date
	 * 2010-4-11 下午01:51:28      
	 */
	public Op() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
		// entityClass  = Class<T> entityClass = (Class<T>) ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public T get(String id) {
		try {
			return entityClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
