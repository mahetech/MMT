package com.sbfc.member.management.common;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.sbfc.member.management.model.GlobalConstant;

public final class Common {

	private static Map<Class<?>, Marshaller> marshallerMap = new HashMap<Class<?>, Marshaller>();

	private static Map<Enum, HashMap<Integer, GlobalConstant>> constantMap = new HashMap<Enum, HashMap<Integer, GlobalConstant>>();

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

	public static void loadConstants() {
		// TODO
	}

}
