package util.common;

import java.lang.reflect.Array;

/**
 * 关于数组,集合类的Util
 * 
 * map,set,list,jsonarray,jsonobject
 * 
 * @author chen
 *
 */
public class CollectionUtil{

	  /**
     * An empty immutable {@code String} array.
     */
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
	
	/**
	 * 如果char[]为空就返回true
	 * @param searchChars
	 * @return
	 */
    public static boolean isEmpty(final char[] searchChars) {
        return getLength(searchChars) == 0;
    }
    
	/**
	 * 如果object[]为空就返回true
	 * @param searchChars
	 * @return
	 */
    public static boolean isEmpty(final Object[] searchChars) {
        return getLength(searchChars) == 0;
    }
    
    
    /**
     * 返回array长度
     * <pre>
     * ArrayUtils.getLength(null)            = 0
     * ArrayUtils.getLength([])              = 0
     * ArrayUtils.getLength([null])          = 1
     * ArrayUtils.getLength([true, false])   = 2
     * ArrayUtils.getLength([1, 2, 3])       = 3
     * ArrayUtils.getLength(["a", "b", "c"]) = 3
     * </pre>
     * @param array
     * @return
     */
    public static int getLength(final Object array) {
        if (array == null) {
            return 0;
        }
        return Array.getLength(array);
    }
	
    /**
     * 如果list不为空就返回true
     * @param array
     * @return
     */
    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }
	
}
