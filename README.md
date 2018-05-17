# Simple-reflect
Reflect to run method get or set (DEMO)

    //set
    public void reflectSet() {
        Demo demo = new Demo();
        Method[] methods = demo.getClass().getMethods();//class's method
        //or can use 'demo.getClass().getMethod("getId",Integer.class);' to get a method of specific name , then same to invoke

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("set")) {//if start with 'set'
                try {
                    method.invoke(demo, "value");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //get
    public void reflectGet() {
        Demo demo = new Demo();
        Method[] methods = demo.getClass().getMethods();//class's method

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
            }
        }
    }

Finish...!!! ^.^
