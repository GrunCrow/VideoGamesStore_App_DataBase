package databasesystemengineering.onlinevideogamestore.shared;
import net.java.html.json.*;
/** Generated for {@link Contacts}*/
public final class Contact implements Cloneable {
  private static Class<Contacts> modelFor() { return Contacts.class; }
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  public java.lang.String getFullName() {
    java.lang.String arg1 = getFirstName();
    java.lang.String arg2 = getLastName();
    try {
      proto.acquireLock();
      return databasesystemengineering.onlinevideogamestore.shared.Contacts.fullName(arg1, arg2);
    } finally {
      proto.releaseLock();
    }
  }
  public java.lang.String getCallInfo() {
    java.util.List<Phone> arg1 = getPhones();
    try {
      proto.acquireLock("callInfo");
      return databasesystemengineering.onlinevideogamestore.shared.Contacts.callInfo(arg1);
    } finally {
      proto.releaseLock();
    }
  }
  public java.lang.String getValidate() {
    java.lang.String arg1 = getFirstName();
    java.lang.String arg2 = getLastName();
    databasesystemengineering.onlinevideogamestore.shared.Address arg3 = getAddress();
    java.util.List<Phone> arg4 = getPhones();
    try {
      proto.acquireLock("validate");
      return databasesystemengineering.onlinevideogamestore.shared.Contacts.validate(arg1, arg2, arg3, arg4);
    } finally {
      proto.releaseLock();
    }
  }
  private java.lang.String prop_id;
  public java.lang.String getId() {
    proto.accessProperty("id");
    return (java.lang.String)prop_id;
  }
  public void setId(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_id;
    if (TYPE.isSame(o , v)) return;
    prop_id = v;
    proto.valueHasMutated("id", o, v);
  }
  private java.lang.String prop_firstName;
  public java.lang.String getFirstName() {
    proto.accessProperty("firstName");
    return (java.lang.String)prop_firstName;
  }
  public void setFirstName(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_firstName;
    if (TYPE.isSame(o , v)) return;
    prop_firstName = v;
    proto.valueHasMutated("firstName", o, v);
    proto.valueHasMutated("fullName", null, getFullName());
    proto.valueHasMutated("validate", null, getValidate());
  }
  private java.lang.String prop_lastName;
  public java.lang.String getLastName() {
    proto.accessProperty("lastName");
    return (java.lang.String)prop_lastName;
  }
  public void setLastName(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_lastName;
    if (TYPE.isSame(o , v)) return;
    prop_lastName = v;
    proto.valueHasMutated("lastName", o, v);
    proto.valueHasMutated("fullName", null, getFullName());
    proto.valueHasMutated("validate", null, getValidate());
  }
  private /*Address*/Object prop_address;
  public Address getAddress() {
    proto.accessProperty("address");
    if (prop_address == TYPE) prop_address = net.java.html.json.Models.bind(new Address(), proto.getContext());
    return (Address)prop_address;
  }
  public void setAddress(Address v) {
    proto.verifyUnlocked();
    Object o = prop_address;
    if (o == v) return;
    prop_address = v;
    proto.valueHasMutated("address", o, v);
    proto.valueHasMutated("validate", null, getValidate());
  }
  private final java.util.List<Phone> prop_phones;
  public java.util.List<Phone> getPhones() {
    proto.accessProperty("phones");
    return prop_phones;
  }
  private Contact(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
    this.prop_phones = proto.createList("phones", -1, "callInfo", "validate");
  };
  public Contact() {
    this(net.java.html.BrwsrCtx.findDefault(Contact.class));
    prop_address = TYPE; /* uninitialized */
  };
  public Contact(java.lang.String aId, java.lang.String aFirstName, java.lang.String aLastName, Address aAddress, Phone... aPhones) {
    this(net.java.html.BrwsrCtx.findDefault(Contact.class));
    this.prop_id = aId;
    this.prop_firstName = aFirstName;
    this.prop_lastName = aLastName;
    this.prop_address = aAddress;
    proto.initTo(this.prop_phones, aPhones);
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Contact> {
    private Html4JavaType() {
      super(Contact.class, Contacts.class, 8, 0);
      registerProperty("fullName", 0, true, false);
      registerProperty("callInfo", 1, true, false);
      registerProperty("validate", 2, true, false);
      registerProperty("id", 3, false, false);
      registerProperty("firstName", 4, false, false);
      registerProperty("lastName", 5, false, false);
      registerProperty("address", 6, false, false);
      registerProperty("phones", 7, false, false);
    }
    @Override public void setValue(Contact data, int type, Object value) {
      switch (type) {
        case 3: data.setId(TYPE.extractValue(java.lang.String.class, value)); return;
        case 4: data.setFirstName(TYPE.extractValue(java.lang.String.class, value)); return;
        case 5: data.setLastName(TYPE.extractValue(java.lang.String.class, value)); return;
        case 6: data.setAddress(TYPE.extractValue(Address.class, value)); return;
        case 7: TYPE.replaceValue(data.getPhones(), Phone.class, value); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Contact data, int type) {
      switch (type) {
        case 0: return data.getFullName();
        case 1: return data.getCallInfo();
        case 2: return data.getValidate();
        case 3: return data.getId();
        case 4: return data.getFirstName();
        case 5: return data.getLastName();
        case 6: return data.getAddress();
        case 7: return data.getPhones();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Contact model, int type, Object data, Object ev) throws Exception {
      switch (type) {
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((Contact)obj).proto;    }
    @Override public void onChange(Contact model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(Contact model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public Contact read(net.java.html.BrwsrCtx c, Object json) { return new Contact(c, json); }
    @Override public Contact cloneTo(Contact o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private Contact(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[5];
    proto.extract(json, new String[] {
      "id",
      "firstName",
      "lastName",
      "address",
      "phones",
    }, ret);
    this.prop_id = (java.lang.String)ret[0];
    this.prop_firstName = (java.lang.String)ret[1];
    this.prop_lastName = (java.lang.String)ret[2];
    this.prop_address = proto.read(Address.class, ret[3]);
    for (Object e : useAsArray(ret[4])) {
      this.prop_phones.add(proto.read(Phone.class, e));
    }
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("id").append('"').append(":");
    sb.append(TYPE.toJSON(getId()));
    sb.append(',');
    sb.append('"').append("firstName").append('"').append(":");
    sb.append(TYPE.toJSON(getFirstName()));
    sb.append(',');
    sb.append('"').append("lastName").append('"').append(":");
    sb.append(TYPE.toJSON(getLastName()));
    sb.append(',');
    sb.append('"').append("address").append('"').append(":");
    sb.append(TYPE.toJSON(thisToNull(this.prop_address)));
    sb.append(',');
    sb.append('"').append("phones").append('"').append(":");
    sb.append(TYPE.toJSON(thisToNull(this.prop_phones)));
    sb.append('}');
    return sb.toString();
  }
  public Contact clone() {
    return clone(proto.getContext());
  }
  private Contact clone(net.java.html.BrwsrCtx ctx) {
    Contact ret = new Contact(ctx);
    ret.prop_id = getId();
    ret.prop_firstName = getFirstName();
    ret.prop_lastName = getLastName();
    ret.prop_address =  prop_address == null ? null : prop_address == TYPE ? TYPE : net.java.html.json.Models.bind(getAddress(), ctx);
    proto.cloneList(ret.getPhones(), ctx, prop_phones);
    return ret;
  }
  private Contact applyBindings() {
    throw new IllegalStateException("Please specify targetId=\"\" in your @Model annotation");
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Contact)) return false;
    Contact p = (Contact)o;
    if (!TYPE.isSame(prop_id, p.prop_id)) return false;
    if (!TYPE.isSame(prop_firstName, p.prop_firstName)) return false;
    if (!TYPE.isSame(prop_lastName, p.prop_lastName)) return false;
    if (!TYPE.isSame(thisToNull(prop_address), p.thisToNull(p.prop_address))) return false;
    if (!TYPE.isSame(thisToNull(prop_phones), p.thisToNull(p.prop_phones))) return false;
    return true;
  }
  public int hashCode() {
    int h = Contact.class.getName().hashCode();
    h = TYPE.hashPlus(prop_id, h);
    h = TYPE.hashPlus(prop_firstName, h);
    h = TYPE.hashPlus(prop_lastName, h);
    h = TYPE.hashPlus(thisToNull(prop_address), h);
    h = TYPE.hashPlus(thisToNull(prop_phones), h);
    return h;
  }
  private Object thisToNull(Object value) {
    return value == this || value == TYPE ? null : value;
  }
}
