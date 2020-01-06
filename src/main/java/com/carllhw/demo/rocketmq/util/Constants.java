package com.carllhw.demo.rocketmq.util;

/**
 * 常量
 *
 * @author carllhw
 */
public class Constants {

    private Constants() {
    }

    /**
     * 数值
     */
    public static class Digital {

        public static final int TEN = 10;

        public static final int ONE_HUNDRED = 100;

        public static final int ONE_HUNDRED_THOUSAND = 100000;

        private Digital() {
        }
    }

    /**
     * 符号常量
     */
    public static class Symbol {

        /**
         * 感叹号：!
         */
        public static final String SIGH = "!";

        /**
         * 符号：@
         */
        public static final String AT = "@";

        /**
         * 井号：#
         */
        public static final String WELL = "#";

        /**
         * 美元符：$
         */
        public static final String DOLLAR = "$";

        /**
         * 人民币符号：￥
         */
        public static final String RMB = "￥";

        /**
         * 空格：
         */
        public static final String SPACE = " ";

        /**
         * 换行符：\r\n
         */
        public static final String LB = System.getProperty("line.separator");

        /**
         * 百分号：%
         */
        public static final String PERCENTAGE = "%";

        /**
         * 符号：&amp;
         */
        public static final String AND = "&";

        /**
         * 星号
         */
        public static final String STAR = "*";

        /**
         * 中横线：-
         */
        public static final String MIDDLE_LINE = "-";

        /**
         * 下划线：_
         */
        public static final String LOWER_LINE = "_";

        /**
         * 等号：=
         */
        public static final String EQUAL = "=";

        /**
         * 加号：+
         */
        public static final String PLUS = "+";

        /**
         * 冒号：:
         */
        public static final String COLON = ":";

        /**
         * 分号：;
         */
        public static final String SEMICOLON = ";";

        /**
         * 逗号：,
         */
        public static final String COMMA = ",";

        /**
         * 点号：.
         */
        public static final String POINT = ".";

        /**
         * 斜杠：/
         */
        public static final String SLASH = "/";

        /**
         * 竖杠：|
         */
        public static final String VERTICAL_BAR = "|";

        /**
         * 双斜杠：//
         */
        public static final String DOUBLE_SLASH = "//";

        /**
         * 反斜杠
         */
        public static final String BACKSLASH = "\\";

        /**
         * 问号：?
         */
        public static final String QUESTION = "?";

        /**
         * 左花括号：{
         */
        public static final String LEFT_BIG_BRACE = "{";

        /**
         * 右花括号：}
         */
        public static final String RIGHT_BIG_BRACE = "}";

        /**
         * 左中括号：[
         */
        public static final String LEFT_MIDDLE_BRACE = "[";

        /**
         * 右中括号：[
         */
        public static final String RIGHT_MIDDLE_BRACE = "]";

        /**
         * 反引号：`
         */
        public static final String BACKQUOTE = "`";

        private Symbol() {
        }
    }
}
