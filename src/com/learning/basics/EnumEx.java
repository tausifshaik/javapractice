package com.learning.basics;
/*
 * Java Enum was introduced in Java 1.5 as a new type whose fields consists of fixed set of constants.
 *  For example, we can create directions as Java Enum with fixed fields as EAST, WEST, NORTH and SOUTH.
 */

import java.util.ArrayList;
import java.util.List;

/*
 * Java enum keyword is used to create an enum type.
 * 
 * All java enum implicitly extends java.lang.Enum class that extends Object class and implements Serializable and Comparable interfaces. So we can’t extend any class in enum.
	Since enum is a keyword, we can’t end package name with it, for example com.journaldev.enum is not a valid package name.
	Enum constructors are always private.
	We can’t create instance of enum using new operator.
	We can declare abstract methods in java enum, then all the enum fields must implement the abstract method. In above example getDetail() is the abstract method and all the enum fields have implemented it.
	We can define a method in enum and enum fields can override them too. For example, toString() method is defined in enum and enum field START has overridden it.
	Java enum fields has namespace, we can use enum field only with class name like ThreadStates.START
	Enums can be used in switch statement, we will see it in action in the later part of this tutorial.
	We can extend existing enum without breaking any existing functionality. For example, we can add a new field NEW in ThreadStates enum without impacting any existing functionality.
	Since enum fields are constants, java best practice is to write them in block letters and underscore for spaces. For example EAST, WEST, EAST_DIRECTION etc.
	Enum constants are implicitly static and final
	Enum constants are final but it’s variable can still be changed. For example, we can use setPriority() method to change the priority of enum constants. We will see it in usage in below example.
	Since enum constants are final, we can safely compare them using “==” and equals() methods. Both will have the same result.
 * 
 */
	
public enum EnumEx {
	CREATE_ACCOUNT("CH1208", 1, "CreateAccount"),
	MANAGE_LOCK_ACCOUNT("CH1208", 2,	"ManageLockAccount - Lock"),
	UPDATE_POLICY_STATUS("CH1208", 3,	"UpdatePolicyStatus -  Active"),
	MANAGE_LOCK_ACCOUNT_UNLCK("CH1208", 41,	"ManageLockAccount - Unlock"),
	UPDATE_POLICY_STATUS_CNL("CH1208", 42,	"UpdatePolicyStatus - Cancel"),
	CLOSE_ACCOUNT("CH1208", 4,	"CloseAccount"),
	MANAGE_TRUEUP("CH1208", 53,	"ManageTrueup"),
	GET_ACCOUNT_STATUS("CH1209", 5,	"GetAccountStatus"),
	SAVE_PAYMENT_CARD_ACTIVE("CH1211", 6,	"SavePaymentCard - Active"),
	CREATE_LEDGER_ACCOUNT("CH1110", 7,	"CreateLedgerAccount"),
	UPDATE_LEDGER_ACCOUNT("CH1110", 8,	"UpdateLedgerAccount"),
	ADD_LEDGER_ENTRY("CH1111", 9,	"AddLedgerEntry"),
	LOCK_LEDGER_TRANSACTION("CH1111", 10,	"LockLedgerTransaction"),
	GET_LEDGER_SUMMARY("CH1112", 11,	"GetLedgerSummary"),
	GET_lEDGER_DETAILS("CH1112", 12,	"GetLedgerDetails"),
	GET_PAYMENT_CARD_STATUS("CH1112", 13,	"GetPaymentCardStatus"),
	SEND_COMMUNICATION("CH1210", 14,	"SendCommunication"),
	MANAGE_PAYMENT_CARD("CH1212", 15,	"ManagePaymentCard"),
	GET_PAYMENT_CARD_INFO("CH1212", 16,	"GetPaymentCardInfo"),
	GET_CONFIGURATION("CH1109", 17,	"GetConfiguration"),
	GET_MEMBER_INFO("CH1109", 18,	"GetMemberInfo"),
	GET_AGENT_INFO("CH1109", 19,	"GetAgentInfo"),
	GET_CONTACT_INFO("CH1109", 64,	"GetContactInfo"),
	GET_TRIPS_ACTIVITY("CH1109", 20,	"GetTripsActivity"),
	GET_TRIP_DETAILS("CH1109", 21,	"GetTripDetails"),
	LEDGER_SUMMARY("CH1109", 22,	"GetLedgerSummary"),
	GET_EVENT_NOTIFICATION("CH1109", 23,	"GetEventNotification"),
	LEDGER_DETAILS("CH1109", 24,	"GetLedgerDetails"),
	GET_MULTIPLE_DOCUMENT_CONTENT("CH1218", 25,	"GetMultipleDocumentContent"),            
	MULTIPLE_DOCUMENT_ACK("CH1218", 26,	"ProvideMultipleDocumentAcknowledgement"),
	GET_DOC_ACK_STATUS("CH1218", 27,	"GetDocumentAcknowledgementStatus"),
	SAVE_PAYMENT_CARD_UPDATE("CH1211", 28,	"SavePaymentCard - Update"),
	SAVE_PAYMENT_CARD_DECLINE("CH1211", 29,	"SavePaymentCard- Decline"),

