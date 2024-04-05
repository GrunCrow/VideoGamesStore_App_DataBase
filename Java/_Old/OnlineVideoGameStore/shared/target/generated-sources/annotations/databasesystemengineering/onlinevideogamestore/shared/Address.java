package databasesystemengineering.onlinevideogamestore.shared;
import net.java.html.json.*;
/** Generated for {@link Contacts.AddressImpl}*/
public final class Address implements Cloneable {
  private static Class<Contacts.AddressImpl> modelFor() { return Contacts.AddressImpl.class; }
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  public java.lang.String getValidate() {
    java.lang.String arg1 = getTown();
    java.lang.String arg2 = getStreet();
    try {
      proto.acquireLock();
      return databasesystemengineering.onlinevideogamestore.shared.Contacts.AddressImpl.validate(arg1, arg2);
    } finally {
      proto.releaseLock();
    }
  }
  private java.lang.String prop_street;
  public java.lang.String getStreet() {
    proto.accessProperty("street");
    return (java.lang.String)prop_street;
  }
  public void setStreet(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_street;
    if (TYPE.isSame(o , v)) return;
    prop_street = v;
    proto.valueHasMutated("street", o, v);
    proto.valueHasMutated("validate", null, getValidate());
  }
  private java.lang.String prop_town;
  public java.lang.String getTown() {
    proto.accessProperty("town");
    return (java.lang.String)prop_town;
  }
  public void setTown(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_town;
    if (TYPE.isSame(o , v)) return;
    prop_town = v;
    proto.valueHasMutated("town", o, v);
    proto.valueHasMutated("validate", null, getValidate());
  }
  private Address(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
  };
  public Address() {
    this(net.java.html.BrwsrCtx.findDefault(Address.class));
  };
  public Address(java.lang.String aStreet, java.lang.String aTown) {
    this(net.java.html.BrwsrCtx.findDefault(Address.class));
    this.prop_street = aStreet;
    this.prop_town = aTown;
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Address> {
    private Html4JavaType() {
      super(Address.class, Contacts.AddressImpl.class, 3, 0);
      registerProperty("validate", 0, true, false);
      registerProperty("street", 1, false, false);
      registerProperty("town", 2, false, false);
    }
    @Override public void setValue(Address data, int type, Object value) {
      switch (type) {
        case 1: data.setStreet(TYPE.extractValue(java.lang.String.class, value)); return;
        case 2: data.setTown(TYPE.extractValue(java.lang.String.class, value)); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Address data, int type) {
      switch (type) {
        case 0: return data.getValidate();
        case 1: return data.getStreet();
        case 2: return data.getTown();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Address model, int type, Object data, Object ev) throws Exception {
      switch (type) {
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((Address)obj).proto;    }
    @Override public void onChange(Address model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(Address model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public Address read(net.java.html.BrwsrCtx c, Object json) { return new Address(c, json); }
    @Override public Address cloneTo(Address o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private Address(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[2];
    proto.extract(json, new String[] {
      "street",
      "town",
    }, ret);
    this.prop_street = (java.lang.String)ret[0];
    this.prop_town = (java.lang.String)ret[1];
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("street").append('"').append(":");
    sb.append(TYPE.toJSON(getStreet()));
    sb.append(',');
    sb.append('"').append("town").append('"').append(":");
    sb.append(TYPE.toJSON(getTown()));
    sb.append('}');
    return sb.toString();
  }
  public Address clone() {
    return clone(proto.getContext());
  }
  private Address clone(net.java.html.BrwsrCtx ctx) {
    Address ret = new Address(ctx);
    ret.prop_street = getStreet();
    ret.prop_town = getTown();
    return ret;
  }
  private Address applyBindings() {
    throw new IllegalStateException("Please specify targetId=\"\" in your @Model annotation");
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Address)) return false;
    Address p = (Address)o;
    if (!TYPE.isSame(prop_street, p.prop_street)) return false;
    if (!TYPE.isSame(prop_town, p.prop_town)) return false;
    return true;
  }
  public int hashCode() {
    int h = Address.class.getName().hashCode();
    h = TYPE.hashPlus(prop_street, h);
    h = TYPE.hashPlus(prop_town, h);
    return h;
  }
}
