package algorithm.common;

import java.util.Stack;

/**
 * 
 * @date 2017年7月1日
 */
public class FormulaImpl {
	
	
	/**
	 * 参考《算法》第四版（只能处理个位数
	 * 使用栈处理公式解释
	 * @param formula
	 * @return
	 */
	public static double simpleCalculate(String formula){
		Stack<Character> ops = new Stack<Character>();
		Stack<Double> vals = new Stack<Double>();
		char[] formulaChar = formula.toCharArray();
		for(Character charUnit:formulaChar){
			if(charUnit.equals('(')){}
			else if(charUnit.equals('+') || charUnit.equals('-') ||
					charUnit.equals('*') || charUnit.equals('/') ){ 
				ops.push(charUnit); 
			}
			else if(charUnit.equals(')') ){
				Character op = ops.pop();
				Double v = vals.pop();
				if(op.equals('+') ){
					v = vals.pop() + v;
				}
				else if(op.equals('-') ){
					v = vals.pop() - v;	
								}
				else if(op.equals('*') ){
					v = vals.pop() * v;
				}
				else if(op.equals('/') ){
					v = vals.pop() / v;
				}
				vals.push(v);
			}else{
				vals.push(Double.parseDouble(charUnit.toString()));
			}
		}
		return vals.pop();
	} 
	
	public static void main(String[] args) {
		//String s = "?";
		String formula = "(1+3-(3*2))";
		double result = simpleCalculate(formula);
		System.out.println(result);
	}
}
