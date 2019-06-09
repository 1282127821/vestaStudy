package com.xy.spring看书;

import java.beans.PropertyEditorSupport;

/**
 * @fileName:MyPropertyEditor
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
public class MyPropertyEditor extends PropertyEditorSupport {
    /**
     *其实这个就是一个用来将字符串转换为 其他类型的一个转换器而已
     * 但是具体怎么用待研究
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] split = text.split("-");
        //这个my转换器是将 100-y 这种格式的字符串转换为My对象
        setValue(new My(Integer.parseInt(split[0]),split[1]));
    }
}
