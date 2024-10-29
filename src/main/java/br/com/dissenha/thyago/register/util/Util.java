package br.com.dissenha.thyago.register.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Util {

    public static void copyPropertiesNotNull(Object origin, Object destination) {
        BeanUtils.copyProperties(origin, destination, findPropertiesNotNull(origin));
    }

    public static String[] findPropertiesNotNull(Object origem) {
        final BeanWrapper origemWrapper = new BeanWrapperImpl(origem);
        PropertyDescriptor[] propertyDescriptors = origemWrapper.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if(origemWrapper.getPropertyValue(propertyDescriptor.getName()) == null) {
                emptyNames.add(propertyDescriptor.getName());
            }
        }
        return emptyNames.toArray(new String[emptyNames.size()]);
    }
}