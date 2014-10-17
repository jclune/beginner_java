package jp.co.axiz.app.web.form.validator;

import java.math.BigDecimal;

import jp.co.axiz.app.web.form.CalcForm;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CalcFormValidator implements Validator{
	
	private MessageSourceAccessor messages;
	
	public void setMessages(MessageSource messages) {
		this.messages = new MessageSourceAccessor(messages);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CalcForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		final CalcForm calcForm = (CalcForm) obj;
		
		String o = calcForm.getO();
		String oFormat = "+*-/%";
		int maxDigits = 12;
		
		if (!oFormat.contains(o)){
			final String[] bindArgs = { messages.getMessage("o") };
			errors.rejectValue("o", "errors.required", bindArgs, "");
		}
		
		if (!StringUtils.hasLength(calcForm.getLeft())) {
			final String[] bindArgs = { messages.getMessage("left") };
			errors.rejectValue("left", "errors.required", bindArgs, "");
		}else{
			if (calcForm.getLeft().length() > maxDigits){
				final String[] bindArgs = { messages.getMessage("left") };
				errors.rejectValue("right", "errors.length", bindArgs, "");
			}else{
				try{
					Double.parseDouble(calcForm.getLeft());
				}catch(NumberFormatException e){
					final String[] bindArgs = { messages.getMessage("left") };
					errors.rejectValue("left", "errors.format", bindArgs, "");
				}
			}
		}
		
		if (!StringUtils.hasLength(calcForm.getRight())) {
			final String[] bindArgs = { messages.getMessage("right") };
			errors.rejectValue("right", "errors.required", bindArgs, "");
		}else{
			if (calcForm.getRight().length() > maxDigits){
				final String[] bindArgs = { messages.getMessage("right") };
				errors.rejectValue("right", "errors.length", bindArgs, "");
			}else{
				try{
					double y = Double.parseDouble(calcForm.getRight());
					String oDivide = "/%";
					if (oDivide.contains(o) && (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(y)) == 0)){
						final String[] bindArgs = { messages.getMessage("right") };
						errors.rejectValue("right", "errors.divideByZero", bindArgs, "");
					}
				}catch(NumberFormatException e){
					final String[] bindArgs = { messages.getMessage("right") };
					errors.rejectValue("right", "errors.format", bindArgs, "");
				}
			}
		}
		
		if (errors.hasFieldErrors()) {
			//System.out.println("form has field error(s)");
		}
			
	}

}