	// Reward Preference WS Operations
	GET_SPND_PREF("CH1231", 50, "GET Spending Preference"),
	PUT_SPND_PREF("CH1231", 47, "PUT Spending Preference"),
	DEL_SPND_PREF("CH1231", 48, "DELETE Spending Preference"),
	GET_APP_MGR("CH1232", 49, "GET Application Manager"),	
	GET_EVENTNOTIFICATION("CH1235", 51,	"GetEventNotification"),
	PUT_EVENTNOTIFICATION("CH1235", 52,	"PutEventNotification"),
	CREATE_NOTIFICATION("CH1235", 81,	"CreateNotification"),
	CLOSE_NOTIFICATION("CH1235", 85,	"CloseNotification"),
	GET_VEH_TRACKS("CH1241", 54, "GET Vehicle Tracks"),
	ACT_MGR_CACHE_REFRESH("CH1208", 56, "AccountManagerWS Cache Refresh"),
	GET_CONTENT_BY_UUID("CH1252", 62, "GET Content By UUID/Policy Number"),
	GET_CONTENT_BY_AUTHID("CH1252", 63, "GET Content By Auth ID/Member ID"),

	MANAGE_LOCK_ACCOUNT_UPD("CH1208", 71, "ManageLockAccount - Update"),
	RECALCULATE_PREMIUM("CH1265", 72, "RecalculatePremium"),
	GET_AGG_MILEAGE_PREMIUM("CH1209", 73, "GetAggregateMileagePremium"),
	GET_VARIABLE_PREMIUM_DETAILS("CH1209", 70,	"GetVariablePremiumDetails"),
	UPDATE_ACCOUNT("CH1208", 75, "UpdateAccount"),
	GET_EMAIL_STATUS("CH1270", 76, "GET EmailStatus"),
	
	GET_MEMBER("CH1271", 79, "GET MEMBER"),
	GET_UUID("CH1271", 78, "GET UUID"),
	PUT_EUA_INFO("CH1271", 77, "PUT EUA Info"),
	GET_EUA_INFO("CH1271", 80, "GET EUA Info"),
	CAT_NOTIFICATION_WS("CH1272",82,"PUT NotificationDetails"),
	;

	private String channelId;
	private long operationId;
	private String operationName;
	
	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @return the operationId
	 */
	public long getOperationId() {
		return operationId;
	}

	/**
	 * @return the operationName
	 */
	public String getOperationName() {
		return operationName;
	}

	private EnumEx(String channelId, int operationId, String operationName){
		this.channelId = channelId;
		this.operationId = operationId;
		this.operationName = operationName;
	}
	
	public static EnumEx getOperationByNameAndChannelId(String operationName, String channelId){
		if(StringUtils.isNotBlank(operationName) && StringUtils.isNotBlank(channelId)){
			for(EnumEx operation : values()){
				if(operation.getOperationName().equalsIgnoreCase(operationName)
						&& operation.getChannelId().equals(channelId)){
					return operation;
				}
			}
		}
		return null;
	}
	
	public static List<EnumEx> getOperationsByChannelId(String channelId){
		List<EnumEx> milewiseOperations = new ArrayList<EnumEx>();
		if(StringUtils.isNotBlank(channelId)){
			for(EnumEx operation : values()){
				if(operation.getChannelId().equalsIgnoreCase(channelId)){
					milewiseOperations.add(operation);
				}
			}
		}
		return milewiseOperations;
	}
}