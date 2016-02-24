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

	private static Map<Short, String> addressTypeMap = new HashMap<Short, String>();
	private static Map<Short, String> dialectMap = new HashMap<Short, String>();
	private static Map<Short, String> identityTypeMap = new HashMap<Short, String>();
	private static Map<Short, String> leavingReasonMap = new HashMap<Short, String>();
	private static Map<Short, String> memberTypeMap = new HashMap<Short, String>();
	private static Map<Short, String> nationalityMap = new HashMap<Short, String>();
	private static Map<Short, String> religionMap = new HashMap<Short, String>();

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

	/**
	 * @return the addressTypeMap
	 */
	public static Map<Short, String> getAddressTypeMap() {
		return addressTypeMap;
	}

	/**
	 * @return the dialectMap
	 */
	public static Map<Short, String> getDialectMap() {
		return dialectMap;
	}

	/**
	 * @return the identityTypeMap
	 */
	public static Map<Short, String> getIdentityTypeMap() {
		return identityTypeMap;
	}

	/**
	 * @return the leavingReasonMap
	 */
	public static Map<Short, String> getLeavingReasonMap() {
		return leavingReasonMap;
	}

	/**
	 * @return the memberTypeMap
	 */
	public static Map<Short, String> getMemberTypeMap() {
		return memberTypeMap;
	}

	/**
	 * @return the nationalityMap
	 */
	public static Map<Short, String> getNationalityMap() {
		return nationalityMap;
	}

	/**
	 * @return the religionMap
	 */
	public static Map<Short, String> getReligionMap() {
		return religionMap;
	}

	public static void loadConstants(List<GlobalConstant> constList) {
		if (constList != null) {
			constList.forEach(constObj -> {
				String type = constObj.getConstantType();

				if ("ADDRESS_TYPE".equalsIgnoreCase(type)) {
					addressTypeMap.put(constObj.getConstantId(), constObj.getConstantName());
				} else if ("DIALECT".equalsIgnoreCase(type)) {
					dialectMap.put(constObj.getConstantId(), constObj.getConstantName());
				} else if ("IDENTITY_TYPE".equalsIgnoreCase(type)) {
					identityTypeMap.put(constObj.getConstantId(), constObj.getConstantName());
				} else if ("LEAVING_REASON".equalsIgnoreCase(type)) {
					leavingReasonMap.put(constObj.getConstantId(), constObj.getConstantName());
				} else if ("MEMBER_TYPE".equalsIgnoreCase(type)) {
					memberTypeMap.put(constObj.getConstantId(), constObj.getConstantName());
				} else if ("NATIONALITY".equalsIgnoreCase(type)) {
					nationalityMap.put(constObj.getConstantId(), constObj.getConstantName());
				} else if ("RELIGION".equalsIgnoreCase(type)) {
					religionMap.put(constObj.getConstantId(), constObj.getConstantName());
				}
			});
		}
		System.out.println("ADDRESS_TYPE Map >> " + getAddressTypeMap());
		System.out.println("DIALECT Map >> " + getDialectMap());
		System.out.println("IDENTITY_TYPE Map >> " + getIdentityTypeMap());
		System.out.println("LEAVING_REASON Map >> " + getLeavingReasonMap());
		System.out.println("MEMBER_TYPE Map >> " + getMemberTypeMap());
		System.out.println("NATIONALITY Map >> " + getNationalityMap());
		System.out.println("RELIGION Map >> " + getReligionMap());
	}
	
}
