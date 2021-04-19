package com.icf.employee.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

public class StringToLocalDateConverter implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceFieldValue == null)
			return null;
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
			if(sourceFieldValue instanceof String) {
				String sourcedate = (String) sourceFieldValue;
				return LocalDate.parse(sourcedate,formatter);
				}
			else if(sourceFieldValue instanceof LocalDate) {
				LocalDate sourceDate = (LocalDate) sourceFieldValue;
				return sourceDate.toString();
			}
			
		throw new MappingException("wrong mapping");
		
		}
	}


