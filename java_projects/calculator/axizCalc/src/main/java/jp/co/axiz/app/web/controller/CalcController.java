package jp.co.axiz.app.web.controller;

import java.math.BigDecimal;
import java.util.Locale;

import jp.co.axiz.app.web.form.CalcForm;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class CalcController {
	private static final Log LOG = LogFactory.getLog(CalcController.class);
	
	@Autowired
	private Validator calcFormValidator;
	
	@Autowired
	private MessageSource messageSource;
		
	@ModelAttribute("calcForm")
	public CalcForm calcForm() { 
		return new CalcForm();
	}
	
	@RequestMapping(value = {"/", "/calc"}, method = RequestMethod.GET)
	public String showCalc() { 
		return "calc";
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public ModelAndView calc(CalcForm calcForm, BindingResult bindingResult) {
		
		Locale locale = LocaleContextHolder.getLocale();
		String l = locale.toString();
		
		calcFormValidator.validate(calcForm, bindingResult);
		final ModelAndView modelAndView = new ModelAndView();
		String calcFail = messageSource.getMessage("calc.fail", null, locale);
		String calcSuccess = messageSource.getMessage("calc.success", null, locale);
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("calc");
			//System.out.println(l);
			modelAndView.addObject("resultMsg", calcFail);
			return modelAndView;
		}
		
		double x = 0;
		double y = 0;
		double z = 0;
		String o = calcForm.getO();
		String oFormat = "+*-/%";
		boolean oFormatError = !oFormat.contains(o);
		boolean leftFormatError = false;
		boolean rightFormatError = false;
		boolean divideByZero = false;
		int maxDigits = 12;
		
		try{
			x = Double.parseDouble(calcForm.getLeft());
		}catch(NumberFormatException e){
			leftFormatError = true;
		}
		try{
			y = Double.parseDouble(calcForm.getRight());
			String oDivide = "/%";
			if (oDivide.contains(o) && (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(y)) == 0)){
				divideByZero = true;
			}
		}catch(NumberFormatException e){
			rightFormatError = true;
		}
		
		if (StringUtils.hasLength(calcForm.getLeft()) && 
				StringUtils.hasLength(calcForm.getRight()) &&
				calcForm.getLeft().length() <= maxDigits &&
				calcForm.getRight().length() <= maxDigits &&
				!leftFormatError &&
				!rightFormatError &&
				!oFormatError &&
				!divideByZero)
				 {
			//System.out.println(l);
			
			switch (o){
			case "+": z = x + y;
				break;
			case "*": z = x * y;
				break;
			case "-": z = x - y;
				break;
			case "/": if (y != 0) {
					z = x / y;
				} else {
					System.out.println("For some odd reason our fallback caught the divideByZero error.");
				}
				break;
			case "%": if (y != 0) {
					z = x % y;	
				} else {
					System.out.println("For some odd reason our fallback caught the remainderByZero error.");
				}
				break;
			default: z = x + y;
			}			
			modelAndView.addObject("resultMsg", calcSuccess + " = " + z);
			modelAndView.setViewName("calc_result");
		} else {
		modelAndView.addObject("resultMsg", calcFail);
		modelAndView.addObject("calcForm", calcForm);
		modelAndView.setViewName("calc");
		}
		return modelAndView;
	}
}
