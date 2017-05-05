package com.pleuvoir.common;

import com.alibaba.fastjson.JSON;

public interface Json {

	default void printJson(){
		System.out.println(JSON.toJSONString(this));
	}
	
	default String toJSON(){
		return JSON.toJSONString(this);
	}
}
