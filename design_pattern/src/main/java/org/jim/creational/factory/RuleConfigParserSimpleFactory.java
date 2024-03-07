package org.jim.creational.factory;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserSimpleFactory {
    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;//返回null还是IllegalArgumentException
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }

    public static class JsonRuleConfigParser implements IRuleConfigParser{

    }

    public static class XmlRuleConfigParser implements IRuleConfigParser{

    }
    public static class YamlRuleConfigParser implements IRuleConfigParser{

    }
    public static class PropertiesRuleConfigParser implements IRuleConfigParser{

    }
}


