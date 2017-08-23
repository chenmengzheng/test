package util.common;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 *
 * String公共方法
 * 方法基于:项目总结&参考Apache comments&JDK
 *
 * </pre>
 *
 * @author chen mengzheng
 */
public class StringUtil extends StringUtils {

    /**
     * <p>如果字符串为空,使用def</p>
     * <p>
     * <pre>
     * StringUtil.isNullDefault("a", "abc")   = "a";
     * StringUtil.isNullDefault("", "abc")    = "abc";
     * StringUtil.isNullDefault(null,"abc")   = "abc";
     * </pre>
     */
    public static String isNullDefault(String str, String def) {
        if (isBlank(def)) {
            def = "";
        }
        if (isBlank(str)) {
            return def;
        }
        return str;
    }


    /**
     * <p>如果字符串为空,使用def</p>
     * <p>
     * <pre>
     * StringUtil.isNullDefault("a")   = "a";
     * StringUtil.isNullDefault("")    = "";
     * StringUtil.isNullDefault(null)   = "";
     * </pre>
     */
    public static String isNullDefault(String str) {
        return isNullDefault(str, "");
    }

}
