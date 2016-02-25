package com.sbfc.member.management.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbfc.member.management.common.Common;
import com.sbfc.member.management.configuration.DatabaseConfiguration;
import com.sbfc.member.management.model.Address;
import com.sbfc.member.management.model.GlobalConstant;
import com.sbfc.member.management.model.Member;
import com.sbfc.member.management.model.Payment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfiguration.class)
@Transactional
public class MemberDaoTest {

	@Autowired
	private IMemberDao memberDao;

	@Test
	public void testRetrieveAllConstants() {
		List<GlobalConstant> constantList = memberDao.retrieveAllConstants();
		assertNotNull("constantObj is NULL", constantList);
		assertFalse("constantList is EMPTY", constantList.isEmpty());

		Common.loadConstants(constantList);
	}

	@Test
	public void testAddAddress() {
		Address addr = new Address();

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		addr.setMemberId("A1");

		addr.setAddressTypeId((short) 200);
		addr.setAddressLine1("addressLine1");
		addr.setAddressLine2("addressLine2");
		addr.setCountry("country");
		addr.setPostalCode("postal");
		// addr.setIsMailingAddress((byte) 100);
		addr.setIsMailingAddress((byte) -100);
		System.out.println("Input Address: " + addr);

		int row = memberDao.addAddress(addr);

		System.out.println("Inserted row >> " + row);
		assertTrue("No ADDRESS Insertion happened", row > 0);
	}

	@Test
	public void testUpdateAddress() {
		Address addr = new Address();

		/*
		 * An address record with addressId=8 should already be available in
		 * "address" table.
		 */
		addr.setAddressId(8);

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		addr.setMemberId("A1");

		addr.setAddressTypeId((short) 201);
		addr.setAddressLine1("addressLine1_UP");
		addr.setAddressLine2("addressLine2_UP");
		addr.setCountry("country_UP");
		addr.setPostalCode("post_UP");
		addr.setIsMailingAddress((byte) 100);
		// addr.setIsMailingAddress((byte) -100);
		System.out.println("Address to be updated:\n " + addr);

		int row = memberDao.updateAddress(addr);

		System.out.println("Update row >> " + row);
		assertTrue("No ADDRESS Update happened", row > 0);
	}

	@Test
	public void testUpdateAddrList() {
		Address addr = new Address();

		/*
		 * An address record with addressId=8 should already be available in
		 * "address" table.
		 */
		addr.setAddressId(8);

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		addr.setMemberId("A1");

		addr.setAddressTypeId((short) 200);
		addr.setAddressLine1("addressLine1");
		addr.setAddressLine2("addressLine2");
		addr.setCountry("country");
		addr.setPostalCode("post");
		addr.setIsMailingAddress((byte) 100);
		// addr.setIsMailingAddress((byte) -100);
		System.out.println("Input Address 1: " + addr);

		Address addr2 = new Address();

		/*
		 * An address record with addressId=9 should already be available in
		 * "address" table.
		 */
		addr2.setAddressId(9);

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		addr2.setMemberId("A1");

		addr2.setAddressTypeId((short) 201);
		addr2.setAddressLine1("addressLine1_**");
		addr2.setAddressLine2("addressLine2_**");
		addr2.setCountry("country_**");
		addr2.setPostalCode("post_UP");
		// addr2.setIsMailingAddress((byte) 100);
		addr2.setIsMailingAddress((byte) -100);
		System.out.println("Input Address 2: " + addr2);

		List<Address> addrList = new ArrayList<Address>();
		addrList.add(addr);
		addrList.add(addr2);

		int[] updateCounts = memberDao.updateAddrList(addrList);

		assertNotNull("No ADDRESS List Update happened", updateCounts);
		assertTrue("No ADDRESS#1 Update happened", updateCounts[0] > 0);
		assertTrue("No ADDRESS#2 Update happened", updateCounts[1] > 0);
	}

	@Test
	public void testGetAddresses() {
		List<Address> addrList = memberDao.getAddresses("A1");
		assertNotNull("No ADDRESS List returned", addrList);
		assertFalse("Address List is EMPTY", addrList.isEmpty());
	}

