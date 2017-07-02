package algorithm.common;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;

public class ExprInterpreter {

	public static void main(String[] args) {
		
		simpleExpr();
		configExpr();
	}
	
	public static void simpleExpr(){
		FelEngine fel = new FelEngineImpl();    
		Object result = fel.eval("5000*12+7500");    
		System.out.println(result);  
	}
	
	
	public static void configExpr(){
		FelEngine fel = new FelEngineImpl(); 
		FelContext ctx = fel.getContext();    
		ctx.set("单价", 5000);    
		ctx.set("数量", 12);    
		ctx.set("运费", 7500);    
		Object result = fel.eval("单价*数量+运费");    
		System.out.println(result);  
	}
}
