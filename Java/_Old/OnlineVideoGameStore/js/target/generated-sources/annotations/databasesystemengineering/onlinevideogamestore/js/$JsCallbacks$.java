package databasesystemengineering.onlinevideogamestore.js;
public final class $JsCallbacks$ {
  static final $JsCallbacks$ VM = new $JsCallbacks$(null);
  private final org.netbeans.html.boot.spi.Fn.Ref<?> ref;
  private $JsCallbacks$ next;
  private $JsCallbacks$(org.netbeans.html.boot.spi.Fn.Presenter p) {
    this.ref = org.netbeans.html.boot.spi.Fn.ref(p);
  }
  synchronized final $JsCallbacks$ current() {
    org.netbeans.html.boot.spi.Fn.Presenter now = org.netbeans.html.boot.spi.Fn.activePresenter();
    $JsCallbacks$ thiz = this;
    $JsCallbacks$ prev = null;
    for (;;) {
      if (thiz.ref != null) {
        org.netbeans.html.boot.spi.Fn.Presenter thizPresenter = thiz.ref.presenter();
        if (thizPresenter == null) {
          if (prev != null) {
            prev.next = thiz.next;
          }
        } else {
          if (thizPresenter == now) return thiz;
        }
      }
      if (thiz.next == null) {
        return thiz.next = new $JsCallbacks$(now);
      }
      prev = thiz;
      thiz = thiz.next;
    }
  }

  public java.lang.Object java_lang_Runnable$run$(java.lang.Runnable self) throws Throwable {
    org.netbeans.html.boot.spi.Fn.Presenter p = ref.presenter(); 
    try (java.io.Closeable a = org.netbeans.html.boot.spi.Fn.activate(p)) { 
    self.run();
    return null;
    }
  }

  public java.lang.Object raw$java_lang_Runnable$run$(java.lang.Object self) throws Throwable {
    org.netbeans.html.boot.spi.Fn.Presenter p = ref.presenter(); 
    if (p instanceof org.netbeans.html.boot.spi.Fn.FromJavaScript) {
      self = ((org.netbeans.html.boot.spi.Fn.FromJavaScript)p).toJava(self);
    }
    try (java.io.Closeable a = org.netbeans.html.boot.spi.Fn.activate(p)) { 
    ((java.lang.Runnable)self).run();
    return null;
    }
  }
}
