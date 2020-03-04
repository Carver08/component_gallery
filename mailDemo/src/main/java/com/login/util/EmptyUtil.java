package com.login.util;

import java.util.Collection;
import java.util.Map;

/*
非空效验工具类
 */
public class EmptyUtil {

    public static boolean isAnyoneEmpty(Object obj)
    {
        if(obj==null)
        {
            return obj==null;
        }
        else if(obj instanceof Collection<?>)
        {
            return ((Collection<?>)obj).isEmpty();
        }
        else if(obj instanceof String)
        {
            return obj.toString().length()==0;
        }
        else if(obj.getClass().isArray())
        {
            return ((Object[])obj).length==0;
        }
        else if(obj instanceof Map)
        {
            return ((Map<?,?>)obj).isEmpty();
        }
        else if(obj instanceof StringBuilder)
        {
            return ((StringBuilder)obj).length()==0;
        }
        else if(obj instanceof StringBuffer)
        {
            return ((StringBuffer)obj).length()==0;
        }
        return false;
    }


}
