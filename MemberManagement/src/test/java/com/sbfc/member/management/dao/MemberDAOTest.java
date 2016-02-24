package com.sbfc.member.management.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import com.sbfc.member.management.model.Payment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfiguration.class)
@Transactional
public class MemberDAOTest {

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
		System.out.println("Input Address: " + addr);

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
		System.out.println("Input Address: " + addr);

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
		System.out.println("Input Address: " + addr2);

		List<Address> addrList = new ArrayList<Address>();
		addrList.add(addr);
		addrList.add(addr2);

		int[] updateCounts = memberDao.updateAddrList(addrList);

		System.out.println("Update row arrary >> " + Arrays.toString(updateCounts));
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

}
