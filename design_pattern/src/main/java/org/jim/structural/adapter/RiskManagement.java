package org.jim.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/*
封装有缺陷的接口
设计统一多个类的接口
设计替换依赖的外部系统
兼容老版本接口
适配不同格式的数据
 */

class ASensitiveWordsFilter { // A敏感词过滤系统提供的接口
    String filterSexyWords(String text) {
        return text;
    }

    String filterPoliticalWords(String text) {
        return text;
    }
}

class BSensitiveWordsFilter  { // B敏感词过滤系统提供的接口
    public String filter(String text, String mask) {
        return text;
    }
}


// 未使用适配器模式之前的代码：代码的可测试性、扩展性不好
//public class RiskManagement {
//    private ASensitiveWordsFilter aFilter = new ASensitiveWordsFilter();
//    private BSensitiveWordsFilter bFilter = new BSensitiveWordsFilter();
//
//
//    public String filterSensitiveWords(String text) {
//        String maskedText = aFilter.filterSexyWords(text);
//        maskedText = aFilter.filterPoliticalWords(maskedText);
//        maskedText = bFilter.filter(maskedText, "***");
//        return maskedText;
//    }
//}




class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private ASensitiveWordsFilter aFilter;
    public String filter(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        return maskedText;
    }
}
//...省略BSensitiveWordsFilterAdaptor、CSensitiveWordsFilterAdaptor...

// 扩展性更好，更加符合开闭原则，如果添加一个新的敏感词过滤系统，
// 这个类完全不需要改动；而且基于接口而非实现编程，代码的可测试性更好。
public class RiskManagement {
    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String text) {
        String maskedText = text;
        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }
}
