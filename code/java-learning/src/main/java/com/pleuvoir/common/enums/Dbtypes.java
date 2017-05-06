package com.pleuvoir.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>@author: pleuvoir</p>
 * <p>@date: 2017年5月7日 上午12:47:16</p>
 * <p>@Description: 数据库类型枚举</p>
 */
public enum Dbtypes {

	ORACLE,
	
	MYSQL;
	
	/**
	 * 返回枚举类型 忽略大小写 剔除空格
	 * @param dbType
	 * @return
	 */
	public static Dbtypes toEnum(String dbType){
		return Dbtypes.valueOf(StringUtils.upperCase(StringUtils.trim(dbType)));
	}
	
}
