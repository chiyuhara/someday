package com.someday.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.someday.member.MemberModel;
import com.someday.history.ReviewModel;

public class ReviewValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ReviewModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// memberModel을 유효성검사하는 타겟으로 잡음
		ReviewModel review = (ReviewModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content");
	}
}