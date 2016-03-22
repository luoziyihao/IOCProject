public class PropertyHandlerImpl implements PropertyHandler{
    public Object setProperties(Object obj, Map<String, Object> properties){
        Class clazz = obj.getClass();
        try {
            for(String key : properties.keySet()){
                String setterName = getSetterMethodName(key);
                Class argClass = getClass(properties.get(key));
                Method setterMethod = getSetterMethod(clazz, setterName, argsClass);
                setterMethod.invoke(obj, properties.get(key));
            }
            return obj;
        } catch (NoSuchMethodException e){
            throw new PropertyException("setter method not found " + e.getMessage());
        } catch (IIIegalArgumentException e){
            throw new PropertyException("wrong argument " + e.getMessage());
        } catch (Exception){
            throw new PropertyException(e.getMessage());
        }
    }

    private Class getClass(Object obj){
        if(obj)
    }

    public Method getSetterMethod(Class objClass, String methodName, Class argClass) throws NoSuchMethodException {
        Method argClassMethod = getMethod(objClass, methodName, argClass);
        if(argClassMethod == null){
            List<Method> methods = getMethods(objClass, methodName);
            Method method = findMethod(argsClass, methods);
            if(method == null){
                throw new NoSuchMethodException(methodName);
            }
            return method;
        }
        return argClassMethod;
    }

    private List<Method> getMethods(Class objClass, String methodName){
        List<Method> result = new ArrayList<Method>();
        for(Method m : objClass.getMethods()){
            if(m.getName().equals(methodName)){
                Class[] c = m.getParameterTypes();
                if(c.length == 1){
                    result.add(m);
                }
            }
        }
        return result;
    }

    private Method findMethod(Class argClass, List<Method> methods){
        for(Method m :methods){
            if(isMethodArgs(m, argClass)){
                return m;
            }
        }
        return null;
    }

    private boolean isMethodArgs(Method m, Class argClass){
        Class[] c = m.getParameterTypes();
        if(c.length == 1){
            try {
                argClass.asSubClass(c[0]);
                return true;
            } catch (ClassCastException e){
                return false;
            }
        }
        return false;
    }
}
