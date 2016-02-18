package com.sbfc.member.management.common;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.sbfc.member.management.model.GlobalConstant;

public final class Common {

	private static Map<Class<?>, Marshaller> marshallerMap = new HashMap<Class<?>, Marshaller>();

	// private enum ConstantTypes {
	// ADDRESS_TYPE, DIALECT, IDENTITY_TYPE, LEAVING_REASON, MEMBER_TYPE,
	// NATIONALITY, RELIGION
	// }

	private static Map<String, HashMap<Short, GlobalConstant>> constantMap = new HashMap<String, HashMap<Short, GlobalConstant>>();

	public static Marshaller getMarshaller(Class<?> clazz) throws JAXBException {
		Marshaller jaxbMarshaller = null;
		if (marshallerMap != null && !marshallerMap.isEmpty()) {
			jaxbMarshaller = marshallerMap.get(clazz);
		}
		if (jaxbMarshaller == null) {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerMap.put(clazz, jaxbMarshaller);
		}

		return jaxbMarshaller;
	}

	public static String convertObjToXML(Object obj, Class<?> clazz) {
		String xmlString = null;
		try {
			Marshaller jaxbMarshaller = getMarshaller(clazz);
			if (jaxbMarshaller != null) {
				StringWriter sw = new StringWriter();
				jaxbMarshaller.marshal(obj, sw);
				xmlString = sw.toString();
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlString;
	}

	public static void loadConstants(List<GlobalConstant> constList) {
		if (constList != null) {
			constList.forEach(constObj -> {
				HashMap<Short, GlobalConstant> constMap = constantMap.getOrDefault(constObj.getConstantType(),
						(new HashMap<Short, GlobalConstant>()));
				System.out.println("Constant TEMP Map >> " + constMap);
				constMap.put(constObj.getConstantId(), constObj);
			});
		}
		System.out.println("Constant TEMP Map >> " + constantMap);
	}

}
