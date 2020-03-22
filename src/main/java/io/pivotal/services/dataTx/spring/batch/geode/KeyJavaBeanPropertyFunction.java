package io.pivotal.services.dataTx.spring.batch.geode;

import nyla.solutions.core.util.JavaBean;

import java.util.function.Function;

/**
 * Return a given property from an object instance
 * @author Gregory Green
 */
public class KeyJavaBeanPropertyFunction<T,R> implements Function<T,R>
{
    private final String propertyName;

    /**
     * Constructor
     * @param propertyName the property name to extract
     */
    public KeyJavaBeanPropertyFunction(String propertyName)
    {
         if(propertyName == null)
                     throw new IllegalArgumentException("[propertyName] required");

        this.propertyName = propertyName;
    }//-------------------------------------------

    @Override
    public R apply(T input)
    {
        if(input == null)
            return null;

        return JavaBean.getProperty(input,propertyName);
    }
}
