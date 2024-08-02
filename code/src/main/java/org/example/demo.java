package org.example;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.json.JSONUtil;
import net.sf.cglib.core.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        String s = map.toString();

    }

    public int addOne(final int x) {
        return x + 1;
    }


}
class Other {
    public int i;
}