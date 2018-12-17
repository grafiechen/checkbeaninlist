/*
 * Copyright (C) www.grafie.cn.
 */
package com.grafie.checkbeaninlist.util;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Grafie
 * @date 2018/12/17 18:19
 */
public class CheckBeanIfInListByValue {
	/**
	 * 在list中，根据实体的某个属性，获取值，
	 * 如果该list中某个实体的属性与o的属性值相同，
	 * 则返回list中的对应实体，否则则会返回null
	 * @param list 目标list
	 * @param o 进行匹配的某个bean
	 * @param value 对比的value
	 * @return Object
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static Object contains(List<? extends Object> list, Object o, String value) throws NoSuchFieldException,IllegalAccessException {
		Object returnObj = null;
		boolean flag = false;
		Field field = o.getClass().getDeclaredField(value);
		field.setAccessible(true);
		Object a = field.get(o);
		for (Object obj : list) {
			Field field2 = obj.getClass().getDeclaredField(value);
			field2.setAccessible(true);
			Object b = field2.get(obj);
			if (a instanceof String) {
				if (a.equals(b)) {
					returnObj = obj;
					break;
				}
			} else {
				if (a == b) {
					returnObj = obj;
					break;
				}
			}
		}
		return returnObj;
	}
}
