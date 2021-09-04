package com.example.demo.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


enum Action {
	ASSIGN, EXECUTE
}

public class CalypsoUploadDocument implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CalypsoEntity> CalypsoEntity;
	

	public List<CalypsoEntity> getCalypsoEntity() {
		return CalypsoEntity;
	}

	public void setCalypsoEntity(List<CalypsoEntity> calypsoEntity) {
		CalypsoEntity = calypsoEntity;
	}
	

}

class CalypsoEntity{
	List<String> ActionEnum;
	private String Action;
	private String EntityId;
	private Entity Entity;
	private AssignTransfer AssignTransfer;
	private Attributes Attributes;
	private Fields Fields;
	private String Comment;
	private String _type;
	
	
	public CalypsoEntity() {
		
		ActionEnum = new ArrayList<String>( );
		ActionEnum.add("ASSIGN");
		ActionEnum.add("EXECUTE");
		
	}
	
	
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		if (ActionEnum.contains(action))
			Action = action;
		else
			throw new Error("WRONG ACTION");
		
		
	}
	public String getEntityId() {
		return EntityId;
	}
	public void setEntityId(String entityId) {
		
		try{
			  if(Integer.parseInt(entityId)>=0) 
				  EntityId = entityId;
			  else
				  throw new Error("entityId should be Positive");  
			} 
		
	    catch (NumberFormatException e) {
			  throw new Error("entityId is not a number");
			}
		
	}
	public Entity getEntity() {
		return Entity;
	}
	public void setEntity(Entity entity) {
		Entity = entity;
	}
	public AssignTransfer getAssignTransfer() {
		return AssignTransfer;
	}
	public void setAssignTransfer(AssignTransfer assignTransfer) {
		AssignTransfer = assignTransfer;
	}
	public Attributes getAttributes() {
		return Attributes;
	}
	public void setAttributes(Attributes attributes) {
		Attributes = attributes;
	}
	public Fields getFields() {
		return Fields;
	}
	public void setFields(Fields fields) {
		Fields = fields;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	
	
	
	
}


class Entity{
	List<String> TransferEnum; 
	private String TransferType;
	private String SettlementDate;
	private String Currency;
	
	public Entity(){
		TransferEnum = new ArrayList<String>( );
		TransferEnum.add("NONE");
		TransferEnum.add("PRINCIPAL");
		TransferEnum.add("INTEREST");
	}
	
	public String getTransferType() {
		return TransferType;
	}
	public void setTransferType(String transferType) {
		if (TransferEnum.contains(transferType))
		    TransferType = transferType;
		else
			throw new Error("WRONG TRANSFER TYPE");
	}
	public String getSettlementDate() {
		return SettlementDate;
	}
	public void setSettlementDate(String settlementDate) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(settlementDate.trim());
            SettlementDate = settlementDate;
        } catch (Exception e) {
        	throw new Error("NOT A VALID DATE");
        }

		
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	
	
	
}

class AssignTransfer{
	private String PayerSDI;
	private String ReceiverSDI;
	private String PayerStatus;
	private String ReceiverStatus;
	private String NettingType;
	private String NettingGroup;
	private String DeliveryType;
	private String IsManualSDI;
	
	
	
	public String getPayerSDI() {
		return PayerSDI;
	}
	public void setPayerSDI(String payerSDI) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
        dateFormat.setLenient(false);
        String[] daterajarray = payerSDI.split("-", 2);
    	String dateraj = daterajarray.length > 1 ? daterajarray[1]: null;
        try {        	
        	if(dateraj != null) 
        		dateFormat.parse(dateraj.replace("T"," ").split("\\+")[0]);
        	PayerSDI = payerSDI;
        } catch (Exception e) {
           throw new Error("Payer SDI is not in a prioper date format");
        }

		
		
	}
	public String getReceiverSDI() {
		return ReceiverSDI;
	}
	public void setReceiverSDI(String receiverSDI) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
        dateFormat.setLenient(false);
        String[] daterajarray = receiverSDI.split("-", 2);
    	String dateraj = daterajarray.length > 1 ? daterajarray[1]: null;
        try { 
			if(dateraj!=null)
				dateFormat.parse(dateraj.replace("T"," ").split("\\+")[0]);
			ReceiverSDI = receiverSDI;
        } catch (Exception e) {
        	throw new Error("Receiver SDI is not in a proper date format");
        }

				 
			
		
		
	}
	public String getPayerStatus() {
		return PayerStatus;
	}
	public void setPayerStatus(String payerStatus) {
		PayerStatus = payerStatus;
	}
	public String getReceiverStatus() {
		return ReceiverStatus;
	}
	public void setReceiverStatus(String receiverStatus) {
		ReceiverStatus = receiverStatus;
	}
	public String getNettingType() {
		return NettingType;
	}
	public void setNettingType(String nettingType) {
		NettingType = nettingType;
	}
	public String getNettingGroup() {
		return NettingGroup;
	}
	public void setNettingGroup(String nettingGroup) {
		NettingGroup = nettingGroup;
	}
	public String getDeliveryType() {
		return DeliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		DeliveryType = deliveryType;
	}
	public String getIsManualSDI() {
		return IsManualSDI;
	}
	public void setIsManualSDI(String isManualSDI) {
		IsManualSDI = isManualSDI;
	}
	
	
	
	
}
	
class Attributes {
	private Attribute Attribute;

		public Attribute getAttribute() {
			return Attribute;
		}
	
		public void setAttribute(Attribute attribute) {
			Attribute = attribute;
		}
	
}
class Attribute {
	private String AttributeName;
	private String AttributeValue;
	
		public String getAttributeName() {
			return AttributeName;
		}
		public void setAttributeName(String attributeName) {
			AttributeName = attributeName;
		}
		public String getAttributeValue() {
			return AttributeValue;
		}
		public void setAttributeValue(String attributeValue) {
			AttributeValue = attributeValue;
		}
	
	
}
		



class Fields {
	private Field Field;

		public Field getField() {
			return Field;
		}
	
		public void setField(Field field) {
			Field = field;
		}
	
}
class Field {
	private String Name;
	private String Value;
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getValue() {
			return Value;
		}
		public void setValue(String value) {
			Value = value;
		}
	
	
}
		


