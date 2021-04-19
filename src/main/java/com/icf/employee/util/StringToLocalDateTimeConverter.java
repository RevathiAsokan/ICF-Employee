package com.icf.employee.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

public class StringToLocalDateTimeConverter implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceFieldValue == null)
			return null;
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
			if(sourceFieldValue instanceof String) {
				String sourcedate = (String) sourceFieldValue;
				return LocalDateTime.parse(sourcedate,formatter);
				}
			else if(sourceFieldValue instanceof LocalDateTime) {
				LocalDateTime sourceDate = (LocalDateTime) sourceFieldValue;
				return sourceDate.toString();
			}
			
		throw new MappingException("wrong mapping");
		
		}
	}


