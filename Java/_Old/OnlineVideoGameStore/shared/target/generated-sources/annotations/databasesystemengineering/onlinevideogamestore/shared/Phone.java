package databasesystemengineering.onlinevideogamestore.shared;
import net.java.html.json.*;
/** Generated for {@link Contacts.PhoneImpl}*/
public final class Phone implements Cloneable {
  private static Class<Contacts.PhoneImpl> modelFor() { return Contacts.PhoneImpl.class; }
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  public java.lang.String getValidate() {
    java.lang.String arg1 = getNumber();
    try {
      proto.acquireLock();
      return databasesystemengineering.onlinevideogamestore.shared.Contacts.PhoneImpl.validate(arg1);
    } finally {
      proto.releaseLock();
    }
  }
  private java.lang.String prop_number;
  public java.lang.String getNumber() {
    proto.accessProperty("number");
    return (java.lang.String)prop_number;
  }
  public void setNumber(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_number;
    if (TYPE.isSame(o , v)) return;
    prop_number = v;
    proto.valueHasMutated("number", o, v);
    proto.valueHasMutated("validate", null, getValidate());
  }
  private databasesystemengineering.onlinevideogamestore.shared.PhoneType prop_type;
  public databasesystemengineering.onlinevideogamestore.shared.PhoneType getType() {
    proto.accessProperty("type");
    return (databasesystemengineering.onlinevideogamestore.shared.PhoneType)prop_type;
  }
  public void setType(databasesystemengineering.onlinevideogamestore.shared.PhoneType v) {
    proto.verifyUnlocked();
    Object o = prop_type;
    if (TYPE.isSame(o , v)) return;
    prop_type = v;
    proto.valueHasMutated("type", o, v);
  }
  private Phone(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
  };
  public Phone() {
    this(net.java.html.BrwsrCtx.findDefault(Phone.class));
  };
  public Phone(java.lang.String aNumber, databasesystemengineering.onlinevideogamestore.shared.PhoneType aType) {
    this(net.java.html.BrwsrCtx.findDefault(Phone.class));
    this.prop_number = aNumber;
    this.prop_type = aType;
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Phone> {
    private Html4JavaType() {
      super(Phone.class, Contacts.PhoneImpl.class, 3, 0);
      registerProperty("validate", 0, true, false);
      registerProperty("number", 1, false, false);
      registerProperty("type", 2, false, false);
    }
    @Override public void setValue(Phone data, int type, Object value) {
      switch (type) {
        case 1: data.setNumber(TYPE.extractValue(java.lang.String.class, value)); return;
        case 2: data.setType(TYPE.extractValue(databasesystemengineering.onlinevideogamestore.shared.PhoneType.class, value)); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Phone data, int type) {
      switch (type) {
        case 0: return data.getValidate();
        case 1: return data.getNumber();
        case 2: return data.getType();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Phone model, int type, Object data, Object ev) throws Exception {
      switch (type) {
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((Phone)obj).proto;    }
    @Override public void onChange(Phone model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(Phone model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public Phone read(net.java.html.BrwsrCtx c, Object json) { return new Phone(c, json); }
    @Override public Phone cloneTo(Phone o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private Phone(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[2];
    proto.extract(json, new String[] {
      "number",
      "type",
    }, ret);
    this.prop_number = (java.lang.String)ret[0];
    try {
    this.prop_type = ret[1] == null ? null : databasesystemengineering.onlinevideogamestore.shared.PhoneType.valueOf(TYPE.stringValue(ret[1]));
    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("number").append('"').append(":");
    sb.append(TYPE.toJSON(getNumber()));
    sb.append(',');
    sb.append('"').append("type").append('"').append(":");
    sb.append(TYPE.toJSON(getType()));
    sb.append('}');
    return sb.toString();
  }
  public Phone clone() {
    return clone(proto.getContext());
  }
  private Phone clone(net.java.html.BrwsrCtx ctx) {
    Phone ret = new Phone(ctx);
    ret.prop_number = getNumber();
    ret.prop_type = getType();
    return ret;
  }
  private Phone applyBindings() {
    throw new IllegalStateException("Please specify targetId=\"\" in your @Model annotation");
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Phone)) return false;
    Phone p = (Phone)o;
    if (!TYPE.isSame(prop_number, p.prop_number)) return false;
    if (!TYPE.isSame(prop_type, p.prop_type)) return false;
    return true;
  }
  public int hashCode() {
    int h = Phone.class.getName().hashCode();
    h = TYPE.hashPlus(prop_number, h);
    h = TYPE.hashPlus(prop_type, h);
    return h;
  }
}
