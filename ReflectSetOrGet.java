package reflact;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect {
    public void reflectSet() {
        Demo demo = new Demo();
        Method[] methods = demo.getClass().getMethods();//class's method
        //set
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("set")) {//if start with 'set'
                try {
                    method.invoke(demo, "value");//invoke method
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void reflectGet() throws NoSuchMethodException {
        Demo demo = new Demo();
        Method[] methods = demo.getClass().getMethods();//class's method
        demo.getClass().getMethod("getId", Integer.class);
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get") && !methodName.equals("getClass")) {//if start with 'get'
                Object value = null;
                try {
                    value = method.invoke(demo);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println(value);
            }
        }
    }
}

//A Entity
class Demo {

}