	@Test
	public void testAddPayment() {
		Date dueDate = null;
		Date paidDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dueDate = sdf.parse("25/10/2016");
			paidDate = sdf.parse("22/11/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		Payment payment = new Payment();

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		payment.setMemberId("A1");

		payment.setAccountingRefVoucher("accountingRefVoucher");
		payment.setChequeNumber("chequeNumber");
		payment.setDueAmount((float) 9999.99);
		payment.setDueDate(dueDate);
		payment.setPaidAmount((float) 8888.76);
		payment.setPaidDate(paidDate);
		payment.setPaymentMode("paymntMd");
		payment.setReceiptNumber("receiptNumber");

		System.out.println("Input Payment: " + payment);

		int row = memberDao.addPayment(payment);

		System.out.println("Inserted row >> " + row);
		assertTrue("No Paymenet Insertion happened", row > 0);
	}

	@Test
	public void testUpdatePayment() {
		Date dueDate = null;
		Date paidDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dueDate = sdf.parse("25/10/2222");
			paidDate = sdf.parse("22/11/2333");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		Payment payment = new Payment();

		/*
		 * An payment record with paymentId=1 should already be available in
		 * "payment" table.
		 */
		payment.setPaymentId(1);

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		payment.setMemberId("A1");

		payment.setAccountingRefVoucher("***untingRefVoucher");
		payment.setChequeNumber("***queNumber");
		payment.setDueAmount((float) 111.99);
		payment.setDueDate(dueDate);
		payment.setPaidAmount((float) 55.76);
		payment.setPaidDate(paidDate);
		payment.setPaymentMode("***Mode");
		payment.setReceiptNumber("***receiptNo");

		System.out.println("Payment to be updated: " + payment);

		int row = memberDao.updatePayment(payment);

		System.out.println("Updated payment row >> " + row);
		assertTrue("No Paymenet update happened", row > 0);
	}

	@Test
	public void testUpdatePaymentList() {
		Date dueDate = null;
		Date paidDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dueDate = sdf.parse("25/10/3222");
			paidDate = sdf.parse("22/11/4333");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		Payment payment = new Payment();

		/*
		 * An payment record with paymentId=2 should already be available in
		 * "payment" table.
		 */
		payment.setPaymentId(2);

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		payment.setMemberId("A1");

		payment.setAccountingRefVoucher("##untingRefVoucher");
		payment.setChequeNumber("##queNumber");
		payment.setDueAmount((float) 353.99);
		payment.setDueDate(dueDate);
		payment.setPaidAmount((float) 656.76);
		payment.setPaidDate(paidDate);
		payment.setPaymentMode("##Mode");
		payment.setReceiptNumber("##receiptNo");

		System.out.println("Input Payment 1: " + payment);

		try {
			dueDate = sdf.parse("25/10/8888");
			paidDate = sdf.parse("22/11/8899");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		Payment payment2 = new Payment();

		/*
		 * An payment record with paymentId=3 should already be available in
		 * "payment" table.
		 */
		payment2.setPaymentId(3);

		/*
		 * A member record with memberId="A1" should already be available in
		 * "member" table.
		 */
		payment2.setMemberId("A1");

		payment2.setAccountingRefVoucher("@@untingRefVoucher");
		payment2.setChequeNumber("@@queNumber");
		payment2.setDueAmount((float) 910103.99);
		payment2.setDueDate(dueDate);
		payment2.setPaidAmount((float) 6060.76);
		payment2.setPaidDate(paidDate);
		payment2.setPaymentMode("@@Mode");
		payment2.setReceiptNumber("@@receiptNo");

		System.out.println("Input Payment 2: " + payment2);

		List<Payment> paymentList = new ArrayList<Payment>();
		paymentList.add(payment);
		paymentList.add(payment2);

		int[] updateCounts = memberDao.updatePaymentList(paymentList);

		assertNotNull("No PAYMENT List Update happened", updateCounts);
		assertTrue("No PAYMENT#1 Update happened", updateCounts[0] > 0);
		assertTrue("No PAYMENT#2 Update happened", updateCounts[1] > 0);
	}

	@Test
	public void testGetPayments() {
		List<Payment> paymentList = memberDao.getPayments("A1");
		assertNotNull("No PAYMENT List returned", paymentList);
		assertFalse("Payment List is EMPTY", paymentList.isEmpty());

		Member mem = new Member();
		System.out.println(mem);
	}

	@Test
	public void testAddMember() {
		Date birthDate = null;
		Date joinDate = null;
		Date leftDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			birthDate = sdf.parse("25/10/1952");
			joinDate = sdf.parse("5/8/1992");
			leftDate = sdf.parse("19/4/2002");
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		Member mem = generateMemberFromXML("src/test/java/com/sbfc/member/management/dao/member01.xml");
		mem.setDateOfBirth(birthDate);
		mem.setDateJoin(joinDate);
		mem.setDateLeft(leftDate);

		System.out.println("Member to be inserted:\n" + mem);

		int row = memberDao.addMember(mem);

		System.out.println("Inserted Member row >> " + row);
		assertTrue("No MEMBER Insertion happened", row > 0);
	}

	/**
	 * To generate MEMBER object based on the input XML file.
	 * 
	 * @param fileName
	 * @return {@link Member}
	 */
	private static Member generateMemberFromXML(String fileName) {
		System.out.println("File Name: " + fileName);
		try {
			JAXBContext context = JAXBContext.newInstance(Member.class);
			Unmarshaller un = context.createUnmarshaller();
			Member mem = (Member) un.unmarshal(new File(fileName));
			System.out.println("Generated Member:\n" + mem);
			return mem;
		} catch (JAXBException e) {
			e.printStackTrace();
			Assert.fail("Error in generated member object using " + fileName);
		}
		return null;
	}

	@Test
	public void testUpdateMember() {
		Date birthDate = null;
		Date joinDate = null;
		Date leftDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			birthDate = sdf.parse("25/10/1952");
			joinDate = sdf.parse("5/8/1992");
			leftDate = sdf.parse("19/4/2002");
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		Member mem = generateMemberFromXML("src/test/java/com/sbfc/member/management/dao/member02.xml");
		mem.setDateOfBirth(birthDate);
		mem.setDateJoin(joinDate);
		mem.setDateLeft(leftDate);
		mem.setNameChinese("MaheName in Chinese");

		System.out.println("Member to be updated:\n" + mem);

		int row = memberDao.updateMember(mem);

		System.out.println("Updated Member row >> " + row);
		assertTrue("No MEMBER Update happened", row > 0);
	}

}
