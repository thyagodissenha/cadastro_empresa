package br.com.dissenha.thyago.cadastro.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Util {

    public static void copiarPropriedadesNaoNulas(Object origem, Object destino) {
        BeanUtils.copyProperties(origem, destino, buscarPropriedadesNaoNulas(origem));
    }

    public static String[] buscarPropriedadesNaoNulas(Object origem) {
        final BeanWrapper origemWrapper = new BeanWrapperImpl(origem);
        PropertyDescriptor[] propertyDescriptors = origemWrapper.getPropertyDescriptors();
        Set<String> nomesVazios = new HashSet<>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if(origemWrapper.getPropertyValue(propertyDescriptor.getName()) == null) {
                nomesVazios.add(propertyDescriptor.getName());
            }
        }
        return nomesVazios.toArray(new String[nomesVazios.size()]);
    }
}