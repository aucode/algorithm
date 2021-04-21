package au.code;

import java.lang.reflect.Method;

public class Menu {

    /**
     * output
     * @param message
     * @return
     */
    public Menu println(Object message){
        System.out.println(message);
        return this;
    }

    /**
     * output menu，type is Object array
     * @param message
     * @return
     */
    public Menu menu(Object[] message){
        for(Object val : message){
            if(null == val) return this;
            System.out.println(val);

        }
        return this;
    }

    /**
     * judgement type is Byte
     * @param o
     * @return
     */
    public boolean judgeByte(Object o){return o instanceof Byte;}
    /**
     * judgement Short type
     * @param o
     * @return
     */
    public boolean judgeShort(Object o){return o instanceof Short;}
    /**
     * judgement type is Integer
     * @param o
     * @return
     */
    public boolean judgeInteger(Object o){return o instanceof Integer;}
    /**
     * judgement type is Long
     * @param o
     * @return
     */
    public boolean judgeLong(Object o){return o instanceof Long;}
    /**
     * judgement type is Float
     * @param o
     * @return
     */
    public boolean judgeFloat(Object o){return o instanceof Float;}
    /**
     * judgement type is Double
     * @param o
     * @return
     */
    public boolean judgeDouble(Object o){return o instanceof Double;}
    /**
     * judgement type is Boolean.
     * @param o
     * @return
     */
    public boolean judgeBoolean(Object o){return o instanceof Boolean;}
    /**
     * judgement type is Character
     * @param o
     * @return
     */
    public boolean judgeChar(Object o){return o instanceof Character;}
    /**
     * judgement is type String.
     * @param o
     * @return
     */
    public boolean judgeString(Object o){return o instanceof String;}


    public Menu whilemenu(Boolean boolaen){
        while (boolaen){
            return this;
        }
        return this;
    }



}
