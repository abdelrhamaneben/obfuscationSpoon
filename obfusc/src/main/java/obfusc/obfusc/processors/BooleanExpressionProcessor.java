package obfusc.obfusc.processors;

import obfusc.obfusc.utils.factotyReference;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.support.reflect.code.CtExpressionImpl;

public class BooleanExpressionProcessor extends AbstractProcessor<CtStatement>{

	private factotyReference fn;
	
	public BooleanExpressionProcessor (factotyReference fn) {
		this.fn = fn;
	}
	
	public void process(CtStatement element) {
		System.out.println("__________________________________________________ STATEMENT __________________________________________________");
		System.out.println(element.getParent().getSignature());
		System.out.println("-------------------------");
		/*CtExpression<Boolean> condition = element.getCondition();
		CtExpression<Boolean> newCondition = getFactory().Code().createCodeSnippetExpression(condition.toString()+" && true");
		System.out.println("-------------------------");
		System.out.println(newCondition);
		element.setCondition(newCondition);*/
		System.out.println("-------------------------");
		System.out.println(element);
	}

}
