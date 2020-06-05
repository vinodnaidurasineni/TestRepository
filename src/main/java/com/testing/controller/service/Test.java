package com.testing.controller.service;

import org.json.JSONArray;
import org.json.JSONException;

public class Test {
	public static void main(String[] args) throws JSONException {
		String test="[{\"a\":\"b\"},{\"a\":\"b\"}]";
		JSONArray arr=new JSONArray(test);
		System.err.println(arr);
	}
	
}
