package br.com.docket.cartorio.config.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DataTransfer {

	private ModelMapper modelMapper = new ModelMapper();

	public <T> T copyToClassTarget(Object object, Class<T> classTarget) {
		T obj = null;
		try {
			obj = classTarget.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		modelMapper.map(object, obj);
		return obj;
	}

	public <T> List<T> copyToClassTarget(List<?> object, Class<T> classTarget) {
		List<T> list = new ArrayList<>();
		object.forEach(data -> {
			list.add(copyToClassTarget(data, classTarget));
		});
		return list;
	}

	public void copyToObjectTarget(Object objectSource, Object objectTarget) {
		modelMapper.map(objectSource, objectTarget);
	}

}
